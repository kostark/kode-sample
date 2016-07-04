package kode.sample.sdk;

/**
 * 客户端调用异常
 *
 * @author Stark
 * @since 1.0, 2016/7/4
 */
public class ApiException extends Exception {
	/** error code */
	private String errCode;
	/** error message */
	private String errMsg;

	public ApiException() {
		super();
	}

	public ApiException(String message) {
		super(message);
	}

	public ApiException(String message, Throwable cause) {
		super(message, cause);
	}

	public ApiException(Throwable cause) {
		super(cause);
	}

	public ApiException(String errCode, String errMsg) {
		super(errCode + ": " + errMsg);
		this.errCode = errCode;
		this.errMsg = errMsg;
	}

	public String getErrCode() {
		return errCode;
	}

	public String getErrMsg() {
		return errMsg;
	}
}
