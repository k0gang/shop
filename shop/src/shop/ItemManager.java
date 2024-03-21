package shop;

import java.util.ArrayList;

public class ItemManager {
	ArrayList<Item> list = new ArrayList<>();
	
	private static ItemManager instance = new ItemManager();
	
	
	public static ItemManager getInstance() {
		return instance;
	}
	
	
	
	public boolean checkDupl(Item tempItem) {
		for(Item item : list)
			if(item.getName().equals(tempItem.getName()))
					return true;
		return false;	
	}
	
	public void add(Item item) {
		list.add(item);
	}
	
}
