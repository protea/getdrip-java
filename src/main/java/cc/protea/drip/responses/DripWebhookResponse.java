package cc.protea.drip.responses;

import java.util.ArrayList;
import java.util.List;

import cc.protea.drip.model.DripWebhook;

public class DripWebhookResponse extends DripPaginatedResponse {

	public List<DripWebhook> webhooks = new ArrayList<DripWebhook>();
	
}
