package cc.protea.drip.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DripBroadcast {

	public static enum Status {
		@JsonProperty("draft") DRAFT,
		@JsonProperty("canceled") CANCELED,
		@JsonProperty("scheduled") SCHEDULED,
		@JsonProperty("sent") SENT,
		@JsonProperty("sending") SENDING;
	}
	
	public String id;
	public Status status;
	public String name;
	@JsonProperty("from_name") public String fromName;
	@JsonProperty("from_email") public String fromEmail;
	@JsonProperty("postal_address") public String postalAddress;
	@JsonProperty("localize_sending_time") public Boolean localizeSendingTime;
	@JsonProperty("send_at") public Date sendAt;
	public List<String> bcc = new ArrayList<String>();
	@JsonProperty("created_at") public Date createdAt;
	public String href;
	@JsonProperty("html_body") public String htmlBody;
	@JsonProperty("text_body") public String textBody;
	public Map<String, String> links = new HashMap<String, String>();
	
}
