
import java.util.Scanner;

public class Store {
	Scanner scan = new Scanner(System.in);
	static Manager itemMgr = new Manager();
	static Manager userMgr = new Manager();
	static Manager orderMgr = new Manager();

	void run() {
		itemMgr.readAll("/Users/gwansik/git/KGU/DD015/HW10/src/input/items.txt", new Factory() {
			public Item create() {
				return new Item();
			}
		});
		userMgr.readAll("/Users/gwansik/git/KGU/DD015/HW10/src/input/user.txt", new Factory() {
			public User create() {
				return new User();
			}
		});
		orderMgr.readAll("/Users/gwansik/git/KGU/DD015/HW10/src/input/order.txt", new Factory() {
			public Order create() {
				return new Order();
			}
		});
		menu();
	}

	void menu() {
		int num;
		while (true) {
			System.out.print("(1)물품출력 (2)사용자출력 (3)주문출력 (4)검색 (기타) 종료 ");
			num = scan.nextInt();
			if (num < 1 || num > 4)
				break;
			switch (num) {
				case 1:
					itemMgr.printAll();
					break;
				case 2:
					userMgr.printAll();
					break;
				case 3:
					orderMgr.printAll();
					break;
				case 4:
					searchMenu();
					break;
				default:
					break;
			}
		}
	}

	void searchMenu() {
		int num;
		while (true) {
			System.out.print("(1)물품검색 (2)사용자검색 (3)주문검색 (기타) 종료 ");
			num = scan.nextInt();
			if (num < 1 || num > 3)
				break;
			switch (num) {
				case 1:
					itemMgr.search(scan);
					break;
				case 2:
					userMgr.search(scan);
					break;
				case 3:
					orderMgr.search(scan);
					break;
				default:
					break;
			}
		}
	}

	static Item findItem(String kwd) {
		return (Item) itemMgr.find(kwd);
	}

	static User findUser(String kwd) {
		return (User) userMgr.find(kwd);
	}

	static Order findOrder(String kwd) {
		return (Order) orderMgr.find(kwd);
	}

	public static void main(String[] args) {
		Store m = new Store();
		m.run();
	}
}
