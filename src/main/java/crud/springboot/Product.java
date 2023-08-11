package crud.springboot;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	private Integer id;
	private String name;
	private float price;
	
	
	//default constructor
	public Product() {
		
	}
	
	//constructor with parameters
	public Product(Integer id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
		}
	
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public float getPrice() {
	return price;
}
public void setPrice(float price) {
	this.price = price;
}
public void setId(Integer id) {
	this.id = id;
}
	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
		}
}