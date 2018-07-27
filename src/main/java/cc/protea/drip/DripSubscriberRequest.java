package cc.protea.drip;

import cc.protea.drip.model.DripBroadcast;

public class DripSubscriberRequest extends DripPagination {

	// TODO
	
	public DripBroadcast.Status sort;
	
	String augmentUrl(String in) {
		in = super.augmentUrl(in);
		boolean usedParam = in.contains("?");
		StringBuilder sb = new StringBuilder(in);
		if (this.sort != null) {
			sb.append(usedParam ? "&" : "?").append("sort=").append(DripJsonUtils.toJson(this.sort));
			usedParam = true;
		}
		return sb.toString();
	}
}
