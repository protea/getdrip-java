package cc.protea.drip.responses;

import java.util.ArrayList;
import java.util.List;

import cc.protea.drip.model.DripSubscriber;

public class DripSubscriberResponse extends DripPaginatedResponse {

	public List<DripSubscriber> subscribers = new ArrayList<DripSubscriber>();
	
}
