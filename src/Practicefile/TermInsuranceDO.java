package Practicefile;

public class TermInsuranceDO extends BasePolicyDO {
	String PolicySeq;
	Double PremiumAmt;
	Double SumAssured;
	
	
	@Override
	public String toString() {
		return "TermInsuranceDO [PolicySeq=" + PolicySeq + ", PremiumAmt="
				+ PremiumAmt + ", SumAssured=" + SumAssured + "]";
	}
	
	public TermInsuranceDO(String partyseq,String agentid, Double sumAssured)  {
		super(partyseq,agentid);
		this.PolicySeq=Integer.toString(Sequence_generator.getinstance().policySeq++);
		this.SumAssured=sumAssured;
		this.PremiumAmt=calculatepremium.premiumcalulation(sumAssured);
		
	}
	public String getPolicySeq() {
		return PolicySeq;
	}
	public void setPolicySeq(String policySeq) {
		PolicySeq = policySeq;
	}
	public Double getPremiumAmt() {
		return PremiumAmt;
	}
	public void setPremiumAmt(Double premiumAmt) {
		PremiumAmt = premiumAmt;
	}
	public Double getSumAssured() {
		return SumAssured;
	}
	public void setSumAssured(Double sumAssured) {
		SumAssured = sumAssured;
	}
	
}
