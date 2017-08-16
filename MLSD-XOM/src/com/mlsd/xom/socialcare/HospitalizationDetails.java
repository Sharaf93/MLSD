package com.mlsd.xom.socialcare;

import java.util.Calendar;

/**
 * The hospitalization information for the person.
 * 
 * @author Ahmed Sharaf
 *
 */
public class HospitalizationDetails {

	private boolean livesInGovernmentalHospital = false;
	private Calendar admissionDate = Calendar.getInstance();

	public HospitalizationDetails() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public boolean isLivesInGovernmentalHospital() {
		return livesInGovernmentalHospital;
	}

	public void setLivesInGovernmentalHospital(boolean livesInGovernmentalHospital) {
		this.livesInGovernmentalHospital = livesInGovernmentalHospital;
	}

	public Calendar getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Calendar admissionDate) {
		this.admissionDate = admissionDate;
	}

}
