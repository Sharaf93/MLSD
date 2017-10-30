package com.mlsd.xom.socialsecurity;

import java.util.Calendar;
import java.util.List;

import com.mlsd.utilities.Utilities;
import com.mlsd.xom.common.Applicant;
import com.mlsd.xom.common.IncomeDetails;
import com.mlsd.xom.common.MedicalCondition;
import com.mlsd.xom.common.Person;

public class AdHocApplicant extends Applicant {

	public enum AdHocSupportService {
		INCLUSIVE_SUPPORT, EXCLUSIVE_SUPPORT
	}

	private Calendar lastInclusiveAdhocPaymentDate = Calendar.getInstance();
	private Calendar lastExclusiveAdhocPaymentDate = Calendar.getInstance();

	private String socialSecuritySegmentInclusiveSupport = "";
	private int numberOfEligibleDependentsInclusiveSupport = 0;

	public AdHocApplicant() {

	}

	public Calendar getLastExclusiveAdhocPaymentDate() {
		return lastExclusiveAdhocPaymentDate;
	}

	public void setLastExclusiveAdhocPaymentDate(Calendar lastExclusiveAdhocPaymentDate) {
		this.lastExclusiveAdhocPaymentDate = lastExclusiveAdhocPaymentDate;
	}

	public Calendar getLastInclusiveAdhocPaymentDate() {
		return lastInclusiveAdhocPaymentDate;
	}

	public void setLastInclusiveAdhocPaymentDate(Calendar lastInclusiveAdhocPaymentDate) {
		this.lastInclusiveAdhocPaymentDate = lastInclusiveAdhocPaymentDate;
	}

	public String getSocialSecuritySegmentInclusiveSupport() {
		return socialSecuritySegmentInclusiveSupport;
	}

	public void setSocialSecuritySegmentInclusiveSupport(String socialSecuritySegmentInclusiveSupport) {
		this.socialSecuritySegmentInclusiveSupport = socialSecuritySegmentInclusiveSupport;
	}

	public int getNumberOfEligibleDependentsInclusiveSupport() {
		return numberOfEligibleDependentsInclusiveSupport;
	}

	public void setNumberOfEligibleDependentsInclusiveSupport(int numberOfEligibleDependentsInclusiveSupport) {
		this.numberOfEligibleDependentsInclusiveSupport = numberOfEligibleDependentsInclusiveSupport;
	}

	public void addPersonToEligibleDependents(Person person) {
		if (person != null) {
			this.getEligibleDependents().add(person);
		}
	}

	public void addPersonToIneligibleDependents(Person person) {
		if (person != null) {
			this.getIneligibleDependents().add(person);
		}
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
		Calendar lastInclusivePaymentDate = this.getLastInclusiveAdhocPaymentDate();

		differenceInDays = Utilities.daysBetween(lastInclusivePaymentDate.getTime(), Calendar.getInstance().getTime());

		differenceInYears = differenceInDays / 365;

		return differenceInYears;
	}

	public float yearsSinceLastExclusiveAdhocPaymentDate() {
		float differenceInYears = 0;
		int differenceInDays = 0;
		Calendar lastExclusivePaymentDate = this.getLastExclusiveAdhocPaymentDate();

		differenceInDays = Utilities.daysBetween(lastExclusivePaymentDate.getTime(), Calendar.getInstance().getTime());

		differenceInYears = differenceInDays / 365;

		return differenceInYears;
	}

	/**
	 * 
	 * @return the total family income from the applicant and all the eligible
	 *         dependents.
	 */
	public double getTotalFamilyIncome() {
		double total = 0.0;
		List<Person> dependents = this.getEligibleDependents();

		// //////////////////// Dependents ///////////////////////////
		if (dependents != null) {
			for (Person person : dependents) {
				List<IncomeDetails> dependentIncomeDetails = person.getIncomeDetails();
				if (dependentIncomeDetails != null) {
					for (IncomeDetails incomeDetail : dependentIncomeDetails) {
						total += incomeDetail.getIncomeAmount();
					}
				}
			}
		}
		// //////////////////////// Applicant /////////////////////////////////
		List<IncomeDetails> applicantIncomeDetails = this.getIncomeDetails();
		if (applicantIncomeDetails != null) {
			for (IncomeDetails applicantIncomeDetail : applicantIncomeDetails) {
				total += applicantIncomeDetail.getIncomeAmount();
			}
		}
		total = Math.round(total * 100);
		total = total / 100;
		return total;
	}

}
