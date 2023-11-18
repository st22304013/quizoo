package frame.context;

import frame.exception.ResourceException;

public interface RequestContext {
	public void setAttribute(String key, Object value);

	public String[] getParameter(String key);

	public void setId(String userId);

	public String getId();

	public String getMessageBody() throws ResourceException;
	
	public String getTargetServiceKey();
}