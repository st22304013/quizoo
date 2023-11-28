package web.exception;

public class MethodNotAllowedException extends Exception{
	public MethodNotAllowedException(String msg,Exception e) {
		super(msg,e);
	}
} 
