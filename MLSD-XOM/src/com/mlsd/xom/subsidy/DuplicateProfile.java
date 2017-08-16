package com.mlsd.xom.subsidy;

import java.util.Calendar;

public class DuplicateProfile {

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

	}

	public String getRecordIdentifier() {
		return recordIdentifier;
	}

	public void setRecordIdentifier(String recordIdentifier) {
		this.recordIdentifier = recordIdentifier;
	}

	public ApplicantType getApplicantType() {
		return applicantType;
	}

	public void setApplicantType(ApplicantType applicantType) {
		this.applicantType = applicantType;
	}

	public Calendar getRegistrationDate() {
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
