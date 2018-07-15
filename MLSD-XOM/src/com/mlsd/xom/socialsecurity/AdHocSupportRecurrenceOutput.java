package com.mlsd.xom.socialsecurity;

public class AdHocSupportRecurrenceOutput {

	public enum AdHocSupportRecurrence {
		ANNUAL, BI_ANNUAL, NONE
	}

	private AdHocSupportRecurrence adHocSupportRecurrence = AdHocSupportRecurrence.NONE;

	public AdHocSupportRecurrenceOutput() {
	}

	public AdHocSupportRecurrence getAdHocSupportRecurrence() {
		if(adHocSupportRecurrence == null)
			adHocSupportRecurrence = AdHocSupportRecurrence.NONE;
		return adHocSupportRecurrence;
	}

	public void setAdHocSupportRecurrence(AdHocSupportRecurrence adHocSupportRecurrence) {
		this.adHocSupportRecurrence = adHocSupportRecurrence;
	}

}
