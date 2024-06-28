package Practicefile;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class Update {
	public void Edit(LinkedHashMap<String, Object> userdetails) throws ParseException {
		//		listofuser.get(0).setFirstName("Deepak");
		Scanner sc=new Scanner(System.in);
		System.out.println("Which party sequence you want to update?");
		String sequence=sc.next();
		for(Map.Entry key:userdetails.entrySet()){
			System.out.println(key.getKey());
		}
		
		while(true){
			int counter=0;
			PartyDO user=(PartyDO) userdetails.get(sequence);
			for(int i=0;i<userdetails.size();i++){
				if(sequence.equalsIgnoreCase(user.getPartySeq())){
					int number;
					System.out.println("Select what you want to update:");
					ArrayList<String> list=new ArrayList<String>(Arrays.asList("1.PartTypeCD","2.First Name"
							,"3.Last Name","4.BirthDate/Age","5.Gender","6.Address","7.Contact","8.Exit"
							));

					for(String str:list){
						System.out.println(str);
					}
					number=sc.nextInt();


					switch (number) {

					case 1: ArrayList<String> partytype=new ArrayList<String>(Arrays.asList("Individual","Oraganisation"));
					System.out.println("Select the Type:");
					for(int j=0;j<partytype.size();j++){
						System.out.println(j+1+"."+partytype.get(j));
					}
					int type;
					while(true){
						type=sc.nextInt();
						int flag=1;
						switch (type) {
						case 1:user.setPartyTypeCd("Individual");
						break;
						case 2:user.setPartyTypeCd("Organisation");
						break;
						default:System.out.println("Invalid input..");
						flag=0;
						}
						if(flag==1){
							break;
						}
					}
					break;

					case 2:System.out.println("Enter First Name:");
					while (true) {
						String firstname=sc.next();
						int flag=0;
						if(registration.ValidateName(firstname)){
							user.setFirstName(firstname);
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
					break;

					case 3:
						break;

					case 4:System.out.println("Enter Birth date(DD/MM/YYYY):");
					String date=sc.next();
					SimpleDateFormat sdf=new SimpleDateFormat("DD/MM/YYYY");
					Date birthdate=sdf.parse(date);
					user.setBirthDate(date);
					Date sydate=new Date();
					int age=DateUtil.getAge(birthdate, sydate);
					user.setAge(age);
					break;

					case 5:
						break;

					case 6:while(true){
						System.out.println("1.Add more address \n2.upadte existing address \n3.exit");
						int input=sc.nextInt();
						int addressflag=0;
						switch (input) {
						case 1:while(true){
							System.out.println("Entre Address Details:");
							partyAddressDO UserAddress=new partyAddressDO();

							System.out.println("Enter Party address Sequence:");
							UserAddress.setPartyAddressSeq(sc.next());

							UserAddress.setPartySeq(user.getPartySeq());

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
							int k=1;
							String[] State=null;
							for(String key:CountryStateMp.keySet()){
								if(key.equals(UserAddress.getCoutryCd())){
									State=CountryStateMp.get(key);
									for(String value:State){
										System.out.println(k+"."+value);
										k++;
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

							user.getPartyAddressDOList().add(UserAddress);
							System.out.println(UserAddress);
							System.out.println("Do you want to add more address(Y/N)?");
							char answer=sc.next().charAt(0);
							if(answer=='N'){
								registration.CheckPrimary(user);
								break;
							}
						}

						break;
						case 2:System.out.println("Select which party address sequence you want to update:");
						for(int m=0;m<user.getPartyAddressDOList().size();m++){
							System.out.println(user.getPartyAddressDOList().get(m).getPartyAddressSeq());
						}
						String partsequence=sc.next();
						while(true){
							int flaga=0;
							for(int l=0;l<user.getPartyAddressDOList().size();l++){
								if(partsequence.equalsIgnoreCase(user.getPartyAddressDOList()
										.get(l).getPartyAddressSeq())){
									System.out.println("select what you want to update:");
									System.out.println("1.AddressType \n2.Country \n3.State \n4.AddressDetails" +
											"\n5.pincode \n6.Primary Address \n7.exit");
									int toupdatec=sc.nextInt();
									switch(toupdatec){
									case 1:System.out.println("Enter Address Type:");
									user.getPartyContactDOList().get(l).setContactType(sc.next());
									break;
									case 2:System.out.println("Select Country:");
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

										case 1: user.getPartyAddressDOList().get(l).setCoutryCd("India");
										break;
										case 2:user.getPartyAddressDOList().get(l).setCoutryCd("USA");
										break;
										case 3:user.getPartyAddressDOList().get(l).setCoutryCd("Canada");
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
									int k=1;
									String[] State=null;
									for(String key:CountryStateMp.keySet()){
										if(key.equals(user.getPartyAddressDOList().get(l).getCoutryCd())){
											State=CountryStateMp.get(key);
											for(String value:State){
												System.out.println(k+"."+value);
												k++;
											}
											break;
										}	
									}
									while(true){
										Statenumber=sc.nextInt();
										int flag=1;
										switch (Statenumber) {
										case 1: user.getPartyAddressDOList().get(l).setStateCd(State[0]);
										break;
										case 2:user.getPartyAddressDOList().get(l).setStateCd(State[1]);
										break;
										case 3:user.getPartyAddressDOList().get(l).setStateCd(State[2]);
										break;
										default:System.out.println("Invalid input..");
										flag=0;
										}
										if(flag==1){
											break; 
										}
									}
									break;
									
									case 3:
									Map<String,String[]> CountryState=new LinkedHashMap<String, String[]>();
									CountryState.put("India",new String[] {"Maharashtra","Delhi","Rajashthan"});
									CountryState.put("USA",new String[] {"NewYork","California","Texas"});
									CountryState.put("Canada",new String[] {"Ontario", "Quebec", "Alberta"});	
									System.out.println("Select your State:");
									int Stateno;
									int n=1;
									String[] Statelist=null;
									for(String key:CountryState.keySet()){
										if(key.equals(user.getPartyAddressDOList().get(l).getCoutryCd())){
											Statelist=CountryState.get(key);
											for(String value:Statelist){
												System.out.println(n+"."+value);
												n++;
											}
											break;
										}	
									}
									while(true){
										Stateno=sc.nextInt();
										int flag=1;
										switch (Stateno) {
										case 1: user.getPartyAddressDOList().get(l).setStateCd(Statelist[0]);
										break;
										case 2:user.getPartyAddressDOList().get(l).setStateCd(Statelist[1]);
										break;
										case 3:user.getPartyAddressDOList().get(l).setStateCd(Statelist[2]);
										break;
										default:System.out.println("Invalid input..");
										flag=0;
										}
										if(flag==1){
											break; 
										}
									}
										break;
										
									case 4://address detail
										break;
										
									case 5://pin codes
										break;
										
									case 6:System.out.println("do you want to make the address as Primary address(0/1):");
									user.getPartyAddressDOList().get(l).setPrimaryAddress(sc.next());
									for (int check=0;check<user.getPartyAddressDOList().size();check++){
										registration.CheckPrimary(user);
									}
										break;
										
									case 7:flaga=1;
									break;
									
									default:System.out.println("Invalid input please enter correct input.");
									break;
									}
								}
							}
							if(flaga==1){
								break;
							}
							
						}
						break;
						case 3:addressflag=1;
						break;
						default:System.out.println("Invalid input please enter correct input.");
							break;
						}
						if(addressflag==1){
							break;
						}
						
					}
					break;
					
					case 7:while(true){
						System.out.println("1.Add new Contact \n2.Edit exixting Contact \n3.exit");
						int contactinput=sc.nextInt();
						int contactflag=0;
						switch (contactinput) {

						case 1:while(true){
							System.out.println("Enter contact detail:");

							partyContactDO userContact=new partyContactDO();

							System.out.println("Enter partyContactSeq:");
							userContact.setPartyContactSeq(sc.next());

							System.out.println("Enter contactType:");
							userContact.setContactType(sc.next());

							System.out.println("enter contactNum:");
							userContact.setContactNum(sc.next());

							user.getPartyContactDOList().add(userContact);

							System.out.println("Do you want to add more contact(Y/N)?");
							char ans=sc.next().charAt(0);
							if(ans=='N'){
								break;
							}
						}
						break;

						case 2:System.out.println("Select which party contact sequence you want to update:");
						for(int m=0;m<user.getPartyContactDOList().size();m++){
							System.out.println(user.getPartyContactDOList().get(m).getPartyContactSeq());
						}
						String partsequence=sc.next();
						while(true){
							int flagc=0;
							for(int l=0;l<user.getPartyContactDOList().size();l++){
								if(partsequence.equalsIgnoreCase(user.getPartyContactDOList()
										.get(l).getPartyContactSeq())){
									System.out.println("select what you want to update:");
									System.out.println("1.contacttype \n2.contact number \n3.Done");
									int toupdatec=sc.nextInt();
									switch(toupdatec){
									case 1:System.out.println("Enter contactType:");
									user.getPartyContactDOList().get(l).setContactType(sc.next());
									break;
									case 2:System.out.println("Enter contact number:");
									user.getPartyContactDOList().get(l).setContactNum(sc.next());
									break;
									case 3:flagc=1;
									break;
									default:System.out.println("Invalid input please enter correct input.");
									break;
									}
								}
							}
							if(flagc==1){
								break;
							}
							
						}
						break;
						case 3:contactflag=1;
						break;
						default:System.out.println("Invalid input please enter correct input.");
						break;

						}
						if(contactflag==1){
							break;
						}
					}
                    break;
					case 8:counter=1;
					break;
					default:System.out.println("Invalid Input.....");

					}
				}

			}
			if(counter==1){
				break;
			}
		}
	}
}
