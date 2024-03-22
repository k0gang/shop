package shop;

import java.util.Scanner;

public class Shop {
	
	private final int JOIN = 1;
	private final int REMOVE_USER = 2;
	private final int LOG_IN = 3;
	private final int LOG_OUT = 4;
	private final int SHOPPING = 5;
	private final int MYPAGE = 6;
	private final int ADMIN = 7;
	private final int EXIT = 0;

	private final int ADD_ITEM = 1;
	private final int DELETE_ITEM = 2;
	private final int UPDATE_ITEM = 3;
	private final int TOTAL_INCOME = 4;
	
	private final int DELETE_CART = 1;
	private final int UPDATE_CART = 2;
	private final int BUY = 3;
		
	private Scanner sc = new Scanner(System.in);
	private String title;
	private int log;
	
	UserManager userManager = UserManager.getInstance();
	ItemManager itemManager = ItemManager.getInstance();
	
	
	public Shop(String title) {
		this.title = title;
		log = -1;
	}
	
	
	
	
	
	private void join() {
		String id = inputString("id");
		String pw = inputString("pw");
	
		User user = new User(id,pw);
		
		if(userManager.checkDupl(id)) {
			System.err.println("중복된 id가 존재합니다");
			return;
		}
		
		userManager.add(user);
		
		System.out.printf("%s님 회원가입 완료\n",id);
	}
	
	
	
	
	private void logIn() {
		String id = inputString("id");
		String pw = inputString("pw");
		
		User user = new User(id,pw);
		
		int index = userManager.findUserIndex(user);
		
		if(index == -1) {
			System.err.println("회원정보가 일치하지 않습니다");
			return;
		}
		
		System.out.printf("%s님 로그인 완료\n",id);
		
		this.log = index;
	}
	
	private void logOut() {
		User user = userManager.findUserByIndex(log);
		
		System.out.printf("%s님 로그아웃 완료\n",user.getId());
		
		this.log = -1;
	}
	
	private void shopping() {
		itemManager.printItems();
		
		int index = inputNumber("상품 번호")-1;
		
		Item item = itemManager.findItemByIndex(index);
		
		if(item == null) {
			System.err.println("다시 확인");
			return;
		}
		
		int amount = inputNumber("갯수 입력");
		
		if(amount <= 0 || amount > 99) {
			System.out.println("다시 확인");
			return;
		}
		
		User user = userManager.findUserByIndex(log);
		
		System.out.println(item);
		System.out.printf("%d개 장바구니 담기 완료\n",amount);
		
		while(amount > 0) {
			user.addCart(item);
			
			amount --;
		}
	}
	
	private void myPage() {
		printCart();
		
		printMyPageMenu();
		
		int sel = inputNumber("입력");
		
		runMyPage(sel);
	}

	private void runMyPage(int sel) {
//		if(sel == DELETE_CART)
//			deleteCart();
//		else if(sel == UPDATE_CART)
//			updateCart();
//		else if(sel == BUY)
//			buy();
	}
	
	private void printCart() {
		
		User user = userManager.findUserByIndex(log);

		user.printCart();
		
	}
	
	

	
	private void addItem() {
		itemManager.printItems();
		
		String name = inputString("name");
		int price = inputNumber("price");
		
		Item item = new Item(name,price);
		
		if(itemManager.checkDupl(item)) {
			System.err.println("같은 이름의 item이 존재합니다");
			return;
		}
		
		itemManager.add(item);
		
		int index = itemManager.findItemIndex(item);
		
		System.out.printf("%d) %s (%d원) 등록완료\n",index+1,name,price);
	}
	
	private void deleteItem() {
		itemManager.printItems();
		
		String name = inputString("name");
		
		Item item = itemManager.findItemByName(name);
		
		if(item == null) {
			System.err.println("입력하신 상품이 존재하지 않습니다");
			return;
		}
		
		System.out.printf("%s 삭제 완료\n",name);
		
		itemManager.remove(item);
		
	}
	
	private void updateItem() {
		itemManager.printItems();
		
		String name = inputString("name");
		
		Item item = itemManager.findItemByName(name);
		
		if(item == null) {
			System.err.println("입력하신 상품이 존재하지 않습니다");
			return;
		}
		
		int price = inputNumber("수정할 가격");
		
		item.setPrice(price);
		
		System.out.println("수정 완료" + item);
		
	}
	
	private void runAdminMenu(int sel) {
		if(sel == ADD_ITEM) 
			addItem();
		else if(sel == DELETE_ITEM)
			deleteItem();
		else if(sel == UPDATE_ITEM)
			updateItem();
//		else if(sel == TOTAL_INCOME)
//			showTotalIncome();
	}
	
	private void printMyPageMenu() {
		System.out.println("1)항목 삭제");
		System.out.println("2)수량 수정");
		System.out.println("3)결제");
	}
	
	private void admin() {
		System.out.println("1)아이템 등록");
		System.out.println("2)아이템 삭제");
		System.out.println("3)아이템 수정");
		System.out.println("4)매출 조회");
		
		int sel = inputNumber("입력");
		
		runAdminMenu(sel);
	}
	
	public void run() {
		while(true) {
			printMenu();
			int sel = inputNumber("입력");
			
			runMenu(sel);
		}
	}
	
	private void runMenu(int sel) {
		if(sel == JOIN && !isLogin())
			join();
//		else if(sel == REMOVE_USER && isLogin())
//			removeUser();
		else if(sel == LOG_IN && !isLogin())
			logIn();
		else if(sel == LOG_OUT && isLogin())
			logOut();
		else if(sel == SHOPPING && isLogin())
			shopping();
		else if(sel == MYPAGE && isLogin())
			myPage();
		else if(sel == ADMIN && !isLogin())
			admin();
//		else if(sel == EXIT)
//			exit();
	}
	
	private boolean isLogin() {
		return this.log == -1 ? false : true;
	}
	
	private void printMenu() {
		if(isLogin()) {
			System.out.println("----------------");
			User user = userManager.findUserByIndex(log);
			System.out.printf("%s님 로그인중\n",user.getId());
		}
		
		System.out.printf("---%s Shop---\n",title);
		System.out.println("1) 회원가입");
		System.out.println("2) 탈퇴");
		System.out.println("3) 로그인");
		System.out.println("4) 로그아웃");
		System.out.println("5) 쇼핑하기");
		System.out.println("6) 마이페이지");
		System.out.println("7) 관리자모드");
		System.out.println("0) 종료");
	}
	
	private int inputNumber(String message) {
		int number = -1;
		try {
			System.out.printf(message + " : ");
			String input = sc.next();
			number = Integer.parseInt(input);
		} catch (Exception e) {
			System.err.println("숫자만 입력가능합니다");
		}
		return number;
	}

	private String inputString(String message) {
		System.out.print(message + " : ");
		return sc.next();
	}
	
}
