package frame.context;

import db.bean.UserInfoBean;
import frame.exception.ResourceException;

public interface RequestContext {
	public void setAttribute(String key, Object value);

	public String[] getParameter(String key);

	public void setUser(UserInfoBean user);

	public UserInfoBean getUser();

	public String getMessageBody() throws ResourceException;
	
	public String getTargetServiceKey();
}