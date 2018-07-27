package cc.protea.drip;

import java.util.ArrayList;
import java.util.List;

class DripTagRequest {
	
	public static class DripTagRequestActual {
		public String email;
		public String tag;
	}
	
	public List<DripTagRequestActual> tags = new ArrayList<DripTagRequestActual>(); 
	
	public DripTagRequest(String email, String tag) {
		DripTagRequestActual actual = new DripTagRequestActual();
		actual.email = email;
		actual.tag = tag;
		tags.add(actual);
	}
	
}
