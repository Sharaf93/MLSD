package com.mlsd.xom.socialcare;

import com.mlsd.xom.common.Person;

/**
 * The OrphanApplicant has all the information needed for the Orphan Services,
 * and by extending the Person object.
 * 
 * @author Ahmed Sharafeldin
 *
 */
public class OrphanApplicant extends Person {

	private Person father = new Person();
	private boolean applicantIsEligible = true;

	public OrphanApplicant() {
		// Empty Constructor for NULL Avoidance
	}

	public Person getFather() {
		if (father == null)
			father = new Person();
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
