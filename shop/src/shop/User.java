package shop;

public class User {
	private String id,password;
	
	Cart cart = Cart.getInstance();
	
	public User(String id, String password) {
		this.id = id;
		this.password = password;
		
	}
	
	public String getId() {
		return this.id;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void addCart(Item item) {
		cart.addItem(item);
	}
}
