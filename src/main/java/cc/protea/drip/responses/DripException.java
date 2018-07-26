package cc.protea.drip.responses;

import cc.protea.drip.responses.DripResponse.DripError;
import cc.protea.util.http.Response;

public class DripException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public Response response = null;
	public String errorMessage;
	public String errorCode;

	public DripException() {
		super();
	}

	public DripException(final Exception e) {
		super(e);
	}

	public DripException(final Exception e, final Response response) {
		super(e);
		this.response = response;
	}

	public DripException(final Exception e, final String errorCode, final String errorMessage) {
		super(e);
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
	}
	
	public DripError toError() {
		DripError error = new DripError();
		error.code = errorCode;
		error.message = errorMessage;
		return error;
	}
}
