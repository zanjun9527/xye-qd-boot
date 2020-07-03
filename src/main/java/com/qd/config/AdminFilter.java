package com.qd.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@SuppressWarnings("unused")
@WebFilter(filterName = "adminFilter", urlPatterns = { "/admin/*" })
public class AdminFilter implements javax.servlet.Filter {

	private static final Logger logger = LoggerFactory.getLogger(AdminFilter.class);


	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		String requestURI = request.getServletPath();

//		//配置的.htm拦截，这里返回主页信息
//		if("/admin".equals(requestURI) || "/index.htm".equals(requestURI)) {
//			response.sendRedirect(request.getContextPath()+"/freePayCenter/freepayAccount/pcInitUserAccount.htm");
//			return;
//		}
		
		//过滤样式和图片
		StringBuffer server = request.getRequestURL();
		if(server.toString().contains(".css") || server.toString().contains(".js") || server.toString().contains(".png")
				 || server.toString().contains(".jpg")){
	        //如果发现是css或者js文件图片文件，直接放行
			arg2.doFilter(request, response);
	        return;
	    }
		Object loginFlag = request.getSession().getAttribute("loginFlag");

		if(loginFlag!=null && "1".equals(loginFlag.toString())){
			//后台登录了，正常放行
			arg2.doFilter(request, response);
			return;
		}else{
			//未登录就跳转后台登录页面
			logger.info("用户尚未登录，跳转登录");
			response.sendRedirect(request.getContextPath()+"/test/loginPage");
			return;
		}
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		
	}

	

	@Override
	public void destroy() {
		
	}
}
