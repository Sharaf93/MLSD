package com.mlsd.xom.socialsecurity;

import java.util.Calendar;

import com.mlsd.utilities.Utilities;

public class AdHocApplicant extends SocialSecurityApplicant {

	private Calendar lastInclusiveAdhocPaymentDate = Calendar.getInstance();
	private Calendar lastExclusiveAdhocPaymentDate = Calendar.getInstance();

	public AdHocApplicant() {

	}

	public Calendar getLastInclusiveAdhocPymentDate() {
		return lastInclusiveAdhocPaymentDate;
	}

	public void setLastInclusiveAdhocPymentDate(Calendar lastInclusiveAdhocPaymentDate) {
		this.lastInclusiveAdhocPaymentDate = lastInclusiveAdhocPaymentDate;
	}

	public Calendar getLastExclusiveAdhocPaymentDate() {
		return lastExclusiveAdhocPaymentDate;
	}

	public void setLastExclusiveAdhocPaymentDate(Calendar lastExclusiveAdhocPaymentDate) {
		this.lastExclusiveAdhocPaymentDate = lastExclusiveAdhocPaymentDate;
	}

	public float yearsSinceLastInclusiveAdhocPaymentDate() {
		float differenceInYears = 0;
		int differenceInDays = 0;
		differenceInDays = Utilities.daysBetween(getLastInclusiveAdhocPymentDate().getTime(), Calendar.getInstance().getTime());

		differenceInYears = differenceInDays / 365;

		return differenceInYears;
	}

	public float yearsSinceLastExclusiveAdhocPaymentDate() {
		float differenceInYears = 0;
		int differenceInDays = 0;
		differenceInDays = Utilities.daysBetween(getLastExclusiveAdhocPaymentDate().getTime(), Calendar.getInstance().getTime());

		differenceInYears = differenceInDays / 365;

		return differenceInYears;
	}

}
