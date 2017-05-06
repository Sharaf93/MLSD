package com.sumerge.mlsd.xom.common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * The information about the residency outside KSA and the reason behind that.
 * 
 * @author Ahmed Sharaf.
 *
 */
public class ResidencyDetailsOutsideKSA {

	private int noOfDaysOutsideKSA = 0;
	private String reasonForTemporaryResidency = "";
	private Calendar residencyPermenancyApprovalDate = Calendar.getInstance();

	private List<SourceMapper> sourcesMap = new ArrayList<>();

	public ResidencyDetailsOutsideKSA() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public Calendar getReasonValidityDate() {
		return residencyPermenancyApprovalDate;
	}

	public void setReasonValidityDate(Calendar reasonValidityDate) {
		this.residencyPermenancyApprovalDate = reasonValidityDate;
	}

	public String getReasonForTemporaryResidency() {
		return reasonForTemporaryResidency;
	}

	public void setReasonForTemporaryResidency(String reasonForTemporaryResidency) {
		this.reasonForTemporaryResidency = reasonForTemporaryResidency;
	}

	public List<SourceMapper> getSourcesMap() {
		return sourcesMap;
	}

	public void setSourcesMap(List<SourceMapper> sourcesMap) {
		this.sourcesMap = sourcesMap;
	}

	public boolean theReasonValidityDateForTheApprovalDidNotExceedOneYear() {
		return false;
	}

	public int getNoOfDaysOutsideKSA() {
		return noOfDaysOutsideKSA;
	}

	public void setNoOfDaysOutsideKSA(int noOfDaysOutsideKSA) {
		this.noOfDaysOutsideKSA = noOfDaysOutsideKSA;
	}

}
