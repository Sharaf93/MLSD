package com.sumerge.mlsd.xom.socialcare;

/**
 * The disability the applicant can have. Stating the disability itself with
 * other attributes related to the applicant about the disability.
 * 
 * @author Ahmed Sharaf
 *
 */
public class ApplicantDisability {

	/**
	 * The Category of the disability.
	 * 
	 * @author Ahmed Sharaf
	 *
	 */
	public enum DisabilityCategory {
		MENTAL, PARALYSIS, VISION, HEARING, SPEAKING, PSYCHOLOGICAL, OTHER
	}

	private int ageOfDisability = 0;
	private DisabilityCategory disabilityCategory = DisabilityCategory.OTHER;

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

	public DisabilityCategory getDisabilityCategory() {
		return disabilityCategory;
	}

	public void setDisabilityCategory(DisabilityCategory disabilityCategory) {
		this.disabilityCategory = disabilityCategory;
	}

}
