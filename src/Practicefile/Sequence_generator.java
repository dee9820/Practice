package Practicefile;

public class Sequence_generator {
	private static Sequence_generator seobj;
	int PartySeq;
	int addressSeq;
	int contactSeq;
	int policySeq;
	int AgentID;
	private Sequence_generator() {
		PartySeq=1;
		addressSeq=1;
		contactSeq=1;
		policySeq=1;
		AgentID=1;
	}
	
	public static Sequence_generator getinstance(){
		if(seobj!=null){
			return seobj;
		}
		else{
			seobj=new Sequence_generator();
			return seobj;
		}
	}
	
}
