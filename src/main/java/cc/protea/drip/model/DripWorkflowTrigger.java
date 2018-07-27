package cc.protea.drip.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DripWorkflowTrigger {

	public static class DripWorkflowTriggerAction {
		public String code;
		public String message;
	}
	
	public String id;
	public String type;
	@JsonProperty("trigger_type") public String triggerType;
	public String provider;
	public Map<String, Object> properties = new HashMap<String, Object>();
	@JsonProperty("actions_required") public List<DripWorkflowTriggerAction> actionsRequired = new ArrayList<DripWorkflowTriggerAction>();
	@JsonProperty("occurred_at") public Date occurredAt;
	
}
