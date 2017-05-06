package com.sumerge.mlsd.xom.common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import com.sumerge.mlsd.utilities.Utilities;

/**
 * The Applicant object extends the Person object to provide the basic
 * information for the applicant. This Object is then extended to other specific
 * applicants related to a specific service/program.
 * 
 * @author Ahmed Sharaf
 *
 */
public class Applicant extends Person {

	private boolean applicantIsEligible = true;

	private Calendar applicationDate = Calendar.getInstance();
	private Calendar registrationDate = Calendar.getInstance();

	/* Logging constants used inside this class. */
	public static final String applicantClassName = Applicant.class.getName();
	public static final Logger logger = Logger.getLogger(applicantClassName);

	private Person mother = new Person();
	private Person father = new Person();
	private Person husband = new Person();

	private List<Person> wives = new ArrayList<>();
	private List<Person> siblings = new ArrayList<>();
	private List<Person> offsprings = new ArrayList<>();
	private List<Person> underCustody = new ArrayList<>();
	private List<Person> eligibleDependents = new ArrayList<>();
	private List<Person> ineligibleDependents = new ArrayList<>();
	private List<Person> applicableDependents = new ArrayList<>();
	private List<Person> inApplicableDependents = new ArrayList<>();

	public Applicant() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public Person getMother() {
		if (mother == null) {
			mother = new Person();
		}
		return mother;
	}

	public void setMother(Person mother) {
		this.mother = mother;
	}

	public Person getFather() {
		if (father == null) {
			father = new Person();
		}
		return father;
	}

	public void setFather(Person father) {
		this.father = father;
	}

	public List<Person> getSiblings() {
		if (siblings == null) {
			siblings = new ArrayList<>();
		}
		return siblings;
	}

	public void setSiblings(List<Person> siblings) {
		this.siblings = siblings;
	}

	public List<Person> getWives() {
		if (wives == null) {
			wives = new ArrayList<>();
		}
		return wives;
	}

	public void setWives(List<Person> wives) {
		this.wives = wives;
	}

	public List<Person> getOffsprings() {
		if (offsprings == null) {
			offsprings = new ArrayList<>();
		}
		return offsprings;
	}

	public void setOffsprings(List<Person> offsprings) {
		this.offsprings = offsprings;
	}

	public Person getHusband() {
		if (husband == null) {
			husband = new Person();
		}
		return husband;
	}

	public void setHusband(Person husband) {
		this.husband = husband;
	}

	public List<Person> getUnderCustody() {
		if (underCustody == null) {
			underCustody = new ArrayList<>();
		}
		return underCustody;
	}

	public void setUnderCustody(List<Person> underCustody) {
		this.underCustody = underCustody;
	}

	public Calendar getRegistrationDate() {
		if (registrationDate == null) {
			registrationDate = Calendar.getInstance();
		}
		return this.registrationDate;
	}

	public void setRegistrationDate(Calendar registrationDate) {
		this.registrationDate = registrationDate;
	}

	public List<Person> getApplicableDependents() {
		if (applicableDependents == null) {
			applicableDependents = new ArrayList<>();
		}
		return applicableDependents;
	}

	public void setApplicableDependents(List<Person> applicableDependents) {
		this.applicableDependents = applicableDependents;
	}

	public Calendar getApplicationDate() {
		if (applicationDate == null) {
			applicationDate = Calendar.getInstance();
		}
		return applicationDate;
	}

	public void setApplicationDate(Calendar applicationDate) {
		this.applicationDate = applicationDate;
	}

	public List<Person> getEligibleDependents() {
		if (this.eligibleDependents == null) {
			this.eligibleDependents = new ArrayList<>();
		}
		return eligibleDependents;
	}

	public List<Person> getIneligibleDependents() {
		if (this.ineligibleDependents == null) {
			this.ineligibleDependents = new ArrayList<>();
		}
		return this.ineligibleDependents;
	}

	public void setIneligibleDependents(List<Person> ineligibleDependents) {
		this.ineligibleDependents = ineligibleDependents;
	}

	public void setEligibleDependents(List<Person> dependents) {
		this.eligibleDependents = dependents;
	}

	public List<Person> getInApplicableDependents() {
		if (inApplicableDependents == null) {
			inApplicableDependents = new ArrayList<>();
		}
		return inApplicableDependents;
	}

	public void setInApplicableDependents(List<Person> notApplicableDependents) {
		this.inApplicableDependents = notApplicableDependents;
	}

	public boolean isTheApplicantEligible() {
		return this.applicantIsEligible;
	}

	// ////////////////////////////////////////// Added functions
	// /////////////////////////////////////////////////

	public void setTheApplicantAsEligible() {
		this.applicantIsEligible = true;
	}

	public void setTheApplicantAsNotEligible() {
		this.applicantIsEligible = false;
	}

	/**
	 * Checks if the provided reason is still valid and it's date doesn't exceed
	 * one year for the applicant who is resident outside KSA.
	 * 
	 * @return the validity result.
	 */
	public boolean theReasonValidityDateForTheApprovalDidNotExceedOneYear() {
		String sourceMethod = "theReasonValidityDateForTheApprovalDidNotExceedOneYear";
		logger.entering(applicantClassName, sourceMethod);
		Calendar reasonValidityDate = this.getResidencyOutsideKSA().getReasonValidityDate();
		int daysInAYear = 366;
		int days = 0;
		if (reasonValidityDate != null) {
			days = Utilities.daysBetween(Calendar.getInstance().getTime(), reasonValidityDate.getTime());
		}
		logger.exiting(applicantClassName, sourceMethod);
		return days < daysInAYear;
	}

	/**
	 * 
	 * @param toBeAdded
	 *            : A list of people to be added in the in-eligible dependents
	 *            list.
	 */
	public void addToIneligibleDependents(java.util.Collection<Person> toBeAdded) {
		String sourceMethod = "addToIneligibleDependents";
		logger.entering(applicantClassName, sourceMethod);
		if (toBeAdded != null) {
			List<Person> tempDependents = getIneligibleDependents();
			if (tempDependents == null) {
				tempDependents = new ArrayList<>();
			}
			tempDependents.addAll(toBeAdded); // Note: Rules were run in a
												// single thread environment
			setIneligibleDependents(tempDependents);
		}
		logger.exiting(applicantClassName, sourceMethod);
	}

	/**
	 * 
	 * @param toBeAdded
	 *            : A list of people to be added in the in-applicable dependents
	 *            list.
	 */
	public void addToNotApplicableDependents(java.util.Collection<Person> toBeAdded) {
		String sourceMethod = "addToNotApplicableDependents";
		logger.entering(applicantClassName, sourceMethod);
		if (toBeAdded != null) {
			List<Person> tempDependents = getInApplicableDependents();
			if (tempDependents == null) {
				tempDependents = new ArrayList<>();
			}
			tempDependents.addAll(toBeAdded);
			setInApplicableDependents(tempDependents);
		}
		logger.exiting(applicantClassName, sourceMethod);
	}

	/**
	 * 
	 * @param toBeAdded
	 *            : A list of people to be added in the eligible dependents
	 *            list.
	 */
	public void addToEligibleDependents(java.util.Collection<Person> toBeAdded) {
		String sourceMethod = "addToEligibleDependents";
		logger.entering(applicantClassName, sourceMethod);
		if (toBeAdded != null) {
			List<Person> tempDependents = getEligibleDependents();
			if (tempDependents == null) {
				tempDependents = new ArrayList<>();
			}
			tempDependents.addAll(toBeAdded);
			setEligibleDependents(tempDependents);
		}
		logger.exiting(applicantClassName, sourceMethod);
	}

	/**
	 * Compares between the guardian and the applicant NINs.
	 * 
	 * @param person
	 *            : The Person to compare with.
	 * @return the comparison result.
	 */
	public boolean theGuardianIsTheApplicant(Person person) {
		String sourceMethod = "theGuardianIsTheApplicant";
		logger.entering(applicantClassName, sourceMethod);
		if (person != null) {
			GuardianshipStatus guardianshipStatus = person.getGuardianshipstatus();
			if (guardianshipStatus != null && this.getNin() != "" && guardianshipStatus.getGuardianNIN().equals(this.getNin())) {
				logger.exiting(applicantClassName, sourceMethod, true);
				return true;
			}
		}
		logger.exiting(applicantClassName, sourceMethod, false);
		return false;
	}

	/**
	 * Compares between the guardian and the applicant NINs.
	 * 
	 * @param person
	 *            : The person to compare with.
	 * @return the comparison result.
	 */
	public boolean theGuardianIsNotTheApplicant(Person person) {
		String sourceMethod = "theGuardianIsNotTheApplicant";
		logger.entering(applicantClassName, sourceMethod);
		GuardianshipStatus guardianshipStatus;
		if (person != null) {
			guardianshipStatus = person.getGuardianshipstatus();
			if (guardianshipStatus != null && this.getNin() != "" && guardianshipStatus.getGuardianNIN().equals(this.getNin())) {
				logger.exiting(applicantClassName, sourceMethod, false);
				return false;
			}
		}
		logger.exiting(applicantClassName, sourceMethod, true);
		return true;
	}

	/**
	 * Removes a list of people from a specified list and returns the modified
	 * list.
	 * 
	 * @param peopleToBeRemoved
	 *            : The list of people that needs to be removed.
	 * @param peopleToRemoveFrom
	 *            : The list of people to remove from.
	 * @return the modified list after removing the list of people.
	 */
	public List<Person> removePeopleFromList(List<Person> peopleToBeRemoved, List<Person> peopleToRemoveFrom) {
		String sourceMethod = "removePeopleFromList";
		logger.entering(applicantClassName, sourceMethod);
		List<Person> toBeRemoved = peopleToBeRemoved;
		List<Person> toRemoveFrom = peopleToRemoveFrom;
		if (toRemoveFrom != null && toBeRemoved != null) {
			for (Person person : toBeRemoved) {
				if (toRemoveFrom.contains(person)) {
					toRemoveFrom.remove(person);
				}
			}
		}
		logger.exiting(applicantClassName, sourceMethod);
		return toRemoveFrom;
	}

	/**
	 * 
	 * @param toBRemovedCollection
	 *            : A list of people to remove from the eligible dependents list
	 */
	public void removeFromEligibleDependents(java.util.Collection<Person> toBRemovedCollection) {
		String sourceMethod = "removeFromEligibleDependents";
		logger.entering(applicantClassName, sourceMethod);
		List<Person> toBeRemoved = new ArrayList<>(toBRemovedCollection);
		List<Person> tempDependents = this.getEligibleDependents();
		List<Person> updatedEligibleDependents = this.removePeopleFromList(toBeRemoved, tempDependents);
		this.setEligibleDependents(updatedEligibleDependents);
		logger.exiting(applicantClassName, sourceMethod);
	}

	/**
	 * 
	 * @param toBeRemoved
	 *            : A Person to remove from the eligible dependents list.
	 */
	public void removeAPersonFromTheEligibleDependents(Person toBeRemoved) {
		String sourceMethod = "removeAPersonFromTheEligibleDependents";
		logger.entering(applicantClassName, sourceMethod);
		List<Person> tempDependentsList = this.getEligibleDependents();

		if (toBeRemoved != null && tempDependentsList != null && tempDependentsList.contains(toBeRemoved)) {
			tempDependentsList.remove(toBeRemoved);
		}
		this.setEligibleDependents(tempDependentsList);
		logger.exiting(applicantClassName, sourceMethod);
	}

	/**
	 * 
	 * @param toBRemoved
	 *            : A list of people to remove from the siblings list.
	 */
	public void removeFromSiblings(java.util.Collection<Person> toBRemoved) {
		String sourceMethod = "removeFromSiblings";
		logger.entering(applicantClassName, sourceMethod);
		List<Person> toBeRemoved = new ArrayList<>(toBRemoved);
		List<Person> dependentsToRemoveFrom = this.getSiblings();
		List<Person> updatedSiblings = this.removePeopleFromList(toBeRemoved, dependentsToRemoveFrom);
		this.setSiblings(updatedSiblings);
		logger.exiting(applicantClassName, sourceMethod);
	}

	/**
	 * 
	 * @param toBeRemoved
	 *            : A list of people to remove from the under custody list.
	 */
	public void removeFromUnderCustody(java.util.Collection<Person> toBeRemoved) {
		String sourceMethod = "removeFromUnderCustody";
		logger.entering(applicantClassName, sourceMethod);
		List<Person> peopleToBeRemoved = new ArrayList<>(toBeRemoved);
		List<Person> dependentsToRemoveFrom = this.getUnderCustody();
		List<Person> updatedUnderCustody = this.removePeopleFromList(peopleToBeRemoved, dependentsToRemoveFrom);
		this.setUnderCustody(updatedUnderCustody);
		logger.exiting(applicantClassName, sourceMethod);
	}

	/**
	 * 
	 * @param toBRemoved
	 *            : A list of people to remove from the wives list.
	 */
	public void removeFromWives(java.util.Collection<Person> toBRemoved) {
		String sourceMethod = "removeFromWives";
		logger.entering(applicantClassName, sourceMethod);
		List<Person> toBeRemoved = new ArrayList<>(toBRemoved);
		List<Person> dependentsToRemoveFrom = this.getWives();
		List<Person> updatedWives = this.removePeopleFromList(toBeRemoved, dependentsToRemoveFrom);
		this.setWives(updatedWives);
		logger.exiting(applicantClassName, sourceMethod);
	}

	/**
	 * 
	 * @param toBRemoved
	 *            : A list of people to remove from the offsprings list.
	 */
	public void removeFromOffsprings(java.util.Collection<Person> toBRemoved) {
		String sourceMethod = "removeFromOffsprings";
		logger.entering(applicantClassName, sourceMethod);
		List<Person> toBeRemoved = new ArrayList<>(toBRemoved);
		List<Person> dependentsToRemoveFrom = this.getOffsprings();
		List<Person> updatedOffsprings = this.removePeopleFromList(toBeRemoved, dependentsToRemoveFrom);
		this.setOffsprings(updatedOffsprings);
		logger.exiting(applicantClassName, sourceMethod);
	}

	/**
	 * 
	 * @param people
	 *            : A list of people to add to the applicable dependents list.
	 */
	public void addAllPeopleToTheApplicableDependents(java.util.Collection<Person> people) {
		String sourceMethod = "addAllPeopleToTheApplicableDependents";
		logger.entering(applicantClassName, sourceMethod);
		if (people != null) {
			this.getApplicableDependents().addAll(people);
		}
		logger.exiting(applicantClassName, sourceMethod);
	}

	/**
	 * 
	 * @return The offsprings with no dependents/offsprings under custody.
	 */
	public List<Person> getOffspringsWithNoOffspringsUnderCustody() {
		String sourceMethod = "getOffspringsWithNoOffspringsUnderCustody";
		logger.entering(applicantClassName, sourceMethod);
		List<Person> applicantOffsprings = this.getOffsprings();
		List<Person> undercustody = this.getUnderCustody();
		List<Person> offspringsWithNoCustodyOffsprings = applicantOffsprings;

		if (undercustody == null || offspringsWithNoCustodyOffsprings == null) {
			return new ArrayList<>();
		}

		for (Person person : applicantOffsprings) {
			for (Person custodyperson : undercustody) {
				if (custodyperson.getGuardianshipstatus().getGuardianNIN().equals(person.getNin())) {
					offspringsWithNoCustodyOffsprings.remove(person);
				}
			}
		}
		logger.exiting(applicantClassName, sourceMethod);
		return offspringsWithNoCustodyOffsprings;
	}

	/**
	 * 
	 * @return the temporary disability report exceeds the medication period or
	 *         not.
	 */
	public boolean isTemporaryDisabilityReportExceedsMedicationPeriod() {
		String sourceMethod = "isTemporaryDisabilityReportExceedsMedicationPeriod";
		logger.entering(applicantClassName, sourceMethod);
		Calendar today = Calendar.getInstance();
		Calendar medicalReportDate = this.getMedicalCondition().getMedicalReportDate();
		int medicationPeriod = this.getMedicalCondition().getMedicationPeriod();

		if (medicalReportDate == null) {
			medicalReportDate = Calendar.getInstance();
		}

		int daysBetweenTodayAndReport = Utilities.daysBetween(medicalReportDate.getTime(), today.getTime());
		int difference = daysBetweenTodayAndReport - medicationPeriod;

		if (difference > 0 || daysBetweenTodayAndReport < 0) {
			logger.exiting(applicantClassName, sourceMethod, true);
			return true; // InEligible - Exceeds the period
		} else {
			logger.exiting(applicantClassName, sourceMethod, false);
			return false;
		}

	}

	/**
	 * 
	 * @return the applicant offsprings and siblings in one list.
	 */
	public List<Person> getOffspringsAndSiblings() {
		String sourceMethod = "getOffspringsAndSiblings";
		logger.entering(applicantClassName, sourceMethod);
		List<Person> applicantOffsprings = this.getOffsprings();
		List<Person> applicantSiblings = this.getSiblings();
		List<Person> offspringsAndSiblings = new ArrayList<>();

		offspringsAndSiblings.addAll(applicantOffsprings);
		offspringsAndSiblings.addAll(applicantSiblings);

		logger.exiting(applicantClassName, sourceMethod);
		return offspringsAndSiblings;
	}

	/**
	 * 
	 * @param person
	 *            : A person to be added to the applicable dependents list.
	 */
	public void addPersonToTheApplicableDependents(Person person) {
		String sourceMethod = "addPersonToTheApplicableDependents";
		logger.entering(applicantClassName, sourceMethod);
		if (person != null) {
			this.getApplicableDependents().add(person);
		}
		logger.exiting(applicantClassName, sourceMethod);
	}

	// //////////////// End of Class ///////////////////////
}
