package com.mlsd.xom.subsidy;

public class AcceptedProfileOutput {

	public enum ProfileFlag {
		FIRST, SECOND
	}

	private ProfileFlag acceptedProfile = ProfileFlag.FIRST;

	public AcceptedProfileOutput() {
	}

	public ProfileFlag getAcceptedProfile() {
		return acceptedProfile;
	}

	public void setAcceptedProfile(ProfileFlag acceptedProfile) {
		this.acceptedProfile = acceptedProfile;
	}

}
