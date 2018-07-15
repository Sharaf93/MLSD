package com.mlsd.xom.common;

import java.util.ArrayList;
import java.util.List;

/**
 * The details of the income of the person. the source, type and amount of that
 * income.
 * 
 * @author Ahmed Sharaf
 *
 */
public class IncomeDetails {

	/**
	 * The source of the income.
	 * 
	 * @author Ahmed Sharaf
	 *
	 */
	public enum IncomeSource {
		GOSI, RASD, PPA, SANED, OTHER
	}

	/**
	 * The type of the income.
	 * 
	 * @author Ahmed Sharaf
	 *
	 */
	public enum IncomeType {
		SALARY, PENSION, PRIVATEBUSINESS, OTHER
	}

	private Double incomeAmount = 0.0;
	private IncomeType incomeType = IncomeType.OTHER;
	private IncomeSource incomeSource = IncomeSource.OTHER;
	private List<SourceMapper> sourcesMap = new ArrayList<>();

	public IncomeDetails() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public Double getIncomeAmount() {
		if(incomeAmount == null)
			incomeAmount = 0.0;
		return incomeAmount;
	}

	public void setIncomeAmount(Double incomeAmount) {
		this.incomeAmount = incomeAmount;
	}

	public IncomeSource getIncomeSource() {
		if(incomeSource == null)
			incomeSource = IncomeSource.OTHER;
		return incomeSource;
	}

	public void setIncomeSource(IncomeSource incomeSource) {
		this.incomeSource = incomeSource;
	}

	public IncomeType getIncomeType() {
		if(incomeType == null)
			incomeType = IncomeType.OTHER;
		return incomeType;
	}

	public void setIncomeType(IncomeType incomeType) {
		this.incomeType = incomeType;
	}

	public List<SourceMapper> getSourcesMap() {
		return sourcesMap;
	}

	public void setSourcesMap(List<SourceMapper> sourcesMap) {
		this.sourcesMap = sourcesMap;
	}

}
