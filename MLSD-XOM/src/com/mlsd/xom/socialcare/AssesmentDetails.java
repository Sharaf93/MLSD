package com.mlsd.xom.socialcare;

import java.util.Calendar;

/**
 * The details of the disability assessment of the applicant.
 * 
 * @author Ahmed Sharafeldin
 *
 */
public class AssesmentDetails {

	private int iqLevel = 120;
	private int disabilityClass = 15;
	private boolean disabilityAssesmentIsValid = true;
	private Calendar disabilityAssesmentDate = Calendar.getInstance();

	public AssesmentDetails() {
		// Empty Constructor for NULL Avoidance
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
		if (disabilityAssesmentDate == null)
			disabilityAssesmentDate = Calendar.getInstance();
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
