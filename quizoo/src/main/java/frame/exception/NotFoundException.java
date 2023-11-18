package frame.exception;

public class NotFoundException extends Exception{
	public NotFoundException() {
		super();
	}
	public NotFoundException(String msg,Exception e) {
		super(msg,e);
	}
} 
