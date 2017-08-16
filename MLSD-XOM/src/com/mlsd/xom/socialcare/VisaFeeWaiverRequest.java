package com.mlsd.xom.socialcare;

import java.util.ArrayList;
import java.util.List;

import com.mlsd.xom.socialcare.HandicappedApplicant.VisaFeeWaiverWorkType;

public class VisaFeeWaiverRequest {

	private List<VisaFeeWaiverWorkType> requestedVisaFeeWaiver = new ArrayList<>();

	public VisaFeeWaiverRequest() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public List<VisaFeeWaiverWorkType> getRequestedVisaFeeWaiver() {
		return requestedVisaFeeWaiver;
	}

	public void setRequestedVisaFeeWaiver(List<VisaFeeWaiverWorkType> requestedVisaFeeWaiver) {
		this.requestedVisaFeeWaiver = requestedVisaFeeWaiver;
	}

}
