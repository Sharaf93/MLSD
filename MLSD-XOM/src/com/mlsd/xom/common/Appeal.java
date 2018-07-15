package com.mlsd.xom.common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.mlsd.utilities.Utilities;
import com.ummalqura.calendar.UmmalquraCalendar;

/**
 * The Appeal object is the details of any appeal a person can submit.
 * 
 * @author Ahmed Sharaf
 *
 */
public class Appeal {

	/**
	 * The Appeal type associated with the appeal.
	 * 
	 * @author Ahmed Sharaf
	 *
	 */
	public enum AppealType {
		IMPRISONMENT, ALIVE, CITIZENSHIP, NONPERMANENCY, ASSOCIATION, MARITAL_STATUS, NONE
	}

	private boolean appealStatus = false;
	private AppealType appealType = AppealType.NONE;
	private List<SourceMapper> sourcesMap = new ArrayList<>();
	private Calendar appealExpirationDate = Calendar.getInstance();

	public Appeal() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public AppealType getAppealType() {
		if(appealType == null)
			appealType = AppealType.NONE;
		return appealType;
	}

	public void setAppealType(AppealType appealType) {
		this.appealType = appealType;
	}

	public Calendar getAppealExpirationDate() {
		return this.getAppealExpirationHijriDate();
	}

	public void setAppealExpirationDate(Calendar expirationDate) {
		this.setAppealExpirationHijriDate(expirationDate);
	}

	public Calendar getAppealExpirationHijriDate() {
		return Utilities.getHijriDateFromGregorianDate(appealExpirationDate);
	}

	public void setAppealExpirationHijriDate(Calendar appealExpirationDate) {
		Calendar cal = new UmmalquraCalendar();
		int year = appealExpirationDate.get(Calendar.YEAR);
		int month = appealExpirationDate.get(Calendar.MONTH);
		int day = appealExpirationDate.get(Calendar.DAY_OF_MONTH);

		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, day);

		this.appealExpirationDate.setTime(cal.getTime());
	}

	public List<SourceMapper> getSourcesMap() {
		return sourcesMap;
	}

	public void setSourcesMap(List<SourceMapper> sourcesMap) {
		this.sourcesMap = sourcesMap;
	}

	public boolean isAppealStatus() {
		return appealStatus;
	}

	public void setAppealStatus(boolean appealStatus) {
		this.appealStatus = appealStatus;
	}

}
