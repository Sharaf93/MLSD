package com.mlsd.xom.socialcare;

import java.util.Calendar;
import java.util.logging.Logger;

import com.mlsd.utilities.Utilities;
import com.ummalqura.calendar.UmmalquraCalendar;

/**
 * The medical equipment of the applicant. Indicating the medical equipment
 * itself and the recieval date of the equipment.
 * 
 * @author Ahmed Sharaf
 *
 */
public class ApplicantMedicalEquipment {

	// private Calendar equipmentReceivalDate = Calendar.getInstance();
	private String equipmentReceivalDate = "";
	private MedicalEquipmentProfile medicalEquipmentDetails = new MedicalEquipmentProfile();

	/* Logging constants used inside this class. */
	public static final String ApplicantMedicalClassName = ApplicantMedicalEquipment.class.getName();
	public static final Logger logger = Logger.getLogger(ApplicantMedicalClassName);

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

	// public Calendar getEquipmentReceivalDate() {
	// return equipmentReceivalDate;
	// }
	//
	// public void setEquipmentReceivalDate(Calendar equipmentReceivalDate) {
	// this.equipmentReceivalDate = equipmentReceivalDate;
	// }

	public String getEquipmentReceivalDate() {
		return equipmentReceivalDate;
	}

	public void setEquipmentReceivalDate(String equipmentReceivalDate) {
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
	// public boolean equipmentReceivalDateExceeds(int month) {
	// String sourceMethod = "equipmentReceivalDateExceeds";
	// logger.entering(ApplicantMedicalClassName, sourceMethod);
	// Calendar todaysDate = Calendar.getInstance();
	// Calendar receivalDate = this.getEquipmentReceivalDate();
	// int monthsDifference = Utilities.getMonthsDifference(receivalDate,
	// todaysDate);
	// if (monthsDifference > month) {
	// logger.exiting(ApplicantMedicalClassName, sourceMethod, true);
	// return true; // exceeds the number of month
	// } else {
	// logger.exiting(ApplicantMedicalClassName, sourceMethod, false);
	// return false;
	// }
	// }

	public boolean equipmentReceivalDateExceeds(int months) {
		Calendar hijriToday = Utilities.getTodaysHigriDate();

		String receivalDate = this.getEquipmentReceivalDate();
		int year = Integer.parseInt(receivalDate.substring(0, 4));
		int month = Integer.parseInt(receivalDate.substring(4, 6));
		month--;
		int day = Integer.parseInt(receivalDate.substring(6, 8));
		Calendar equipmentHijri = new UmmalquraCalendar();
		equipmentHijri.set(UmmalquraCalendar.YEAR, year);
		equipmentHijri.set(UmmalquraCalendar.MONTH, month);
		equipmentHijri.set(UmmalquraCalendar.DAY_OF_MONTH, day);

		double daysToCompare = months * 29.54;
		double daysDifference = Utilities.getNumberOfDaysBetweenTwoHijriDates(equipmentHijri, hijriToday);

		if (daysDifference > daysToCompare) {
			return true; // exceeds the number of month
		} else {
			return false;
		}
	}

	public boolean equipmentIsExpired() {
		if (equipmentReceivalDateExceeds(this.getMedicalEquipmentDetails().getEquipmentValidityInMonth()))
			return true;
		return false;
	}

	// public static void main(String[] args){
	// String hijriString = "14390825";
	// int year = Integer.parseInt(hijriString.substring(0, 4));
	// int month = Integer.parseInt(hijriString.substring(4,6));
	// month--;
	// int day = Integer.parseInt(hijriString.substring(6, 8));
	//
	// Calendar hijri2 = new UmmalquraCalendar();
	// hijri2.set(UmmalquraCalendar.YEAR, year);
	// hijri2.set(UmmalquraCalendar.MONTH, month);
	// hijri2.set(UmmalquraCalendar.DAY_OF_MONTH, day);
	// System.out.println(hijri2.get(UmmalquraCalendar.YEAR) + " " +
	// hijri2.get(UmmalquraCalendar.MONTH)+ " "
	// +hijri2.get(UmmalquraCalendar.DAY_OF_MONTH));
	//
	// Calendar hij = Utilities.getTodaysHigriDate();
	// System.out.println(hij.get(UmmalquraCalendar.YEAR) + " " +
	// hij.get(UmmalquraCalendar.MONTH)+ " "
	// +hij.get(UmmalquraCalendar.DAY_OF_MONTH));
	//
	// int diff = Utilities.getNumberOfDaysBetweenTwoHijriDates(hijri2, hij);
	// System.out.println(diff);
	//
	// }

}
