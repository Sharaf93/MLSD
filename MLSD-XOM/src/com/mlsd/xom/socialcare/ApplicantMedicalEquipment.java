package com.mlsd.xom.socialcare;

import java.util.Calendar;
import java.util.logging.Logger;

import com.mlsd.utilities.Utilities;
import com.ummalqura.calendar.UmmalquraCalendar;

/**
 * The medical equipment of the applicant. Indicating the medical equipment
 * itself and the receival date of the equipment.
 * 
 * @author Ahmed Sharafeldin
 *
 */
public class ApplicantMedicalEquipment {

	private String equipmentReceivalDate = "";
	private MedicalEquipmentProfile medicalEquipmentDetails = new MedicalEquipmentProfile();

	/* Logging constants used inside this class. */
	public static final String ApplicantMedicalClassName = ApplicantMedicalEquipment.class.getName();
	public static final Logger logger = Logger.getLogger(ApplicantMedicalClassName);

	public ApplicantMedicalEquipment() {
		// Empty Constructor for NULL Avoidance
	}

	public MedicalEquipmentProfile getMedicalEquipmentDetails() {
		if (medicalEquipmentDetails == null)
			medicalEquipmentDetails = new MedicalEquipmentProfile();
		return medicalEquipmentDetails;
	}

	public void setMedicalEquipmentDetails(MedicalEquipmentProfile medicalEquipmentDetails) {
		this.medicalEquipmentDetails = medicalEquipmentDetails;
	}

	public String getEquipmentReceivalDate() {
		if (equipmentReceivalDate == null)
			equipmentReceivalDate = "";
		return equipmentReceivalDate;
	}

	public void setEquipmentReceivalDate(String equipmentReceivalDate) {
		this.equipmentReceivalDate = equipmentReceivalDate;
	}

	/**
	 * Checks the receival date (Hijri) of the medical equipment does not exceed
	 * the limit number in month
	 * 
	 * @param month
	 *            : the number of valid month to compare with
	 * @return whether it exceeds the limit or not
	 */
	public boolean equipmentReceivalDateExceeds(int months) {
		String sourceMethod = "equipmentReceivalDateExceeds";
		logger.entering(ApplicantMedicalClassName, sourceMethod);
		Calendar hijriToday = Utilities.getTodaysHigriDate();
		Calendar equipmentHijri;

		String receivalDate = this.getEquipmentReceivalDate();
		if (receivalDate != null && receivalDate != "" && receivalDate.length() == 8) {
			int year = Integer.parseInt(receivalDate.substring(0, 4));
			int month = Integer.parseInt(receivalDate.substring(4, 6));
			month--;
			int day = Integer.parseInt(receivalDate.substring(6, 8));
			equipmentHijri = new UmmalquraCalendar();
			equipmentHijri.set(UmmalquraCalendar.YEAR, year);
			equipmentHijri.set(UmmalquraCalendar.MONTH, month);
			equipmentHijri.set(UmmalquraCalendar.DAY_OF_MONTH, day);
		} else {
			equipmentHijri = Utilities.getTodaysHigriDate();
		}

		double daysToCompare = months * 29.54;
		double daysDifference = Utilities.getNumberOfDaysBetweenTwoHijriDates(equipmentHijri, hijriToday);

		if (daysDifference > daysToCompare) {
			logger.exiting(ApplicantMedicalClassName, sourceMethod, true);
			return true; // exceeds the number of month
		} else {
			logger.exiting(ApplicantMedicalClassName, sourceMethod, false);
			return false;
		}
	}

	/**
	 * Checks if an equipment is expired.
	 * 
	 * @return whether it is expired
	 */
	public boolean equipmentIsExpired() {
		String sourceMethod = "equipmentReceivalDateExceeds";
		logger.entering(ApplicantMedicalClassName, sourceMethod);
		if (equipmentReceivalDateExceeds(this.getMedicalEquipmentDetails().getEquipmentValidityInMonth())) {
			logger.exiting(ApplicantMedicalClassName, sourceMethod, true);
			return true;
		}
		logger.exiting(ApplicantMedicalClassName, sourceMethod, false);
		return false;
	}

}
