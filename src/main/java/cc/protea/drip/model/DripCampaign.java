package cc.protea.drip.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DripCampaign {

	public static enum Status {
		@JsonProperty("active") ACTIVE,
		@JsonProperty("paused") PAUSED,
		@JsonProperty("draft") DRAFT;
	}
	
	public String id;
	public Status status;
	public String name;
	@JsonProperty("from_name") public String fromName;
	@JsonProperty("from_email") public String fromEmail;
	@JsonProperty("postal_address") public String postalAddress;
	@JsonProperty("minutes_from_midnight") public Integer minutesFromMidnight;
	@JsonProperty("localize_sending_time") public Boolean localizeSendingTime;
	@JsonProperty("days_of_the_week_mask") public String daysOfTheWeekMask;
	@JsonProperty("start_immediately") public Boolean startImmediately;
	@JsonProperty("double_optin") public Boolean doubleOptin;
	@JsonProperty("notify_subscribe_email") public String notifySubscribeEmail;
	@JsonProperty("notify_unsubscribe_email") public String notifyUnsubscribeEmail;
	public String bcc;
	@JsonProperty("email_count") public Integer emailCount;
	@JsonProperty("active_subscriber_count") public Integer activeSubscriberCount;
	@JsonProperty("unsubscribed_subscriber_count") public Integer unsubscribedSubscriberCount;
	@JsonProperty("email_open_rate") public Double emailOpenRate;
	@JsonProperty("email_click_rate") public Double emailClickRate;
	@JsonProperty("created_at") public Date createdAt;
	public String href;
	public Map<String, String> links = new HashMap<String, String>();
	public List<DripForm> forms = new ArrayList<DripForm>();
	
}
