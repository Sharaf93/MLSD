package com.mlsd.xom.subsidy;

public class SubsidyEligibilityStatus {

	public enum EligibilityStatus {
		ELIGIBLE, INELIGIBLE, PUD
	}

	private EligibilityStatus eligibilityStatus = EligibilityStatus.ELIGIBLE;

	public SubsidyEligibilityStatus() {

	}

	public EligibilityStatus getEligibilityStatus() {
		if(eligibilityStatus == null)
			eligibilityStatus = EligibilityStatus.ELIGIBLE;
		return eligibilityStatus;
	}

	public void setEligibilityStatus(EligibilityStatus eligibilityStatus) {
		this.eligibilityStatus = eligibilityStatus;
	}

}
