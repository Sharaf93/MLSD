package com.mlsd.xom.socialcare;

import com.mlsd.xom.common.Person;

public class OrphanApplicant extends Person {

	private Person father = new Person();
	private boolean applicantIsEligible = true;

	public OrphanApplicant() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public Person getFather() {
		return father;
	}

	public void setFather(Person father) {
		this.father = father;
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
