package agents;

import jade.core.Agent;



public class RobotAgent extends Agent {

	private static final long serialVersionUID = 1L;
	
	protected void setup() {
		System.out.println("O robô foi ativado!");
		
	}
	
	protected void take_down() {
		System.out.println("O robo foi desativado!");
	}

}
