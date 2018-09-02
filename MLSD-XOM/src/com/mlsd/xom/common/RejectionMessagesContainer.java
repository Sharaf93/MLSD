package com.mlsd.xom.common;

import java.util.ArrayList;
import java.util.List;

/**
 * This object is created for the output parameter in the decision operation, to
 * view the rejection messages as a list.
 * 
 * @author Ahmed Sharafeldin
 *
 */
public class RejectionMessagesContainer {

	private List<RejectionMessageDetails> rejectionMsg = new ArrayList<>();

	public RejectionMessagesContainer() {
		// Empty Constructor for NULL Avoidance
	}

	public List<RejectionMessageDetails> getRejectionMsg() {
		if (rejectionMsg == null) {
			rejectionMsg = new ArrayList<>();
		}
		return rejectionMsg;
	}

	public void setRejectionMsg(List<RejectionMessageDetails> rejectionMsg) {
		this.rejectionMsg = rejectionMsg;
	}
}
