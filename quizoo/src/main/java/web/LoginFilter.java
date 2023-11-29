package web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import db.bean.UserInfoBean;

public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		// TODO 自動生成されたメソッド・スタブ
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest)request).getSession();

		UserInfoBean bean = (UserInfoBean) session.getAttribute("id");
		
		if(bean == null || bean.getUserId() == null || bean.getUserId().isEmpty()) {
			RequestDispatcher rd = request.getRequestDispatcher("login-page");
			rd.forward(request, response);
		} else {
			chain.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO 自動生成されたメソッド・スタブ
		
	}
	
} 
