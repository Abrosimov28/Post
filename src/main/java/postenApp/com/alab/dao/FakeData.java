package postenApp.com.alab.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import postenApp.com.alab.entity.Pack;

@Repository
public class MySqlPackageDaoImpl implements PackageDao {
	private static List<Pack> priceList;

	static {
		priceList = new ArrayList<Pack>() {
			{
				add(new Pack(1, 50));
				add(new Pack(2, 60));
				add(new Pack(3, 70));
			}
		};
	}

	public Collection<Pack> getAllPrices() {
		return priceList;
	}

	public Pack getPriceByWeight(int weight) {
		for (Pack p : priceList) {
			if (p.getWeight() == weight) {
				return p;
			}
		}
		return null;
	}

	public void insertPackage(Pack pack) {
		priceList.add(pack);
	}
	
	public void removePack(int weight) {
		for (int i = 0; i < priceList.size(); i++) {
			if (priceList.get(i).getWeight() == weight) {
				priceList.remove(i);
			}
		}
	}

	public void updatePack(Pack pack) {
		for (int i = 0; i < priceList.size(); i++) {
			if (pack.getWeight() == priceList.get(i).getWeight()) {
				priceList.get(i).setPrice(pack.getPrice());
			}
		}
		
	}
	
}
