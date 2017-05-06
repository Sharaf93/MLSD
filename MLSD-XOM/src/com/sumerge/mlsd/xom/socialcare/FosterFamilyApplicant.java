package com.sumerge.mlsd.xom.socialcare;

import com.sumerge.mlsd.xom.common.Person;

public class FosterFamilyApplicant extends Person{

	private int numberOfOffspringsLessThanSixYears = 0;
	private boolean recievedOrphanCustodyRewardBefore = false;
	private Person orphan = new Person();

	public FosterFamilyApplicant() {
	}

	public int getNumberOfOffspringsLessThanSixYears() {
		return numberOfOffspringsLessThanSixYears;
	}

	public void setNumberOfOffspringsLessThanSixYears(int numberOfOffspringsLessThanSixYears) {
		this.numberOfOffspringsLessThanSixYears = numberOfOffspringsLessThanSixYears;
	}

	public boolean isRecievedOrphanCustodyRewardBefore() {
		return recievedOrphanCustodyRewardBefore;
	}

	public void setRecievedOrphanCustodyRewardBefore(boolean recievedOrphanCustodyRewardBefore) {
		this.recievedOrphanCustodyRewardBefore = recievedOrphanCustodyRewardBefore;
	}

	public Person getOrphan() {
		return orphan;
	}

	public void setOrphan(Person orphan) {
		this.orphan = orphan;
	}

}
