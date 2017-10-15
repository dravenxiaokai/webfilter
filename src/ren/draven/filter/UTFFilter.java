package ren.draven.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * <filter>
  	<filter-name>UTFFilter</filter-name>
  	<filter-class>ren.draven.filter.UTFFilter</filter-class>
  </filter>
  <filter-mapping>
  	<filter-name>UTFFilter</filter-name>
  	<url-pattern>/*</url-pattern>
  </filter-mapping>
  
 * @author dravenxiaokai
 *
 *	filterName <==> <filter-name>
 *	urlPatterns="/*" <==> <url-pattern>/*</url-pattern>
 *	urlPatterns <==> value
 */

@WebFilter(filterName="UTFFilter",value= {"/*"},servletNames = {"LoginServlet"})
public class UTFFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("------销毁---------");
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain filterChain)
			throws IOException, ServletException {
		// 设置字符编码集
		req.setCharacterEncoding("utf-8");
		filterChain.doFilter(req, res);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("------初始化--------");
		
	}

}
