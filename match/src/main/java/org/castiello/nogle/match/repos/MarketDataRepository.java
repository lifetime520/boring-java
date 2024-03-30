package org.castiello.nogle.match.repos;

import org.castiello.nogle.match.po.MarketDataPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketDataRepository extends JpaRepository<MarketDataPo, String> {

	public MarketDataPo findByName(String name);
}
