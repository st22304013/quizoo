package frame.exception;

public class ResourceException extends Exception {
	public ResourceException(String msg,Exception e) {
		super(msg, e);
	}
}
