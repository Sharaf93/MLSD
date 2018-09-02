package com.mlsd.xom.socialsecurity;

import java.util.List;
import java.util.logging.Logger;

import com.mlsd.xom.common.Applicant;
import com.mlsd.xom.common.IncomeDetails;
import com.mlsd.xom.common.Person;
import com.mlsd.xom.common.IncomeDetails.IncomeType;

/**
 * The Social Security Applicant. It extends the Applicant object and adds the
 * needed attributes related to the social security program.
 * 
 * @author Ahmed Sharafeldin
 *
 */
public class SocialSecurityApplicant extends Applicant {

	private boolean employedOrphanFlag = false;
	private boolean entitlmentIsSuspended = false;
	private boolean approvedToBeIndependentFromBeneficiary = false;

	/* Logging constants used inside this class. */
	public static final String socialSecurityclassName = SocialSecurityApplicant.class.getName();
	public static final Logger logger = Logger.getLogger(socialSecurityclassName);

	public SocialSecurityApplicant() {
		// Empty Constructor for NULL Avoidance
	}

	public boolean isApprovedToBeIndependentFromBeneficiary() {
		return approvedToBeIndependentFromBeneficiary;
	}

	public void setApprovedToBeIndependentFromBeneficiary(boolean approvedToBeIndependentFromBeneficiary) {
		this.approvedToBeIndependentFromBeneficiary = approvedToBeIndependentFromBeneficiary;
	}

	public boolean isEmployedOrphanFlag() {
		return employedOrphanFlag;
	}

	public void setEmployedOrphanFlag(boolean employedOrphanFlag) {
		this.employedOrphanFlag = employedOrphanFlag;
	}

	public boolean isEntitlmentSuspended() {
		return entitlmentIsSuspended;
	}

	public void setEntitlmentSuspended(boolean entitlmentIsSuspended) {
		this.entitlmentIsSuspended = entitlmentIsSuspended;
	}

	/**
	 * Adds a person to the eligible dependents list
	 * 
	 * @param person
	 *            the person to be added
	 */
	public void addPersonToEligibleDependents(Person person) {
		String sourceMethod = "addPersonToEligibleDependents";
		logger.entering(socialSecurityclassName, sourceMethod);
		if (person != null) {
			this.getEligibleDependents().add(person);
		}
		logger.exiting(socialSecurityclassName, sourceMethod);
	}

	/**
	 * Adds a person to the ineligible dependents list
	 * 
	 * @param person
	 *            the person to be added
	 */
	public void addPersonToIneligibleDependents(Person person) {
		String sourceMethod = "addPersonToIneligibleDependents";
		logger.entering(socialSecurityclassName, sourceMethod);
		if (person != null) {
			this.getIneligibleDependents().add(person);
		}
		logger.exiting(socialSecurityclassName, sourceMethod);
	}

	/**
	 * Calculates the total family income from the applicant and his eligible
	 * dependents
	 * 
	 * @return the total income
	 */
	public double getTotalFamilyIncome() {
		String sourceMethod = "getTotalFamilyIncome";
		logger.entering(socialSecurityclassName, sourceMethod);
		double total = 0;
		List<Person> dependents = this.getEligibleDependents();
		boolean applicantEmployedOrphanFlag = this.isEmployedOrphanFlag();

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
				if (applicantEmployedOrphanFlag) {
					if (!IncomeType.SALARY.equals(applicantIncomeDetail.getIncomeType())) {
						total += applicantIncomeDetail.getIncomeAmount();
					}
				} else {
					total += applicantIncomeDetail.getIncomeAmount();
				}
			}
		}
		total = Math.round(total * 100);
		total = total / 100;
		logger.exiting(socialSecurityclassName, sourceMethod);
		return total;
	}
}
