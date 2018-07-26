package cc.protea.drip.responses;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DripPaginatedResponse extends DripResponse {

	public static class Meta {
		public int page;
		public int count;
		@JsonProperty("total_pages") public int totalPages;
		@JsonProperty("total_count") public int totalCount;
	}
	
	public Meta meta = new Meta();
	public Map<String, String> links = new HashMap<String, String>();
	
}
