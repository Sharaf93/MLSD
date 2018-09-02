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
 * The applicant for the handicapped services in social care. It extends Person
 * to use the basic person information.
 * 
 * @author Ahmed Sharafeldin
 *
 */
public class HandicappedApplicant extends Person {

	/**
	 * The detailed assistance cards.
	 * 
	 * @author Ahmed Sharafeldin
	 *
	 */
	public enum AssistanceCards {
		CAR_PARKING_CARD, TRAVEL_DISCOUNT_CARD, AUTISM_CARD
	}

	/**
	 * The visa fee waiver several work types.
	 * 
	 * @author Ahmed Sharafeldin
	 *
	 */
	public enum VisaFeeWaiverWorkType {
		DRIVER, MAID, NURSE
	}

	private Person mother = new Person();
	private boolean applicantIsEligible = true;
	private double headOfHouseHoldIncomeInMonth = 0;
	private AssesmentDetails assesmentDetails = new AssesmentDetails();
	private List<ApplicantDisability> applicantDisabilities = new ArrayList<>();
	private HospitalizationDetails hospitalizationDetails = new HospitalizationDetails();
	private List<ApplicantMedicalEquipment> receivedMedicalEquipments = new ArrayList<>();

	/* Logging constants used inside this class. */
	public static final String handicappedApplicantClassName = HandicappedApplicant.class.getName();
	public static final Logger logger = Logger.getLogger(handicappedApplicantClassName);

	public HandicappedApplicant() {
		// Empty Constructor for NULL Avoidance
	}

	public List<ApplicantMedicalEquipment> getReceivedMedicalEquipments() {
		if (receivedMedicalEquipments == null)
			receivedMedicalEquipments = new ArrayList<>();
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
		if (applicantDisabilities == null)
			applicantDisabilities = new ArrayList<>();
		return applicantDisabilities;
	}

	public void setApplicantDisabilities(List<ApplicantDisability> applicantDisabilities) {
		this.applicantDisabilities = applicantDisabilities;
	}

	public AssesmentDetails getAssesmentDetails() {
		if (assesmentDetails == null)
			assesmentDetails = new AssesmentDetails();
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
		if (hospitalizationDetails == null)
			hospitalizationDetails = new HospitalizationDetails();
		return hospitalizationDetails;
	}

	public void setHospitalizationDetails(HospitalizationDetails hospitalizationDetails) {
		this.hospitalizationDetails = hospitalizationDetails;
	}

	public Person getMother() {
		if (mother == null)
			mother = new Person();
		return mother;
	}

	public void setMother(Person mother) {
		this.mother = mother;
	}

	/**
	 * Calculates the total applicant income.
	 * 
	 * @return the total income.
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
	 * Checks if the applicant's disabilities complies with the service.
	 * 
	 * @param service
	 *            : The service to check with.
	 * @return whether the disability provide the service.
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
	 * Checks the number of admission days with a specified limit
	 * 
	 * @return whether he exceeds the valid period
	 */
	public boolean numberOfDaysSinceAdmissionDateInGovernmentalHospitalExceedsLimit(int validPeriodInDays) {
		String sourceMethod = "numberOfDaysSinceAdmissionDateInGovernmentalHospitalExceedsLimit";
		logger.entering(handicappedApplicantClassName, sourceMethod);
		HospitalizationDetails applicantHospitalizationDetails = this.getHospitalizationDetails();
		if (applicantHospitalizationDetails != null) {
			Calendar admissionDate = applicantHospitalizationDetails.getAdmissionDate();
			Calendar todaysDate = Calendar.getInstance();
			int daysSinceStartDate = Utilities.daysBetween(admissionDate.getTime(), todaysDate.getTime());
			if (daysSinceStartDate > validPeriodInDays) {
				logger.exiting(handicappedApplicantClassName, sourceMethod, true);
				return true; // admission days exceeds the valid period.
			}
		}
		logger.exiting(handicappedApplicantClassName, sourceMethod, false);
		return false;
	}

	/**
	 * Calculates the period since the assessment date
	 * 
	 * @return the number of days between the assessment date and today's date.
	 */
	public double numberOfDaysSinceAssesmentDate() {
		String sourceMethod = "numberOfDaysSinceAssesmentDate";
		logger.entering(handicappedApplicantClassName, sourceMethod);
		AssesmentDetails applicantAssesmentDetails = this.getAssesmentDetails();
		double daysDifference = 0;
		if (applicantAssesmentDetails != null) {
			Calendar assesmentDate = applicantAssesmentDetails.getDisabilityAssesmentDate();
			Calendar todaysDate = Calendar.getInstance();
			if (assesmentDate != null) {
				daysDifference = Utilities.daysBetween(assesmentDate.getTime(), todaysDate.getTime());
			}
		}
		logger.exiting(handicappedApplicantClassName, sourceMethod);
		return daysDifference;
	}

	/**
	 * Checks if the assessment exceeds a period of days
	 * 
	 * @param validPeriodInDays
	 *            the periodto compare with.
	 * 
	 * @return whether it exceeds the period
	 */
	public boolean assessmentDoesNotExceedPeriodOfDays(int validPeriodInDays) {
		String sourceMethod = "assessmentDoesNotExceedPeriodOfDays";
		logger.entering(handicappedApplicantClassName, sourceMethod);
		AssesmentDetails applicantAssesmentDetails = this.getAssesmentDetails();
		Calendar assesmentDate = applicantAssesmentDetails.getDisabilityAssesmentDate();
		Calendar todaysDate = Calendar.getInstance();
		if (assesmentDate != null) {
			int daysSinceStartDate = Utilities.daysBetween(assesmentDate.getTime(), todaysDate.getTime());
			if (daysSinceStartDate <= validPeriodInDays) {
				logger.exiting(handicappedApplicantClassName, sourceMethod, true);
				return true; // assessment date does not cover the valid
								// period
			}
		}
		logger.exiting(handicappedApplicantClassName, sourceMethod, false);
		return false;
	}

	/**
	 * Checks if the medical equipment is expired.
	 * 
	 * @param medicalEquipment
	 *            : the equipment that will be checked
	 * @return whether the equipment is expired.
	 */
	public boolean medicalEquipmentIsExpired(ApplicantMedicalEquipment medicalEquipment) {
		String sourceMethod = "medicalEquipmentIsExpired";
		logger.entering(handicappedApplicantClassName, sourceMethod);
		if (medicalEquipment != null) {
			logger.exiting(handicappedApplicantClassName, sourceMethod, medicalEquipment.equipmentIsExpired());
			return medicalEquipment.equipmentIsExpired();
		}
		logger.exiting(handicappedApplicantClassName, sourceMethod, false);
		return false;
	}

	/**
	 * Gets the received medical equipments. (MedicalEquipmentProfile form)
	 * 
	 * @return a list of medical equipment profiles from the received
	 *         equipments.
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
	 * Gets the received medical equipments. (MedicalEquipment form)
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

	/**
	 * Checks if any of the requested equipments matches with any of the
	 * received ones and still not expired.
	 * 
	 * @param receivedMedicalEquipment
	 *            the received equipment list
	 * @param requestedMedicalEquipment
	 *            the requested equipment list
	 * @return whether any of the equipments matches
	 */
	public boolean anyOfRequestedEquipMatchesAnyOfReceivedEquipAndNotExpired(List<ApplicantMedicalEquipment> receivedMedicalEquipment,
			List<MedicalEquipmentProfile> requestedMedicalEquipment) {
		String sourceMethod = "anyOfRequestedEquipMatchesAnyOfReceivedEquipAndNotExpired";
		logger.entering(handicappedApplicantClassName, sourceMethod);
		if (receivedMedicalEquipment != null && requestedMedicalEquipment != null && receivedMedicalEquipment.size() > 0
				&& requestedMedicalEquipment.size() > 0) {
			int receivedEquipmentID, requestedEquipmentID;
			for (ApplicantMedicalEquipment receivedEquipment : receivedMedicalEquipment) {
				receivedEquipmentID = receivedEquipment.getMedicalEquipmentDetails().getMedicalEquipment().getEquipmentID();
				if (receivedEquipment.equipmentIsExpired() == false) {
					for (MedicalEquipmentProfile requestedEquipment : requestedMedicalEquipment) {
						requestedEquipmentID = requestedEquipment.getMedicalEquipment().getEquipmentID();
						if (receivedEquipmentID == requestedEquipmentID) {
							logger.exiting(handicappedApplicantClassName, sourceMethod, true);
							return true;
						}
					}
				}
			}
		}
		logger.exiting(handicappedApplicantClassName, sourceMethod, false);
		return false;
	}

	/**
	 * Checks if any of the requested equipments matches each other using the
	 * equipment-ID
	 * 
	 * @param requestedMedicalEquipment
	 *            the requested equipment list
	 * @return whether there is an equipment match
	 */
	public boolean anyOfRequestedEquipMatchesTheEquipmentType(List<MedicalEquipmentProfile> requestedMedicalEquipment) {
		String sourceMethod = "anyOfRequestedEquipMatchesTheEquipmentType";
		logger.entering(handicappedApplicantClassName, sourceMethod);
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
					logger.exiting(handicappedApplicantClassName, sourceMethod, true);
					return true;
				}
			}
		}
		logger.exiting(handicappedApplicantClassName, sourceMethod, false);
		return false;
	}

	/**
	 * Checks if any of the conflicting equipments matches with the received
	 * equipment.
	 * 
	 * @param conflictingMedicalEquipment
	 *            the conflicting equipments list
	 * @param receivedMedicalEquipment
	 *            the received equipment list
	 * @return whether there is an equipment match
	 */
	public boolean anyOfConflictingEquipMatchesAnyOfReceivedEquipAndNotExpired(List<MedicalEquipment> conflictingMedicalEquipment,
			List<ApplicantMedicalEquipment> receivedMedicalEquipment) {
		String sourceMethod = "anyOfConflictingEquipMatchesAnyOfReceivedEquipAndNotExpired";
		logger.entering(handicappedApplicantClassName, sourceMethod);
		if (receivedMedicalEquipment != null && conflictingMedicalEquipment != null && receivedMedicalEquipment.size() > 0
				&& conflictingMedicalEquipment.size() > 0) {
			int receivedEquipmentID, conflictEquipmentID;
			for (ApplicantMedicalEquipment receivedEquipment : receivedMedicalEquipment) {
				receivedEquipmentID = receivedEquipment.getMedicalEquipmentDetails().getMedicalEquipment().getEquipmentID();
				if (receivedEquipment.equipmentIsExpired() == false) {
					for (MedicalEquipment requestedEquipment : conflictingMedicalEquipment) {
						conflictEquipmentID = requestedEquipment.getEquipmentID();
						if (receivedEquipmentID == conflictEquipmentID) {
							logger.exiting(handicappedApplicantClassName, sourceMethod, true);
							return true;
						}
					}
				}
			}
		}
		logger.exiting(handicappedApplicantClassName, sourceMethod, false);
		return false;
	}

	/**
	 * Checks the applicant disabilities compatibility with a disability list
	 * 
	 * @param disabilityList
	 *            the disability list to compare with
	 * @param applicantDisability
	 *            the applicants disability list
	 * @return whether there is a disability match
	 */
	public boolean isDisabilityListMatchesAnyOfApplicantDisabilities(List<ApplicantDisability> disabilityList, List<ApplicantDisability> applicantDisability) {
		String sourceMethod = "isDisabilityListMatchesAnyOfApplicantDisabilities";
		logger.entering(handicappedApplicantClassName, sourceMethod);
		int disabilityId, appDisabilityId;
		if (disabilityList == null || disabilityList.size() == 0 || applicantDisability == null || applicantDisability.size() == 0) {
			return false;
		}
		for (ApplicantDisability disability : disabilityList) {
			disabilityId = disability.getDisabilityDetails().getDisabilityID();
			for (ApplicantDisability appDisability : applicantDisability) {
				appDisabilityId = appDisability.getDisabilityDetails().getDisabilityID();
				if (disabilityId == appDisabilityId) {
					logger.exiting(handicappedApplicantClassName, sourceMethod, true);
					return true;
				}
			}
		}
		logger.exiting(handicappedApplicantClassName, sourceMethod, false);
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
	 * Checks the availability of the Mother of the applicant.
	 * 
	 * @return whether the applicant has an added mother.
	 */
	public boolean hasAddedMother() {
		String sourceMethod = "totalNumberOfPrimaryEquipmentsExceedstheLimit";
		logger.entering(handicappedApplicantClassName, sourceMethod);
		String motherNIN = this.getMother().getNin();
		if (motherNIN == null) {
			motherNIN = "";
		}
		if ("".equals(motherNIN)) {
			logger.exiting(handicappedApplicantClassName, sourceMethod, false);
			return false;
		}
		logger.exiting(handicappedApplicantClassName, sourceMethod, true);
		return true;
	}

	/**
	 * Checks if there are similar equipments in the same request
	 * 
	 * @param requestedEquipments
	 *            the requested equipments list
	 * @return whether there is a similarity
	 */
	public boolean similarEquipmentsInRequest(List<MedicalEquipmentProfile> requestedEquipments) {
		String sourceMethod = "similarEquipmentsInRequest";
		logger.entering(handicappedApplicantClassName, sourceMethod);
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
				logger.exiting(handicappedApplicantClassName, sourceMethod, true);
				return true;
			}
		}
		logger.exiting(handicappedApplicantClassName, sourceMethod, false);
		return false;
	}

};
