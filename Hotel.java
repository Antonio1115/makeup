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
	String name ;
	int roomNum;
	Customer customer;
	NormalRoom room;


	System.out.println("Name and room number:");
	name = scan.nextLine();
	roomNum = scan.nextInt();
	customer = findCustomer(customers, name);

	if(customer!=null){
		if(room>=100 && room<110){
			room = findRoom(normalroom, roomNum);
			setRoom(normalroom, customer, roomNum);
			System.out.println("hi");
		}
		else if(room>=110&&room<=119){
			room = findExecRoom(executiveroom, roomNum);
			setExecRoom(executiveroom, customer, roomNum);
			System.out.println("hi")
		}
		else{
			System.out.println("Not a room")
		}
	}
	

	public static Customer findCustumer(Customer[] customers, string name){
		for(Customer customer : customers){
			if(customer.getname().equals(name)) return customer;
		}
		return null;
	}
	public static NormalRoom findRoom(NormalRoom[] rooms, int roomNumber){
		for(NormalRoom room : rooms){
			if(room.getnumber==roomNumber) return room;
		}
		return null;
	}
	public static NormalRoom findExecRoom(ExecutiveRoom[] rooms, int roomNumber){
		for(NormalRoom room : rooms){
			if(room.getnumber==roomNumber) return room;
		}
		return null;
	}

	public static void setRoom(NormalRoom[] rooms, Customer customer, int roomNumber){
		for(int i = 0; i< rooms.length; i++){
			if(rooms[i].getroomNumber()==roomNumber&&rooms[i].getstatus.equals("Available")){
				customer.setRoom(roomNumber);
				rooms[i].changestatus("occupied");
				return;
			}
		}
		System.out.println("Not available");
	}
	public static void setExecRoom(ExecutiveRoom[] rooms, Customer customer, int roomNumber){
		for(int i = 0; i< rooms.length; i++){
			if(rooms[i].getroomNumber()==roomNumber&&rooms[i].getstatus.equals("Available")){
				customer.setRoom(roomNumber);
				rooms[i].changestatus("occupied");
				return;
			}
		}
		System.out.println("Not available");
	}



}
