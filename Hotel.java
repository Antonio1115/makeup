import java.util.Scanner;
public class Hotel {
public static void main (String[] args) {

	NormalRoom[] normalroom = new NormalRoom[10];
	
	normalroom[0] = new NormalRoom(100, 10);
	normalroom[1] = new NormalRoom(101, 10);
	normalroom[2] = new NormalRoom(102, 10);
	normalroom[3] = new NormalRoom(103, 10);
	normalroom[4] = new NormalRoom(104, 10);
	normalroom[5] = new NormalRoom(105, 10);
	normalroom[6] = new NormalRoom(106, 10);
	normalroom[7] = new NormalRoom(107, 10);
	normalroom[8] = new NormalRoom(108, 10);
	normalroom[9] = new NormalRoom(109, 10);
	
	ExecutiveRoom[] executiveroom = new ExecutiveRoom[10];
	
	executiveroom[0] = new ExecutiveRoom(110,10, 15);
	executiveroom[1] = new ExecutiveRoom(111,10, 15);
	executiveroom[2] = new ExecutiveRoom(112,10, 15);
	executiveroom[3] = new ExecutiveRoom(113,10, 15);
	executiveroom[4] = new ExecutiveRoom(114,10, 15);
	executiveroom[5] = new ExecutiveRoom(115,10, 15);
	executiveroom[6] = new ExecutiveRoom(116,10, 15);
	executiveroom[7] = new ExecutiveRoom(117,10, 15);
	executiveroom[8] = new ExecutiveRoom(118,10, 15);
	executiveroom[9] = new ExecutiveRoom(119,10, 15);
	
	Customer[] customers = new Customer[3];
	
	customers[0] = new Customer("Pier");
	customers[1] = new Customer("Logan");
	customers[2] = new Customer("Robert");
	
	Scanner scan = new Scanner(System.in);
	
	boolean booking = true;

	while (booking) {
		System.out.println("Name and the room number you are booking:");
		String name = scan.nextLine();
		int roomnumber = scan.nextInt();
		scan.nextLine();
		
		Customer customer = findname(customers, name);
		ExecutiveRoom Executiveroom = findexecutiveroom(executiveroom, roomnumber);
		NormalRoom Normalroom = findnormalroom(normalroom, roomnumber);
		
		
		setbyroomnumber(normalroom,roomnumber,customer);
		
		if(customer != null &&  roomnumber >= 100 && roomnumber <= 119) {
			
			if(roomnumber >= 100 && roomnumber < 110) {
			
				System.out.println("Room number: " + customer.getroomNumber() + " is " + Normalroom.getstatus());
				
			}
			
			if(roomnumber >= 110 && roomnumber <= 119)
			
				System.out.println("Room number: " + customer.getroomNumber() + " is " + Executiveroom.getstatus());
			
		}
		
		else System.out.println("oops");
		
					}
	}

	public static Customer findname(Customer[] customers, String name) {
		for(Customer customer: customers) {
			if(customer != null && customer.getname().equals(name)) {
				return customer;
			}
		}
		return null;
	}
	public static NormalRoom findnormalroom(NormalRoom[] normalroom, int roomnumber) {
		for(NormalRoom Normalroom: normalroom) {
			if(Normalroom != null && Normalroom.getroomNumber() == roomnumber) {
				return Normalroom;
			}
		}
		return null;	
	}
	
	public static ExecutiveRoom findexecutiveroom(ExecutiveRoom[] executiveroom, int roomnumber) {
		for(ExecutiveRoom Executiveroom: executiveroom) {
			if(Executiveroom != null && Executiveroom.getroomNumber() == roomnumber) {
				return Executiveroom;
			}
		}
		return null;	
	}

	public static void setbyroomnumber(NormalRoom[] normalrooms,int roomnumber,Customer customer) {
		for (int i = 0; i < normalrooms.length; i++) {
			if (roomnumber == normalrooms[i].getroomNumber()&& "Available".equals(normalrooms[i].getstatus()) && customer.getroomNumber() == -1) {
				customer.setroom(normalrooms[i].getroomNumber());
			}
		}
	}

	public static void setroomnumber(NormalRoom[] normalrooms, Customer customer) {
		for (int i = 0; i < normalrooms.length; i++) {
			if ("Available".equals(normalrooms[i].getstatus())) {
				customer.setroom(normalrooms[i].getroomNumber());
				normalrooms[i].changestatus("Occupied");
				return;
			}
		}
	}

	
}


