package cc.protea.drip.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DripConversion {

	public static enum Status { @JsonProperty("enabled") ENABLED, @JsonProperty("disabled") DISABLED }
	public static enum CountingMethod { @JsonProperty("one_per_visitor") ONE_PER_VISITOR, @JsonProperty("all") ALL }
	
	public String id;
	public Status status;
	public String name;
	public String url;
	@JsonProperty("default_value") public String defaultValue;
	@JsonProperty("counting_method") public CountingMethod countingMethod;
	@JsonProperty("created_at") public Date createdAt;
	public String href;
	public Map<String, String> links = new HashMap<String, String>();
	
}
