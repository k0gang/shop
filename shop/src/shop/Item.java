package shop;

public class Item {
	String name;
	int price;
	int number;
	
	
	public Item(String name, int price) {
		this.name = name;
		this.price = price;
		
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public int getNumber() {
		return this.number;
	}
	
	
	@Override
	public String toString() {
		return String.format("%d) %s : %d원",number,name,price);
	}
}
