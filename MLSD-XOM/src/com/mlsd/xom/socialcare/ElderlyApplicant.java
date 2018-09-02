package com.mlsd.xom.socialcare;

import com.mlsd.xom.common.Person;

/**
 * The ElderlyApplicant has all the information needed for the Elderly Service,
 * and by extending the Person object.
 *
 * @author Ahmed Sharafeldin
 */
public class ElderlyApplicant extends Person {

	private boolean applicantIsEligible = true;

	public ElderlyApplicant() {
		// Empty Constructor for NULL Avoidance
	}

	public boolean isTheApplicantEligible() {
		return applicantIsEligible;
	}

	public void setTheApplicantAsEligible() {
		this.applicantIsEligible = true;
	}

	public void setTheApplicantAsInEligible() {
		this.applicantIsEligible = false;
	}

	public void setApplicantIsEligible(boolean applicantIsEligible) {
		this.applicantIsEligible = applicantIsEligible;
	}

}
