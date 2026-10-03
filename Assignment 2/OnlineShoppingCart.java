import java.util.ArrayList;
import java.util.Scanner;

class Product {
	int id;
	String name;
	double price;
	int quantity;
	
	public Product(int id, String name, double price, int quantity) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	public double total() {
		double total = 0;
		total += (this.price * this.quantity);
		return total;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}
	
}

public class OnlineShoppingCart {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		ArrayList<Product> card = new ArrayList<>();
		
		System.out.println("===== Online Shopping Cart =====\n");
		
		boolean exit = false;
		do {
		System.out.print("1. Add product\r\n"
				+ "2. Remove product\r\n"
				+ "3. Update quantity\r\n"
				+ "4. Display cart\r\n"
				+ "5. Calculate total\r\n"
				+ "6. Exit\r\n"
				+ "Enter Choice: ");
		int choice = sc.nextInt();
		
		switch(choice) {
		
		case 1:
		{
			System.out.println("Enter Product Data:");
			int id = sc.nextInt();
			String name = sc.next();
			double price = sc.nextDouble();
			int quantity = sc.nextInt();
			card.add(new Product(id, name, price, quantity));
			break;
		}
		
		case 2 :
		{
			System.out.print("Enter index: ");
			int index = sc.nextInt();
			card.remove(index);
			break;
			
		}
		
		case 3:
		{
			System.out.print("Enter index: ");
			int index = sc.nextInt();
			Product prod = card.get(index);
			System.out.print("Enter new quantity: ");
			int quantity = sc.nextInt();
			prod.setQuantity(quantity);
			break;
		}
		
		case 4: 
		{
			for (Product product : card) {
				System.out.println(product);
			}
			break;
		}
		
		case 5 :
		{
			double total = 0;
			for (Product product : card) {
				total += product.total();
			}
			System.out.println("Total = " + total);
			break;
		}
		
		case 6 :
		{
			exit = true;
			System.out.println("----- Thank You. -----");
			break;
		}
		
		default:
		{
			System.out.println("----- Invalid Choice. -----");
			break;
		}
		}
		
		
		} while(!exit);
	}

}
