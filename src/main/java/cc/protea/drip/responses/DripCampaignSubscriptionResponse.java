package cc.protea.drip.responses;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import cc.protea.drip.model.DripCampaignSubscription;

public class DripCampaignSubscriptionResponse extends DripPaginatedResponse {

	@JsonProperty("campaign_subscriptions") public List<DripCampaignSubscription> campaignSubscriptions = new ArrayList<DripCampaignSubscription>();
	
}
