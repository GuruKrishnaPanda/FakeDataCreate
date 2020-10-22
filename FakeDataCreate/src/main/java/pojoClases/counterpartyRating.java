package pojoClases;

public class counterpartyRating {
	private String reportingEntityId;
	private String counterpartyId;
	private String ratingID;
	private String creditRating;
	private String assessmentAgencyAuthority;
	private String creditRatingAsOn;
	private String creditRatingExpiryDate;
	public String getReportingEntityId() {
		return reportingEntityId;
	}
	public void setReportingEntityId(String reportingEntityId) {
		this.reportingEntityId = reportingEntityId;
	}
	public String getCounterpartyId() {
		return counterpartyId;
	}
	public void setCounterpartyId(String counterpartyId) {
		this.counterpartyId = counterpartyId;
	}
	public String getRatingID() {
		return ratingID;
	}
	public void setRatingID(String ratingID) {
		this.ratingID = ratingID;
	}
	public String getCreditRating() {
		return creditRating;
	}
	public void setCreditRating(String creditRating) {
		this.creditRating = creditRating;
	}
	public String getAssessmentAgencyAuthority() {
		return assessmentAgencyAuthority;
	}
	public void setAssessmentAgencyAuthority(String assessmentAgencyAuthority) {
		this.assessmentAgencyAuthority = assessmentAgencyAuthority;
	}
	public String getCreditRatingAsOn() {
		return creditRatingAsOn;
	}
	public void setCreditRatingAsOn(String creditRatingAsOn) {
		this.creditRatingAsOn = creditRatingAsOn;
	}
	public String getCreditRatingExpiryDate() {
		return creditRatingExpiryDate;
	}
	public void setCreditRatingExpiryDate(String creditRatingExpiryDate) {
		this.creditRatingExpiryDate = creditRatingExpiryDate;
	}

}
