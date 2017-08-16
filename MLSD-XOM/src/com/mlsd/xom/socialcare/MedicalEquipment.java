package com.mlsd.xom.socialcare;

/**
 * The basic information of the medical equipment. Mainly the IDs associated
 * with the medical equipment.
 * 
 * @author Ahmed Sharaf
 *
 */
public class MedicalEquipment {

	private int mainID = 0;
	private int subID = 0;
	private int compositeID = 0;
	private String equipmentName = "";

	public MedicalEquipment() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public int getMainID() {
		return mainID;
	}

	public void setMainID(int mainID) {
		this.mainID = mainID;
	}

	public int getSubID() {
		return subID;
	}

	public void setSubID(int subID) {
		this.subID = subID;
	}

	public int getCompositeID() {
		return compositeID;
	}

	public void setCompositeID(int compositeID) {
		this.compositeID = compositeID;
	}

}
