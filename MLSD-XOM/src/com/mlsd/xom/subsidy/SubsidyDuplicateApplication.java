package com.mlsd.xom.subsidy;

import java.util.Calendar;

import com.mlsd.utilities.Utilities;

public class SubsidyDuplicateApplication {

	private String NIN = "";

	private DuplicateProfile firstApplication = new DuplicateProfile();
	private DuplicateProfile secondApplication = new DuplicateProfile();

	public SubsidyDuplicateApplication() {

	}

	public String getNIN() {
		return NIN;
	}

	public void setNIN(String nIN) {
		NIN = nIN;
	}

	public DuplicateProfile getFirstApplication() {
		return firstApplication;
	}

	public void setFirstApplication(DuplicateProfile firstApplication) {
		this.firstApplication = firstApplication;
	}

	public DuplicateProfile getSecondApplication() {
		return secondApplication;
	}

	public void setSecondApplication(DuplicateProfile secondApplication) {
		this.secondApplication = secondApplication;
	}

	public boolean firstProfileIsNewer() {
		Calendar firstProfileDate = this.getFirstApplication().getRegistrationDate();
		Calendar secondProfileDate = this.getSecondApplication().getRegistrationDate();
		int days = 0;
		days = Utilities.daysBetween(secondProfileDate.getTime(), firstProfileDate.getTime());
		return days > 0;
	}

	// public boolean secondProfileIsNewer() {
	// if (firstProfileIsNewer() == true)
	// return false;
	// else
	// return true;
	//
	// }
}
