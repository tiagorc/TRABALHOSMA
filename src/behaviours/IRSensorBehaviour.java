package behaviours;

import jade.core.AID;
import jade.core.Agent;
import jade.core.ProfileImpl;
import jade.core.Profile;
import jade.wrapper.PlatformController;
import jade.wrapper.AgentController;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;

public class IRSensorBehaviour extends CyclicBehaviour{

	public IRSensorBehaviour(Agent agent){
		super(agent);
	}
	
	@Override
	public void action() {
		ACLMessage msg = myAgent.receive();
		if(msg != null){

		}
		
	}

}
