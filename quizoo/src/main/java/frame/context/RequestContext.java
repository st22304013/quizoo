package frame.context;

public interface RequestContext {
	void setAttribute(String key, Object value);

	String[] getParameter(String key);

	void setId(String userId);

	String getId();

	String getMessageBody();
}