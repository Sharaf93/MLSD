package com.mlsd.xom.common;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * The medical condition of the person. Indicating details of the personal
 * medical state.
 * 
 * @author Ahmed Sharafeldin
 *
 */
public class MedicalCondition {

	private String illnessName = "";
	private int medicationPeriod = 0;
	private boolean terminalIllness = false;
	private boolean temporaryIllness = false;
	private boolean permenantDisability = false;
	private boolean temporaryDisability = false;
	private Calendar medicalReportDate = Calendar.getInstance();
	private List<SourceMapper> sourcesMap = new ArrayList<>();

	public MedicalCondition() {
		// Empty Constructor for NULL Avoidance
	}

	public String getillnessName() {
		if (illnessName == null)
			illnessName = "";
		return illnessName;
	}

	public void setillnessName(String typeOfIllness) {
		this.illnessName = typeOfIllness;
	}

	public boolean isTerminallyIll() {
		return terminalIllness;
	}

	public boolean isNotTerminallyIll() {
		boolean terminally = this.isTerminallyIll();
		return !terminally;
	}

	public void setTerminallyIll(boolean terminallyIll) {
		this.terminalIllness = terminallyIll;
	}

	public boolean isPermenantDisability() {
		return permenantDisability;
	}

	public boolean isNotPermenantDisability() {
		boolean permanant = this.isPermenantDisability();
		return !permanant;
	}

	public void setPermenantDisability(boolean disabledPermenantly) {
		this.permenantDisability = disabledPermenantly;
	}

	public boolean istemporaryDisability() {
		return temporaryDisability;
	}

	public void settemporaryDisability(boolean disabledTemporarily) {
		this.temporaryDisability = disabledTemporarily;
	}

	public Calendar getMedicalReportDate() {
		if (medicalReportDate == null)
			medicalReportDate = Calendar.getInstance();
		return medicalReportDate;
	}

	public void setMedicalReportDate(Calendar medicalReportDate) {
		this.medicalReportDate = medicalReportDate;
	}

	public int getMedicationPeriod() {
		return medicationPeriod;
	}

	public void setMedicationPeriod(int recoveryTimeInDays) {
		this.medicationPeriod = recoveryTimeInDays;
	}

	public List<SourceMapper> getSourcesMap() {
		if (sourcesMap == null)
			sourcesMap = new ArrayList<>();
		return sourcesMap;
	}

	public void setSourcesMap(List<SourceMapper> sourcesMap) {
		this.sourcesMap = sourcesMap;
	}

	public boolean isTemporaryIllness() {
		return temporaryIllness;
	}

	public void setTemporaryIllness(boolean temporaryIllness) {
		this.temporaryIllness = temporaryIllness;
	}

}
