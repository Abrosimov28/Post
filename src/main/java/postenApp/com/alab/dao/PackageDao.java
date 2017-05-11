package postenApp.com.alab.dao;

import java.util.Collection;

import postenApp.com.alab.entity.Pack;

public interface PackageDao {

	Collection<Pack> getAllPrices();

	Pack getPriceByWeight(int weight);

	void insertPackage(Pack pack);

	void removePack(int weight);

	void updatePack(Pack pack);

}
