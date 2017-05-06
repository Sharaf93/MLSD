package com.sumerge.mlsd.xom.socialcare;

import java.util.ArrayList;
import java.util.List;

/**
 * The Disability details. All the information needed about a disability.
 * 
 * @author Ahmed Sharaf
 *
 */
public class DisabilityDetails {

	/**
	 * The Disability Class.
	 * 
	 * @author Ahmed Sharaf
	 *
	 */
	public enum DisabilityClass {
		A23, B23, A24, B24, NONE;
	}

	/**
	 * The eligible services a disability can approve.
	 * 
	 * @author Ahmed Sharaf
	 *
	 */
	public enum EligibleServicesForDisability {
		FINANCIAL_SERVICE, MEDICAL_EQUIPMENT, EQUIPPED_CAR, ASSISTANCE_CARDS, VISA_FEE_WAIVER, HOME_CARE, SCHOOLING_DAY_CARE, SOCIAL_REHABILITATION, JOB_REHABILITATION, NONE
	}

	private int disabilityID = 0;
	private String disabilityDescription = "";
	private DisabilityClass disabilityClass = DisabilityClass.NONE;
	private List<EligibleServicesForDisability> eligibleServicesForDisabilityList = new ArrayList<>();

	public DisabilityDetails() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public int getDisabilityID() {
		return disabilityID;
	}

	public void setDisabilityID(int disabilityID) {
		this.disabilityID = disabilityID;
	}

	public String getDisabilityDescription() {
		return disabilityDescription;
	}

	public void setDisabilityDescription(String disabilityDescription) {
		this.disabilityDescription = disabilityDescription;
	}

	public DisabilityClass getDisabilityClass() {
		return disabilityClass;
	}

	public void setDisabilityClass(DisabilityClass disabilityClass) {
		this.disabilityClass = disabilityClass;
	}

	public List<EligibleServicesForDisability> getEligibleServicesForDisabilityList() {
		return eligibleServicesForDisabilityList;
	}

	public void setEligibleServicesForDisabilityList(List<EligibleServicesForDisability> eligibleServicesForDisabilityList) {
		this.eligibleServicesForDisabilityList = eligibleServicesForDisabilityList;
	}

}
