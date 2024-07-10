package dslproject;
import java.util.*;
class book{
	String name;
	String authname;
	String genre;
	int sellcopies;
	int rentcopies;
	float price;
	book left;
	book right;
	book(String name, String authname, String Genre, int sellcopies, int rentcopies, float Price){
		this.name=name;
		this.authname=authname;
		genre=Genre;
		this.sellcopies=sellcopies;
		this.rentcopies=rentcopies;
		price=Price;
		left=null;
		right=null;
	}
}
class Tree{
	book root, ptr,temp;
	Tree() {
		root=null;
	}
	void create(){
	temp=new book("The Lord Of The Rings","J R R Tolkien ","Action",15,15,250);
	arrange(temp);
	temp=new book("The Hobbit","J R R Tolkien","Action", 10,10,200);
	arrange(temp);
	temp=new book("Dune","Frank Herbert","Action", 15,15,180);
	arrange(temp);
	temp=new book("The Alchemist","Paulo Coehlo","Action", 25,25,250);
	arrange(temp);
	temp=new book("Batman","Frank Miller","Comic", 20,20,280);
	arrange(temp);
	temp=new book("This One Summer","Maniko Tamaki","Comic", 10,10,180);
	arrange(temp);
	temp=new book("Nimona","ND Sterson","Comic", 10,10,150);
	arrange(temp);
	temp=new book("X Men","Chris Claremont","Comic", 15,15,200);
	arrange(temp);
	temp=new book("Ghost Circles","Jeff Smith","Comic", 15,15,180);
	arrange(temp);
	temp=new book("Ring","Koji Suzuki","Horror", 20,20,280);
	arrange(temp);
	temp=new book("The Haunting Of Hill House","Shirley Jackson","Horror", 15,15,280);
	arrange(temp);
	temp=new book("Ghost Story","Peter Strahub","Horror", 15,10,150);
	arrange(temp);
	temp=new book("Bird Box","Josh Malerman","Horror", 20,20,280);
	arrange(temp);
	temp=new book("Dracula","Bram Stoker","Horror", 15,15,150);
	arrange(temp);
	temp=new book("Pride And Prejudice","Jane Austen","Romace", 20,20,280);
	arrange(temp);
	temp=new book("The Notebook","Nicholas Sparks","Romace", 20,20,280);
	arrange(temp);
	temp=new book("Red White And Royal Blue","Casey McQuistin","Romace", 15,15,250);
	arrange(temp);
	temp=new book("Call Me By Your Name","Andre Aciman","Romace", 15,15,150);
	arrange(temp);
	temp=new book("Outlander","Diana Gabaldon","Romace", 10,10,150);
	arrange(temp);
	temp=new book("The Great Gatsby","Scott Fritzberg","Fiction", 15,15,200);
	arrange(temp);
	temp=new book("Nineteen Eighty Four","George Orwell","Fiction", 15,15,200);
	arrange(temp);
	temp=new book("Invisible Man","Ralph Ellison","Fiction", 20,20,250);
	arrange(temp);
	temp=new book("Lolita","Vladimir Nabakov","Fiction", 10,10,100);
	arrange(temp);
	temp=new book("Midnight's Children","Salman Rushdie","Fiction", 20,20,180);
	arrange(temp);
	}
	void arrange(book b) {
		int flag=0;
		if (root==null) {
			root=b;
			flag=1;
		}
		else {
			ptr=root;
			while(flag==0) {
				if(ptr.name.compareTo(b.name)>0) {
					if(ptr.left!=null)
						ptr=ptr.left;
					else {
						ptr.left=b;
						flag=1;
						break;
					}
				}
				if(ptr.name.compareTo(b.name)<0) {
					if(ptr.right!=null)
						ptr=ptr.right;
					else {
						ptr.right=b;
						flag=1;
						break;
					}
				}	
			}
		}
		
	}
}
class Store{
	book root=null;
	boolean search() {
		
	}
	void sell() {
		//1. search
		//2. ask number of copies
		//3. check if copies are enough
		//4. if yes-> ask for coupon
		//5. check for valid coupon, yes-> discounted price, else normal price
		//6. update number of sell copies
		//7. show total amount to pay
		//8. if book not found, display unavailable, ask do you want to rent it instead, yes-> go to rent
		//
	}
	void rent(){
		//1. search
		//2. ask number of copies
		//3. check if copies are enough
		//4. yes-> rent
		// update number of copies
		//5. no->ask if they want to buy instead, yes->go to sell
		//6. update link list with date of renting
	}
	void Return() {
		// check when book was issued
		// calculate days
		//if days<7 -> calculate normal rent to be paid
		// if days>7 -> calculate extra days(days-7) then calculate rent extra days*fine per day
		//update rent copies
		// delete link list node
	}
	
	
	
}
public class bookstore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
