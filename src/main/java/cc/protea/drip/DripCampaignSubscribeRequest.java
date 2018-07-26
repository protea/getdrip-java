package cc.protea.drip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

import cc.protea.drip.model.DripSubscriber.EuConsent;

public class DripCampaignSubscribeRequest {

	public String email;
	@JsonProperty("user_id") public String userId;
	@JsonProperty("time_zone") public String timeZone;
	@JsonProperty("double_optin") public Boolean doubleOptIn;
	@JsonProperty("starting_email_index") public Integer startingEmailIndex;
	@JsonProperty("custom_fields") public Map<String, String> customFields = new HashMap<String, String>();
	public List<String> tags = new ArrayList<String>();
	@JsonProperty("reactivate_if_removed") public Boolean reactivateIfRemoved;
	public Boolean prospect;
	@JsonProperty("base_lead_score") public Integer baseLeadScore;
	@JsonProperty("eu_consent") public EuConsent euConsent; 
	@JsonProperty("eu_consent_message") public String euConsentMessage; 
	
}
