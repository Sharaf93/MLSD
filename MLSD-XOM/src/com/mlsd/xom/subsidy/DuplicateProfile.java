package com.mlsd.xom.subsidy;

import java.util.Calendar;

/**
 * This object gathers the information needed for a duplicate profile in the
 * Subsidy program
 * 
 * @author Ahmed Sharafeldin
 *
 */
public class DuplicateProfile {

	/**
	 * The applicant types
	 * 
	 * @author Ahmed Sharafeldin
	 *
	 */
	public enum ApplicantType {
		HOH, DEPENDENT
	}

	private String recordIdentifier = "";
	private ApplicantType applicantType = ApplicantType.HOH;
	private Calendar registrationDate = Calendar.getInstance();

	private boolean CRMFlag = false;
	private boolean MLSDFlag = false;
	private boolean NICFlag = false;

	public DuplicateProfile() {
		// Empty Constructor For NULL Avoidance
	}

	public String getRecordIdentifier() {
		if (recordIdentifier == null)
			recordIdentifier = "";
		return recordIdentifier;
	}

	public void setRecordIdentifier(String recordIdentifier) {
		this.recordIdentifier = recordIdentifier;
	}

	public ApplicantType getApplicantType() {
		if (applicantType == null)
			applicantType = ApplicantType.HOH;
		return applicantType;
	}

	public void setApplicantType(ApplicantType applicantType) {
		this.applicantType = applicantType;
	}

	public Calendar getRegistrationDate() {
		if (registrationDate == null)
			registrationDate = Calendar.getInstance();
		return registrationDate;
	}

	public void setRegistrationDate(Calendar registrationDate) {
		this.registrationDate = registrationDate;
	}

	public boolean isCRMFlag() {
		return CRMFlag;
	}

	public void setCRMFlag(boolean cRMFlag) {
		CRMFlag = cRMFlag;
	}

	public boolean isMLSDFlag() {
		return MLSDFlag;
	}

	public void setMLSDFlag(boolean mLSDFlag) {
		MLSDFlag = mLSDFlag;
	}

	public boolean isNICFlag() {
		return NICFlag;
	}

	public void setNICFlag(boolean nICFlag) {
		NICFlag = nICFlag;
	}

}
