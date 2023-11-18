package web.context;

import javax.servlet.http.HttpServletRequest;

import frame.context.RequestContext;

public class HttpRequestContext implements RequestContext{
	HttpServletRequest req = null;
	public HttpRequestContext(HttpServletRequest req) {
		this.req = req;
	}
	@Override
	public void setAttribute(String key, Object value) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	@Override
	public String[] getParameter(String key) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	@Override
	public void setId(String userId) {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	@Override
	public String getId() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	@Override
	public String getMessageBody() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
	@Override
	public String getTargetServiceKey() {
		return req.getRequestURI().toString().replaceFirst(".","").replaceAll("/", ".");
	}
} 
