package behaviours;

import agents.IRSensorAgent;
import agents.RobotAgent;
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

	private static final MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);	
	ACLMessage robotMsg;

	public IRSensorBehaviour(Agent agent){
		super(agent);
	}
	
	@Override
	public void action() {
		robotMsg = myAgent.receive(mt);
		if(robotMsg != null){
			System.out.println("message received");
			if(robotMsg.equals(RobotAgent.MAYIMOVEFORWARD)){
				sendMessage(IRSensorAgent.yes);
				System.out.println("forward");
			}
		}else{
			this.block();
		}
		
	}

	private void sendMessage(String message){
		ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
		msg.addReceiver(robotMsg.getSender());
		msg.setContent(message);
		myAgent.send(msg);	
	}
	
}
