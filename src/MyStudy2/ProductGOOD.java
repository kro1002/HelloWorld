package MyStudy2;

import java.util.Calendar;

public class ProductGOOD {
	
	private String name;
	private double price;
	private int quantity;

		
	public ProductGOOD() {
		this.name = "";
		this.price = 0;
		this.quantity = 0;
	
		
	}
	
	public ProductGOOD(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		
		
	}
	


	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
		
	}
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}
