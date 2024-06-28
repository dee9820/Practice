package Practicefile;

import java.util.ArrayList;

public class PartyDO {
	String partyTypeCd;
	String partySeq;
	String firstName;
	String birthDate;
	int age;
	ArrayList<partyAddressDO> partyAddressDOList=new ArrayList<partyAddressDO>();
	ArrayList<partyContactDO> partyContactDOList=new ArrayList<partyContactDO>();
	
	
	@Override
	public String toString() {
		return "PartyDO \npartyTypeCd=" + partyTypeCd + ", partySeq=" + partySeq
				+ "\n firstName=" + firstName + "\n birthDate=" + birthDate
				+ "\n age=" + age + "\n partyAddressDOList=" + partyAddressDOList
				+ "\n partyContactDOList=" + partyContactDOList;
	}
	public String getPartyTypeCd() {
		return partyTypeCd;
	}
	public void setPartyTypeCd(String partyTypeCd) {
		this.partyTypeCd = partyTypeCd;
	}
	public String getPartySeq() {
		return partySeq;
	}
	public void setPartySeq(String partySeq) {
		this.partySeq = partySeq;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public ArrayList<partyAddressDO> getPartyAddressDOList() {
		return partyAddressDOList;
	}
	public void setPartyAddressDOList(ArrayList<partyAddressDO> partyAddressDOList) {
		this.partyAddressDOList = partyAddressDOList;
	}
	public ArrayList<partyContactDO> getPartyContactDOList() {
		return partyContactDOList;
	}
	public void setPartyContactDOList(ArrayList<partyContactDO> partyContactDOList) {
		this.partyContactDOList = partyContactDOList;
	}
	
	
}
