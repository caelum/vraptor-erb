package br.com.caelum.vraptor.erb;

import java.io.IOException;
import java.util.Map;

import javax.script.ScriptException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(filterName = "erb", urlPatterns="*.erb")
public class ErbFilter implements Filter{

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
		String uri = request.getRequestURI();
		if(uri.startsWith("/")) {
			uri = uri.substring(1, uri.length());
		}
		try {
			new Erb().render(uri, getAttributes(request));
		} catch (ScriptException e) {
			throw new ServletException(e);
		}
	}

	private Map<String, Object> getAttributes(HttpServletRequest request) {
		return null;
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}

