package cc.protea.drip.responses;

import java.util.ArrayList;
import java.util.List;

import cc.protea.drip.model.DripEvent;

public class DripEventResponse extends DripResponse {

	public List<DripEvent> events = new ArrayList<DripEvent>();
}
