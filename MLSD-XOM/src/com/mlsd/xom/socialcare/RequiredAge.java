package com.mlsd.xom.socialcare;

public class RequiredAge {
	private int minAge = 0;
	private int maxAge = 0;
	private boolean inclusive = false;

	public RequiredAge() {
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