package com.mlsd.xom.common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * The home workers details and description.
 * 
 * @author Ahmed Sharafeldin
 *
 */
public class HomeWorkerDetails {

	/**
	 * the type of the worker
	 * 
	 * @author Ahmed Sharafeldin
	 *
	 */
	public enum WorkType {
		NURSE, DRIVER, MAID, GARDNER, UNKNOWN
	}

	private String workerName = "";
	private WorkType workerType = WorkType.UNKNOWN;
	private Calendar hireDate = Calendar.getInstance();
	private List<SourceMapper> sourcesMap = new ArrayList<>();

	public HomeWorkerDetails() {
		// Empty Constructor for NULL Avoidance
	}

	public WorkType getTypeOfWork() {
		if (workerType == null)
			workerType = WorkType.UNKNOWN;
		return workerType;
	}

	public void setTypeOfWork(WorkType typeOfWork) {
		this.workerType = typeOfWork;
	}

	public Calendar getDateOfHiring() {
		if (hireDate == null)
			hireDate = Calendar.getInstance();
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
		if (workerName == null)
			workerName = "";
		return workerName;
	}

	public void setWorkerName(String workerName) {
		this.workerName = workerName;
	}

}
