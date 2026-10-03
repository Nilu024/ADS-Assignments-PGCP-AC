import java.util.Scanner;

public class RailwayBerthBooking {
	
	static void bookBirth(int arr[], int index) {
		
		if(index < 1 || index > arr.length) {
			System.out.println("---- Invalid berth number. ----");
			return;
		}
		
		int birthNo = index - 1;
		
		if (arr[birthNo] == 0) {
			arr[birthNo] = 1;
			System.out.println("---- Birth Booked. ----");
			return;
		} else {
			System.out.println("---- Birth Already Booked. ----");
			return;
		}
	}
	
	static void cancelBirth(int arr[], int index) {
		
		if(index < 1 || index > arr.length) {
			System.out.println("---- Invalid berth number. ----");
			return;
		}
		
		int birthNo = index -1;
		
		if(arr[birthNo] == 1) {
			arr[birthNo] = 0;
			System.out.println("---- Booking Canceled. ----");
			return;
		} else {
			System.out.println("---- Booking never done. ----");
			return;
		}
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Railway Berth Booking.");
		
		int[] births = {0, 0, 0, 0, 0, 0};
		
		boolean exit = false;
		do {
			System.out.println("\n==============================");
		System.out.print("1. Book Berth\r\n"
				+ "2. Cancel Berth\r\n"
				+ "3. Display Berths\r\n"
				+ "4. Exit\r\n"
				+ "Enter Choice: ");
		
		int choice = sc.nextInt();
		switch (choice) {
		case 1: 
		{
			System.out.print("Enter Birth No: ");
			int index = sc.nextInt();
			bookBirth(births, index);
			break;
		}
		
		case 2: 
		{
			System.out.print("Enter Birth No: ");
			int index = sc.nextInt();
			cancelBirth(births, index);
			break;	
		}
		
		case 3: 
		{
			for (int i = 0; i < births.length; i++) {
				int birthNo = i + 1;
				System.out.println(births[i] == 0 ? (birthNo + " is Available.") : (birthNo + " is Booked."));
			}
			break;
		}
		
		case 4:
		{
			exit = true;
			System.out.println("---- Thanks! ----");
			System.out.println("==============================");
			break;
		}
		
		default:
			System.out.println("Invalid Choice.");
		}
		
		
		} while(!exit);
		
	}

}
