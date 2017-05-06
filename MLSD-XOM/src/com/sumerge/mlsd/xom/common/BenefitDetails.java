package com.sumerge.mlsd.xom.common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.sumerge.mlsd.utilities.Utilities;

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

	public boolean benefitDoesNotExceedPeriodOfDaysSinceStartDate(int validPeriodInDays) {
		Calendar benefitStartDate = this.getBenefitStartDate();
		Calendar todaysDate = Calendar.getInstance();
		int daysSinceStartDate = Utilities.daysBetween(benefitStartDate.getTime(), todaysDate.getTime());
		if (daysSinceStartDate < validPeriodInDays) {
			return true; // benefit start date does not cover the valid
							// period
		}
		return false;
	}
}
