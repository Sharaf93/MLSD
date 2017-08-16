package com.mlsd.xom.socialcare;

import com.mlsd.xom.common.Person;

/**
 * The FosterFamilyApplicant object has all the information needed for the
 * Foster Family services.
 *
 * @author Ahmed Sharaf
 */
public class FosterFamilyApplicant extends Person {

	private Person wife = new Person();
	private Person orphan = new Person();
	private boolean applicantIsEligible = true;

	public FosterFamilyApplicant() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public Person getOrphan() {
		return orphan;
	}

	public void setOrphan(Person orphan) {
		this.orphan = orphan;
	}

	public Person getWife() {
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
