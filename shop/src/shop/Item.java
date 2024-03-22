package shop;

public class Item {
	private String name;
	private int price;
	
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public void setPrice (int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	
	@Override
	public String toString() {
		return String.format("%s : %d원",name,price);
	}
}
