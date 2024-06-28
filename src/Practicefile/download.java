package Practicefile;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.c2lbiz.symbiosys.systemcommon.util.FileUtil;

public class download {
	public void save(LinkedHashMap<String, Object> userdetails,
			LinkedHashMap<String, LinkedHashMap<String, BasePolicyDO>> insurancelist) throws Exception
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Which party sequence you want to search fro?");
		for(Map.Entry key:userdetails.entrySet()){
			System.out.println(key.getKey());
		}
		String seq=sc.next();
		PartyDO user=(PartyDO) userdetails.get(seq);
		for(Map.Entry key:userdetails.entrySet()){
			if(seq.equalsIgnoreCase((String) key.getKey()) ){
				String print=user.toString();
				if(insurancelist.containsKey(key.getKey())){
					for(Map.Entry<String, LinkedHashMap<String, BasePolicyDO>> existuser:insurancelist.entrySet()){
						LinkedHashMap<String, BasePolicyDO> userplolicy=existuser.getValue();
						print=print+userplolicy.toString();
					}
				}
				else{
					System.out.println("No policy found");
				}
				Fileutil.createFile("C:\\Users\\deepak.kumavat\\Documents\\New folder\\","user"+user.getPartySeq()+".txt", 
						print);
			}
			
		}
		
	}
}