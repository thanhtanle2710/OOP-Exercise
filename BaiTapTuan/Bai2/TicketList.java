import java.util.ArrayList;

public class TicketList{
	private ArrayList<Integer> tickets= new ArrayList<Integer>();
	public TicketList(int capacity) {
		for(int i=0;i<capacity;i++)
		{
			tickets.add(i+1);
		}
	}

	public synchronized boolean sellTicket(int AgentID)
	{  
		if(tickets.size()>0)
	    {System.out.println("Agent "+AgentID+" sold ticket "+tickets.get(0));
	    tickets.remove(0);
	    return true;}
		return false;
	
	}
}
