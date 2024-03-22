package shop;

import java.util.ArrayList;

public class Cart {
	private ArrayList<Item> list = new ArrayList<>();
	
	private static Cart instance = new Cart();
	
	public static Cart getInstance() {
		return instance;
	}
	
	public void addItem(Item item) {
		list.add(item);
	}

}
