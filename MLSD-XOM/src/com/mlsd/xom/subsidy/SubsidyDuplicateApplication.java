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
		if(NIN == null)
			NIN = "";
		return NIN;
	}

	public void setNIN(String nIN) {
		NIN = nIN;
	}

	public DuplicateProfile getFirstApplication() {
		if(firstApplication == null)
			firstApplication = new DuplicateProfile();
		return firstApplication;
	}

	public void setFirstApplication(DuplicateProfile firstApplication) {
		this.firstApplication = firstApplication;
	}

	public DuplicateProfile getSecondApplication() {
		if(secondApplication == null)
			secondApplication = new DuplicateProfile();
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

}
