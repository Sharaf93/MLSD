package com.mlsd.xom.socialcare;

/**
 * The age in one of the social care services (Medical Equipment) requires to be
 * in a range and indicating whether it's inclusive or exclusive. 
 * 
 * @author Ahmed Sharafeldin
 *
 */
public class RequiredAge {
	private int minAge = 0;
	private int maxAge = 0;
	private boolean inclusive = false;

	public RequiredAge() {
		// empty constructor for NULL avoidance
	}

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public boolean isInclusive() {
		return inclusive;
	}

	public void setInclusive(boolean inclusive) {
		this.inclusive = inclusive;
	}

}