package com.mlsd.xom.common;

/**
 * The source mapper object is used to define the used data source of each
 * attribute in all the classes.
 * 
 * @author Ahmed Sharaf
 *
 */
public class SourceMapper {

	private String attributeName = "";
	private String usedDataSource = "";

	public SourceMapper() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public String getAttributeName() {
		if(attributeName == null)
			attributeName = "";
		return attributeName;
	}

	public void setAttributeName(String attributeName) {
		this.attributeName = attributeName;
	}

	public String getUsedDataSource() {
		if(usedDataSource == null)
			usedDataSource = "";
		return usedDataSource;
	}

	public void setUsedDataSource(String usedDataSource) {
		this.usedDataSource = usedDataSource;
	}

}
