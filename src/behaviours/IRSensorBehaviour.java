package behaviours;

import agents.IRSensorAgent;
import agents.RobotAgent;
import jade.core.Agent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import jade.core.behaviours.CyclicBehaviour;

import java.util.Random;

public class IRSensorBehaviour extends CyclicBehaviour{
	private static final long serialVersionUID = 1L;
	
	private static final MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);	
	ACLMessage robotMsg;

	public IRSensorBehaviour(Agent agent){
		super(agent);
	}
	
	@Override
	public void action() {
		robotMsg = myAgent.receive(mt);
		if(robotMsg != null){
			String decision = decision();
			
			if (decision == IRSensorAgent.no) {
				sendMessage(IRSensorAgent.no);
			}else {
				switch (robotMsg.getContent()) {
				case RobotAgent.MAYIMOVEFORWARD:
					sendMessage(RobotAgent.MOVEFORWARD);
					break;
				case RobotAgent.MAYIMOVEBACKWARD:
					sendMessage(RobotAgent.MOVEBACKWARD);
					break;
				case RobotAgent.MAYITURNLEFT:
					sendMessage(RobotAgent.TURNLEFT);
					break;
				case RobotAgent.MAYITURNRIGHT:
					sendMessage(RobotAgent.TURNRIGHT);
					break;
				default:
					break;
				}
			}
		}else{
			this.block();
		}
	}
	
	private String decision() {
		int min = 0;
		int max = 1;
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		if (randomNum == 0) {
			return IRSensorAgent.yes;
		}else {
			return IRSensorAgent.no;
		}
	}

	private void sendMessage(String message){
		ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
		msg.addReceiver(robotMsg.getSender());
		msg.setContent(message);
		myAgent.send(msg);	
	}
	
}
