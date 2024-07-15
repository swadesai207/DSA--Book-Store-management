/*
 MINI PROJECT= ONLINE BOOK STORE
 PROJECT BY= 
 VEDIKA DESAI (UCE2022449)
 SWASTISHRI DESAI(UCE2022448)
 PRAJAKTA CHAUDHARI(UCE2022437)
 BATCH=A2
 
 */


package miniproject;
// imported all packages.
import java.text.SimpleDateFormat;   
import java.util.LinkedList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Random;

class Node {  //Details of the Book
	int isbn;
	String name;
	String author;
	int sellCopies;
	int rentCopies;
	float price;
	Date returnDate;
	String genre;

	public Node(int isbn, String name, String author, String genre, int sellCopies, int rentCopies, float price) {
		this.isbn = isbn;
		this.name = name;
		this.author = author;
		this.sellCopies = sellCopies;
		this.rentCopies = rentCopies;
		this.price = price;
		this.genre = genre;
		this.returnDate = null;
	}
}

class Online_bookstore{ 
	int flag = 0;
	int isbn;
	String author;
	Scanner sc = new Scanner(System.in);
	HashMap<String, Node> x1;   //Created hashmap for storing books
	final String DATE_FORMAT = "dd-MM-yyyy";
	int copiesFromCustomer;
	LinkedList<Integer> ll=new LinkedList<>();   //Created linked list to store membership

	public Online_bookstore() {
		x1 = new HashMap<>();  //Initialize hashmap
	}

	void create() {   //1. adding books in our bookstore.
		add(2613, "The Lord Of The Rings", "J R R Tolkien", "Action", 1, 1, 250);
		add(9845, "The Hobbit", "J R R Tolkien", "Action", 10, 10, 200);
		add(7643, "Jurassic Park", "Micheal Crichton", "Action", 15, 15, 250);
		add(8943, "Dune", "Frank Herbert", "Action", 25, 15, 180);
		add(3242, "The Alchemist", "Paulo Coelho", "Action", 25, 25, 250);
		add(8797, "Batman", "Frank Miller", "Comic", 20, 20, 280);
		add(1343, "This One Summer", "Mariko Tamaki", "Comic", 10, 10, 180);
		add(1977, "Nimona", "Noelle Stevenson", "Comic", 10, 10, 150);
		add(9898, "X-Men", "Chris Claremont", "Comic", 15, 15, 200);
		add(5522, "Ghost Circles", "Jeff Smith", "Comic", 15, 15, 180);
		add(4322, "Ring", "Koji Suzuki", "Horror", 20, 20, 280);
		add(9875, "The Haunting Of Hill House", "Shirley Jackson", "Horror", 15, 15, 280);
		add(9009, "Ghost Story", "Peter Straub", "Horror", 15, 10, 150);
		add(3901, "Bird Box", "Josh Malerman", "Horror", 20, 20, 280);
		add(9805, "Dracula", "Bram Stoker", "Horror", 15, 15, 150);
		add(6899, "Pride And Prejudice", "Jane Austen", "Romance", 20, 20, 280);
		add(5534, "The Notebook", "Nicholas Sparks", "Romance", 20, 20, 280);
		add(2002, "Red, White, And Royal Blue", "Casey McQuiston", "Romance", 15, 15, 250);
		add(1205, "Call Me By Your Name", "Andre Aciman", "Romance", 15, 15, 150);
		add(6775, "Outlander", "Diana Gabaldon", "Romance", 10, 10, 150);
		add(2222, "The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 15, 15, 200);
		add(9906, "Nineteen Eighty-Four", "George Orwell", "Fiction", 15, 15, 200);
		add(4453, "Invisible Man", "Ralph Ellison", "Fiction", 20, 20, 250);
		add(3232, "Lolita", "Vladimir Nabokov", "Fiction", 10, 10, 100);
		add(5969, "Midnight's Children", "Salman Rushdie", "Fiction", 20, 20, 180);
		ll.add(5243);                                                                  //2.Adding memberships
		ll.add(5543);
		ll.add(6342);
	}

	void add(int i, String n, String a, String g, int s, int r, float p) {
		Node b = new Node(i, n, a, g, s, r, p);
		x1.put(b.name, b);
	}

	Node searchbook(String key) {
		Node sample = x1.get(key);
		System.out.println(sample.name);
		return sample;
	}

	public void buyFromCustomer(String name) {
		Node book = x1.get(name);
		System.out.println("please note: " + name + " not present in store,then 50 rs discount ");
		if (book != null) {
			System.out.println("How many copies of '" + name + "' are you selling?");
			int copiesFromCustomer = sc.nextInt();
			float purchasePricePerCopy = 150;

			float totalPrice = purchasePricePerCopy * copiesFromCustomer;

			System.out.println("Book(s) purchased from the customer: " + name);
			System.out.println("Author: " + book.author);
			System.out.println("Number of copies purchased: " + copiesFromCustomer);
			System.out.println("Total Purchase Price: " + totalPrice);

			book.rentCopies += copiesFromCustomer; // Add the purchased books to rentCopies
		} else {
			// Book not found in the store, insert it into the store's inventory
			System.out.println("Book not found in the store. Inserting it into the inventory...");
			System.out.println("please enter author name");
			String au = sc.next();
			System.out.println("please enter the isbn number of book");
			int a = sc.nextInt();
			sc.nextLine();
			System.out.println("please enter genre");
			String genre = sc.next();
			float price = 200;
			System.out.println("Enter the number of copies available for rent:");
			int rentCopies = sc.nextInt();

			// Create a new book and add it to the store
			Node newBook = new Node(a, name, au, genre, 0, copiesFromCustomer, price);
			x1.put(name, newBook);

			System.out.println("Book inserted into the store, and " + rentCopies + " copies added to rentCopies.");
		}
	}

	public void coupon(String coupons) {
		System.out.println("Enter the coupon: ");
		String s = sc.nextLine();
		if (s.equals(coupons)) {
			System.out.println("Congrats! You will get a 5% discount.");
		} else {
			System.out.println("Sorry, you can't get a discount.");
		}
	}

	public void purchaseBook(String name, String coupons) {
		Node book = x1.get(name);
		System.out.println("How many copies do you want to purchase?");
		int c = sc.nextInt();

		if (book != null && book.sellCopies >= c) {
			System.out.println("Do you have a coupon? Enter yes for yes, or no for no.");
			String a = sc.next().toLowerCase();
			sc.nextLine();

			float totalPrice = book.price * c; // Calculate the total price before applying the coupon

			if (a.equals("yes")) {
				coupon(coupons);
				totalPrice *= 0.95; // Apply a 5% discount 
			}

			book.sellCopies -= c;

			System.out.println("Book purchased successfully: " + name);
			System.out.println("Author: " + book.author);
			System.out.println("Total Price for " + c + " copies: " + totalPrice); // Display the total price
		} else {
			System.out.println("No available copies of: " + name);

			if (flag == 0 && availableForRent()) { 
				flag = 1;
				System.out.println("You can rent this book. Would you like to rent it (yes/no)?");
				String choice = sc.next().toLowerCase();
				if (choice.equals("yes")) {
					rentBook(name, coupons);
				}
			}
		}
	}

	public boolean availableForRent() {
		for (Node b : x1.values()) {
			if (b.rentCopies > 0) {
				return true;
			}
		}
		return false;
	}

	public void rentBook(String name, String coupons) {
		Node book = x1.get(name);

		System.out.println("How many copies do you want to rent?");
		int c = sc.nextInt();

		if (book != null && book.rentCopies >= c) {
			book.rentCopies -= c;
			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
			System.out.println("Enter the rental date (dd-MM-yyyy): ");
			String rentDate = sc.next();
			try {
				Date rentalDate = sdf.parse(rentDate);
				book.returnDate = new Date(rentalDate.getTime() + 7 * 24 * 60 * 60 * 1000); // Assuming a 7-day rental period
				System.out.println("Book rented successfully: " + name);
				System.out.println("Return Date: " + sdf.format(book.returnDate));
			} catch (Exception e) {
				System.out.println("Invalid date format. Rental failed.");
			}
		} else {
			System.out.println("No available copies for rent of: " + name);
			if (flag == 0 && availableForPurchase()) {
				flag = 1;
				System.out.println("You can purchase this book. Would you like to purchase it (yes/no)?");
				String choice = sc.next().toLowerCase();
				if (choice.equals("yes")) {
					System.out.println("Do you have a coupon? Enter yes for yes, or no for no.");
					String a = sc.next().toLowerCase();
					if (a.equals("yes")) {
						coupon(coupons);
					}
					purchaseBook(name, coupons);
				}
			}
		}
	}

	public boolean availableForPurchase() {
		for (Node b : x1.values()) {
			if (b.sellCopies > 0) {
				return true;
			}
		}
		return false;
	}

	public void returnBook(String name) {
		Node book = x1.get(name);
		int TotalFee = 35;
		int totalLateFee = 0;
		if (book != null && book.returnDate != null) {
			System.out.println("How many copies do you have rented?");
			int ch = sc.nextInt();

			SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
			Date currentDate = new Date(System.currentTimeMillis());
			long Days = TimeUnit.MILLISECONDS.toDays(currentDate.getTime() - book.returnDate.getTime());

			System.out.println("do u have membership with us(yes/no)");
			String a1 = sc.next();
			if (a1.equals("yes")) {
				System.out.println("enter your unique membership number:");
				int num = sc.nextInt();
				if (ll.contains(num) == true) {
					System.out.println("yes, you are the member");
					if (Days <= 7) {
						System.out.println("Book returned on time (within 7 days).");
						// Within 7 days
						TotalFee = 35;
						System.out.println("Total  late Fee: Rs. 0");
						System.out.println("Total  Fee: Rs. " + TotalFee * ch);

					} else if (Days > 7 && Days <= 60) {
						System.out.println("Book returned " + (Days - 7) + " Days late.");
						totalLateFee = 35 + (int) ((Days - 7) * 10);
						System.out.println("thus total fees to be paid is:35+ late fees=" + totalLateFee * ch);
					} else if (Days > 60) {
						System.out.println("Book returned " + (Days - 7) + " Days late.");
						System.out.println("Your store membership is canceled.");
						totalLateFee = 35 + (int) ((Days - 7) * 10);
						System.out.println("thus total fees to be paid is:35+ late fees=" + totalLateFee * ch);

					}
					book.returnDate = null;
					book.rentCopies++;
					System.out.println("Book returned successfully: " + name);
				}

				else {
					System.out.println("Sorry, you are not a member");

				}

			} else {
				System.out.println("do u want the membership of our store");
				String a2 = sc.next();
				if (a2.equals("yes")) {
					Random random = new Random();
					int randomcode = random.nextInt(9000) + 1000;
					System.out.println("your membership code is" + randomcode);
					ll.add(randomcode);
					System.out.println("Membership added. Please pay 500.");
					if (Days <= 7) {
						System.out.println("Book returned on time (within 7 days).");
						// Within 7 days
						TotalFee = 35;
						System.out.println("Total Late Fee: Rs. " + TotalFee * ch);

					} else {
						System.out.println("Book returned " + (Days - 7) + " Days late.");
						totalLateFee = 35 + (int) ((Days - 7) * 10);
						System.out.println("thus total fees to be paid is:35+ late fees=" + totalLateFee * ch);
					}
				} else {
					if (Days <= 7) {
						System.out.println("Book returned on time (within 7 days).");
						// Within 7 days
						TotalFee = 70;
						System.out.println("Total Fee: Rs. " + TotalFee * ch);

					} else if (Days > 7 && Days <= 60) {
						System.out.println("Book returned " + (Days - 7) + " Days late.");
						totalLateFee = 70 + (int) ((Days - 7) * 20);
						System.out.println("thus total fees to be paid is:70+ late fees=" + totalLateFee * ch);
					} else if (Days > 60) {
						System.out.println("Book returned " + (Days - 7) + " Days late. You have to pay Rs 300 extra");
						totalLateFee = 70 + (int) ((Days - 7) * 20);
						System.out.println("thus total fees to be paid is:70+ late fees=" + totalLateFee * ch);

					}
				}
				if (Days <= 7) {
					System.out.println("Book returned on time (within 7 days).");
					// Within 7 days
					TotalFee = 70;
					System.out.println("Total Fee: Rs. " + TotalFee);

				} else if (Days > 7 && Days <= 60) {
					System.out.println("Book returned " + (Days - 7) + " Days late.");
					totalLateFee = 70 + (int) ((Days - 7) * 20);
					System.out.println("thus total fees to be paid is:70+ late fees=" + totalLateFee * ch);
				} else if (Days > 60) {
					System.out.println("Book returned " + (Days - 7) + " Days late. You have to pay Rs 300 extra");
					totalLateFee = 70 + (int) ((Days - 7) * 20);
					System.out.println("thus total fees to be paid is:70+ late fees=" + totalLateFee * ch);

				}
			}
		}

		else {
			System.out.println("This book is not currently rented or does not exist.");
		}
	}

}

public class bookstorefinal {

	public static void main(String[] args) {
		Online_bookstore B = new Online_bookstore();
		B.create();
		final String COUPON_CODE = "SAVE20";
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("Welcome to the Online Bookstore!");
			System.out.println("1. Search for a book by name");
			System.out.println("2. Purchase a book");
			System.out.println("3. Rent a book");
			System.out.println("4. Return a rented book");
			System.out.println("5. Buy from customer");
			System.out.println("6. Exit");
			System.out.print("Enter your choice: ");

			int choice = scanner.nextInt();
			scanner.nextLine();

			if (choice == 1) {
				System.out.print("Enter the name of the book you want to search: ");
				String bookName = scanner.nextLine();

				Node foundBook = B.searchbook(bookName);

				if (foundBook != null) {
					System.out.println("Book found: " + foundBook.name);
					System.out.println("Author: " + foundBook.author);
					System.out.println("Price: " + foundBook.price);
				} else {
					System.out.println("Book not found with the name: " + bookName);
				}
			} else if (choice == 2) {
				System.out.print("Enter the name of the book you want to purchase: ");
				String bookName = scanner.nextLine();
				B.purchaseBook(bookName, COUPON_CODE);
			} else if (choice == 3) {
				System.out.print("Enter the name of the book you want to rent: ");
				String bookName = scanner.nextLine();
				B.rentBook(bookName, COUPON_CODE);
			} else if (choice == 4) {
				System.out.print("Enter the name of the rented book you want to return: ");
				String bookName = scanner.nextLine();
				B.returnBook(bookName);
			} else if (choice == 6) {
				System.out.println("Thank you for visiting our store. Goodbye!");
				break;
			} else if (choice == 5) {
				System.out.print("Enter the name of the book you want to buy from the customer: ");
				String bookName = scanner.nextLine();
				B.buyFromCustomer(bookName);

			} else {
				System.out.println("Invalid choice. Please select a valid option.");
			}
		}

		scanner.close();
	}

}
/*
  OUTPUT=
 Welcome to the Online Bookstore!
1. Search for a book by name
2. Purchase a book
3. Rent a book
4. Return a rented book
5. Buy from customer
6. Exit
Enter your choice: 1
Enter the name of the book you want to search: Dune
Dune
Book found: Dune
Author: Frank Herbert
Price: 180.0
Welcome to the Online Bookstore!
1. Search for a book by name
2. Purchase a book
3. Rent a book
4. Return a rented book
5. Buy from customer
6. Exit
Enter your choice: 2
Enter the name of the book you want to purchase: The Alchemist
How many copies do you want to purchase?
2
Do you have a coupon? Enter yes for yes, or no for no.
yes
Enter the coupon: 
SAVE20
Congrats! You will get a 5% discount.
Book purchased successfully: The Alchemist
Author: Paulo Coelho
Total Price for 2 copies: 475.0
Welcome to the Online Bookstore!
1. Search for a book by name
2. Purchase a book
3. Rent a book
4. Return a rented book
5. Buy from customer
6. Exit
Enter your choice: 3
Enter the name of the book you want to rent: Ghost Story
How many copies do you want to rent?
1
Enter the rental date (dd-MM-yyyy): 
20-10-2023
Book rented successfully: Ghost Story
Return Date: 27-10-2023
Welcome to the Online Bookstore!
1. Search for a book by name
2. Purchase a book
3. Rent a book
4. Return a rented book
5. Buy from customer
6. Exit
Enter your choice: 4
Enter the name of the rented book you want to return: Ghost Story
How many copies do you have rented?
1
do u have membership with us(yes/no)
no
do u want the membership of our store
yes
your membership code is9814
Membership added. Please pay 500.
Book returned 5 Days late.
thus total fees to be paid is:35+ late fees=85
Book returned 5 Days late.
thus total fees to be paid is:70+ late fees=170
Welcome to the Online Bookstore!
1. Search for a book by name
2. Purchase a book
3. Rent a book
4. Return a rented book
5. Buy from customer
6. Exit
Enter your choice: 2
Enter the name of the book you want to purchase: wrw
How many copies do you want to purchase?
4
No available copies of: wrw
You can rent this book. Would you like to rent it (yes/no)?
no
Welcome to the Online Bookstore!
1. Search for a book by name
2. Purchase a book
3. Rent a book
4. Return a rented book
5. Buy from customer
6. Exit
Enter your choice: 3
Enter the name of the book you want to rent: The Alchemist
How many copies do you want to rent?
2
Enter the rental date (dd-MM-yyyy): 
1-11-2023
Book rented successfully: The Alchemist
Return Date: 08-11-2023
Welcome to the Online Bookstore!
1. Search for a book by name
2. Purchase a book
3. Rent a book
4. Return a rented book
5. Buy from customer
6. Exit
Enter your choice: 4
Enter the name of the rented book you want to return: The Alchemist
How many copies do you have rented?
1
do u have membership with us(yes/no)
yes
enter your unique membership number:
9814
yes, you are the member
Book returned on time (within 7 days).
Total  late Fee: Rs. 0
Total  Fee: Rs. 35
Book returned successfully: The Alchemist
Welcome to the Online Bookstore!
1. Search for a book by name
2. Purchase a book
3. Rent a book
4. Return a rented book
5. Buy from customer
6. Exit
Enter your choice: 5
Enter the name of the book you want to buy from the customer: trex
please note: trex not present in store,then 50 rs discount 
Book not found in the store. Inserting it into the inventory...
please enter author name
dino
please enter the isbn number of book
2343
please enter genre
fiction
Enter the number of copies available for rent:
4
Book inserted into the store, and 4 copies added to rentCopies.
Welcome to the Online Bookstore!
1. Search for a book by name
2. Purchase a book
3. Rent a book
4. Return a rented book
5. Buy from customer
6. Exit
Enter your choice: 1
Enter the name of the book you want to search: trex
trex
Book found: trex
Author: dino
Price: 200.0
Welcome to the Online Bookstore!
1. Search for a book by name
2. Purchase a book
3. Rent a book
4. Return a rented book
5. Buy from customer
6. Exit
Enter your choice: 6
Thank you for visiting our store. Goodbye!
 */
