package com.mlsd.xom.subsidy;

/**
 * This object is used for the output parameters in a decision operation. It is
 * used to show the accepted profile flag enum in the output parameter.
 * 
 * @author Ahmed Sharafeldin
 *
 */
public class AcceptedProfileOutput {

	/**
	 * The available profile flags
	 * 
	 * @author Ahmed Sharafeldin
	 *
	 */
	public enum ProfileFlag {
		FIRST, SECOND
	}

	private ProfileFlag acceptedProfile = ProfileFlag.FIRST;

	public AcceptedProfileOutput() {
		// Empty Constructor For NULL Avoidance
	}

	public ProfileFlag getAcceptedProfile() {
		if (acceptedProfile == null)
			acceptedProfile = ProfileFlag.FIRST;
		return acceptedProfile;
	}

	public void setAcceptedProfile(ProfileFlag acceptedProfile) {
		this.acceptedProfile = acceptedProfile;
	}

}
