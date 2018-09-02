package com.mlsd.xom.socialcare;

import java.util.ArrayList;
import java.util.List;

/**
 * This object is used for the input parameters in a decision operation. It is
 * used to show the Medical Equipments as a list in the input parameter.
 * 
 * @author Ahmed Sharafeldin
 *
 */
public class MedicalEquipmentRequest {

	private List<MedicalEquipmentProfile> requestedMedicalEquipment = new ArrayList<>();

	public MedicalEquipmentRequest() {
		// Empty Constructor for NULL Avoidance
	}

	public List<MedicalEquipmentProfile> getRequestedMedicalEquipment() {
		if (requestedMedicalEquipment == null)
			requestedMedicalEquipment = new ArrayList<>();
		return requestedMedicalEquipment;
	}

	public void setRequestedMedicalEquipment(List<MedicalEquipmentProfile> requestedMedicalEquipment) {
		this.requestedMedicalEquipment = requestedMedicalEquipment;
	}

}
