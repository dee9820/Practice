package Practicefile;

public class AgentDO {
	String AgentID;
	String AgentName;
	
	@Override
	public String toString() {
		return "AgentDO [AgentID=" + AgentID + ", AgentName=" + AgentName + "]";
	}

	public String getAgentID() {
		return AgentID;
	}

	public void setAgentID(String agentID) {
		AgentID = agentID;
	}

	public String getAgentName() {
		return AgentName;
	}

	public void setAgentName(String agentName) {
		AgentName = agentName;
	}
	
	
	
}
