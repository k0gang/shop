package shop;

import java.util.ArrayList;

public class UserManager {
	ArrayList<User> list = new ArrayList<>();
	
	private static UserManager instance = new UserManager();
	
	
	public static UserManager getInstance() {
		return instance;
	}
	
	
	
	
	
	public int findUserIndex(User tempUser) {
		for(int i=0; i<list.size(); i++) {
			User user = list.get(i);
			
			if(user.getId().equals(tempUser.getId()) && user.getPassword().equals(tempUser.getPassword())) 
				return i;
		}
		return -1;
	}
	
	public boolean checkDupl(String id) {
		for(User user : list)
			if(user.getId().equals(id))
				return true;
		return false;
	}
	
	public void add(User user) {
		list.add(user);
	}
}
