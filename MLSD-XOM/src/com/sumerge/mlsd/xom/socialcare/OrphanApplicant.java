package com.sumerge.mlsd.xom.socialcare;

import com.sumerge.mlsd.xom.common.Person;

public class OrphanApplicant extends Person {

	private boolean receivedMarriageReward = false;
	private boolean livesInMinisterialFacility = false;
	private Person father = new Person();

	public OrphanApplicant() {
	}

	public boolean isLivesInMinisterialFacility() {
		return livesInMinisterialFacility;
	}

	public void setLivesInMinisterialFacility(boolean livesInMinisterialFacility) {
		this.livesInMinisterialFacility = livesInMinisterialFacility;
	}

	public Person getFather() {
		return father;
	}

	public void setFather(Person father) {
		this.father = father;
	}

	public boolean isReceivedMarriageReward() {
		return receivedMarriageReward;
	}

	public void setReceivedMarriageReward(boolean receivedMarriageReward) {
		this.receivedMarriageReward = receivedMarriageReward;
	}

}
