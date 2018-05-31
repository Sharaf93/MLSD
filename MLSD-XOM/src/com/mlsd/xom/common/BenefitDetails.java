package com.mlsd.xom.common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import com.mlsd.utilities.Utilities;
import com.ummalqura.calendar.UmmalquraCalendar;

/**
 * The benefit details of the person. Whether the person is beneficiary in a
 * service and which program type this benefit belongs to.
 * 
 * @author Ahmed Sharaf
 *
 */
public class BenefitDetails {

	/**
	 * The program type of this benefit.
	 * 
	 * @author Ahmed Sharaf
	 *
	 */
	public enum ProgramType {
		SOCIALSECURITY, SUBSIDY, SOCIALCARE, NONE
	}

	private boolean isBeneficiary = false;
	private String beneficiaryService = "";
	private ProgramType programType = ProgramType.NONE;
	private Calendar lastPaymentDate = Calendar.getInstance();
	private Calendar benefitStartDate = Calendar.getInstance();
	private String benefitStartHijriDate = "";

	private List<SourceMapper> sourcesMap = new ArrayList<>();

	/* Logging constants used inside this class. */
	public static final String benefitDetailsClassName = BenefitDetails.class.getName();
	public static final Logger logger = Logger.getLogger(benefitDetailsClassName);

	public BenefitDetails() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public boolean isBeneficiary() {
		return isBeneficiary;
	}

	public void setBeneficiary(boolean isBeneficiary) {
		this.isBeneficiary = isBeneficiary;
	}

	public Calendar getBenefitStartDate() {
		return benefitStartDate;
	}

	public void setBenefitStartDate(Calendar benefitStartDate) {
		this.benefitStartDate = benefitStartDate;
	}

	public List<SourceMapper> getSourcesMap() {
		return sourcesMap;
	}

	public void setSourcesMap(List<SourceMapper> sourcesMap) {
		this.sourcesMap = sourcesMap;
	}

	public Calendar getLastPaymentDate() {
		return lastPaymentDate;
	}

	public void setLastPaymentDate(Calendar lastPaymentDate) {
		this.lastPaymentDate = lastPaymentDate;
	}

	public ProgramType getProgramType() {
		return programType;
	}

	public void setProgramType(ProgramType programType) {
		this.programType = programType;
	}

	public String getBeneficiaryService() {
		return beneficiaryService;
	}

	public void setBeneficiaryService(String beneficiaryService) {
		this.beneficiaryService = beneficiaryService;
	}

	public String getBenefitStartHijriDate() {
		return benefitStartHijriDate;
	}

	public void setBenefitStartHijriDate(String benefitStartHijriDate) {
		this.benefitStartHijriDate = benefitStartHijriDate;
	}

	/**
	 * Checks if the benefit exceeds a ceertain period since start date
	 * 
	 * @param validPeriodInDays
	 *            : the valid period number of days
	 * @return if the benefit exceeds the valid period
	 */
	public boolean benefitDoesNotExceedPeriodOfDaysSinceStartDate(int validPeriodInDays) {
		String sourceMethod = "benefitDoesNotExceedPeriodOfDaysSinceStartDate";
		logger.entering(benefitDetailsClassName, sourceMethod);
		Calendar benefitStartDate = this.getBenefitStartDate();
		Calendar todaysDate = Calendar.getInstance();
		int daysSinceStartDate = Utilities.daysBetween(benefitStartDate.getTime(), todaysDate.getTime());
		if (daysSinceStartDate < validPeriodInDays) {
			logger.exiting(benefitDetailsClassName, sourceMethod, true);
			return true; // benefit start date does not cover the valid
							// period
		}
		logger.exiting(benefitDetailsClassName, sourceMethod, false);
		return false;
	}

	public boolean benefitDoesNotExceedPeriodOfDaysSinceHijriStartDate(double validPeriodInDays) {
		Calendar hijriToday = Utilities.getTodaysHigriDate();
		String benefitStartHijriDate = this.getBenefitStartHijriDate();

		int year = Integer.parseInt(benefitStartHijriDate.substring(0, 4));
		int month = Integer.parseInt(benefitStartHijriDate.substring(4, 6));
		month--;
		int day = Integer.parseInt(benefitStartHijriDate.substring(6, 8));
		Calendar benefitHijri = new UmmalquraCalendar();
		benefitHijri.set(UmmalquraCalendar.YEAR, year);
		benefitHijri.set(UmmalquraCalendar.MONTH, month);
		benefitHijri.set(UmmalquraCalendar.DAY_OF_MONTH, day);

		double daysSinceStartDate = Utilities.getNumberOfDaysBetweenTwoHijriDates(benefitHijri, hijriToday);

		if (daysSinceStartDate < validPeriodInDays) {
			return true; // benefit start date does not cover the valid
							// period
		}
		return false;
	}
}
