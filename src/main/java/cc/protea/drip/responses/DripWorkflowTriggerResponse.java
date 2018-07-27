package cc.protea.drip.responses;

import java.util.ArrayList;
import java.util.List;

import cc.protea.drip.model.DripWorkflowTrigger;

public class DripWorkflowTriggerResponse extends DripResponse {

	public List<DripWorkflowTrigger> triggers = new ArrayList<DripWorkflowTrigger>();
	
}
