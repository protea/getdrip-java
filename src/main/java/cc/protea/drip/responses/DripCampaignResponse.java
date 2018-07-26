package cc.protea.drip.responses;

import java.util.ArrayList;
import java.util.List;

import cc.protea.drip.model.DripCampaign;

public class DripCampaignResponse extends DripPaginatedResponse {

	public List<DripCampaign> campaigns = new ArrayList<DripCampaign>();
	
}
