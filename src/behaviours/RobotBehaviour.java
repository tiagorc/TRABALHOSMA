package behaviours;

import agents.IRSensorAgent;
import agents.RobotAgent;
import jade.core.AID;
import jade.core.Agent;

import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import jade.core.behaviours.SimpleBehaviour;

import java.util.Random;


public class RobotBehaviour extends SimpleBehaviour{

	private static final long serialVersionUID = 1L;
	
	private static final MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
	ACLMessage message;
	
	int countActions = 0;//conta quantas mensagens foram trocadas
	
	public final static int TOTAL_MESSAGES = 10;
	
	public RobotBehaviour(Agent agent){
		super (agent);
	}

	@Override
	public void action() {
		//o agente vai verificar se recebeu ou nao alguma mensagem
		if (countActions == 0) {//primeira mensagem
			//enviar a primeira mensagem
			sendFirstMessage();
		}else {
			message = myAgent.receive(mt);
			if (message != null) {
				if (message.getContent() == IRSensorAgent.no){
					System.out.println(RobotAgent.OKAY);
				}else {
					RobotAgent.move_or_turn(message.getContent());
				}
				send_message();
			}else {
				this.block();
			}
		}	
	}
	
	private void sendFirstMessage() {
		//definição do agente
		AID receiver = new AID ("irsensor", AID.ISLOCALNAME);
		ACLMessage first_message = new ACLMessage(ACLMessage.REQUEST);
		first_message.addReceiver(receiver);
		first_message.setContent(send_new_message());
		myAgent.send(first_message);
		System.out.println("******Comunication work's!******\n\n");
	}
	
	private String send_new_message () {
		int min = 0;
		int max = 3;
		Random rand = new Random();
		int randomNum = rand.nextInt((max - min) + 1) + min;
		
		String message = "";
		switch (randomNum) {
		case 0:
			message = RobotAgent.MAYIMOVEBACKWARD;
			break;
		case 1:
			message = RobotAgent.MAYIMOVEFORWARD;
			break;
		case 2:
			message = RobotAgent.MAYITURNLEFT;
			break;
		default:
			message = RobotAgent.MAYITURNRIGHT;
			break;
		}
		return message;
	}
	
	private void send_message() {
		ACLMessage msg = new ACLMessage(ACLMessage.REQUEST);
	    msg.addReceiver(message.getSender());
	    msg.setContent(send_new_message());
	    myAgent.send(msg);
	}

	@Override
	public boolean done() {
		if (countActions == TOTAL_MESSAGES)
		      myAgent.doDelete();
		    else
		      countActions++;

		    return false;
	}
	
}
