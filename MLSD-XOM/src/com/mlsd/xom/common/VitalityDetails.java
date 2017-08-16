package com.mlsd.xom.common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * This object indicates the vitality status of a person. Whether he is alive or
 * deceased and the date of birth.
 * 
 * @author Ahmed Sharaf
 *
 */
public class VitalityDetails {

	private boolean isDeceased = false;
	private Calendar dateOfBirth = Calendar.getInstance();
	private Calendar deceasedDate = Calendar.getInstance();
	private List<SourceMapper> sourcesMap = new ArrayList<>();

	public VitalityDetails() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public boolean isDeceased() {
		return isDeceased;
	}

	public void setDeceased(boolean isDeceased) {
		this.isDeceased = isDeceased;
	}

	public Calendar getDeceasedDate() {
		return deceasedDate;
	}

	public void setDeceasedDate(Calendar deceasedDate) {
		this.deceasedDate = deceasedDate;
	}

	public Calendar getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Calendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public List<SourceMapper> getSourcesMap() {
		return sourcesMap;
	}

	public void setSourcesMap(List<SourceMapper> sourcesMap) {
		this.sourcesMap = sourcesMap;
	}

}
