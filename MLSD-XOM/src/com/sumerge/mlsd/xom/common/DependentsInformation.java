package com.sumerge.mlsd.xom.common;

import java.util.ArrayList;
import java.util.List;

/**
 * This object is used for the output parameters in a decision operation. It is
 * used to show the dependents as a list in the output parameter.
 * 
 * @author Ahmed Sharaf
 *
 */
public class DependentsInformation {
	List<Person> dependentsList = new ArrayList<>();

	public DependentsInformation() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public List<Person> getDependentsList() {
		if (this.dependentsList == null) {
			this.dependentsList = new ArrayList<>();
		}
		return this.dependentsList;
	}

	public void setDependentsList(List<Person> dependentsList) {
		this.dependentsList = dependentsList;
	}

}
