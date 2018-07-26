package cc.protea.drip.responses;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DripEventActionsResponse extends DripResponse {

	@JsonProperty("event_actions") public List<String> eventActions = new ArrayList<String>();
}
