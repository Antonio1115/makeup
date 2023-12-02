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
		int days;
		boolean cont = true;
		while(cont) {
			
			System.out.println("Do you want to check in or check out");
			
			
			System.out.println("Name and room number and days:");
			name = scan.next();
			roomNum = scan.nextInt();
			days=scan.nextInt();
			customer = findCustumer(customers, name);
		
			
			
			if(customer!=null){
				if(roomNum>=100 && roomNum<110){
					room = findRoom(normalroom, roomNum);
					if(room.getstatus().equals("Occupied")) {
						System.out.println("Room is occupied");
					}
					else {
						setRoom(normalroom, customer, roomNum);
						System.out.println(room.getroomNumber() + " now "+room.getstatus()+" for " + days);
					}
				
				}
				else if(roomNum>=110&&roomNum<=119){
					room = findExecRoom(executiveroom, roomNum);
					if(room.getstatus().equals("Occupied")) {
						System.out.println("Room is occupied");
					}
					else {
						setExecRoom(executiveroom, customer, roomNum);
						System.out.println(room.getroomNumber() + " now "+room.getstatus()+" for " + days);
					}
				}
				else{
					System.out.println("Not a room");
					cont=false;
				}
			}
			else {
				System.out.println("Not a customer");
				cont=false;
			}
			
		}
		
	}
	
	
		public static Customer findCustumer(Customer[] customers, String name){
			for(Customer customer : customers){
				if(customer.getname().equals(name)) return customer;
			}
			return null;
		}
		public static NormalRoom findRoom(NormalRoom[] rooms, int roomNumber){
			for(NormalRoom room : rooms){
				if(room.getroomNumber()==roomNumber) return room;
			}
			return null;
		}
		public static NormalRoom findExecRoom(ExecutiveRoom[] rooms, int roomNumber){
			for(NormalRoom room : rooms){
				if(room.getroomNumber()==roomNumber) return room;
			}
			return null;
		}
		public static void setRoom(NormalRoom[] rooms, Customer customer, int roomNumber){
			for(int i = 0; i< rooms.length; i++){
				if(rooms[i].getroomNumber()==roomNumber&&(rooms[i].getstatus()).equals("Available")){
					customer.setroom(roomNumber);
					rooms[i].changestatus("Occupied");
					return;
				}
			}
			System.out.println("Not available");
		}
		public static void setExecRoom(ExecutiveRoom[] rooms, Customer customer, int roomNumber){
			for(int i = 0; i< rooms.length; i++){
				if(rooms[i].getroomNumber()==roomNumber&&rooms[i].getstatus().equals("Available")){
					customer.setroom(roomNumber);
					rooms[i].changestatus("Occupied");
					return;
				}
			}
			System.out.println("Not available");
		}
}
