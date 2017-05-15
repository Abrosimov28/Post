package postenApp.com.alab.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import postenApp.com.alab.dao.PackageDao;
import postenApp.com.alab.entity.Pack;

@Service
public class PackageService {
	
	@Autowired
	@Qualifier("mySql") //we are defining a bean
	private PackageDao pack;
	
	public Collection<Pack> getAllPrices() {
		return pack.getAllPrices();
	}
	
	public Pack getPriceByWeight(int weight) {
		return pack.getPriceByWeight(weight);
	}

	public void insertPackage(Pack pack) {
		this.pack.insertPackage(pack);
	}

	public void removePack(int weight) {
		pack.removePack(weight);
		
	}

	public void updatePack(Pack pack) {
		this.pack.updatePack(pack);
	}

	
	
}
