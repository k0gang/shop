package shop;

public class User {
	private String id,password;
	
	private Cart cart;
	
	public User(String id, String password) {
		this.id = id;
		this.password = password;
		cart = new Cart();
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
	
	public void printCart() {
		cart.printCart();
	}
	
	@Override
	public String toString() {
		return "";
	}
	
	
}
