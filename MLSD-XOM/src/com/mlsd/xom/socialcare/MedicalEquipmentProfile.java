package com.mlsd.xom.socialcare;

import java.util.ArrayList;
import java.util.List;

/**
 * The medical equipment profile. All the information needed for the medical
 * equipment a person has or can request.
 * 
 * @author Ahmed Sharaf
 *
 */
public class MedicalEquipmentProfile {

	/**
	 * The category of the equipment.
	 * 
	 * @author Ahmed Sharaf
	 *
	 */
	public enum EquipmentCategory {
		PRIMARY, PRIMARY_SPECIAL_CASES, SECONDARY, NONE;
	}

	private int equipmentValidityInMonth = 0;
	private RequiredAge requiredAge = new RequiredAge();
	private MedicalEquipment medicalEquipment = new MedicalEquipment();
	private EquipmentCategory equipmentCategory = EquipmentCategory.NONE;

	private List<MedicalEquipment> conflictingEquipments = new ArrayList<>();
	private List<ApplicantDisability> eligibleDisabilities = new ArrayList<>();
	private List<ApplicantDisability> ineligibleDisabilities = new ArrayList<>();


	public MedicalEquipmentProfile() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public MedicalEquipment getMedicalEquipment() {
		if(medicalEquipment == null)
			medicalEquipment = new MedicalEquipment();
		return medicalEquipment;
	}

	public void setMedicalEquipment(MedicalEquipment medicalEquipment) {
		this.medicalEquipment = medicalEquipment;
	}

	public List<MedicalEquipment> getConflictingEquipments() {
		if(conflictingEquipments == null)
			conflictingEquipments = new ArrayList<>();
		return conflictingEquipments;
	}

	public void setConflictingEquipments(List<MedicalEquipment> conflictingEquipments) {
		this.conflictingEquipments = conflictingEquipments;
	}

	public EquipmentCategory getEquipmentCategory() {
		if (equipmentCategory == null)
			equipmentCategory = EquipmentCategory.NONE;
		return equipmentCategory;
	}

	public void setEquipmentCategory(EquipmentCategory equipmentCategory) {
		this.equipmentCategory = equipmentCategory;
	}

	public List<ApplicantDisability> getEligibleDisabilities() {
		if(eligibleDisabilities == null)
			eligibleDisabilities = new ArrayList<>();
		return eligibleDisabilities;
	}

	public void setEligibleDisabilities(List<ApplicantDisability> eligibleDisabilities) {
		this.eligibleDisabilities = eligibleDisabilities;
	}

	public List<ApplicantDisability> getIneligibleDisabilities() {
		if(ineligibleDisabilities == null)
			ineligibleDisabilities = new ArrayList<>();
		return ineligibleDisabilities;
	}

	public void setIneligibleDisabilities(List<ApplicantDisability> ineligibleDisabilities) {
		this.ineligibleDisabilities = ineligibleDisabilities;
	}

	public int getEquipmentValidityInMonth() {
		return equipmentValidityInMonth;
	}

	public void setEquipmentValidityInMonth(int equipmentValidityInMonth) {
		this.equipmentValidityInMonth = equipmentValidityInMonth;
	}

	public RequiredAge getRequiredAge() {
		if(requiredAge == null)
			requiredAge = new RequiredAge();
		return requiredAge;
	}

	public void setRequiredAge(RequiredAge requiredAge) {
		this.requiredAge = requiredAge;
	}

}
