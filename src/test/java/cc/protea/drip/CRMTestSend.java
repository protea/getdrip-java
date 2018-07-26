package cc.protea.drip;

import org.junit.Test;

public class CRMTestSend {

	Drip drip = new Drip("200cec2d5f78be40bd0119f19a0c95d8", "9314486");
	
	@Test
	public void testSend() {
		print(drip.getAuthorizedUser());
		print(drip.accounts.list());
		print(drip.customFields.list());
	}
	
	void print(Object in) {
		System.out.println(DripJsonUtils.toJson(in));
	}

}
