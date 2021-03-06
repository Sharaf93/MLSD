package com.mlsd.xom.common;

/**
 * The details of the rejection message object. Containing the arabic, english
 * message and the code associated with them.
 * 
 * @author Ahmed Sharafeldin
 *
 */
public class RejectionMessageDetails {

	private String messageCode = "";
	private String arabicMessage = "";
	private String englishMessage = "";

	public RejectionMessageDetails() {
		// Empty Constructor for NULL Avoidance
	}

	public RejectionMessageDetails(String messageCode, String englishMessage, String arabicMessage) {
		this.messageCode = messageCode;
		this.englishMessage = englishMessage;
		this.arabicMessage = arabicMessage;
	}

	public String getMessageCode() {
		if (messageCode == null)
			messageCode = "";
		return messageCode;
	}

	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	public String getEnglishMessage() {
		if (englishMessage == null)
			englishMessage = "";
		return englishMessage;
	}

	public void setEnglishMessage(String englishMessage) {
		this.englishMessage = englishMessage;
	}

	public String getArabicMessage() {
		if (arabicMessage == null)
			arabicMessage = "";
		return arabicMessage;
	}

	public void setArabicMessage(String arabicMessage) {
		this.arabicMessage = arabicMessage;
	}

}
