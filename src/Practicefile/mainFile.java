package Practicefile;


import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

//import com.c2lbiz.symbiosys.systemcommon.util.FileUtil;


public class mainFile {


	public static void main(String[] args) throws Exception {

		Scanner sc=new Scanner(System.in);
		LinkedHashMap<String,Object> userdetails=new LinkedHashMap<String,Object>();
		LinkedHashMap<String, LinkedHashMap<String, BasePolicyDO>> Insurancelist=new 
				LinkedHashMap<String, LinkedHashMap<String,BasePolicyDO>>();
//		LinkedHashMap<String, LinkedHashMap<String, LinkedHashMap<String, BasePolicyDO>>> Agentpolicy=new
//				LinkedHashMap<String, LinkedHashMap<String,LinkedHashMap<String, BasePolicyDO>>>();
		LinkedHashMap<String, AgentDO> agentlist=new LinkedHashMap<String, AgentDO>();

		while(true){
			System.out.println("Select from the list:");
			System.out.println("1.New Registration"+"\n"
					+"2.Update"+"\n"+"3.Delete"+"\n"+"4.Search"+"\n"+"5.download"+"\n"+"6.Buy policy"+
					"\n7.Updatepolicy"+"\n8.agentregistartion"+"\n9.agent Search"+"\n10.Exit");
			int input=sc.nextInt();
			int flag=0;

			switch(input){
			case 1:
				PartyDO newuser=new PartyDO();
				registration r=new registration();
				r.newRegistration(newuser);
				userdetails.put(newuser.getPartySeq(), newuser);
				break;

			case 2: 
				if(!userdetails.isEmpty()){
					Update edit=new Update();
					edit.Edit(userdetails);
				}
				else{
					System.out.println("please register atleast one user first");
				}

				break;

			case 3:
				if(!userdetails.isEmpty()){
					Delete d=new Delete();
					d.remove(userdetails);
				}
				else{
					System.out.println("please register atleast one user first");
				}

				break;

			case 4:
				if(!userdetails.isEmpty()){
					Search s=new Search();
					s.display(userdetails,Insurancelist);
				}
				else{
					System.out.println("please register atleast one user first");
				}
				break;

			case 5:
				if(!userdetails.isEmpty()){
					download c=new download();
					c.save(userdetails,Insurancelist);
				}
				else{
					System.out.println("please register atleast one user first");
				}

				break;

			case 6: 
				if(!userdetails.isEmpty()){
					System.out.println("Enter PArty Sequence");
					String PartySeq=sc.next();
					if(userdetails.containsKey(PartySeq)){
						BuyInsurance insurance=new BuyInsurance();
						insurance.buypolicy(PartySeq,agentlist,Insurancelist);
					}
					else {
						System.out.println("Invalid Party Sequence...");;
					}
				}
				else{
					System.out.println("Register a user first...");
				}


				break;

			case 7:
				if (!userdetails.isEmpty()) {
					if (!Insurancelist.isEmpty()) {
						UpdatePolicy u=new UpdatePolicy();
						u.updateinsurance(Insurancelist);
					} 
					else {
						System.out.println("No policy to update...");
					}
				} 
				else {
					System.out.println("please register a user first...");
				}
				break;

				
			case 8: AgentDO newAgent=new AgentDO();
			AgentRegistration a=new AgentRegistration();
			a.newAgentRegistration(newAgent);
			agentlist.put(newAgent.getAgentID(), newAgent);
			break;
			
			case 9:agentWiseSearch agentsearch=new agentWiseSearch();
			agentsearch.searchagent(agentlist,userdetails,Insurancelist);

			case 10:
				flag=1;
				break;
			default: System.out.println("Enter a valid input:");
			}

			if(flag==1){
				break;
			}
		}
	}
}
