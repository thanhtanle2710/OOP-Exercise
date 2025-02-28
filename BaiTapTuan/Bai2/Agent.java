
public class Agent extends Thread{
private int AgentID;
private TicketList list;
public Agent(int agentID, TicketList list) {
	AgentID = agentID;
	this.list = list;
}
@Override
	public void run() {
		while(true)
		{   
			if(!list.sellTicket(AgentID)) {
				break;
			}
			try {
				sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
			
		
		
	}

}
