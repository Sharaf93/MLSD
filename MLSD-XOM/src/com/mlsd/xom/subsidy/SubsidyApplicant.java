package com.mlsd.xom.subsidy;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import com.mlsd.utilities.Utilities;
import com.mlsd.xom.common.Applicant;
import com.mlsd.xom.common.IncomeDetails;
import com.mlsd.xom.common.Person;
import com.mlsd.xom.common.IncomeDetails.IncomeType;

/**
 * The Subsidy Applicant. It extends the Applicant object and adds the needed
 * attributes related to the subsidy program.
 * 
 * @author Youssef Hatem
 *
 */
public class SubsidyApplicant extends Applicant {

//	private PortalSubsidyApplicant portalSubsidyApplicant = new PortalSubsidyApplicant();

	private boolean MLSDNoProofRequired = false;
	private boolean CRMHohApproval = false;

	/* Logging constants used inside this class. */
	public static final String subsidyClassName = SubsidyApplicant.class.getName();
	public static final Logger logger = Logger.getLogger(subsidyClassName);

	public SubsidyApplicant() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	/**
	 * 
	 * @return the subsidy registration date as Hijri date.
	 */
	// public Calendar getSubsidyHijriRegistrationDate() {
	// String sourceMethod = "getSubsidyHijriRegistrationDate";
	// logger.entering(subsidyClassName, sourceMethod);
	// Calendar registrationDateGregorian = this.getRegistrationDate();
	// if (registrationDateGregorian == null) {
	// registrationDateGregorian = Calendar.getInstance();
	// }
	// logger.exiting(subsidyClassName, sourceMethod);
	// return
	// Utilities.getHijriDateFromGregorianDate(registrationDateGregorian);
	// }

	/**
	 * 
	 * @param subsidyRegistrationDate
	 *            : the Subsidy registration date
	 */
	// public void setSubsidyHijriRegistrationDate(Calendar
	// subsidyRegistrationDate) {
	// String sourceMethod = "setSubsidyHijriRegistrationDate";
	// logger.entering(subsidyClassName, sourceMethod);
	// Calendar regDate = this.getRegistrationDate();
	// Calendar cal =
	// Utilities.convertFromGregorianCalendarToUmmalquraCalendar(regDate);
	// regDate.setTime(cal.getTime());
	// this.setRegistrationDate(regDate);
	// logger.exiting(subsidyClassName, sourceMethod);
	// }

	/**
	 * 
	 * @param numberOfDays
	 *            : The number of days to compare the subsidy registration date
	 *            with.
	 * @return if subsidy registration date exceeds the specified number of days
	 */
	public boolean subsidyRegistrationDateIsMoreThan(int numberOfDays) {
		String sourceMethod = "subsidyRegistrationDateIsMoreThan";
		logger.entering(subsidyClassName, sourceMethod);
		// Calendar todaysHijriDate = Utilities.getTodaysHigriDate();
		Calendar todaysDate = Calendar.getInstance();
		Calendar subsidyRegistrationDate = this.getRegistrationDate();
		int days = 0;
		if (subsidyRegistrationDate != null) {
			days = Utilities.daysBetween(subsidyRegistrationDate.getTime(), todaysDate.getTime());
		}
		logger.exiting(subsidyClassName, sourceMethod);
		return days > numberOfDays;
	}

	/**
	 * 
	 * @param person
	 *            : A person to be added to the eligible dependents list.
	 */
	public void addPersonToEligibleDependents(Person person) {
		if (person.getNin() != null && person.getNin() != "") {
			this.getEligibleDependents().add(person);
		}
	}

	/**
	 * 
	 * @param person
	 *            : A person to be added to the ineligible dependents list.
	 */
	public void addPersonToIneligibleDependents(Person person) {
		if (person.getNin() != null && person.getNin() != "") {
			this.getIneligibleDependents().add(person);
		}
	}

	/**
	 * 
	 * @return the total family income from the applicant and the eligible
	 *         dependents.
	 */
	public double getTotalFamilyIncome() {
		String sourceMethod = "getTotalFamilyIncome";
		logger.entering(subsidyClassName, sourceMethod);
		double total = 0;
		List<Person> dependents = this.getEligibleDependents();

		// //////////////////// Dependents ///////////////////////////
		for (Person person : dependents) {
			List<IncomeDetails> dependentIncomeDetails = person.getIncomeDetails();
			for (IncomeDetails incomeDetail : dependentIncomeDetails) {
				total += incomeDetail.getIncomeAmount();
			}
		}
		// //////////////////////// Applicant /////////////////////////////////
		List<IncomeDetails> applicantIncomeDetails = this.getIncomeDetails();
		for (IncomeDetails applicantIncomeDetail : applicantIncomeDetails) {
			total += applicantIncomeDetail.getIncomeAmount();
		}

		total = Math.round(total * 100);
		total = total / 100;
		logger.exiting(subsidyClassName, sourceMethod);
		return total;
	}

	// public PortalSubsidyApplicant getPortalSubsidyApplicant() {
	// if(portalSubsidyApplicant == null)
	// portalSubsidyApplicant = new PortalSubsidyApplicant();
	// return portalSubsidyApplicant;
	// }
	//
	// public void setPortalSubsidyApplicant(PortalSubsidyApplicant
	// portalSubsidyApplicant) {
	// this.portalSubsidyApplicant = portalSubsidyApplicant;
	// }

	public boolean isMLSDNoProofRequired() {
		return MLSDNoProofRequired;
	}

	public void setMLSDNoProofRequired(boolean mLSDNoProofRequired) {
		MLSDNoProofRequired = mLSDNoProofRequired;
	}

	public boolean isCRMHohApproval() {
		return CRMHohApproval;
	}

	public void setCRMHohApproval(boolean cRMHohApproval) {
		CRMHohApproval = cRMHohApproval;
	}

	public double getHOHTotalIncome() {
		double maxIncome = 0.0;
		double totalIncome = 0.0;
		IncomeType typeOfIncome;
		List<IncomeType> incomeTypes = new ArrayList<>();
		List<IncomeDetails> hohIncome = this.getIncomeDetails();
		for (IncomeDetails income : hohIncome) {
			typeOfIncome = income.getIncomeType();
			if (!(incomeTypes.contains(typeOfIncome))) {
				incomeTypes.add(typeOfIncome);
			}
		}
		for (IncomeType incomeType : incomeTypes) {
			for (IncomeDetails income : hohIncome) {
				if (incomeType.equals(income.getIncomeType())) {
					if (maxIncome < income.getIncomeAmount()) {
						maxIncome = income.getIncomeAmount();
					}
				}
			}
			totalIncome += maxIncome;
			maxIncome = 0.0;
		}
		return totalIncome;
	}

	public double getEligibleDependentsTotalIncome() {
		double maxIncome = 0.0;
		double totalIncome = 0.0;
		IncomeType typeOfIncome;
		List<Person> eligibleDependents = this.getEligibleDependents();
		for (Person dependent : eligibleDependents) {
			List<IncomeType> incomeTypes = new ArrayList<>();
			List<IncomeDetails> dependentIncome = dependent.getIncomeDetails();
			for (IncomeDetails income : dependentIncome) {
				typeOfIncome = income.getIncomeType();
				if (!(incomeTypes.contains(typeOfIncome))) {
					incomeTypes.add(typeOfIncome);
				}
			}
			for (IncomeType incomeType : incomeTypes) {
				for (IncomeDetails income : dependentIncome) {
					if (incomeType.equals(income.getIncomeType())) {
						if (maxIncome < income.getIncomeAmount()) {
							maxIncome = income.getIncomeAmount();
						}
					}
				}
				totalIncome += maxIncome;
				maxIncome = 0.0;
			}
		}
		return totalIncome;
	}

	public Integer dependentsDeductionDays(int gracePeriod) {
		List<Person> eligibleDependents = this.getEligibleDependents();
		int deductionDays = 0;
		int numberOfDaysOutsideKSA = 0;
		int temp = 0;
		for (Person dependent : eligibleDependents) {
			numberOfDaysOutsideKSA = dependent.getResidencyOutsideKSA().getNoOfDaysOutsideKSA();
			temp = numberOfDaysOutsideKSA - gracePeriod;
			deductionDays += temp;
		}
		return deductionDays;
	}

}
