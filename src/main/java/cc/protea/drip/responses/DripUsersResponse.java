package cc.protea.drip.responses;

import java.util.ArrayList;
import java.util.List;

import cc.protea.drip.model.DripUser;

public class DripUsersResponse extends DripPaginatedResponse {

	public List<DripUser> users = new ArrayList<DripUser>();
	
}
