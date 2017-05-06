package com.sumerge.mlsd.xom.common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
/**
 * The home workers details.
 * @author Ahmed Sharaf
 *
 */
public class HomeWorkerDetails {

	public enum WorkType {
		NURSE, DRIVER, MAID, GARDNER, UNKNOWN
	}

	private String workerName = "";
	private WorkType workerType = WorkType.UNKNOWN;
	private Calendar hireDate = Calendar.getInstance();
	private List<SourceMapper> sourcesMap = new ArrayList<>();

	public HomeWorkerDetails() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public WorkType getTypeOfWork() {
		return workerType;
	}

	public void setTypeOfWork(WorkType typeOfWork) {
		this.workerType = typeOfWork;
	}

	public Calendar getDateOfHiring() {
		return hireDate;
	}

	public void setDateOfHiring(Calendar dateOfHiring) {
		this.hireDate = dateOfHiring;
	}

	public List<SourceMapper> getSourcesMap() {
		return sourcesMap;
	}

	public void setSourcesMap(List<SourceMapper> sourcesMap) {
		this.sourcesMap = sourcesMap;
	}

	public String getWorkerName() {
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

}
