package cc.protea.drip.responses;

import java.util.ArrayList;
import java.util.List;

import cc.protea.drip.model.DripAccount;

public class DripAccountsResponse extends DripPaginatedResponse {

	public List<DripAccount> accounts = new ArrayList<DripAccount>();
	
}
