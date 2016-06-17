package behaviours;

import agents.RobotAgent;
import jade.core.AID;
import jade.core.Agent;

import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import jade.core.behaviours.CyclicBehaviour;

import java.util.Random;


public class RobotBehaviour extends CyclicBehaviour{

	private static final long serialVersionUID = 1L;
	
	private static final MessageTemplate mt = MessageTemplate.MatchPerformative(ACLMessage.REQUEST);
	ACLMessage message;
	
	int countActions = 0;//conta quantas mensagens foram trocadas
	
	public RobotBehaviour(Agent agent){
		super (agent);
	}

	@Override
	public void action() {
		//o agente vai verificar se recebeu ou nao alguma mensagem
		if (countActions == 0) {//primeira mensagem
			//enviar a primeira mensagem
			sendFirstMessage();
			countActions++;
		}else {
			message = myAgent.receive(mt);
			if (message != null) {
				send_new_message();
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
}
