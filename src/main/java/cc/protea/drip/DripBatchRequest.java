package cc.protea.drip;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class DripBatchRequest<T> {

	public List<Map<String, List<T>>> batches = new ArrayList<Map<String, List<T>>>();
	
}
