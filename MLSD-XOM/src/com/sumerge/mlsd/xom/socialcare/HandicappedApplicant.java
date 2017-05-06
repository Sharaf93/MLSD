package com.sumerge.mlsd.xom.socialcare;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.sumerge.mlsd.utilities.Utilities;
import com.sumerge.mlsd.xom.common.IncomeDetails;
import com.sumerge.mlsd.xom.common.Person;
import com.sumerge.mlsd.xom.common.IncomeDetails.IncomeType;
import com.sumerge.mlsd.xom.socialcare.DisabilityDetails.EligibleServicesForDisability;

/**
 * The applicant for the handicapped service in social care. It extends Person
 * to use the basic person info.
 * 
 * @author Administrator
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
		DRIVER_VISA_FEE_WAIVER, MAID_VISA_FEE_WAIVER, NURSE_VISA_FEE_WAIVER
	}

	private double headOfHouseHoldIncomeInMonth = 0;

	private boolean applicantIsEligible = true;
	private boolean beneficiaryInHealthCareFromMilitarySectors = false;

	private AssesmentDetails assesmentDetails = new AssesmentDetails();
	private HospitalizationDetails hospitalizationDetails = new HospitalizationDetails();

	private List<ApplicantDisability> applicantDisabilities = new ArrayList<>();
	private List<ApplicantMedicalEquipment> receivedMedicalEquipments = new ArrayList<>();

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

	public boolean isBeneficiaryInHealthCareFromMilitarySectors() {
		return beneficiaryInHealthCareFromMilitarySectors;
	}

	public void setBeneficiaryInHealthCareFromMilitarySectors(boolean beneficiaryInHealthCareFromMilitarySectors) {
		this.beneficiaryInHealthCareFromMilitarySectors = beneficiaryInHealthCareFromMilitarySectors;
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

	/**
	 * 
	 * @return the total applicant income from income type Salary and Pension.
	 */
	public double totalApplicantIncomeFromSalaryAndPension() {
		double total = 0;
		List<IncomeDetails> applicantIncomeDetails = this.getIncomeDetails();
		for (IncomeDetails incomeDetail : applicantIncomeDetails) {
			if (incomeDetail.getIncomeType().equals(IncomeType.SALARY) || incomeDetail.getIncomeType().equals(IncomeType.PENSION)) {
				total += incomeDetail.getIncomeAmount();
			}
		}
		total = Math.round(total * 100);
		total = total / 100;
		return total;
	}

	/**
	 * 
	 * @param service
	 *            : The service to check with.
	 * @return if the disability provide this service.
	 */
	public boolean disabilitiesHasServiceTypeEnabled(EligibleServicesForDisability service) {
		List<ApplicantDisability> disabilities = this.getApplicantDisabilities();
		if (disabilities != null && disabilities.size() > 0) {
			DisabilityDetails disabilityDetails;
			for (ApplicantDisability disability : disabilities) {
				disabilityDetails = disability.getDisabilityDetails();
				if (disabilityDetails.getEligibleServicesForDisabilityList().contains(service)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 
	 * @return the number of month between admission date in a governmental
	 *         hospital and today's date.
	 */
	public int numberOfMonthSinceAdmissionDateInGovernmentalHospital() {
		HospitalizationDetails applicantHospitalizationDetails = this.getHospitalizationDetails();
		int monthsDifference = 0;
		if (applicantHospitalizationDetails != null) {
			Calendar admissionDate = applicantHospitalizationDetails.getAdmissionDate();
			Calendar todayDate = Calendar.getInstance();
			monthsDifference = Utilities.getMonthsDifference(admissionDate, todayDate);
		}
		return monthsDifference;
	}

	/**
	 * 
	 * @return the number of years since between the assessment date and today's
	 *         date.
	 */
	public double numberOfYearsSinceAssesmentDate() {
		AssesmentDetails applicantAssesmentDetails = this.getAssesmentDetails();
		int monthsDifference = 0;
		if (applicantAssesmentDetails != null) {
			Calendar assesmentDate = applicantAssesmentDetails.getDisabilityAssesmentDate();
			Calendar todaysDate = Calendar.getInstance();
			monthsDifference = Utilities.getMonthsDifference(assesmentDate, todaysDate);
		}
		return monthsDifference / 12;
	}

	public boolean medicalEquipmentIsExpired(ApplicantMedicalEquipment medicalEquipment) {
		if (medicalEquipment != null) {
			Calendar todaysDate = Calendar.getInstance();
			Calendar equipmentRecievalDate = medicalEquipment.getEquipmentRecievalDate();
			MedicalEquipmentProfile equipmentProfile = medicalEquipment.getMedicalEquipmentDetails();
			int equipmentValidityInMonth = equipmentProfile.getEquipmentValidityInMonth();
			int monthsDifference = Utilities.getMonthsDifference(equipmentRecievalDate, todaysDate);
			if (monthsDifference > equipmentValidityInMonth) {
				return true; // Equipment Is Expired
			}
		}
		return false;
	}

	public List<MedicalEquipmentProfile> getReceivedMedicalEquipmentProfiles() {
		List<ApplicantMedicalEquipment> applicantReceivedEquipments = this.getReceivedMedicalEquipments();
		List<MedicalEquipmentProfile> medicalEquipments = new ArrayList<>();
		if (applicantReceivedEquipments != null) {
			for (ApplicantMedicalEquipment receivedEquipment : applicantReceivedEquipments) {
				medicalEquipments.add(receivedEquipment.getMedicalEquipmentDetails());
			}
		}
		return medicalEquipments;
	}

	public boolean isReceivedEquipmentExpiredWithConflictingEquipment(MedicalEquipment conflictingEquipment) {
		List<ApplicantMedicalEquipment> applicantReceivedEquipments = this.getReceivedMedicalEquipments();
		if (conflictingEquipment != null && applicantReceivedEquipments != null) {
			Calendar equipmentReceivalDate = Calendar.getInstance();
			Calendar todaysDate = Calendar.getInstance();
			int monthsDifference = 0;
			int equipmentValidityInMonth = 0;
			for (ApplicantMedicalEquipment receivedEquipment : applicantReceivedEquipments) {
				MedicalEquipment equipment = receivedEquipment.getMedicalEquipmentDetails().getMedicalEquipment();
				if (conflictingEquipment.equals(equipment)) {
					equipmentReceivalDate = receivedEquipment.getEquipmentRecievalDate();
					equipmentValidityInMonth = receivedEquipment.getMedicalEquipmentDetails().getEquipmentValidityInMonth();
					monthsDifference = Utilities.getMonthsDifference(equipmentReceivalDate, todaysDate);
					if (monthsDifference > equipmentValidityInMonth) {
						return true; // Equipment Is Expired
					}
				}
			}
		}
		return false;
	}

};
