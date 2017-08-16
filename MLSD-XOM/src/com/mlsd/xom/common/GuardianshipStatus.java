package com.mlsd.xom.common;

import java.util.ArrayList;
import java.util.List;

/**
 * This object states the guardianship status for the person.
 * 
 * @author Youssef Hatem
 *
 */
public class GuardianshipStatus {

	/**
	 * The Relationship of the guardian.
	 * 
	 * @author Youssef Hatem
	 *
	 */
	public enum Relationship {
		COUSIN, GRANDFATHER, FATHER, MOTHER, UNCLE, NONE
	}

	String guardianNIN = "";
	boolean underCustody = false;
	Relationship guardianRelationship = Relationship.NONE;
	private List<SourceMapper> sourcesMap = new ArrayList<>();

	public GuardianshipStatus() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	/**
	 * 
	 * @param underCustody
	 * @param guardianSSN
	 * @param guardianRelationship
	 */
	public GuardianshipStatus(boolean underCustody, String guardianSSN, Relationship guardianRelationship) {
		super();
		this.guardianNIN = guardianSSN;
		this.underCustody = underCustody;
		this.guardianRelationship = guardianRelationship;
	}

	public boolean isUnderCustody() {
		return underCustody;
	}

	public void setUnderCustody(boolean underCustody) {
		this.underCustody = underCustody;
	}

	public String getGuardianNIN() {
		return guardianNIN;
	}

	public void setGuardianNIN(String guardianSSN) {
		this.guardianNIN = guardianSSN;
	}

	public Relationship getGuardianRelationship() {
		return guardianRelationship;
	}

	public void setGuardianRelationship(Relationship guardianRelationship) {
		this.guardianRelationship = guardianRelationship;
	}

	public List<SourceMapper> getSourcesMap() {
		return sourcesMap;
	}

	public void setSourcesMap(List<SourceMapper> sourcesMap) {
		this.sourcesMap = sourcesMap;
	}

}
