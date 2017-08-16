package com.mlsd.xom.socialcare;

import java.util.Calendar;
import java.util.logging.Logger;

import com.mlsd.utilities.Utilities;
import com.mlsd.xom.common.Person;

/**
 * The medical equipment of the applicant. Indicating the medical equipment
 * itself and the recieval date of the equipment.
 * 
 * @author Ahmed Sharaf
 *
 */
public class ApplicantMedicalEquipment {

	private Calendar equipmentReceivalDate = Calendar.getInstance();
	private MedicalEquipmentProfile medicalEquipmentDetails = new MedicalEquipmentProfile();

	/* Logging constants used inside this class. */
	public static final String personClassName = Person.class.getName();
	public static final Logger logger = Logger.getLogger(personClassName);

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

	public Calendar getEquipmentReceivalDate() {
		return equipmentReceivalDate;
	}

	public void setEquipmentReceivalDate(Calendar equipmentReceivalDate) {
		this.equipmentReceivalDate = equipmentReceivalDate;
	}

	/**
	 * Checks the receival date of the medical equipment does not exceed the
	 * limit number in month
	 * 
	 * @param month
	 *            : the number of valid month to compare with
	 * @return whether it exceeds the limit or not
	 */
	public boolean equipmentReceivalDateExceeds(int month) {
		String sourceMethod = "equipmentReceivalDateExceeds";
		logger.entering(personClassName, sourceMethod);
		Calendar todaysDate = Calendar.getInstance();
		Calendar receivalDate = this.getEquipmentReceivalDate();
		int monthsDifference = Utilities.getMonthsDifference(receivalDate, todaysDate);
		if (monthsDifference > month) {
			logger.exiting(personClassName, sourceMethod, true);
			return true; // exceeds the number of month
		} else {
			logger.exiting(personClassName, sourceMethod, false);
			return false;
		}
	}

	public boolean equipmentIsExpired() {
		if (equipmentReceivalDateExceeds(this.getMedicalEquipmentDetails().getEquipmentValidityInMonth())) {
			return true;
		}
		return false;
	}

}
