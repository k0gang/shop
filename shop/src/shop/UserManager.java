package shop;

import java.util.ArrayList;

public class UserManager {
	ArrayList<User> list = new ArrayList<>();
	
	private static UserManager instance = new UserManager();
	
	
	public static UserManager getInstance() {
		return instance;
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
