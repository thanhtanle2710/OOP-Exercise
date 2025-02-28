
public class TestTicket {
public static void main(String[] args) {
	TicketList tl1= new TicketList(30);
	Agent a1= new Agent(112, tl1);
	Agent a2= new Agent(113, tl1);
	Agent a3= new Agent(114, tl1);
	a1.start();
	a2.start();
	a3.start();
	
	
}
}
