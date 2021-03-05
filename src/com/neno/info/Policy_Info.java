package com.neno.info;

import java.io.Serializable;

public class Policy_Info implements Serializable {

	String complaint;
	String RiskRating;
	String evidence;
	String date;
	String findings;

	public String getComplaint() {
		return complaint;
	}

	public void setComplaint(String complaint) {
		this.complaint = complaint;
	}

	public String getRiskRating() {
		return RiskRating;
	}

	public void setRiskRating(String risk) {
		this.RiskRating = risk;
	}

	public String getEvidence() {
		return evidence;
	}

	public void setEvidence(String evidence) {
		this.evidence = evidence;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getFindings() {
		return findings;
	}

	public void setFindings(String findings) {
		this.findings = findings;
	}

}
