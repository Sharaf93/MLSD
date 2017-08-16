package com.mlsd.xom.common;

import java.util.ArrayList;
import java.util.List;

/**
 * The Asset details is the description of the asset a person can have.
 * 
 * @author Ahmed Sharaf
 *
 */
public class AssetDetails {

	/**
	 * The use type of the asset.
	 * 
	 * @author Ahmed Sharaf
	 *
	 */
	public enum AssetUseType {
		COMMERCIAL, RESIDENTIAL
	}

	/**
	 * The source of the asset.
	 * 
	 * @author Ahmed Sharaf
	 *
	 */
	public enum AssetSource {
		INHERITED, GRANTEDFROMSTATE, NONE
	}

	/**
	 * The real state type.
	 * 
	 * @author Ahmed Sharaf
	 *
	 */
	public enum RealStateType {
		VILLA, APARTMENT, BUILDING, OTHER
	}

	private boolean isShared = false;
	private int areaInSquaredMeters = 0;
	private Double assetValueInSAR = 0.0;
	private AssetSource assetSource = AssetSource.NONE;
	private RealStateType assetType = RealStateType.OTHER;
	private AssetUseType assetUseType = AssetUseType.RESIDENTIAL;

	private List<SourceMapper> sourcesMap = new ArrayList<>();

	public AssetDetails() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public RealStateType getAssetType() {
		return assetType;
	}

	public void setAssetType(RealStateType type) {
		this.assetType = type;
	}

	public List<SourceMapper> getSourcesMap() {
		return sourcesMap;
	}

	public void setSourcesMap(List<SourceMapper> sourcesMap) {
		this.sourcesMap = sourcesMap;
	}

	public boolean isShared() {
		return isShared;
	}

	public void setShared(boolean isShared) {
		this.isShared = isShared;
	}

	public Double getAssetValueInSAR() {
		return assetValueInSAR;
	}

	public void setAssetValueInSAR(Double assetValueInSAR) {
		this.assetValueInSAR = assetValueInSAR;
	}

	public boolean isNotShared() {
		boolean shared = this.isShared();
		return !shared;
	}

	public int getAreaInSquaredMeters() {
		return areaInSquaredMeters;
	}

	public void setAreaInSquaredMeters(int areaInSquaredMeters) {
		this.areaInSquaredMeters = areaInSquaredMeters;
	}

	public AssetUseType getAssetUseType() {
		return assetUseType;
	}

	public void setAssetUseType(AssetUseType assetUseType) {
		this.assetUseType = assetUseType;
	}

	public AssetSource getAssetSource() {
		return assetSource;
	}

	public void setAssetSource(AssetSource assetSource) {
		this.assetSource = assetSource;
	}

}
