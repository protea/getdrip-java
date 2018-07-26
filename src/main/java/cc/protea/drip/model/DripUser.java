package cc.protea.drip.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DripUser {

	public String email;
	public String name;
	@JsonProperty("time_zone") public String timeZone;
	
}
