package Practicefile;

public class BasePolicyDO {
	String Partseq;
	String agentID;

	public BasePolicyDO(String partseq,String agentID) {
		this.Partseq = partseq;
		this.agentID=agentID;
	}

	public String getPartseq() {
		return Partseq;
	}

	public void setPartseq(String partseq) {
		Partseq = partseq;
	}

}
