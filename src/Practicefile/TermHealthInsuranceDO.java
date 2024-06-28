package Practicefile;

public class TermHealthInsuranceDO extends BasePolicyDO {
	String policySeq;
	Double PremiumAmt;
	Double SumAssured;
	Double Healthcover;
	@Override
	public String toString() {
		return "TermHealthInsuranceDO [policySeq=" + policySeq
				+ ", PremiumAmt=" + PremiumAmt + ", SumAssured=" + SumAssured
				+ ", Healthcover=" + Healthcover + "]";
	}
	public TermHealthInsuranceDO(String Partyseq,String agentid, Double sumAssured) {
		super(Partyseq,agentid);
		this.SumAssured=sumAssured;
		this.policySeq=Integer.toString(Sequence_generator.getinstance().policySeq++);
		this.PremiumAmt=calculatepremium.calculatehealthpremium(sumAssured);
		this.Healthcover=sumAssured*0.05;
		
	}
	public String getPolicySeq() {
		return policySeq;
	}
	public void setPolicySeq(String policySeq) {
		this.policySeq = policySeq;
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
	public Double getHealthcover() {
		return Healthcover;
	}
	public void setHealthcover(Double healthcover) {
		Healthcover = healthcover;
	}
	
}
