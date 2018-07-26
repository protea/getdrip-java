package cc.protea.drip.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DripSubscriber {

	public static enum Status { @JsonProperty("active") ACTIVE, @JsonProperty("unsubscribed") UNSUBSCRIBED }
	public static enum EuConsent { @JsonProperty("granted") GRANTED, @JsonProperty("denied") DENIED, @JsonProperty("unknown") UNKNOWN }
	
	public String id;
	public Status status;
	public String email;
	@JsonProperty("eu_consent") public EuConsent euConsent;
	@JsonProperty("eu_consent_message") public String euConsentMessage;
	@JsonProperty("time_zone") public String timeZone;
	@JsonProperty("utc_offset") public Integer utcOffset;
	@JsonProperty("visitor_uuid") public String visitorUuid;
	@JsonProperty("custom_fields") public Map<String, String> customFields = new HashMap<String, String>();
	public List<String> tags = new ArrayList<String>();
	@JsonProperty("ip_address") public String ipAddress;
	@JsonProperty("user_agent") public String userAgent;
	@JsonProperty("original_referrer") public String originalReferrer;
	@JsonProperty("landing_url") public String landingUrl;
	public Boolean prospect;
	@JsonProperty("lead_score") public Integer leadScore;
	@JsonProperty("lifetime_value") public Integer lifetimeValue;
	@JsonProperty("created_at") public Date createdAt;
	public String href;
	@JsonProperty("user_id") public String userId;
	@JsonProperty("base_lead_score") public Integer baseLeadScore;
	public Map<String, String> links = new HashMap<String, String>();
	
}
