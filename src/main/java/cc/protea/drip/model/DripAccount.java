package cc.protea.drip.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DripAccount {

	public String id;
	public String name;
	public String url;
	@JsonProperty("default_from_name") public String defaultFromName;
	@JsonProperty("default_from_email") public String defaultFromEmail;
	@JsonProperty("default_postal_address") public String defaultPostalAddress;
	@JsonProperty("primary_email") public String primaryEmail;
	@JsonProperty("enable_third_party_cookies") public Boolean enableThirdPartyCookies;
	@JsonProperty("phone_number") public String phoneNumber;
	@JsonProperty("created_at") public Date createdAt;
	public String href;
	public Map<String, String> links = new HashMap<String, String>();
	
}
