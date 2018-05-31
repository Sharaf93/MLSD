package com.mlsd.xom.socialcare;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Logger;

import com.mlsd.utilities.Utilities;
import com.mlsd.xom.common.IncomeDetails;
import com.mlsd.xom.common.Person;
import com.mlsd.xom.socialcare.DisabilityDetails.EligibleServicesForDisability;
import com.mlsd.xom.socialcare.MedicalEquipmentProfile.EquipmentCategory;

/**
 * The applicant for the handicapped service in social care. It extends Person
 * to use the basic person info.
 * 
 * @author Ahmed Sharaf
 *
 */
public class HandicappedApplicant extends Person {

	/**
	 * The detailed assistance cards.
	 * 
	 * @author Ahmed Sharaf
	 *
	 */
	public enum AssistanceCards {
		CAR_PARKING_CARD, TRAVEL_DISCOUNT_CARD, AUTISM_CARD
	}

	/**
	 * The visa fee waiver several work types.
	 * 
	 * @author Ahmed Sharaf
	 *
	 */
	public enum VisaFeeWaiverWorkType {
		DRIVER, MAID, NURSE
	}

	private double headOfHouseHoldIncomeInMonth = 0;

	private boolean applicantIsEligible = true;
	// private boolean beneficiaryInHealthCareFromMilitarySectors = false;

	private AssesmentDetails assesmentDetails = new AssesmentDetails();
	private HospitalizationDetails hospitalizationDetails = new HospitalizationDetails();

	private List<ApplicantDisability> applicantDisabilities = new ArrayList<>();
	private List<ApplicantMedicalEquipment> receivedMedicalEquipments = new ArrayList<>();

	private Person mother = new Person();

	/* Logging constants used inside this class. */
	public static final String handicappedApplicantClassName = HandicappedApplicant.class.getName();
	public static final Logger logger = Logger.getLogger(handicappedApplicantClassName);

	public HandicappedApplicant() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public List<ApplicantMedicalEquipment> getReceivedMedicalEquipments() {
		return receivedMedicalEquipments;
	}

	public void setReceivedMedicalEquipments(List<ApplicantMedicalEquipment> receivedMedicalEquipments) {
		this.receivedMedicalEquipments = receivedMedicalEquipments;
	}

	public boolean isTheApplicantEligible() {
		return this.applicantIsEligible;
	}

	public void setTheApplicantAsEligible() {
		this.applicantIsEligible = true;
	}

	public void setTheApplicantAsInEligible() {
		this.applicantIsEligible = false;
	}

	public boolean isApplicantIsEligible() {
		return applicantIsEligible;
	}

	public void setApplicantIsEligible(boolean applicantIsEligible) {
		this.applicantIsEligible = applicantIsEligible;
	}

	public List<ApplicantDisability> getApplicantDisabilities() {
		return applicantDisabilities;
	}

	public void setApplicantDisabilities(List<ApplicantDisability> applicantDisabilities) {
		this.applicantDisabilities = applicantDisabilities;
	}

	public AssesmentDetails getAssesmentDetails() {
		return assesmentDetails;
	}

	public void setAssesmentDetails(AssesmentDetails assesmentDetails) {
		this.assesmentDetails = assesmentDetails;
	}

	public double getHeadOfHouseHoldIncomeInMonth() {
		return headOfHouseHoldIncomeInMonth;
	}

	public void setHeadOfHouseHoldIncomeInMonth(double headOfHouseHoldIncomeInMonth) {
		this.headOfHouseHoldIncomeInMonth = headOfHouseHoldIncomeInMonth;
	}

	public HospitalizationDetails getHospitalizationDetails() {
		return hospitalizationDetails;
	}

	public void setHospitalizationDetails(HospitalizationDetails hospitalizationDetails) {
		this.hospitalizationDetails = hospitalizationDetails;
	}

	public Person getMother() {
		return mother;
	}

	public void setMother(Person mother) {
		this.mother = mother;
	}

	/**
	 * 
	 * @return the total applicant income.
	 */
	public double totalApplicantIncome() {
		String sourceMethod = "totalApplicantIncome";
		logger.entering(handicappedApplicantClassName, sourceMethod);
		double total = 0;
		List<IncomeDetails> applicantIncomeDetails = this.getIncomeDetails();
		if (applicantIncomeDetails != null) {
			for (IncomeDetails incomeDetail : applicantIncomeDetails) {
				total += incomeDetail.getIncomeAmount();
			}
		}
		total = Math.round(total * 100.0);
		total = total / 100.0;
		logger.exiting(handicappedApplicantClassName, sourceMethod, total);
		return total;
	}

	/**
	 * 
	 * @param service
	 *            : The service to check with.
	 * @return if the disability provide this service.
	 */
	public boolean disabilitiesHasServiceTypeEnabled(EligibleServicesForDisability service) {
		String sourceMethod = "disabilitiesHasServiceTypeEnabled";
		logger.entering(handicappedApplicantClassName, sourceMethod);
		List<ApplicantDisability> disabilities = this.getApplicantDisabilities();
		if (disabilities != null && disabilities.size() > 0) {
			DisabilityDetails disabilityDetails;
			for (ApplicantDisability disability : disabilities) {
				disabilityDetails = disability.getDisabilityDetails();
				if (disabilityDetails != null) {
					if (disabilityDetails.getEligibleServicesForDisabilityList().contains(service)) {
						logger.exiting(handicappedApplicantClassName, sourceMethod, true);
						return true;
					}
				}
			}
		}
		logger.exiting(handicappedApplicantClassName, sourceMethod, false);
		return false;
	}

	/**
	 * 
	 * @return the number of month between admission date in a governmental
	 *         hospital and today's date.
	 */
	// public int numberOfMonthSinceAdmissionDateInGovernmentalHospital() {
	// String sourceMethod =
	// "numberOfMonthSinceAdmissionDateInGovernmentalHospital";
	// logger.entering(handicappedApplicantClassName, sourceMethod);
	// HospitalizationDetails applicantHospitalizationDetails =
	// this.getHospitalizationDetails();
	// int monthsDifference = 0;
	// if (applicantHospitalizationDetails != null) {
	// Calendar admissionDate =
	// applicantHospitalizationDetails.getAdmissionDate();
	// Calendar todayDate = Calendar.getInstance();
	// monthsDifference = Utilities.getMonthsDifference(admissionDate,
	// todayDate);
	// }
	// logger.exiting(handicappedApplicantClassName, sourceMethod,
	// monthsDifference);
	// return monthsDifference;
	// }

	public boolean numberOfDaysSinceAdmissionDateInGovernmentalHospitalExceedsLimit(int validPeriodInDays) {
		HospitalizationDetails applicantHospitalizationDetails = this.getHospitalizationDetails();
		if (applicantHospitalizationDetails != null) {
			Calendar admissionDate = applicantHospitalizationDetails.getAdmissionDate();
			Calendar todaysDate = Calendar.getInstance();
			int daysSinceStartDate = Utilities.daysBetween(admissionDate.getTime(), todaysDate.getTime());
			if (daysSinceStartDate > validPeriodInDays) {
				return true; // admission days exceeds the valid period.
			}
		}
		return false;
	}

	/**
	 * 
	 * @return the number of years between the assessment date and today's date.
	 */
	public double numberOfDaysSinceAssesmentDate() {
		AssesmentDetails applicantAssesmentDetails = this.getAssesmentDetails();
		double daysDifference = 0;
		if (applicantAssesmentDetails != null) {
			Calendar assesmentDate = applicantAssesmentDetails.getDisabilityAssesmentDate();
			Calendar todaysDate = Calendar.getInstance();
			if (assesmentDate != null) {
				daysDifference = Utilities.daysBetween(assesmentDate.getTime(), todaysDate.getTime());
			}
		}
		return daysDifference;
	}

	public boolean assessmentDoesNotExceedPeriodOfDays(int validPeriodInDays) {
		AssesmentDetails applicantAssesmentDetails = this.getAssesmentDetails();
		Calendar assesmentDate = applicantAssesmentDetails.getDisabilityAssesmentDate();
		Calendar todaysDate = Calendar.getInstance();
		int daysSinceStartDate = Utilities.daysBetween(assesmentDate.getTime(), todaysDate.getTime());
		if (daysSinceStartDate <= validPeriodInDays) {
			return true; // assessment date does not cover the valid
							// period
		}
		return false;
	}

	/**
	 * Checks if the medical equipment is expired.
	 * 
	 * @param medicalEquipment
	 *            : the equipment that will be checked
	 * @return the whether the equipment is expired or not.
	 */
	public boolean medicalEquipmentIsExpired(ApplicantMedicalEquipment medicalEquipment) {
		String sourceMethod = "medicalEquipmentIsExpired";
		logger.entering(handicappedApplicantClassName, sourceMethod);
		if (medicalEquipment != null) {
			return medicalEquipment.equipmentIsExpired();
		}
		logger.exiting(handicappedApplicantClassName, sourceMethod, false);
		return false;
	}

	/**
	 * 
	 * @return the medical equipment profiles from the received equipments.
	 */
	public List<MedicalEquipmentProfile> getReceivedMedicalEquipmentProfiles() {
		String sourceMethod = "getReceivedMedicalEquipmentProfiles";
		logger.entering(handicappedApplicantClassName, sourceMethod);
		List<ApplicantMedicalEquipment> applicantReceivedEquipments = this.getReceivedMedicalEquipments();
		List<MedicalEquipmentProfile> medicalEquipments = new ArrayList<>();
		if (applicantReceivedEquipments != null) {
			for (ApplicantMedicalEquipment receivedEquipment : applicantReceivedEquipments) {
				medicalEquipments.add(receivedEquipment.getMedicalEquipmentDetails());
			}
		}
		logger.exiting(handicappedApplicantClassName, sourceMethod);
		return medicalEquipments;
	}

	/**
	 * 
	 * @return the medical equipment cores from the requested equipments.
	 */
	public List<MedicalEquipment> getReceivedMedicalEquipmentsCore() {
		String sourceMethod = "getReceivedMedicalEquipmentProfiles";
		logger.entering(handicappedApplicantClassName, sourceMethod);
		List<ApplicantMedicalEquipment> applicantReceivedEquipments = this.getReceivedMedicalEquipments();
		List<MedicalEquipment> medicalEquipments = new ArrayList<>();
		if (applicantReceivedEquipments != null) {
			for (ApplicantMedicalEquipment receivedEquipment : applicantReceivedEquipments) {
				medicalEquipments.add(receivedEquipment.getMedicalEquipmentDetails().getMedicalEquipment());
			}
		}
		logger.exiting(handicappedApplicantClassName, sourceMethod);
		return medicalEquipments;
	}

	// *** Deprecated for changing from main-id & sub-id to equipment-id ***
	// public boolean
	// anyOfRequestedEquipMatchesAnyOfReceivedEquipAndNotExpired(List<ApplicantMedicalEquipment>
	// receivedMedicalEquipment,
	// List<MedicalEquipmentProfile> requestedMedicalEquipment) {
	// if (receivedMedicalEquipment != null && requestedMedicalEquipment != null
	// && receivedMedicalEquipment.size() > 0
	// && requestedMedicalEquipment.size() > 0) {
	// int recievedMainId, recievedSubId, requestedMainId, requestedSubId;
	// for (ApplicantMedicalEquipment receivedEquipment :
	// receivedMedicalEquipment) {
	// recievedMainId =
	// receivedEquipment.getMedicalEquipmentDetails().getMedicalEquipment().getMainID();
	// recievedSubId =
	// receivedEquipment.getMedicalEquipmentDetails().getMedicalEquipment().getSubID();
	// if (receivedEquipment.equipmentIsExpired() == false) {
	// for (MedicalEquipmentProfile requestedEquipment :
	// requestedMedicalEquipment) {
	// requestedMainId = requestedEquipment.getMedicalEquipment().getMainID();
	// requestedSubId = requestedEquipment.getMedicalEquipment().getSubID();
	// if (recievedMainId == requestedMainId && recievedSubId == requestedSubId)
	// {
	// return true;
	// }
	// }
	// }
	// }
	// }
	// return false;
	// }

	public boolean anyOfRequestedEquipMatchesAnyOfReceivedEquipAndNotExpired(List<ApplicantMedicalEquipment> receivedMedicalEquipment,
			List<MedicalEquipmentProfile> requestedMedicalEquipment) {
		if (receivedMedicalEquipment != null && requestedMedicalEquipment != null && receivedMedicalEquipment.size() > 0
				&& requestedMedicalEquipment.size() > 0) {
			int receivedEquipmentID, requestedEquipmentID;
			for (ApplicantMedicalEquipment receivedEquipment : receivedMedicalEquipment) {
				receivedEquipmentID = receivedEquipment.getMedicalEquipmentDetails().getMedicalEquipment().getEquipmentID();
				if (receivedEquipment.equipmentIsExpired() == false) {
					for (MedicalEquipmentProfile requestedEquipment : requestedMedicalEquipment) {
						requestedEquipmentID = requestedEquipment.getMedicalEquipment().getEquipmentID();
						if (receivedEquipmentID == requestedEquipmentID) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	// *** Deprecated since equipment-type & main-id is no longer in use ***
	// public boolean
	// anyOfRequestedEquipMatchesWithEquipmentTypeAnyOfReceivedEquipAndNotExpired(List<MedicalEquipmentProfile>
	// requestedMedicalEquipment,
	// List<ApplicantMedicalEquipment> receivedMedicalEquipment) {
	// if (receivedMedicalEquipment != null && requestedMedicalEquipment != null
	// && receivedMedicalEquipment.size() > 0
	// && requestedMedicalEquipment.size() > 0) {
	// int receivedMainId, receivedEquipmentType, requestedMainId,
	// requestedEquipmentType;
	// for (ApplicantMedicalEquipment receivedEquipment :
	// receivedMedicalEquipment) {
	// receivedMainId =
	// receivedEquipment.getMedicalEquipmentDetails().getMedicalEquipment().getMainID();
	// receivedEquipmentType =
	// receivedEquipment.getMedicalEquipmentDetails().getEquipmentType();
	// if (receivedEquipment.equipmentIsExpired() == false) {
	// for (MedicalEquipmentProfile requestedEquipment :
	// requestedMedicalEquipment) {
	// requestedMainId = requestedEquipment.getMedicalEquipment().getMainID();
	// requestedEquipmentType = requestedEquipment.getEquipmentType();
	// if (receivedMainId == requestedMainId && receivedEquipmentType ==
	// requestedEquipmentType) {
	// return true;
	// }
	// }
	// }
	// }
	// }
	// return false;
	// }

	// *** Deprecated since equipment-type & main-id is no longer in use ***
	public boolean anyOfRequestedEquipMatchesTheEquipmentType(List<MedicalEquipmentProfile> requestedMedicalEquipment) {
		if (requestedMedicalEquipment != null && requestedMedicalEquipment.size() > 0) {
			int equipmentID, requestedEquipmentID, count;
			for (MedicalEquipmentProfile requestedEquipment : requestedMedicalEquipment) {
				equipmentID = requestedEquipment.getMedicalEquipment().getEquipmentID();
				count = 0;
				for (MedicalEquipmentProfile equipments : requestedMedicalEquipment) {
					requestedEquipmentID = equipments.getMedicalEquipment().getEquipmentID();
					if (equipmentID == requestedEquipmentID) {
						count++;
					}
				}
				if (count > 1) {
					return true;
				}
			}
		}
		return false;
	}

	// *** Deprecated for changing from main-id & sub-id to equipment-id ***
	// public boolean
	// anyOfConflictingEquipMatchesAnyOfReceivedEquipAndNotExpired(List<MedicalEquipment>
	// conflictingMedicalEquipment,
	// List<ApplicantMedicalEquipment> receivedMedicalEquipment) {
	// if (receivedMedicalEquipment != null && conflictingMedicalEquipment !=
	// null && receivedMedicalEquipment.size() > 0
	// && conflictingMedicalEquipment.size() > 0) {
	// int receivedMainId, receivedSubId, conflictMainId, conflictSubId;
	// for (ApplicantMedicalEquipment receivedEquipment :
	// receivedMedicalEquipment) {
	// receivedMainId =
	// receivedEquipment.getMedicalEquipmentDetails().getMedicalEquipment().getMainID();
	// receivedSubId =
	// receivedEquipment.getMedicalEquipmentDetails().getMedicalEquipment().getSubID();
	// if (receivedEquipment.equipmentIsExpired() == false) {
	// for (MedicalEquipment requestedEquipment : conflictingMedicalEquipment) {
	// conflictMainId = requestedEquipment.getMainID();
	// conflictSubId = requestedEquipment.getSubID();
	// if (receivedMainId == conflictMainId && receivedSubId == conflictSubId) {
	// return true;
	// }
	// }
	// }
	// }
	// }
	// return false;
	// }

	public boolean anyOfConflictingEquipMatchesAnyOfReceivedEquipAndNotExpired(List<MedicalEquipment> conflictingMedicalEquipment,
			List<ApplicantMedicalEquipment> receivedMedicalEquipment) {
		if (receivedMedicalEquipment != null && conflictingMedicalEquipment != null && receivedMedicalEquipment.size() > 0
				&& conflictingMedicalEquipment.size() > 0) {
			int receivedEquipmentID, conflictEquipmentID;
			for (ApplicantMedicalEquipment receivedEquipment : receivedMedicalEquipment) {
				receivedEquipmentID = receivedEquipment.getMedicalEquipmentDetails().getMedicalEquipment().getEquipmentID();
				if (receivedEquipment.equipmentIsExpired() == false) {
					for (MedicalEquipment requestedEquipment : conflictingMedicalEquipment) {
						conflictEquipmentID = requestedEquipment.getEquipmentID();
						if (receivedEquipmentID == conflictEquipmentID) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public boolean isDisabilityListMatchesAnyOfApplicantDisabilities(List<ApplicantDisability> disabilityList, List<ApplicantDisability> applicantDisability) {
		int disabilityId, appDisabilityId;
		if (disabilityList == null || disabilityList.size() == 0 || applicantDisability == null || applicantDisability.size() == 0) {
			return false;
		}
		for (ApplicantDisability disability : disabilityList) {
			disabilityId = disability.getDisabilityDetails().getDisabilityID();
			for (ApplicantDisability appDisability : applicantDisability) {
				appDisabilityId = appDisability.getDisabilityDetails().getDisabilityID();
				if (disabilityId == appDisabilityId) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Checks the total number of 'Primary' medical equipments in the received
	 * and the requested medical equipments. It should not exceed the provided
	 * limit.
	 * 
	 * @param limit
	 *            :the number of eligible primary equipments
	 * @param applicantReceivedEquipments
	 *            : the received equipments of the applicant.
	 * @param requestedEquipments
	 *            : the requested equipments of the applicant.
	 * @return whether the number exceeds the provided limit or not.
	 */
	public boolean totalNumberOfPrimaryEquipmentsExceedstheLimit(int limit, List<ApplicantMedicalEquipment> applicantReceivedEquipments,
			List<MedicalEquipmentProfile> requestedEquipments) {
		String sourceMethod = "totalNumberOfPrimaryEquipmentsExceedstheLimit";
		logger.entering(handicappedApplicantClassName, sourceMethod);
		if (applicantReceivedEquipments == null || applicantReceivedEquipments.size() == 0 || requestedEquipments == null || requestedEquipments.size() == 0) {
			logger.exiting(handicappedApplicantClassName, sourceMethod, false);
			return false;
		}
		int numberOfPrimaryEquipments = 0;
		EquipmentCategory equipCategory;
		for (ApplicantMedicalEquipment applicantEquipment : applicantReceivedEquipments) {
			if (!applicantEquipment.equipmentIsExpired()) {
				equipCategory = applicantEquipment.getMedicalEquipmentDetails().getEquipmentCategory();
				if (EquipmentCategory.PRIMARY.equals(equipCategory) || EquipmentCategory.PRIMARY_SPECIAL_CASES.equals(equipCategory)) {
					numberOfPrimaryEquipments++;
				}
			}
		}
		for (MedicalEquipmentProfile reqEquipment : requestedEquipments) {
			equipCategory = reqEquipment.getEquipmentCategory();
			if (EquipmentCategory.PRIMARY.equals(equipCategory) || EquipmentCategory.PRIMARY_SPECIAL_CASES.equals(equipCategory)) {
				numberOfPrimaryEquipments++;
			}
		}
		if (numberOfPrimaryEquipments > limit) {
			logger.exiting(handicappedApplicantClassName, sourceMethod, true);
			return true;
		} else {
			logger.exiting(handicappedApplicantClassName, sourceMethod, false);
			return false;
		}
	}

	/**
	 * This medthod is used to check the availability of the Mother of the
	 * applicant.
	 * 
	 * @return if the applicant has an added mother.
	 */
	public boolean hasAddedMother() {
		String motherNIN = this.getMother().getNin();
		if (motherNIN == null) {
			motherNIN = "";
		}
		if ("".equals(motherNIN)) {
			return false;
		}
		return true;
	}

	public boolean similarEquipmentsInRequest(List<MedicalEquipmentProfile> requestedEquipments) {
		if (requestedEquipments == null || requestedEquipments.size() == 0 || requestedEquipments.size() == 1) {
			return false;
		}
		int equipmentID, requestedEquipmentID, count;
		for (MedicalEquipmentProfile requestedEquipment : requestedEquipments) {
			equipmentID = requestedEquipment.getMedicalEquipment().getEquipmentID();
			count = 0;
			for (MedicalEquipmentProfile equipments : requestedEquipments) {
				requestedEquipmentID = equipments.getMedicalEquipment().getEquipmentID();
				if (equipmentID == requestedEquipmentID) {
					count++;
				}
			}
			if (count > 1) {
				return true;
			}
		}
		return false;
	}

};
