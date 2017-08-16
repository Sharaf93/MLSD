package com.mlsd.xom.socialcare;

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
	 * The eligible services a disability can approve.
	 * 
	 * @author Ahmed Sharaf
	 *
	 */
	public enum EligibleServicesForDisability {
		FINANCIAL_SERVICE, MEDICAL_EQUIPMENT, EQUIPPED_CAR, CAR_PARKING_CARD, TRAVEL_DISCOUNT_CARD, AUTISM_CARD, DRIVER_VISA_FEE_WAIVER, MAID_VISA_FEE_WAIVER, NURSE_VISA_FEE_WAIVER, HOME_CARE, SCHOOLING_DAY_CARE, SOCIAL_REHABILITATION, JOB_REHABILITATION, NONE
	}

	private int disabilityID = 0;
	private String disabilityDescription = "";
	private int disabilityClass = 15;
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

	public int getDisabilityClass() {
		return disabilityClass;
	}

	public void setDisabilityClass(int disabilityClass) {
		this.disabilityClass = disabilityClass;
	}

	public List<EligibleServicesForDisability> getEligibleServicesForDisabilityList() {
		return eligibleServicesForDisabilityList;
	}

	public void setEligibleServicesForDisabilityList(List<EligibleServicesForDisability> eligibleServicesForDisabilityList) {
		this.eligibleServicesForDisabilityList = eligibleServicesForDisabilityList;
	}

}
