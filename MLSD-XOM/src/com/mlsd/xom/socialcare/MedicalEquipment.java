package com.mlsd.xom.socialcare;

/**
 * The basic information of the medical equipment. Mainly the ID associated with
 * the medical equipment.
 * 
 * @author Ahmed Sharafeldin
 *
 */
public class MedicalEquipment {

	private int equipmentID = 0;
	private String equipmentName = "";

	public MedicalEquipment() {
		// Empty Constructor for NULL Avoidance
	}

	public String getEquipmentName() {
		if (equipmentName == null)
			equipmentName = "";
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	public int getEquipmentID() {
		return equipmentID;
	}

	public void setEquipmentID(int equipmentID) {
		this.equipmentID = equipmentID;
	}

}
