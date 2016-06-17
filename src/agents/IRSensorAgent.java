package agents;

import behaviours.IRSensorBehaviour;
import jade.core.Agent;

import jade.domain.FIPAAgentManagement.DFAgentDescription;
import jade.domain.FIPAAgentManagement.ServiceDescription;
import jade.domain.DFService;
import jade.domain.FIPAException;

public class IRSensorAgent extends Agent{

	public final static String yes= "Yes";
	public final static String no= "No";
	
	protected void setup(){
				
		System.out.println("Setting up Infra Red sensor named: "+ this.getLocalName());
		
		this.addBehaviour(new IRSensorBehaviour(this));
		
	}
}
