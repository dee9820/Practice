
package Practicefile;

import java.util.LinkedHashMap;
import java.util.Scanner;


public class AgentRegistration {

	public void newAgentRegistration(AgentDO newAgent) {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("your AgentID:"+Sequence_generator.getinstance().AgentID);
		newAgent.setAgentID(Integer.toString(Sequence_generator.getinstance().AgentID++));
		
		System.out.println("Enter your name");
		newAgent.setAgentName(sc.next());
		
		
	}

}
