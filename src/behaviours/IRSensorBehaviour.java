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
			System.out.println(robotMsg.getContent());
			switch (robotMsg.getContent()) {
			case RobotAgent.MOVEFORWARD:
				sendMessage(IRSensorAgent.yes);
				System.out.println("Go forward!");
				break;
			case RobotAgent.MOVEBACKWARD:
				sendMessage(IRSensorAgent.yes);
				System.out.println("Go backward!");
				break;
			case RobotAgent.TURNLEFT:
				sendMessage(IRSensorAgent.yes);
				System.out.println("Turn left!");
				break;
			case RobotAgent.TURNRIGHT:
				sendMessage(IRSensorAgent.yes);
				System.out.println("Turn right!");
				break;
			default:
				break;
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
