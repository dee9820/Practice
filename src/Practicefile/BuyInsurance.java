package Practicefile;

import java.util.LinkedHashMap;
import java.util.Scanner;



public class BuyInsurance {

	public void buypolicy(String partySeq, LinkedHashMap<String, AgentDO> agentlist, 
			LinkedHashMap<String, LinkedHashMap<String, BasePolicyDO>> insurancelist) {
		Scanner sc=new Scanner(System.in);
		LinkedHashMap<String, BasePolicyDO> policy=insurancelist.get(partySeq);

//		if(insurancelist.containsKey(partySeq)){
//			policy=insurancelist.get(partySeq);
//		}
//		else{
//			policy=new LinkedHashMap<String, BasePolicyDO>();
//		}

		while(true){
			int flag=0;
			System.out.println("which insurance you want to buy?");
			System.out.println("1.Term insurance \n2.Health Insurance");
			int insurance=sc.nextInt();

			switch(insurance){
			case 1:if(!policy.containsKey("TI")){
				System.out.println("Enter the AgentID");
				String agentid=sc.next();
				if(agentlist.containsKey(agentid)){
					System.out.println("Select sumAssured: \n1.1 Cr \n2.2 Cr \n3.3 Cr");
					int sumAssured=sc.nextInt();
					switch(sumAssured){
					case 1: TermInsuranceDO newinsurance1=new TermInsuranceDO(partySeq,agentid,(double) 10000000);
					policy.put("TI", newinsurance1);
					insurancelist.put(partySeq, policy);
					break;
					case 2: TermInsuranceDO newinsurance2=new TermInsuranceDO(partySeq,agentid,(double) 20000000);
					policy.put("TI", newinsurance2);
					insurancelist.put(partySeq, policy);
					break;
					case 3: TermInsuranceDO newinsurance3=new TermInsuranceDO(partySeq,agentid,(double) 30000000);
					policy.put("TI", newinsurance3);
					insurancelist.put(partySeq, policy);
					break;
					}
				}
				else{
					System.out.println("Inavlid AgentID...");
				}


			}
			else{
				System.out.println("You already have an insurance do you wnat to upgrade?(yes/no)");
				String input=sc.next();
				if(input.equalsIgnoreCase("yes")){
					System.out.println("Select sumAssured: \n1.1 Cr \n2.2 Cr \n3.3 Cr");
					int sumAssured=sc.nextInt();
					switch(sumAssured){
					case 1: TermInsuranceDO newinsurance1=(TermInsuranceDO) policy.get("TI");
					newinsurance1.setSumAssured((double) 10000000);
					newinsurance1.setPremiumAmt(calculatepremium.premiumcalulation((double) 10000000));
					break;
					case 2: TermInsuranceDO newinsurance2=(TermInsuranceDO) policy.get("TI");
					newinsurance2.setSumAssured((double) 20000000);
					newinsurance2.setPremiumAmt(calculatepremium.premiumcalulation((double) 20000000));
					break;
					case 3:TermInsuranceDO newinsurance3=(TermInsuranceDO) policy.get("TI");
					newinsurance3.setSumAssured((double) 30000000);
					newinsurance3.setPremiumAmt(calculatepremium.premiumcalulation((double) 30000000));
					break;
					}
				}
				else{
					break;
				}
			}
			break;
			case 2:
				if(!policy.containsKey("THI")){
					System.out.println("Enter the AgentID");
					String agentid=sc.next();
					if(agentlist.containsKey(agentid)){
						System.out.println("Select sumAssured: \n1.1 Cr \n2.2 Cr \n3.3 Cr");
						int sumAssured=sc.nextInt();
						switch(sumAssured){
						case 1: TermHealthInsuranceDO newinsurance1=new TermHealthInsuranceDO(partySeq,agentid,(double) 10000000);
						policy.put("THI", newinsurance1);
						insurancelist.put(partySeq, policy);
						break;
						case 2: TermHealthInsuranceDO newinsurance2=new TermHealthInsuranceDO(partySeq,agentid,(double) 20000000);
						policy.put("THI", newinsurance2);
						insurancelist.put(partySeq, policy);
						break;
						case 3: TermHealthInsuranceDO newinsurance3=new TermHealthInsuranceDO(partySeq,agentid,(double) 30000000);
						policy.put("THI", newinsurance3);
						insurancelist.put(partySeq, policy);
						break;
						}

					}
					else{
						System.out.println("invalid agentid...");
					}
				}
				else{
					System.out.println("You already have an insurance do you wnat to upgrade?(yes/no)");
					String input=sc.next();
					if(input.equalsIgnoreCase("yes")){
						System.out.println("Select sumAssured: \n1.1 Cr \n2.2 Cr \n3.3 Cr");
						int sumAssured=sc.nextInt();
						switch(sumAssured){
						case 1: TermHealthInsuranceDO newinsurance1=(TermHealthInsuranceDO) policy.get("THI");
						newinsurance1.setSumAssured((double) 10000000);
						newinsurance1.setPremiumAmt(calculatepremium.calculatehealthpremium((double) 10000000));
						break;
						case 2: TermHealthInsuranceDO newinsurance2=(TermHealthInsuranceDO) policy.get("THI");
						newinsurance2.setSumAssured((double) 20000000);
						newinsurance2.setPremiumAmt(calculatepremium.calculatehealthpremium((double) 20000000));
						break;
						case 3: TermHealthInsuranceDO newinsurance3=(TermHealthInsuranceDO) policy.get("THI");
						newinsurance3.setSumAssured((double) 30000000);
						newinsurance3.setPremiumAmt(calculatepremium.calculatehealthpremium((double) 30000000));
						break;
						}
					}
					else{
						break;
					}
				}
				break;
			case 3:flag=1;
			break;

			default:System.out.println("Enter valid number...");
			}
			if(flag==1){
				break;
			}
		}
	}

}
