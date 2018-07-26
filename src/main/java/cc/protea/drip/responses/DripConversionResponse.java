package cc.protea.drip.responses;

import java.util.ArrayList;
import java.util.List;

import cc.protea.drip.model.DripConversion;

public class DripConversionResponse extends DripPaginatedResponse {

	public List<DripConversion> goals = new ArrayList<DripConversion>();
	
}
