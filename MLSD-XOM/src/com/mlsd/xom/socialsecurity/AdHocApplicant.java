package com.mlsd.xom.socialsecurity;

import java.util.Calendar;

import com.mlsd.utilities.Utilities;
import com.mlsd.xom.common.MedicalCondition;

public class AdHocApplicant extends SocialSecurityApplicant {

	private Calendar lastInclusiveAdhocPaymentDate = Calendar.getInstance();
	private Calendar lastExclusiveAdhocPaymentDate = Calendar.getInstance();

	private String segmentAppliedFor = "";
	private boolean isBeneficiaryDuringMedicationPeriod = false;

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

	public boolean isBeneficiaryDuringMedicationPeriod() {
		return isBeneficiaryDuringMedicationPeriod;
	}

	public void setBeneficiaryDuringMedicationPeriod(boolean isBeneficiaryDuringMedicationPeriod) {
		this.isBeneficiaryDuringMedicationPeriod = isBeneficiaryDuringMedicationPeriod;
	}

	public String getSegmentAppliedFor() {
		return segmentAppliedFor;
	}

	public void setSegmentAppliedFor(String segmentAppliedFor) {
		this.segmentAppliedFor = segmentAppliedFor;
	}

	public boolean medicationPeriodExceedPeriodOfDays(int periodOfDays) {
		MedicalCondition applicantMedicalCondition = this.getMedicalCondition();
		int medicationPeriod = applicantMedicalCondition.getMedicationPeriod();
		if (periodOfDays <= medicationPeriod) {
			return true; // medication period exceeds period of days
		}
		return false;
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
