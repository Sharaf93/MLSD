package com.mlsd.xom.socialsecurity;

import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import com.mlsd.utilities.Utilities;
import com.mlsd.xom.common.Applicant;
import com.mlsd.xom.common.IncomeDetails;
import com.mlsd.xom.common.MedicalCondition;
import com.mlsd.xom.common.Person;

/**
 * The AdHoc Applicant. It extends the Applicant object and adds the needed
 * attributes related to the AdHoc (One Time Support) program.
 * 
 * @author Ahmed Sharafeldin
 *
 */
public class AdHocApplicant extends Applicant {

	/**
	 * The available Adhoc support services
	 * 
	 * @author Ahmed Sharafeldin
	 *
	 */
	public enum AdHocSupportService {
		INCLUSIVE_SUPPORT, EXCLUSIVE_SUPPORT, NONE
	}

	private Calendar lastInclusiveAdhocPaymentDate = Calendar.getInstance();
	private Calendar lastExclusiveAdhocPaymentDate = Calendar.getInstance();

	private String socialSecuritySegmentInclusiveSupport = "";
	private int numberOfEligibleDependentsInclusiveSupport = 0;

	/* Logging constants used inside this class. */
	public static final String adHocApplicantclassName = AdHocApplicant.class.getName();
	public static final Logger logger = Logger.getLogger(adHocApplicantclassName);

	public AdHocApplicant() {
		// Empty Constructor for NULL avoidance
	}

	public Calendar getLastExclusiveAdhocPaymentDate() {
		if (lastExclusiveAdhocPaymentDate == null)
			lastExclusiveAdhocPaymentDate = Calendar.getInstance();
		return lastExclusiveAdhocPaymentDate;
	}

	public void setLastExclusiveAdhocPaymentDate(Calendar lastExclusiveAdhocPaymentDate) {
		this.lastExclusiveAdhocPaymentDate = lastExclusiveAdhocPaymentDate;
	}

	public Calendar getLastInclusiveAdhocPaymentDate() {
		if (lastInclusiveAdhocPaymentDate == null)
			lastInclusiveAdhocPaymentDate = Calendar.getInstance();
		return lastInclusiveAdhocPaymentDate;
	}

	public void setLastInclusiveAdhocPaymentDate(Calendar lastInclusiveAdhocPaymentDate) {
		this.lastInclusiveAdhocPaymentDate = lastInclusiveAdhocPaymentDate;
	}

	public String getSocialSecuritySegmentInclusiveSupport() {
		if (socialSecuritySegmentInclusiveSupport == null)
			socialSecuritySegmentInclusiveSupport = "";
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

	/**
	 * Adds a person to the eligible dependents list
	 * 
	 * @param person
	 *            the person to be added
	 */
	public void addPersonToEligibleDependents(Person person) {
		String sourceMethod = "addPersonToEligibleDependents";
		logger.entering(adHocApplicantclassName, sourceMethod);
		if (person != null) {
			this.getEligibleDependents().add(person);
		}
		logger.exiting(adHocApplicantclassName, sourceMethod);
	}

	/**
	 * Adds a person to the ineligible dependents list
	 * 
	 * @param person
	 *            the person to be added
	 */
	public void addPersonToIneligibleDependents(Person person) {
		String sourceMethod = "addPersonToIneligibleDependents";
		logger.entering(adHocApplicantclassName, sourceMethod);
		if (person != null) {
			this.getIneligibleDependents().add(person);
		}
		logger.exiting(adHocApplicantclassName, sourceMethod);
	}

	/**
	 * Checks if medication period exceeds a period of days
	 * 
	 * @param periodOfDays
	 *            the period to be checked upon
	 * @return whether it exceeds the valid period
	 */
	public boolean medicationPeriodExceedPeriodOfDays(int periodOfDays) {
		String sourceMethod = "medicationPeriodExceedPeriodOfDays";
		logger.entering(adHocApplicantclassName, sourceMethod);
		MedicalCondition applicantMedicalCondition = this.getMedicalCondition();
		int medicationPeriod = applicantMedicalCondition.getMedicationPeriod();
		if (periodOfDays <= medicationPeriod) {
			logger.exiting(adHocApplicantclassName, sourceMethod, true);
			return true; // medication period exceeds period of days
		}
		logger.exiting(adHocApplicantclassName, sourceMethod, false);
		return false;
	}

	/**
	 * Calculates the number of years since the last inclusive AdHoc payment
	 * 
	 * @return the number of years
	 */
	public float yearsSinceLastInclusiveAdhocPaymentDate() {
		String sourceMethod = "yearsSinceLastInclusiveAdhocPaymentDate";
		logger.entering(adHocApplicantclassName, sourceMethod);
		float differenceInYears = 0;
		int differenceInDays = 0;
		Calendar lastInclusivePaymentDate = this.getLastInclusiveAdhocPaymentDate();
		if (lastInclusivePaymentDate != null) {
			differenceInDays = Utilities.daysBetween(lastInclusivePaymentDate.getTime(), Calendar.getInstance().getTime());
			differenceInYears = differenceInDays / 365;
		}
		logger.exiting(adHocApplicantclassName, sourceMethod);
		return differenceInYears;
	}

	/**
	 * Calculates the number of years since the last Exclusive AdHoc payment
	 * 
	 * 
	 * @return the number of years
	 */
	public float yearsSinceLastExclusiveAdhocPaymentDate() {
		String sourceMethod = "yearsSinceLastExclusiveAdhocPaymentDate";
		logger.entering(adHocApplicantclassName, sourceMethod);
		float differenceInYears = 0;
		int differenceInDays = 0;
		Calendar lastExclusivePaymentDate = this.getLastExclusiveAdhocPaymentDate();
		if (lastExclusivePaymentDate != null) {
			differenceInDays = Utilities.daysBetween(lastExclusivePaymentDate.getTime(), Calendar.getInstance().getTime());
			differenceInYears = differenceInDays / 365;
		}
		logger.exiting(adHocApplicantclassName, sourceMethod);
		return differenceInYears;
	}

	// This method should be used instead of the float one above it.
	// public double yearsSinceLastExclusiveAdhocPaymentDate(){
	// double differenceInYears = 0;
	// int differenceInDays = 0;
	// Calendar lastExclusivePaymentDate = this
	// .getLastExclusiveAdhocPaymentDate();
	// differenceInDays =
	// Utilities.daysBetween(lastExclusivePaymentDate.getTime(),
	// Calendar.getInstance().getTime());
	// differenceInYears = differenceInDays / 365;
	//
	// return differenceInYears;
	// }

	/**
	 * Calculates the total family income from the applicant and his eligible
	 * dependents
	 * 
	 * @return the total income
	 */
	public double getTotalFamilyIncome() {
		String sourceMethod = "getTotalFamilyIncome";
		logger.entering(adHocApplicantclassName, sourceMethod);
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
		logger.exiting(adHocApplicantclassName, sourceMethod);
		return total;
	}

}
