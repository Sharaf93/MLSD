package com.sumerge.mlsd.xom.subsidy;

import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import com.sumerge.mlsd.utilities.Utilities;
import com.sumerge.mlsd.xom.common.Applicant;
import com.sumerge.mlsd.xom.common.IncomeDetails;
import com.sumerge.mlsd.xom.common.Person;

/**
 * The Subsidy Applicant. It extends the Applicant object and adds the needed
 * attributes related to the subsidy program.
 * 
 * @author Youssef Hatem
 *
 */
public class SubsidyApplicant extends Applicant {

	/**
	 * The Segment the applicant can apply for.
	 * 
	 * @author Youssef Hatem
	 *
	 */
	public enum Segment {
		FAMILY, INDEPENDENT
	}

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
	public Calendar getSubsidyHijriRegistrationDate() {
		String sourceMethod = "getSubsidyHijriRegistrationDate";
		logger.entering(subsidyClassName, sourceMethod);
		Calendar registrationDateGregorian = this.getRegistrationDate();
		if (registrationDateGregorian == null) {
			registrationDateGregorian = Calendar.getInstance();
		}
		logger.exiting(subsidyClassName, sourceMethod);
		return Utilities.getHijriDateFromGregorianDate(registrationDateGregorian);
	}

	/**
	 * 
	 * @param subsidyRegistrationDate
	 *            : the Subsidy registration date
	 */
	public void setSubsidyHijriRegistrationDate(Calendar subsidyRegistrationDate) {
		String sourceMethod = "setSubsidyHijriRegistrationDate";
		logger.entering(subsidyClassName, sourceMethod);
		Calendar regDate = this.getRegistrationDate();
		Calendar cal = Utilities.convertFromGregorianCalendarToUmmalquraCalendar(regDate);
		regDate.setTime(cal.getTime());
		this.setRegistrationDate(regDate);
		logger.exiting(subsidyClassName, sourceMethod);
	}

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
		Calendar todaysHijriDate = Utilities.getTodaysHigriDate();
		Calendar subsidyRegistrationDate = this.getSubsidyHijriRegistrationDate();
		int days = 0;
		if (subsidyRegistrationDate != null) {
			days = Utilities.getNumberOfDaysBetweenTwoHijriDates(subsidyRegistrationDate, todaysHijriDate);
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

	/**
	 * This medthod is used to check the availability of the husband of the
	 * applicant.
	 * 
	 * @return if the applicant has an added husband.
	 */
	public boolean hasAddedHusband() {
		String husbandNIN = this.getHusband().getNin();
		if (husbandNIN == null) {
			husbandNIN = "";
		}
		if ("".equals(husbandNIN)) {
			return false;
		}
		return true;
	}

	/**
	 * This medthod is used to check the availability of the Father of the
	 * applicant.
	 * 
	 * @return if the applicant has an added father.
	 */
	public boolean hasAddedFather() {
		String fatherNIN = this.getFather().getNin();
		if (fatherNIN == null) {
			fatherNIN = "";
		}
		if ("".equals(fatherNIN)) {
			return false;
		}
		return true;
	}

	/**
	 * This medthod is used to check the availability of the Mother of the
	 * applicant.
	 * 
	 * @return if the applicant has an added mother.
	 */
	public boolean hasAddedsMother() {
		String motherNIN = this.getMother().getNin();
		if (motherNIN == null) {
			motherNIN = "";
		}
		if ("".equals(motherNIN)) {
			return false;
		}
		return true;
	}

}
