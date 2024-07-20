package Practicefile;

public class BasePolicyDO {
	

	String Partseq;
	String agentID;
	
	@Override
	public String toString() {
		return "BasePolicyDO [Partseq=" + Partseq + ", agentID=" + agentID
				+ "]";
	}

	public String getAgentID() {
		return agentID;
	}

	public void setAgentID(String agentID) {
		this.agentID = agentID;
	}

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
