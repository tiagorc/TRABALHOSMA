package agents;

import jade.core.Agent;
import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.DFService;
import jade.domain.FIPAException;



public class RobotAgent extends Agent {

	private static final long serialVersionUID = 1L;
	
	//ask
	public final static String MAYIMOVEFORWARD = "May I mode forward?";
	public final static String MAYIMOVEBACKWARD = "May I move backward?";
	public final static String MAYITURNLEFT = "May I turn left?";
	public final static String MAYITURNRIGHT = "May I turn right?";
	
	//answer
	public final static String MOVEFORWARD = "Moving forward...";
	public final static String MOVEBACKWARD = "Moving backward";
	public final static String TURNLEFT = "Turning left...";
	public final static String TURNRIGHT = "Turning right..";
	public final static String OKAY = "Okay";
	
	
	protected void setup() {
		try {
			System.out.println( getLocalName() + " setting up!");
			
			// create the agent descrption of itself
			DFAgentDescription dfd = new DFAgentDescription();
            dfd.setName( getAID() );
            DFService.register( this, dfd );
            
            //addbehaviour
		}
        catch (Exception e) {
            System.out.println( "Saw exception in HostAgent: " + e );
            e.printStackTrace();
        }
	}
	
	protected void take_down() {
		try{
			System.out.println(getLocalName() + " shut down!");
		}catch (Exception e) {
			System.out.println( "Saw exception in HostAgent: " + e );
            e.printStackTrace();
		}
	}
	
	private void move_or_turn(boolean answer, String message) {
		if (answer == true) {
			switch (message) {
			case MOVEFORWARD:
				System.out.println(message);
			case MOVEBACKWARD:
				System.out.println(message);
			case TURNLEFT:
				System.out.println(message);
			case TURNRIGHT:
				System.out.println(message);
			default:
				System.out.println("Unable to move..");
			}
		}else {
			System.out.println(OKAY);
		}
	}
	
	private void shut_down_robot() {
		try {
			DFService.deregister( this );
			doDelete();
		} catch (FIPAException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}   
	}
}
