package com.mlsd.xom.socialcare;

import java.util.ArrayList;
import java.util.List;

public class MedicalEquipmentRequest {

	private List<MedicalEquipmentProfile> requestedMedicalEquipment = new ArrayList<>();

	public MedicalEquipmentRequest() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public List<MedicalEquipmentProfile> getRequestedMedicalEquipment() {
		return requestedMedicalEquipment;
	}

	public void setRequestedMedicalEquipment(List<MedicalEquipmentProfile> requestedMedicalEquipment) {
		this.requestedMedicalEquipment = requestedMedicalEquipment;
	}

}
