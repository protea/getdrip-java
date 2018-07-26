package cc.protea.drip.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DripForm {

	public static enum Orientation {
		@JsonProperty("bottom_left_tab") BOTTOM_LEFT_TAB,
		@JsonProperty("bottom_right_tab") BOTTOM_RIGHT_TAB,
		@JsonProperty("side_left_tab") SIDE_LEFT_TAB,
		@JsonProperty("side_right_tab") SIDE_RIGHT_TAB,
		@JsonProperty("embedded") EMBEDDED,
		@JsonProperty("lightbox") LIGHTBOX
	}
	
	public String id;
	public String headline;
	public String description;
	@JsonProperty("button_text") public String buttonText;
	@JsonProperty("confirmation_heading") public String confirmationHeading;
	@JsonProperty("confirmation_text") public String confirmationText;
	@JsonProperty("send_ga_event") public Boolean sendGAEvent;
	@JsonProperty("seconds_before_popup") public Integer secondsBeforePopup;
	@JsonProperty("seconds_between_popup_after_close") public Integer secondsBetweenPopupAfterClose;
	public Orientation orientation;
	public Double opacity;
	@JsonProperty("show_labels") public Boolean showLabels;
	@JsonProperty("primary_color") public String primaryColor;
	@JsonProperty("secondary_color") public String secondaryColor;
	@JsonProperty("is_widget_enabled") public Boolean widgetEnabled;
	public List<String> whitelist = new ArrayList<String>();
	public List<String> blacklist = new ArrayList<String>();
	@JsonProperty("is_whitelist_enabled") public Boolean whitelistEnabled;
	@JsonProperty("is_blacklist_enabled") public Boolean blacklistEnabled;
	@JsonProperty("hide_on_mobile") public Boolean hideOnMobile;
	@JsonProperty("created_at") public Date createdAt;
	public Map<String, String> links = new HashMap<String, String>();
	
}
