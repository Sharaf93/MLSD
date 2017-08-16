package com.mlsd.xom.common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * The imprisonment details having the information if the person is imprisoned
 * and the dates associated with his imprisonment.
 * 
 * @author Ahmed Sharaf
 *
 */
public class ImprisonmentDetails {

	/**
	 * The crime type associated with the imprisonment.
	 * 
	 * @author Ahmed Sharaf
	 *
	 */
	public enum CrimeType {
		FELONY, MISDEMEANOR, OTHER
	}

	private boolean imprisoned = false;
	private int sentenceDurationInDays = 0;
	private CrimeType crimeType = CrimeType.OTHER;
	private Calendar releaseDate = Calendar.getInstance();
	private Calendar imprisonmentDate = Calendar.getInstance();
	private Calendar imprisonmentReportDate = Calendar.getInstance();

	private List<SourceMapper> sourcesMap = new ArrayList<>();

	public ImprisonmentDetails() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public boolean isimprisoned() {
		return imprisoned;
	}

	public boolean isNotImprisoned() {
		return !imprisoned;
	}

	public void setimprisoned(boolean isImprisoned) {
		this.imprisoned = isImprisoned;
	}

	public Calendar getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Calendar releaseDate) {
		this.releaseDate = releaseDate;
	}

	public int getSentenceDurationInDays() {
		return sentenceDurationInDays;
	}

	public void setSentenceDurationInDays(int sentenceDurationInDays) {
		this.sentenceDurationInDays = sentenceDurationInDays;
	}

	public CrimeType getCrimeType() {
		return crimeType;
	}

	public void setCrimeType(CrimeType crimeType) {
		this.crimeType = crimeType;
	}

	public List<SourceMapper> getSourcesMap() {
		return sourcesMap;
	}

	public void setSourcesMap(List<SourceMapper> sourcesMap) {
		this.sourcesMap = sourcesMap;
	}

	public Calendar getImprisonmentDate() {
		return imprisonmentDate;
	}

	public void setImprisonmentDate(Calendar imprisonmentDate) {
		this.imprisonmentDate = imprisonmentDate;
	}

	public Calendar getImprisonmentReportDate() {
		return imprisonmentReportDate;
	}

	public void setImprisonmentReportDate(Calendar imprisonmentReportDate) {
		this.imprisonmentReportDate = imprisonmentReportDate;
	}

}
