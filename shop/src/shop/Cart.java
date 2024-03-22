package shop;

import java.util.ArrayList;

public class Cart {
	private ArrayList<Item> list = new ArrayList<>();
	
	ItemManager itemManager = ItemManager.getInstance();

	
	
	
	
	public void addItem(Item item) {
		list.add(item);
	}


	public void printCart() {
		
		int[] temp = new int[list.size()];
		
		for(Item item : list){
			int idx = itemManager.findItemIndex(item);
			
			temp[idx] ++;
		}
		
		for(int i=0; i<temp.length; i++) {
			Item item = itemManager.findItemByIndex(i);
			
			if(temp[i] > 0) {
				System.out.printf("%s %d개 : %d원\n",item.getName(),temp[i],
						temp[i] * item.getPrice());
			}
		}
			
	
	}
}
