package Practicefile;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Search {

	public void display(LinkedHashMap<String, Object> userdetails, 
			LinkedHashMap<String, LinkedHashMap<String, BasePolicyDO>> insurancelist) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Which party sequence you want to search fro?");
//		for(Map.Entry key:userdetails.entrySet()){
//			System.out.println(key.getKey());
//		}
//		String seq=sc.next();
//		PartyDO user=(PartyDO) userdetails.get(seq);
//		for(Map.Entry key:userdetails.entrySet()){
//			if(seq.equalsIgnoreCase((String) key.getKey()) ){
//				System.out.println(user.toString());
//				if(insurancelist.containsKey(key.getKey())){
//					for(Map.Entry<String, LinkedHashMap<String, BasePolicyDO>> existuser:insurancelist.entrySet()){
//						LinkedHashMap<String, BasePolicyDO> userplolicy=existuser.getValue();
//						System.out.println(userplolicy.toString());
//					}
//				}
//				else{
//					System.out.println("No policy found");
//				}
//			}
//		}
		
		String number=sc.next();
		for(Map.Entry key:userdetails.entrySet()){
			PartyDO user=(PartyDO) userdetails.get(key.getKey());
			ArrayList<partyContactDO> contactnumber=user.getPartyContactDOList();
			for(int i=0;i<contactnumber.size();i++){
				if(number.equalsIgnoreCase(contactnumber.get(i).getContactNum())){
					System.out.println(user.toString());
				}
			}
		}
	}


}
