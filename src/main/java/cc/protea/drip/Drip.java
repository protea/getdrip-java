package cc.protea.drip;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cc.protea.drip.model.DripAccount;
import cc.protea.drip.model.DripBroadcast;
import cc.protea.drip.model.DripCampaign;
import cc.protea.drip.model.DripConversion;
import cc.protea.drip.model.DripEvent;
import cc.protea.drip.model.DripForm;
import cc.protea.drip.model.DripOrder;
import cc.protea.drip.model.DripRefund;
import cc.protea.drip.model.DripSubscriber;
import cc.protea.drip.model.DripUser;
import cc.protea.drip.responses.DripAccountsResponse;
import cc.protea.drip.responses.DripBroadcastResponse;
import cc.protea.drip.responses.DripCampaignResponse;
import cc.protea.drip.responses.DripConversionResponse;
import cc.protea.drip.responses.DripCustomFieldsResponse;
import cc.protea.drip.responses.DripEventActionsResponse;
import cc.protea.drip.responses.DripEventResponse;
import cc.protea.drip.responses.DripFormResponse;
import cc.protea.drip.responses.DripOrderResponse;
import cc.protea.drip.responses.DripResponse;
import cc.protea.drip.responses.DripSubscriberResponse;
import cc.protea.drip.responses.DripUsersResponse;

public class Drip {

	private String apiKey = null;
	private String accountId = null;

	private DripUtils util = new DripUtils();

	public Drip(String apiKey, String accountId) {
		setApiKey(apiKey);
		setAccountId(accountId);
	}
	
	public Drip setApiKey(String apiKey) {
		this.apiKey = DripUtils.trimToNull(apiKey);;
		return this;
	}
	
	public Drip setAccountId(String accountId) {
		this.accountId = DripUtils.trimToNull(accountId);
		return this;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	// Current User
	
	public DripUser getAuthorizedUser() {
		DripUsersResponse response = util.get(apiKey, "/user", DripUsersResponse.class);
		return response.users == null || response.users.isEmpty() ? null : response.users.get(0); 
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	// Accounts
	
	public Accounts accounts = new Accounts();
	
	class Accounts {
		
		public DripAccountsResponse list() {
			return util.get(apiKey, "/accounts", DripAccountsResponse.class);
		}
		
		public DripAccount get(String accountId) {
			DripAccountsResponse response = util.get(apiKey, "/accounts/" + DripUtils.trim(accountId), DripAccountsResponse.class);
			return response.accounts == null || response.accounts.isEmpty() ? null : response.accounts.get(0);
		}
		
	}

	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	// Batching
	
	public List<DripResponse> batchSubcribers(List<DripSubscriber> subscribers) {
		return batch(subscribers, "/" + accountId.trim() + "/subscribers/batches");
	}

	public List<DripResponse> batchUnsubscribes(List<String> unsubscribes) {
		if (unsubscribes == null) {
			return null;
		}
		List<Map<String, String>> request = new ArrayList<Map<String, String>>();
		for (String email : unsubscribes) {
			if (email == null) {
				continue;
			}
			Map<String, String> map = new HashMap<String, String>();
			map.put("email", email.trim());
			request.add(map);
		}
		return batch(request, "/" + accountId.trim() + "/unsubscribes/batches");
	}

	public List<DripResponse> batchOrders(List<DripOrder> orders) {
		return batch(orders, "/" + accountId.trim() + "/orders/batches");
	}

	List<DripResponse> batch(List<? extends Object> dripObjects, String url) {
		if (dripObjects == null || accountId == null || accountId.trim().length() == 0) {
			return null;
		}
		List<DripResponse> responses = new ArrayList<DripResponse>();
		DripBatchRequest dbr = new DripBatchRequest();
		List<Object> batch = new ArrayList<Object>();
		dbr.batches = batch;
		for (Object object : dripObjects) {
			batch.add(object);
			if (batch.size() == 1000) {
				responses.add(util.post(apiKey, url, dbr, DripResponse.class));
				batch.clear();
			}
		}
		if (! batch.isEmpty()) {
			responses.add(util.post(apiKey, url, dbr, DripResponse.class));
		}
		return responses;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	// Broadcasts
	
	public Broadcasts broadcasts = new Broadcasts();
	
	class Broadcasts {
		
		public DripBroadcastResponse list() {
			return list(new DripBroadcastRequest());
		}
		
		public DripBroadcastResponse list(DripBroadcastRequest pagination) {
			String url = util.buildUrl(accountId, "/broadcasts", pagination);
			return util.get(apiKey, url, DripBroadcastResponse.class);
		}
		
		public DripBroadcast get(String broadcastId) {
			if (DripUtils.isEmpty(broadcastId)) {
				return null;
			}
			String url = util.buildUrl(accountId, "/broadcasts/" + broadcastId.trim());
			DripBroadcastResponse response = util.get(apiKey, url, DripBroadcastResponse.class);
			return response.broadcasts == null || response.broadcasts.isEmpty() ? null : response.broadcasts.get(0);
		}

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////
	// Campaigns
	
	public Campaigns campaigns = new Campaigns();
	
	class Campaigns {
		
		public DripCampaignResponse list() {
			return list(new DripPagination());
		}
		
		public DripCampaignResponse list(DripPagination pagination) {
			String url = util.buildUrl(accountId, "/campaigns", pagination);
			return util.get(apiKey, url, DripCampaignResponse.class);
		}
		
		public DripCampaign get(String campaignId) {
			if (DripUtils.isEmpty(campaignId)) {
				return null;
			}
			String url = util.buildUrl(accountId, "/campaigns/" + campaignId.trim());
			DripCampaignResponse response = util.get(apiKey, url, DripCampaignResponse.class);
			return response.campaigns == null || response.campaigns.isEmpty() ? null : response.campaigns.get(0);
		}
	
		public DripResponse activate(String campaignId) {
			if (DripUtils.isEmpty(campaignId)) {
				return null;
			}
			String url = util.buildUrl(accountId, "/campaigns/" + campaignId.trim() + "/activate");
			return util.post(apiKey, url, null, DripCampaignResponse.class);
		}
	
		public DripResponse pause(String campaignId) {
			if (DripUtils.isEmpty(campaignId)) {
				return null;
			}
			String url = util.buildUrl(accountId, "/campaigns/" + campaignId.trim() + "/pause");
			return util.post(apiKey, url, null, DripCampaignResponse.class);
		}
		
		public DripSubscriberResponse listSubscribers(String campaignId) {
			return listSubscribers(campaignId, new DripPagination());
		}
	
		public DripSubscriberResponse listSubscribers(String campaignId, DripPagination pagination) {
			String url = util.buildUrl(accountId, "/campaigns/" + campaignId + "/subscribers", pagination);
			return util.get(apiKey, url, DripSubscriberResponse.class);
		}
		
		public DripSubscriberResponse addSubscriber(String campaignId, DripCampaignSubscribeRequest request) {
			String url = util.buildUrl(accountId, "/campaigns/" + campaignId + "/subscribers");
			return util.post(apiKey, url, request, DripSubscriberResponse.class);
		}
		
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////
	// Conversions
	
	public Conversions conversions = new Conversions();
	
	class Conversions {
	
		public DripConversionResponse list() {
			return list(null);
		}
		
		public DripConversionResponse list(DripConversionRequest request) {
			String url = util.buildUrl(accountId, "/goals", request);
			return util.get(apiKey, url, DripConversionResponse.class);
		}
		
		public DripConversion get(String conversionId) {
			String url = util.buildUrl(accountId, "/goals" + conversionId);
			DripConversionResponse response = util.get(apiKey, url, DripConversionResponse.class);
			return response.goals == null || response.goals.isEmpty() ? null : response.goals.get(0);
		}
		
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////
	// Custom Fields
	
	public CustomFields customFields = new CustomFields();
	
	class CustomFields {
	
		public DripCustomFieldsResponse list() {
			String url = util.buildUrl(accountId, "/custom_field_identifiers");
			return util.get(apiKey, url, DripCustomFieldsResponse.class);
		}
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	// Events
	
	public Events events = new Events();
	
	class Events {
	
		public DripEventResponse list() {
			return list(null);
		}
		
		public DripEventResponse list(DripPagination request) {
			String url = util.buildUrl(accountId, "/events", request);
			return util.get(apiKey, url, DripEventResponse.class);
		}
		
		public DripEventActionsResponse listActions() {
			return listActions(null);
		}
		
		public DripEventActionsResponse listActions(DripPagination pagination) {
			String url = util.buildUrl(accountId, "/event_actions", pagination);
			return util.get(apiKey, url, DripEventActionsResponse.class);
		}
		
		public DripEvent get(String eventId) {
			String url = util.buildUrl(accountId, "/events" + eventId);
			DripEventResponse response = util.get(apiKey, url, DripEventResponse.class);
			return response.events == null || response.events.isEmpty() ? null : response.events.get(0);
		}
		
		public DripResponse record(DripEvent event) {
			String url = util.buildUrl(accountId, "/events");
			return util.post(apiKey, url, event, DripResponse.class);
		}
		
		public List<DripResponse> record(List<DripEvent> events) {
			return batch(events, "/" + accountId.trim() + "/events/batches");
		}

	}

	////////////////////////////////////////////////////////////////////////////////////////////////////
	// Forms
	
	public Forms forms = new Forms();
	
	class Forms {
	
		public DripFormResponse list() {
			String url = util.buildUrl(accountId, "/forms");
			return util.get(apiKey, url, DripFormResponse.class);
		}
		
		public DripForm get(String formId) {
			String url = util.buildUrl(accountId, "/forms" + formId);
			DripFormResponse response = util.get(apiKey, url, DripFormResponse.class);
			return response.forms == null || response.forms.isEmpty() ? null : response.forms.get(0);
		}
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	// Orders
	
	public Orders orders = new Orders();
	
	class Orders {
	
		public DripOrderResponse list() {
			return list(null);
		}
		
		public DripOrderResponse list(DripPagination request) {
			String url = util.buildUrl(accountId, "/orders", request);
			return util.get(apiKey, url, DripOrderResponse.class);
		}
		
		public DripOrder get(String orderId) {
			String url = util.buildUrl(accountId, "/orders" + orderId);
			DripOrderResponse response = util.get(apiKey, url, DripOrderResponse.class);
			return response.orders == null || response.orders.isEmpty() ? null : response.orders.get(0);
		}
		
		public DripResponse record(DripOrder order) {
			String url = util.buildUrl(accountId, "/orders");
			return util.post(apiKey, url, order, DripResponse.class);
		}
		
		public DripResponse refund(DripRefund refund) {
			String url = util.buildUrl(accountId, "/refunds");
			return util.post(apiKey, url, refund, DripResponse.class);
		}
		
		public List<DripResponse> record(List<DripOrder> orders) {
			return batch(orders, "/" + accountId.trim() + "/orders/batches");
		}

	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////
	// Subscribers 
	
	class Subscribers {
		
		public void listCampaignSubscriptions(String subscriberId, DripPagination pagination) {
			// http://developer.drip.com/#list-all-of-a-subscriber-39-s-campaign-subscriptions
		}
	}
	
}
