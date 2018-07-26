package cc.protea.drip.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DripWorkflow {

	public static enum Status {
		@JsonProperty("active") ACTIVE,
		@JsonProperty("paused") PAUSED,
		@JsonProperty("draft") DRAFT;
	}
	
	public String id;
	public String href;
	public String name;
	public Status status;
	@JsonProperty("created_at") public Date createdAt;
	public Map<String, String> links = new HashMap<String, String>();
	
}
