package cc.protea.drip.responses;

import java.util.ArrayList;
import java.util.List;

import cc.protea.drip.model.DripBroadcast;

public class DripBroadcastResponse extends DripPaginatedResponse {

	public List<DripBroadcast> broadcasts = new ArrayList<DripBroadcast>();
	
}
