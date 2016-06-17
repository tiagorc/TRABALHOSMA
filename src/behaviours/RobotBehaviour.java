package behaviours;

import jade.core.AID;
import jade.core.Agent;

import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;

import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;


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
		}else {
			if (message != null) {
				System.out.println(message.getContent());
//				sendNewMessage();
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
		first_message.setContent(myAgent.getLocalName() + "May I move forwards?");
		myAgent.send(first_message);
	}
}
