package agents;

import behaviours.IRSensorBehaviour;
import jade.core.Agent;

public class IRSensorAgent extends Agent{

	protected void setup(){
		System.out.println("Setting up Infra Red sensor named: "+ this.getLocalName());
		
		this.addBehaviour(new IRSensorBehaviour(this));
		
	}
}
