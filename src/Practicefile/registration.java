package Practicefile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;


public class registration {

	public static boolean ValidateName(String str){
		String expression = "^[a-zA-Z\\s]+";
		return str.matches(expression);
	}

	public static void CheckPrimary(PartyDO obj){
		int Primary=0;
		for(partyAddressDO address:obj.getPartyAddressDOList()){
			if(address.getPrimaryAddress().equals("1")){
				Primary=1;
				break;
			}

		}
		if(Primary==0){
			setPrimary(obj);
		}
	}

	public static void setPrimary(PartyDO obj){
		Scanner sc=new Scanner(System.in);
		System.out.println("Which Party Sequence Address You want to make Primary Address?");
		for(partyAddressDO address:obj.getPartyAddressDOList()){
			System.out.println(address);
		}

		while(true){
			String seqnumber=sc.next();
			int present=0;
			for(partyAddressDO address:obj.getPartyAddressDOList()){
				if(address.getPartyAddressSeq().equals(seqnumber)){
					present=1;
					address.setPrimaryAddress("1");
					break;
				}
			}
			if(present==0){
				System.out.println("Enter a valid Sequence number:");
			}
			else{
				break;
			}
		}
	}


	public void newRegistration(PartyDO userobj) throws ParseException{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Personal Details:");
//		System.out.println("Enter Party Sequence:");
		
		userobj.setPartySeq(Integer.toString(Sequence_generator.getinstance().PartySeq++));
		ArrayList<String> partytype=new ArrayList<String>(Arrays.asList("Individual","Oraganisation"));
		System.out.println("Select the Type:");
		for(int i=0;i<partytype.size();i++){
			System.out.println(i+1+"."+partytype.get(i));
		}
		int type;
		while(true){
			type=sc.nextInt();
			int flag=1;
			switch (type) {
			case 1:userobj.setPartyTypeCd("Individual");
			break;
			case 2:userobj.setPartyTypeCd("Organisation");
			break;
			default:System.out.println("Invalid input..");
			flag=0;
			}
			if(flag==1){
				break;
			}
		}

		System.out.println("Enter First Name:");
		while (true) {
			String firstname=sc.next();
			int flag=0;
			if(ValidateName(firstname)){
				userobj.setFirstName(firstname);
				break;
			}
			else{
				System.out.println("Enter only Alphabets:");
				flag=0;
			}
			if(flag==1){
				break;
			}
		}

		System.out.println("Enter Birth date(DD/MM/YYYY):");
		String date=sc.next();
		SimpleDateFormat sdf=new SimpleDateFormat("DD/MM/YYYY");
		Date birthdate=sdf.parse(date);
		userobj.setBirthDate(date);
		Date sydate=new Date();
		int age=DateUtil.getAge(birthdate, sydate);
		userobj.setAge(age);

		//		taking address from user

		while(true){
			System.out.println("Entre Address Details:");
			partyAddressDO UserAddress=new partyAddressDO();

//			System.out.println("Enter Party address Sequence:");
			UserAddress.setPartyAddressSeq(Integer.toString(Sequence_generator.getinstance().addressSeq++));

			UserAddress.setPartySeq(userobj.getPartySeq());

			Map<String,String[]> CountryStateMp=new LinkedHashMap<String, String[]>();
			CountryStateMp.put("India",new String[] {"Maharashtra","Delhi","Rajashthan"});
			CountryStateMp.put("USA",new String[] {"NewYork","California","Texas"});
			CountryStateMp.put("Canada",new String[] {"Ontario", "Quebec", "Alberta"});
			System.out.println("Select your country:");
			int country;
			int j=1;
			for(Map.Entry m:CountryStateMp.entrySet()){
				System.out.println(j+"."+m.getKey());
				j++;
			}

			while(true){
				country=sc.nextInt();
				int flag=1;
				switch (country) {

				case 1: UserAddress.setCoutryCd("India");
				break;
				case 2:UserAddress.setCoutryCd("USA");
				break;
				case 3:UserAddress.setCoutryCd("Canada");
				break;
				default:System.out.println("Invalid input..");
				flag=0;
				}
				if(flag==1){
					break; 
				}
			}

			System.out.println("Select your State:");
			int Statenumber;
			int i=1;
			String[] State=null;
			for(String key:CountryStateMp.keySet()){
				if(key.equals(UserAddress.getCoutryCd())){
					State=CountryStateMp.get(key);
					for(String value:State){
						System.out.println(i+"."+value);
						i++;
					}
					break;
				}	
			}
			while(true){
				Statenumber=sc.nextInt();
				int flag=1;
				switch (Statenumber) {
				case 1: UserAddress.setStateCd(State[0]);
				break;
				case 2:UserAddress.setStateCd(State[1]);
				break;
				case 3:UserAddress.setCoutryCd(State[2]);
				break;
				default:System.out.println("Invalid input..");
				flag=0;
				}
				if(flag==1){
					break; 
				}
			}

			System.out.println("Is this your Primary address(0/1):");
			UserAddress.setPrimaryAddress(sc.next());

			userobj.getPartyAddressDOList().add(UserAddress);
			System.out.println(UserAddress);
			System.out.println("Do you want to add more address(Y/N)?");
			char answer=sc.next().charAt(0);
			if(answer=='N'){
				CheckPrimary(userobj);
				break;
			}
		}
		
		//taking Contact details
		
		
		while(true){
			System.out.println("Enter contact detail:");

			partyContactDO userContact=new partyContactDO();

//			System.out.println("Enter partyContactSeq:");
			userContact.setPartyContactSeq(Integer.toString(Sequence_generator.getinstance().contactSeq++));

			System.out.println("Enter contactType:");
			userContact.setContactType(sc.next());

			System.out.println("enter contactNum:");
			userContact.setContactNum(sc.next());

			userobj.getPartyContactDOList().add(userContact);

			System.out.println("Do you want to add more contact(Y/N)?");
			char ans=sc.next().charAt(0);
			if(ans=='N'){
				break;
			}
		}
		
		System.out.println("Entered Details:"+"\n"+userobj.getPartyTypeCd()+" "+userobj.getPartySeq()+" "+userobj.getFirstName()+" "+userobj.getBirthDate()+" "+userobj.getAge());
		
		for(partyAddressDO address:userobj.getPartyAddressDOList()){
			System.out.println(address);
		}
		
		for(partyContactDO contact:userobj.getPartyContactDOList()){
			System.out.println(contact);
		}
	}
}


