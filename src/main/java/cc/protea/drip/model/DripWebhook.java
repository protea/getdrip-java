package cc.protea.drip.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DripWebhook {
	
	public String id;
	public String href;
	@JsonProperty("post_url") public String postUrl;
	public String version;
	@JsonProperty("include_received_email") public Boolean includeReceivedEmail;
	@JsonProperty("created_at") public Date createdAt;
	public List<String> events = new ArrayList<String>();
	public Map<String, String> links = new HashMap<String, String>();
	
}
