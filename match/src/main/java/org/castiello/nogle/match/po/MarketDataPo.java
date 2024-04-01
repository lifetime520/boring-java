package org.castiello.nogle.match.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.btse.match.common.MarketInfo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "s_market")
@Getter
@Setter
@ToString
public class MarketDataPo {

    @Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int uuid;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private boolean active;
    @Column(nullable = false)
    private boolean future;
    @Column(nullable = false)
    private boolean marketClosed;
    @Column(nullable = false)
    private boolean matchingDisabled;
    @Column(nullable = false)
    private long openTime;
    @Column(nullable = false)
    private long closeTime;
    @Column(nullable = false)
    private long inactiveTime;
    @Column(nullable = false)
    private long startMatching;

    public void setMarketInfo(MarketInfo marketInfo) {
        this.name = marketInfo.getName();
        this.active = marketInfo.isActive();
        this.future = marketInfo.isFuture();
        this.marketClosed = marketInfo.isMarketClosed();
        this.matchingDisabled = marketInfo.isMatchingDisabled();
        this.openTime = marketInfo.getOpenTime();
        this.closeTime = marketInfo.getCloseTime();
        this.inactiveTime = marketInfo.getInactiveTime();
        this.startMatching = marketInfo.getStartMatching();
    }

    public void updateMarketInfo(MarketInfo marketInfo) {
        this.active = marketInfo.isActive();
        this.marketClosed = marketInfo.isMarketClosed();
        this.matchingDisabled = marketInfo.isMatchingDisabled();
        this.openTime = marketInfo.getOpenTime();
        this.closeTime = marketInfo.getCloseTime();
        this.inactiveTime = marketInfo.getInactiveTime();
        this.startMatching = marketInfo.getStartMatching();
    }
}