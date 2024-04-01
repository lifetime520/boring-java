package org.castiello.nogle.match.subscriber;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;

import lombok.extern.log4j.Log4j2;

@Log4j2
public abstract class AbstractEventMgmtService<T> {

	protected final Map<Class<T>, Map<String, IEventSubscriber>> subscriberMap = new ConcurrentHashMap<>();
	protected final BlockingQueue<T> asyncQueue = new LinkedBlockingDeque<>();
	protected final AtomicBoolean asynTaskActive = new AtomicBoolean(false);

	/**
	 * 
	 * @param clazz
	 * @param eventSubscriber
	 * @return
	 */
	public String subscriber(final Class<T> clazz, final IEventSubscriber eventSubscriber) {
		final Map<String, IEventSubscriber> innerMap = subscriberMap.compute(clazz, (k, v) -> v == null ? new ConcurrentHashMap<>() : v);
		String subscriberUuid = null;
		synchronized (this) {
			while (innerMap.containsKey((subscriberUuid = uuidGenerator()))) {
				;
			}
			innerMap.put(subscriberUuid, eventSubscriber);
		}
		return subscriberUuid;
	}

	private final String uuidGenerator() {
		return String.format("%s-%s", this.getClass().getSimpleName(), UUID.randomUUID());
	}

	/**
	 * 
	 * @param clazz
	 * @param subscriberUuid
	 * @return
	 */
	public boolean unsubscriber(final Class<?> clazz, final String subscriberUuid) {
		Map<String, IEventSubscriber> innerMap = null;
		if (subscriberMap.containsKey(clazz) && (innerMap = subscriberMap.get(clazz)) != null) {
			return innerMap.remove(subscriberUuid) != null;
		}
		return false;
	}

	/**
	 * 
	 */
	protected void syncEventProxyStart() {
		while (true) {
			try {
				final Object obj = asyncQueue.take();

				final Map<String, IEventSubscriber> innerMap = subscriberMap.getOrDefault(obj.getClass(), null);
				if (innerMap != null) {
					getTaskExecutor().execute(() -> {
						try {
							innerMap.forEach((k, v) -> {
								v.onMessage(obj);
							});
						} catch (Exception e) {
							log.error(e.getMessage(), e);
						}
					});
				}
			} catch (Exception e) {
				log.error(e.getMessage(), e);
			}
		}
	}

	protected abstract ExecutorService getTaskExecutor();

	/**
	 * 
	 * @param threadName
	 * @return
	 */
	protected boolean singleThread(String threadName) {
		if (asynTaskActive.getAndSet(true)) {
			log.info("[MN:singleThread] {}.syncEventProxyStart() already started", this.getClass().getSimpleName());
			return false;
		}
		new Thread(() -> {
			log.info("[MN:singleThread] start {}.syncEventProxyStart()", this.getClass().getSimpleName());
			try {
				syncEventProxyStart();
			} catch (Exception e) {
				log.error("[singleThread] stop {}.syncEventProxyStart(), Reason:{}", this.getClass().getSimpleName(), e.getMessage(), e);
				asynTaskActive.set(false);
			}
		}, threadName).start();
		return true;
	}
}
