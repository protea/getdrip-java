package cc.protea.drip.responses;

import java.util.List;

public class DripResponse {
	public static class DripError {
		String code;
		String message;
		String attribute;
	}
	public boolean success = true;
	public List<DripError> errors;
}
