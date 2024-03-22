package shop;

import java.util.ArrayList;

public class ItemManager {
	ArrayList<Item> list = new ArrayList<>();
	
	private static ItemManager instance = new ItemManager();
	
	
	public static ItemManager getInstance() {
		return instance;
	}
	
	
	
	public int getItemSize() {
		return list.size();
	}
	
	public void printItems() {
		for(int i=0; i<list.size(); i++) {
			Item item = list.get(i);
			System.out.println(i+1 + ") " + item);
		}
	}
	
	public boolean checkDupl(Item tempItem) {
		for(Item item : list)
			if(item.getName().equals(tempItem.getName()))
					return true;
		return false;	
	}
	
	public Item getItemByIndex(int index) {
		return list.get(index);
	}
	
	public int findItemIndex(Item tempItem) {
		for(int i=0; i<list.size(); i++) {
			Item item = list.get(i);
			if(item.getName().equals(tempItem.getName()))
				return i;
		}
		return -1;
	}
	
	public Item findItemByName(String name) {
		for(Item item : list)
			if(item.getName().equals(name))
				return item;
		return null;
	}
	
	public Item findItemByIndex(int index) {
		if(index < 0 || index >= list.size()) 
			return null;
		
		return list.get(index);
	}
	
	public void add(Item item) {
		list.add(item);
	}
	
	public void remove(Item item) {
		list.remove(item);
	}
	
}










