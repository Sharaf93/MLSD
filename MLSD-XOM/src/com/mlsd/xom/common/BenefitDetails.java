package com.mlsd.xom.common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import com.mlsd.utilities.Utilities;

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

	private List<SourceMapper> sourcesMap = new ArrayList<>();

	/* Logging constants used inside this class. */
	public static final String personClassName = Person.class.getName();
	public static final Logger logger = Logger.getLogger(personClassName);

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

	/**
	 * Checks if the benefit exceeds a ceertain period since start date
	 * 
	 * @param validPeriodInDays
	 *            : the valid period number of days
	 * @return if the benefit exceeds the valid period
	 */
	public boolean benefitDoesNotExceedPeriodOfDaysSinceStartDate(int validPeriodInDays) {
		String sourceMethod = "benefitDoesNotExceedPeriodOfDaysSinceStartDate";
		logger.entering(personClassName, sourceMethod);
		Calendar benefitStartDate = this.getBenefitStartDate();
		Calendar todaysDate = Calendar.getInstance();
		int daysSinceStartDate = Utilities.daysBetween(benefitStartDate.getTime(), todaysDate.getTime());
		if (daysSinceStartDate < validPeriodInDays) {
			logger.exiting(personClassName, sourceMethod, true);
			return true; // benefit start date does not cover the valid
							// period
		}
		logger.exiting(personClassName, sourceMethod, false);
		return false;
	}
}
