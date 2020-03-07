package com.boke.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

//@WebFilter(urlPatterns="/*")
//@Configuration
public class SessionFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// 过滤的uri
		String[] notFilter = new String[] { "index.html"};
		// 请求的uri
		String uri = request.getRequestURI();
		System.out.println(uri);
		// 是否过滤
		boolean doFilter = false;
		for (String s : notFilter) {
			// 过滤掉jsp文件
			if (uri.lastIndexOf(s) == uri.length() - s.length() ) {
				// uri中包含过滤uri，则进行过滤
				doFilter = true;
				break;
			}
		}
		System.out.println(doFilter);
		if (doFilter) {
			// 过滤操作
			// 从session中获取登陆者实体
			Object obj = request.getSession().getAttribute("User");
			if (obj == null) {
				boolean isAjaxRequest = isAjaxRequest(request);
				if (isAjaxRequest) {
					response.setCharacterEncoding("UTF-8");
					response.sendError(HttpStatus.UNAUTHORIZED.value(), "您已经太长时间没有操作,请刷新页面");
					return;
				} else {
					System.out.println("开始存储Cookie");
					//存储
					String cookieName="FormerUrl";
					String cookieValue="http://localhost:8080" + uri;
					Cookie myCookie=new Cookie(cookieName,cookieValue);
					myCookie.setMaxAge(60*60*24);//一天
					myCookie.setPath("/Freshs");	//设置cookie的作用域
					response.addCookie(myCookie);
					response.sendRedirect("./login.html");
				}
			} else {
				// Memberinfo user = (Memberinfo) obj;
				// 如果session中存在登录者实体，则继续
				filterChain.doFilter(request, response);
			}
		} else {
			// 不执行过滤操作
			filterChain.doFilter(request, response);
		}
	}

	/**
	 * is Ajax request
	 * @param request
	 * @return
	 */
	private boolean isAjaxRequest(HttpServletRequest request) {
		String header = request.getHeader("X-Requested-With");
		if (header != null && "XMLHttpRequest".equals(header)) {
			// ajax request
			return true;
		} else {
			// traditional sync http request
			return false;
		}
	}
}
