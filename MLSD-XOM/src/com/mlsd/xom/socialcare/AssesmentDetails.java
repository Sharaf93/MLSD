package com.mlsd.xom.socialcare;

import java.util.Calendar;

/**
 * The details of the disability assessment for the applicant.
 * 
 * @author Ahmed Sharaf
 *
 */
public class AssesmentDetails {

	private int iqLevel = 120;
	private boolean disabilityAssesmentIsValid = true;
	private int disabilityClass = 15;
	private Calendar disabilityAssesmentDate = Calendar.getInstance();

	public AssesmentDetails() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public int getIqLevel() {
		return iqLevel;
	}

	public void setIqLevel(int iqLevel) {
		this.iqLevel = iqLevel;
	}

	public boolean isDisabilityAssesmentIsValid() {
		return disabilityAssesmentIsValid;
	}

	public void setDisabilityAssesmentIsValid(boolean disabilityAssesmentIsExpired) {
		this.disabilityAssesmentIsValid = disabilityAssesmentIsExpired;
	}

	public Calendar getDisabilityAssesmentDate() {
		return disabilityAssesmentDate;
	}

	public void setDisabilityAssesmentDate(Calendar disabilityAssesmentDate) {
		this.disabilityAssesmentDate = disabilityAssesmentDate;
	}

	public int getDisabilityClass() {
		return disabilityClass;
	}

	public void setDisabilityClass(int disabilityClass) {
		this.disabilityClass = disabilityClass;
	}

}
