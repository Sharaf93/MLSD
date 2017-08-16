package com.mlsd.xom.socialcare;

/**
 * The disability the applicant can have. Stating the disability itself with
 * other attributes related to the applicant about the disability.
 * 
 * @author Ahmed Sharaf
 *
 */
public class ApplicantDisability {

	private int ageOfDisability = 0;
	private Integer disabilityCategory = 7000;

	DisabilityDetails disabilityDetails = new DisabilityDetails();

	public ApplicantDisability() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public int getAgeOfDisability() {
		return ageOfDisability;
	}

	public void setAgeOfDisability(int ageOfDisability) {
		this.ageOfDisability = ageOfDisability;
	}

	public DisabilityDetails getDisabilityDetails() {
		return disabilityDetails;
	}

	public void setDisabilityDetails(DisabilityDetails disabilityDetails) {
		this.disabilityDetails = disabilityDetails;
	}

	public Integer getDisabilityCategory() {
		return disabilityCategory;
	}

	public void setDisabilityCategory(Integer disabilityCategory) {
		this.disabilityCategory = disabilityCategory;
	}

}