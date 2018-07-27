package cc.protea.drip.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DripCampaignSubscription {

	public static enum Status {
		@JsonProperty("active") ACTIVE,
		@JsonProperty("paused") PAUSED;
	}
	
	public String id;
	@JsonProperty("campaign_id") public String campaignId;
	public Status status;
	@JsonProperty("is_complete") public Boolean complete;
	public Integer lap;
	@JsonProperty("last_email_sent_index") public Integer lastEmailSentIndex;
	@JsonProperty("last_email_sent_at") public Date lastEmailSentAt;
	public Map<String, String> links = new HashMap<String, String>();
	
}
