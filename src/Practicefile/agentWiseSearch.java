package Practicefile;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;



public class agentWiseSearch {

	public void searchagent(
			LinkedHashMap<String, AgentDO> agentlist,
			LinkedHashMap<String, Object> userdetails,
			LinkedHashMap<String, LinkedHashMap<String, BasePolicyDO>> insurancelist) {
		
		Scanner sc=new Scanner(System.in);
		 
		 System.out.println("Enter agent ID:");
		 String agentId=sc.nextLine();
		 AgentDO agent=agentlist.get(agentId);
		 System.out.println(agent.toString());
		 if (agentlist.containsKey(agentId)) {
			 System.out.println();
			for(Entry<String, LinkedHashMap<String, BasePolicyDO>> policy:insurancelist.entrySet()){
				LinkedHashMap<String, BasePolicyDO> userpolicy=policy.getValue();
				for(Map.Entry<String, BasePolicyDO> user:userpolicy.entrySet()){
					if(agentId.equalsIgnoreCase(user.getValue().getAgentID())){
						System.out.println(user.toString());
					}
				}
			}
		} else {
			System.out.println("Invalid Agent ID...");
		}
	}

}
