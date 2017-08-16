package com.mlsd.xom.common;

import java.util.ArrayList;
import java.util.List;

/**
 * The Education details of the person. Indicating the level of education and
 * the state of the person in the education field.
 * 
 * @author Ahmed Sharaf
 *
 */
public class EducationDetails {

	/**
	 * The educational level.
	 * 
	 * @author Ahmed Sharaf
	 *
	 */
	public enum EducationLevel {
		KINDERGARDEN, PRIMARY, SECONDARY, HIGHSCHOOL, COLLEGE, OTHER
	}

	private boolean scholar = false;
	private boolean isStudent = true;
	private EducationLevel educationalLevel = EducationLevel.OTHER;
	private boolean receivedGraduationCertificate = false;

	private List<SourceMapper> sourcesMap = new ArrayList<>();

	public EducationDetails() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public EducationLevel getEducationalLevel() {
		return educationalLevel;
	}

	public void setEducationalLevel(EducationLevel educationalLevel) {
		this.educationalLevel = educationalLevel;
	}

	public boolean isStudent() {
		return isStudent;
	}

	public void setStudent(boolean isStudent) {
		this.isStudent = isStudent;
	}

	public List<SourceMapper> getSourcesMap() {
		return sourcesMap;
	}

	public void setSourcesMap(List<SourceMapper> sourcesMap) {
		this.sourcesMap = sourcesMap;
	}

	public boolean isScholar() {
		return scholar;
	}

	public void setScholar(boolean scholar) {
		this.scholar = scholar;
	}

	public boolean isReceivedGraduationCertificate() {
		return receivedGraduationCertificate;
	}

	public void setReceivedGraduationCertificate(boolean receivedGraduationCertificate) {
		this.receivedGraduationCertificate = receivedGraduationCertificate;
	}

}
