package org.castiello.nogle.match.subscriber;

@FunctionalInterface
public interface IEventSubscriber {

	public void onMessage(Object obj);
}
