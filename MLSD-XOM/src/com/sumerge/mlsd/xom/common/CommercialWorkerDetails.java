package com.sumerge.mlsd.xom.common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * The commercial worker details.
 * 
 * @author Ahmed Sharaf
 *
 */
public class CommercialWorkerDetails {

	private String workType = "";
	private String workerName = "";
	private Calendar hireDate = Calendar.getInstance();
	private List<SourceMapper> sourcesMap = new ArrayList<>();

	public CommercialWorkerDetails() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public String getWorkType() {
		return workType;
	}

	public void setWorkType(String workType) {
		this.workType = workType;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

	public Calendar getHireDate() {
		return hireDate;
	}

	public void setHireDate(Calendar hiringDate) {
		this.hireDate = hiringDate;
	}

	public List<SourceMapper> getSourcesMap() {
		return sourcesMap;
	}

	public void setSourcesMap(List<SourceMapper> sourcesMap) {
		this.sourcesMap = sourcesMap;
	}

}
