package com.sumerge.mlsd.xom.socialcare;

import java.util.Calendar;

/**
 * The medical equipment of the applicant. Indicating the medical equipment
 * itself and the recieval date of the equipment.
 * 
 * @author Ahmed Sharaf
 *
 */
public class ApplicantMedicalEquipment {

	private Calendar equipmentRecievalDate = Calendar.getInstance();

	private MedicalEquipmentProfile medicalEquipmentDetails = new MedicalEquipmentProfile();

	public ApplicantMedicalEquipment() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public MedicalEquipmentProfile getMedicalEquipmentDetails() {
		return medicalEquipmentDetails;
	}

	public void setMedicalEquipmentDetails(MedicalEquipmentProfile medicalEquipmentDetails) {
		this.medicalEquipmentDetails = medicalEquipmentDetails;
	}

	public Calendar getEquipmentRecievalDate() {
		return equipmentRecievalDate;
	}

	public void setEquipmentRecievalDate(Calendar equipmentRecievalDate) {
		this.equipmentRecievalDate = equipmentRecievalDate;
	}

}
