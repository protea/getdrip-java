package cc.protea.drip;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DripPagination {

	public static enum Direction { 
		@JsonProperty("asc") ASC,
		@JsonProperty("desc") DESC
	}
	
	public Direction direction = Direction.ASC;
	public Integer page;

	String augmentUrl(String in) {
		if (in == null) {
			return in;
		}
		StringBuilder sb = new StringBuilder(in);
		boolean usedParam = in.contains("?");
		if (this.page != null) {
			sb.append(usedParam ? "&" : "?").append("page=").append(this.page);
			usedParam = true;
		}
		if (this.direction != null) {
			sb.append(usedParam ? "&" : "?").append("direction=").append(DripJsonUtils.toJson(this.direction));
			usedParam = true;
		}
		return in.toString();
	}
	
}
