package agents;

import behaviours.IRSensorBehaviour;
import jade.core.Agent;

public class IRSensorAgent extends Agent{
	private static final long serialVersionUID = 1L;
	
	public final static String yes= "Yes";
	public final static String no= "No";
	
	protected void setup(){
				
		System.out.println("Setting up Infra Red sensor named: "+ this.getLocalName());
		
		this.addBehaviour(new IRSensorBehaviour(this));
		
	}
	
	protected void take_down() {
		System.out.println("take_down sensor");
	}
}
