package cc.protea.drip.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DripEvent {

	public static enum Status {
		@JsonProperty("active") ACTIVE,
		@JsonProperty("paused") PAUSED,
		@JsonProperty("draft") DRAFT;
	}
	
	public String id;
	public Status email;
	public String action;
	public Boolean prospect;
	public Map<String, Object> properties = new HashMap<String, Object>();
	@JsonProperty("occurred_at") public Date occurredAt;
	
}
