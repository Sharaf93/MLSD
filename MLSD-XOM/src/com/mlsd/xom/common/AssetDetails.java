package com.mlsd.xom.common;

import java.util.ArrayList;
import java.util.List;

/**
 * The Asset details is the description of the asset a person can own.
 * 
 * @author Ahmed Sharafeldin
 *
 */
public class AssetDetails {

	/**
	 * The use type of the asset.
	 * 
	 * @author Ahmed Sharafeldin
	 *
	 */
	public enum AssetUseType {
		COMMERCIAL, RESIDENTIAL, OTHER
	}

	/**
	 * The source of the asset.
	 * 
	 * @author Ahmed Sharafeldin
	 *
	 */
	public enum AssetSource {
		INHERITED, GRANTEDFROMSTATE, NONE
	}

	/**
	 * The real estate type.
	 * 
	 * @author Ahmed Sharafeldin
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
	private AssetUseType assetUseType = AssetUseType.OTHER;

	private List<SourceMapper> sourcesMap = new ArrayList<>();

	public AssetDetails() {
		// Empty Constructor for NULL Avoidance
	}

	public AssetDetails(boolean isShared, int areaInSquaredMeters, Double assetValueInSAR, AssetSource assetSource, RealStateType assetType,
			AssetUseType assetUseType) {
		this.isShared = isShared;
		this.areaInSquaredMeters = areaInSquaredMeters;
		this.assetValueInSAR = assetValueInSAR;
		this.assetSource = assetSource;
		this.assetType = assetType;
		this.assetUseType = assetUseType;
	}

	public RealStateType getAssetType() {
		if (assetType == null)
			assetType = RealStateType.OTHER;
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
		if (assetValueInSAR == null)
			assetValueInSAR = 0.0;
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
		if (assetUseType == null)
			assetUseType = AssetUseType.OTHER;
		return assetUseType;
	}

	public void setAssetUseType(AssetUseType assetUseType) {
		this.assetUseType = assetUseType;
	}

	public AssetSource getAssetSource() {
		if (assetSource == null)
			assetSource = AssetSource.NONE;
		return assetSource;
	}

	public void setAssetSource(AssetSource assetSource) {
		this.assetSource = assetSource;
	}

}
