package cc.protea.drip.responses;

import java.util.ArrayList;
import java.util.List;

import cc.protea.drip.model.DripWorkflow;

public class DripWorkflowResponse extends DripPaginatedResponse {

	public List<DripWorkflow> workflows = new ArrayList<DripWorkflow>();
	
}
