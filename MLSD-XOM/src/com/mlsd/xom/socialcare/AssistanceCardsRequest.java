package com.mlsd.xom.socialcare;

import java.util.ArrayList;
import java.util.List;

import com.mlsd.xom.socialcare.HandicappedApplicant.AssistanceCards;

/**
 * This object is created for the input parameter in the decision operation, to
 * request a list of assisstance cards.
 * 
 * @author Ahmed Sharaf
 *
 */
public class AssistanceCardsRequest {

	private List<AssistanceCards> requestedAssistanceCards = new ArrayList<>();

	public AssistanceCardsRequest() {
		/*
		 * Empty Constructor for NULL Avoidance
		 */
	}

	public List<AssistanceCards> getRequestedAssistanceCards() {
		if(requestedAssistanceCards == null)
			requestedAssistanceCards = new ArrayList<>();
		return requestedAssistanceCards;
	}

	public void setRequestedAssistanceCards(List<AssistanceCards> requestedAssistanceCards) {
		this.requestedAssistanceCards = requestedAssistanceCards;
	}

}
