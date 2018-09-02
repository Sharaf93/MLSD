package com.mlsd.xom.socialsecurity;

/**
 * This object is used for the output parameters in a decision operation. It is
 * used to show the AdHoc support recurrence enum in the output parameter.
 * 
 * @author Ahmed Sharafeldin
 *
 */
public class AdHocSupportRecurrenceOutput {

	/**
	 * The available AdHoc support recurrence
	 * 
	 * @author Ahmed Sharafeldin
	 *
	 */
	public enum AdHocSupportRecurrence {
		ANNUAL, BI_ANNUAL, NONE
	}

	private AdHocSupportRecurrence adHocSupportRecurrence = AdHocSupportRecurrence.NONE;

	public AdHocSupportRecurrenceOutput() {
		// Empty constructor for NULL avoidance
	}

	public AdHocSupportRecurrence getAdHocSupportRecurrence() {
		if (adHocSupportRecurrence == null)
			adHocSupportRecurrence = AdHocSupportRecurrence.NONE;
		return adHocSupportRecurrence;
	}

	public void setAdHocSupportRecurrence(AdHocSupportRecurrence adHocSupportRecurrence) {
		this.adHocSupportRecurrence = adHocSupportRecurrence;
	}

}
