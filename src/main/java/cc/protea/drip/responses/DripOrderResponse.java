package cc.protea.drip.responses;

import java.util.ArrayList;
import java.util.List;

import cc.protea.drip.model.DripOrder;

public class DripOrderResponse extends DripPaginatedResponse {

	public List<DripOrder> orders = new ArrayList<DripOrder>();
	
}
