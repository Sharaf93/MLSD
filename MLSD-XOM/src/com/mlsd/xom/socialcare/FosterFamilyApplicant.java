package com.mlsd.xom.socialcare;

import com.mlsd.xom.common.Person;

/**
 * The FosterFamilyApplicant has all the information needed for the Foster
 * Family services, and by extending the Person object.
 *
 * @author Ahmed Sharafeldin
 */
public class FosterFamilyApplicant extends Person {

	private Person wife = new Person();
	private Person orphan = new Person();
	private boolean applicantIsEligible = true;

	public FosterFamilyApplicant() {
		// Empty Constructor for NULL Avoidance
	}

	public Person getOrphan() {
		if (orphan == null)
			orphan = new Person();
		return orphan;
	}

	public void setOrphan(Person orphan) {
		this.orphan = orphan;
	}

	public Person getWife() {
		if (wife == null)
			wife = new Person();
		return wife;
	}

	public void setWife(Person wife) {
		this.wife = wife;
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
