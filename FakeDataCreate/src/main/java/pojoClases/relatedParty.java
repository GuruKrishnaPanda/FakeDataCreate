package pojoClases;

public class relatedParty {
	
	private String reportingEntityId;
	private String counterpartyId;
	private String relatedCounterpartyID;
	private String relation;
	private String relatedPartyId;
	
	public String getRelatedPartyId() {
		return relatedPartyId;
	}
	public void setRelatedPartyId(String relatedPartyId) {
		this.relatedPartyId = relatedPartyId;
	}
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
	public String getRelatedCounterpartyID() {
		return relatedCounterpartyID;
	}
	public void setRelatedCounterpartyID(String relatedCounterpartyID) {
		this.relatedCounterpartyID = relatedCounterpartyID;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		this.relation = relation;
	}
	
}