package cc.protea.drip.model;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DripWebookEvent {
	
	public static class Data {
		@JsonProperty("account_id") public String accountId;
		public DripSubscriber subscriber;
		public Map<String, Object> properties = new HashMap<String, Object>();
	}
	
	public String event;
	public Data data = new Data();
	@JsonProperty("occurred_at") public Date occurredAt;
	
}
