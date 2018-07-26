package cc.protea.drip;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DripConversionRequest extends DripPagination {

	public static enum Sort { @JsonProperty("created_at") CREATED_AT, @JsonProperty("name") NAME }
	
	public Sort sort;
	
	String augmentUrl(String in) {
		in = super.augmentUrl(in);
		boolean usedParam = in.contains("?");
		StringBuilder sb = new StringBuilder(in);
		if (this.sort != null) {
			sb.append(usedParam ? "&" : "?").append("sort=").append(DripJsonUtils.toJson(this.sort));
			usedParam = true;
		}
		return sb.toString();
	}
}
