package postenApp.com.alab.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Pack {
	@Id
	private int weight;
	private int price;
	// worth having default constructor???
	
	public Pack(int weight, int price) {
		this.weight = weight;
		this.price = price;
	}
	
	public Pack() {
		
	}
	
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
}
