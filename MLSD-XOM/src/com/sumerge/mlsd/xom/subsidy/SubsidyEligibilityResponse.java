package com.sumerge.mlsd.xom.subsidy;

/**
 * This object was created for the output parameter of the subsidy operation.
 * 
 * @author Youssef Hatem.
 *
 */
public class SubsidyEligibilityResponse {

	private boolean eligibility = false;
	private String eligibilityText = "";

	public SubsidyEligibilityResponse() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	/**
	 * 
	 * @param eligibility
	 * @param eligibilityText
	 */
	public SubsidyEligibilityResponse(boolean eligibility, String eligibilityText) {
		super();
		this.eligibility = eligibility;
		this.eligibilityText = eligibilityText;
	}

	public boolean isEligibility() {
		return eligibility;
	}

	public void setEligibility(boolean eligibility) {
		this.eligibility = eligibility;
		this.setEligibilityText("eligiblity: " + eligibility + "");
	}

	public String getEligibilityText() {
		return eligibilityText;
	}

	public void setEligibilityText(String eligibilityText) {
		this.eligibilityText = eligibilityText;
	}

	public void markAsEligible() {
		this.eligibility = true;
	}

	public void markAsNotEligible() {
		this.eligibility = false;
	}

}
