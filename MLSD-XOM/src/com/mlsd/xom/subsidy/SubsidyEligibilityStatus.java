package com.mlsd.xom.subsidy;

/**
 * The available Subsidy responses (Eligibility Output Response) for the
 * applicants
 * 
 * @author Ahmed Sharafeldin
 *
 */
public class SubsidyEligibilityStatus {

	/**
	 * the eligibility statuses
	 * 
	 * @author Ahmed Sharafeldin
	 *
	 */
	public enum EligibilityStatus {
		ELIGIBLE, INELIGIBLE, PUD
	}

	private EligibilityStatus eligibilityStatus = EligibilityStatus.ELIGIBLE;

	public SubsidyEligibilityStatus() {
		// Empty Constructor For NULL Avoidance
	}

	public EligibilityStatus getEligibilityStatus() {
		if (eligibilityStatus == null)
			eligibilityStatus = EligibilityStatus.ELIGIBLE;
		return eligibilityStatus;
	}

	public void setEligibilityStatus(EligibilityStatus eligibilityStatus) {
		this.eligibilityStatus = eligibilityStatus;
	}

}
