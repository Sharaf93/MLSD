package com.sumerge.mlsd.xom.common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * The status details of a person. Describing the status of the person and the
 * report for his status associated with the required dates.
 * 
 * @author Ahmed Sharaf
 *
 */
public class PersonalStatusDetails {

	/**
	 * The status details a person can have.
	 * 
	 * @author Ahmed Sharaf
	 *
	 */
	public enum StatusDetails {
		ADDICT, ABSENT, LOST, ABANDONEDORSUSPENDED, INCAPACITATED, HANDICAPPED, UNKNOWN, NONE
	}

	private int statusReportValidityInDays = 365;
	private Calendar statusDate = Calendar.getInstance();
	private StatusDetails statusDetails = StatusDetails.NONE;
	private Calendar statusReportDate = Calendar.getInstance();

	private List<SourceMapper> sourcesMap = new ArrayList<>();

	public PersonalStatusDetails() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public int getStatusReportValidityInDays() {
		return statusReportValidityInDays;
	}

	public void setStatusReportValidityInDays(int statusReportValidityInDays) {
		this.statusReportValidityInDays = statusReportValidityInDays;
	}

	public StatusDetails getStatusDetails() {
		return statusDetails;
	}

	public void setStatusDetails(StatusDetails statusDetails) {
		this.statusDetails = statusDetails;
	}

	public Calendar getStatusDate() {
		return statusDate;
	}

	public void setStatusDate(Calendar statusDate) {
		this.statusDate = statusDate;
	}

	public Calendar getStatusReportDate() {
		return statusReportDate;
	}

	public void setStatusReportDate(Calendar statusReportDate) {
		this.statusReportDate = statusReportDate;
	}

	public List<SourceMapper> getSourcesMap() {
		return sourcesMap;
	}

	public void setSourcesMap(List<SourceMapper> sourcesMap) {
		this.sourcesMap = sourcesMap;
	}

}
