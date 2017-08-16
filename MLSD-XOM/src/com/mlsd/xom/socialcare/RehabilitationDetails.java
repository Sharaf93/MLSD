package com.mlsd.xom.socialcare;

/**
 * This object is for an input parameter in one of the social care services that
 * requires values in a certain manner to be caculated.
 * 
 * @author Ahmed Sharaf
 *
 */
public class RehabilitationDetails {

	private int rehabilitationSinceLastPaymentInDays = 0;
	private int residencyInRehabilitionCenterInDays = 0;

	public RehabilitationDetails() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public int getRehabilitationSinceLastPaymentInDays() {
		return rehabilitationSinceLastPaymentInDays;
	}

	public void setRehabilitationSinceLastPaymentInDays(int rehabilitationSinceLastPaymentInDays) {
		this.rehabilitationSinceLastPaymentInDays = rehabilitationSinceLastPaymentInDays;
	}

	public int getResidencyInRehabilitionCenterInDays() {
		return residencyInRehabilitionCenterInDays;
	}

	public void setResidencyInRehabilitionCenterInDays(int residencyInRehabilitionCenterInDays) {
		this.residencyInRehabilitionCenterInDays = residencyInRehabilitionCenterInDays;
	}

}
