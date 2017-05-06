
package com.sumerge.mlsd.xom.common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.sumerge.mlsd.utilities.Utilities;
import com.sumerge.ummalqura.calendar.UmmalquraCalendar;

/**
 * The Appeal object is the details of any appeal a person can submit.
 * @author Ahmed Sharaf
 *
 */
public class Appeal {
	
	/**
	 * The Appeal type associated with the appeal.
	 * @author Ahmed Sharaf
	 *
	 */
	public enum AppealType {
		IMPRISONMENT, ALIVE, CITIZENSHIP, NONPERMANENCY, NONE
	}

	private boolean appealValidity = false;
	private AppealType appealType = AppealType.NONE;
	private List<SourceMapper> sourcesMap = new ArrayList<>();
	private Calendar appealExpirationDate = Calendar.getInstance();

	public Appeal() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public Appeal(AppealType appealType, Calendar appealExpirationDate, boolean appealValidity) {
		super();
		this.appealType = appealType;
		this.appealExpirationDate = appealExpirationDate;
		this.appealValidity = appealValidity;
	}

	public AppealType getAppealType() {
		return appealType;
	}

	public void setAppealType(AppealType appealType) {
		this.appealType = appealType;
	}

	public Calendar getAppealExpirationDate() {
		return Utilities.getHijriDateFromGregorianDate(appealExpirationDate);
	}

	public void setAppealExpirationDate(Calendar appealExpirationDate) {
		Calendar cal = new UmmalquraCalendar();
		int year = appealExpirationDate.get(Calendar.YEAR);
		int month = appealExpirationDate.get(Calendar.MONTH);
		int day = appealExpirationDate.get(Calendar.DAY_OF_MONTH);

		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		cal.set(Calendar.DAY_OF_MONTH, day);

		this.appealExpirationDate.setTime(cal.getTime());
	}

	public boolean isAppealValidity() {
		return appealValidity;
	}

	public void setAppealValidity(boolean appealValidity) {
		this.appealValidity = appealValidity;
	}

	public List<SourceMapper> getSourcesMap() {
		return sourcesMap;
	}

	public void setSourcesMap(List<SourceMapper> sourcesMap) {
		this.sourcesMap = sourcesMap;
	}

}
