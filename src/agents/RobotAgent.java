package agents;

import behaviours.RobotBehaviour;
import jade.core.Agent;


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
            
			this.addBehaviour(new RobotBehaviour(this));
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
		  
	}
}
