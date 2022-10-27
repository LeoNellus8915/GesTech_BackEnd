package it.teorema.gestech.utils;

public class ResponseHttp {
	private String code;
	private String message;
	private Object dataSource;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getDataSource() {
		return dataSource;
	}
	public void setDataSource(Object dataSource) {
		this.dataSource = dataSource;
	}
	
	
}
