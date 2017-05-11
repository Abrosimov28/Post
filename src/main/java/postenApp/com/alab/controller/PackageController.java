package postenApp.com.alab.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import postenApp.com.alab.entity.Pack;
import postenApp.com.alab.service.PackageService;

@RestController
@RequestMapping("/package")
public class PackageController {
	
	@Autowired
	private PackageService packageService;
	
	@RequestMapping
	public Collection<Pack> getAllPrices() {
		return packageService.getAllPrices();
	}
	
	@RequestMapping(value = "/{weight}", method = RequestMethod.GET)
	public Pack getPriceByWeight(@PathVariable int weight) {
		return packageService.getPriceByWeight(weight);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void insertPack(@RequestBody Pack pack) {
		packageService.insertPackage(pack);
	}
	
	@RequestMapping(value = "/{weight}" , method = RequestMethod.DELETE)
	public void removePack(@PathVariable int weight) {
		packageService.removePack(weight);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public void updatePack(@RequestBody Pack pack) {
		packageService.updatePack(pack);
	}
}
