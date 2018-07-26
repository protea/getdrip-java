package cc.protea.drip.model;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DripRefund {
	
	public String provider;
	@JsonProperty("order_upstream_id") public String orderUpstreamId;
	public Integer amount;
	@JsonProperty("upstream_id") public String upstreamId;
	public String note;
	@JsonProperty("processed_at") public Date processedAt;
		
}
