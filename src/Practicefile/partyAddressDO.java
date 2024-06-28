package Practicefile;

public class partyAddressDO {
	String partyAddressSeq;
	String partySeq;
	String coutryCd;
	String stateCd;
	String primaryAddress;
	
	
	
	@Override
	public String toString() {
		return "partyAddressDO [partyAddressSeq=" + partyAddressSeq
				+ ", partySeq=" + partySeq + ", coutryCd=" + coutryCd
				+ ", stateCd=" + stateCd + ", primaryAddress=" + primaryAddress
				+ "]";
	}
	public String getPartyAddressSeq() {
		return partyAddressSeq;
	}
	public void setPartyAddressSeq(String partyAddressSeq) {
		this.partyAddressSeq = partyAddressSeq;
	}
	public String getPartySeq() {
		return partySeq;
	}
	public void setPartySeq(String partySeq) {
		this.partySeq = partySeq;
	}
	public String getCoutryCd() {
		return coutryCd;
	}
	public void setCoutryCd(String coutryCd) {
		this.coutryCd = coutryCd;
	}
	public String getStateCd() {
		return stateCd;
	}
	public void setStateCd(String stateCd) {
		this.stateCd = stateCd;
	}
	public String getPrimaryAddress() {
		return primaryAddress;
	}
	public void setPrimaryAddress(String primaryAddress) {
		this.primaryAddress = primaryAddress;
	}
}
