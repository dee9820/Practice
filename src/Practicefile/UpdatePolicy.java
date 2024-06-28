package Practicefile;

import java.util.LinkedHashMap;
import java.util.Map;

public class UpdatePolicy {

	public void updateinsurance(LinkedHashMap<String, LinkedHashMap<String, BasePolicyDO>> insurancelist) {
		
		for(Map.Entry<String, LinkedHashMap<String, BasePolicyDO>> policy:insurancelist.entrySet() ){
			
			LinkedHashMap<String , BasePolicyDO> user=policy.getValue();
			for(Map.Entry<String, BasePolicyDO> userpolicy:user.entrySet()){
				if(userpolicy.getValue() instanceof TermInsuranceDO){
					System.out.println("before upgrade:" +((TermInsuranceDO) userpolicy.getValue()).getPremiumAmt());
					((TermInsuranceDO)userpolicy.getValue()).setPremiumAmt(((TermInsuranceDO) 
							userpolicy.getValue()).getPremiumAmt()*1.05);
					System.out.println("after upgrade:" +((TermInsuranceDO) userpolicy.getValue()).getPremiumAmt());
				}
				else if(userpolicy.getValue() instanceof TermHealthInsuranceDO){
					System.out.println("before upgrade:" +((TermHealthInsuranceDO) userpolicy.getValue()).getPremiumAmt());
					((TermHealthInsuranceDO)userpolicy.getValue()).setPremiumAmt(((TermHealthInsuranceDO) 
							userpolicy.getValue()).getPremiumAmt()*1.05);
					System.out.println("after upgrade:" +((TermHealthInsuranceDO) userpolicy.getValue()).getPremiumAmt());
				}
			}
		}
		
	}

}
