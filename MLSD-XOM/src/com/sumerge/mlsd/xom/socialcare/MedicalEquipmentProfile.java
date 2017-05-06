package com.sumerge.mlsd.xom.socialcare;

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
		PRIMARY, SECONDARY, NONE;
	}

	/**
	 * The type of the equipment.
	 * 
	 * @author Ahmed Sharaf.
	 *
	 */
	public enum EquipmentType {
		MEDICAL_CHAIR, MEDICAL_BED, MEDICAL_SEATER, MEDICAL_EARPHONE, MEDICAL_CAR, MEDICAL_LIFTER, MEDICAL_WALKER, MEDICAL_HEADREST, TABLE, GRIP, DEVICE, OTHER
	}

	private int requiredAge = 0;
	private int equipmentValidityInMonth = 0;
	private boolean notAvailableFromMilitarySectors = true;

	private EquipmentType equipmentType = EquipmentType.OTHER;
	private EquipmentCategory equipmentCategory = EquipmentCategory.NONE;

	private MedicalEquipment medicalEquipment = new MedicalEquipment();

	private List<MedicalEquipment> conflictingEquipments = new ArrayList<>();
	private List<ApplicantDisability> eligibleDisabilities = new ArrayList<>();
	private List<ApplicantDisability> ineligibleDisabilities = new ArrayList<>();

	public MedicalEquipmentProfile() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public MedicalEquipment getMedicalEquipment() {
		return medicalEquipment;
	}

	public void setMedicalEquipment(MedicalEquipment medicalEquipment) {
		this.medicalEquipment = medicalEquipment;
	}

	public List<MedicalEquipment> getConflictingEquipments() {
		return conflictingEquipments;
	}

	public void setConflictingEquipments(List<MedicalEquipment> conflictingEquipments) {
		this.conflictingEquipments = conflictingEquipments;
	}

	public int getRequiredAge() {
		return requiredAge;
	}

	public void setRequiredAge(int requiredAge) {
		this.requiredAge = requiredAge;
	}

	public EquipmentType getEquipmentType() {
		return equipmentType;
	}

	public void setEquipmentType(EquipmentType equipmentType) {
		this.equipmentType = equipmentType;
	}

	public EquipmentCategory getEquipmentCategory() {
		return equipmentCategory;
	}

	public void setEquipmentCategory(EquipmentCategory equipmentCategory) {
		this.equipmentCategory = equipmentCategory;
	}

	public List<ApplicantDisability> getEligibleDisabilities() {
		return eligibleDisabilities;
	}

	public void setEligibleDisabilities(List<ApplicantDisability> eligibleDisabilities) {
		this.eligibleDisabilities = eligibleDisabilities;
	}

	public List<ApplicantDisability> getIneligibleDisabilities() {
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

	public boolean isNotAvailableFromMilitarySectors() {
		return notAvailableFromMilitarySectors;
	}

	public void setNotAvailableFromMilitarySectors(boolean notAvailableFromMilitarySectors) {
		this.notAvailableFromMilitarySectors = notAvailableFromMilitarySectors;
	}

}