package shop;

public class Item {
	String name;
	int price;
	
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	
	public String getName() {
		return this.name;
	}
	

	
	
	@Override
	public String toString() {
		return String.format("%s : %d원",name,price);
	}
}
