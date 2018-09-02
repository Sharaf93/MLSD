package com.mlsd.xom.socialcare;

import java.util.ArrayList;
import java.util.List;

import com.mlsd.xom.socialcare.HandicappedApplicant.VisaFeeWaiverWorkType;

/**
 * This object is used for the input parameters in a decision operation. It is
 * used to show the Visa Fee Waivers as a list in the input parameter.
 * 
 * @author Ahmed Sharafeldin
 *
 */
public class VisaFeeWaiverRequest {

	private List<VisaFeeWaiverWorkType> requestedVisaFeeWaiver = new ArrayList<>();

	public VisaFeeWaiverRequest() {
		// Empty Constructor for NULL Avoidance
	}

	public List<VisaFeeWaiverWorkType> getRequestedVisaFeeWaiver() {
		if (requestedVisaFeeWaiver == null)
			requestedVisaFeeWaiver = new ArrayList<>();
		return requestedVisaFeeWaiver;
	}

	public void setRequestedVisaFeeWaiver(List<VisaFeeWaiverWorkType> requestedVisaFeeWaiver) {
		this.requestedVisaFeeWaiver = requestedVisaFeeWaiver;
	}

}
