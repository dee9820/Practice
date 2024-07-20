package Practicefile;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Delete {

	public void remove(LinkedHashMap<String, Object> userdetails) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Which party sequence you want to remove");
		for(Map.Entry key:userdetails.entrySet()){
			System.out.println(key.getKey());
		}
		String sequence=sc.next();
		for(Map.Entry key:userdetails.entrySet()){
			if(sequence.equalsIgnoreCase((String) key.getKey()) ){
				userdetails.remove(sequence);

			}
		}
		
	}

}
