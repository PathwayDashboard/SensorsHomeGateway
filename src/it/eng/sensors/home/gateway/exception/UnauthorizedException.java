package it.eng.sensors.home.gateway.exception;

public class UnauthorizedException extends Exception {
	
	private static final long serialVersionUID = 1L;
	private int code;
	private String msg;
	

	public UnauthorizedException(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	@Override
	public String toString() {
		return "ErrCode: "+ this.code + " " + this.msg;
	}
	
	

}
