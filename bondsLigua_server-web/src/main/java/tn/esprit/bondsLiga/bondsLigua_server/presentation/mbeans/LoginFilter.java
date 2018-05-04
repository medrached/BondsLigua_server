package tn.esprit.bondsLiga.bondsLigua_server.presentation.mbeans;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebFilter(urlPatterns={"/Omid/about.jsf","/Omid/pricing.jsf","/Omid/portfolio2.jsf","/Omid/portfolio1.jsf","/Omid/services.jsf"})
public class LoginFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
	
		HttpServletRequest serveletRequest=(HttpServletRequest) request;
		HttpServletResponse serveletResponse=(HttpServletResponse) response;
		UserBean userBean =(UserBean) serveletRequest.getSession().getAttribute("userBean");
		if((userBean!=null&& userBean.isLoggedIn())||serveletRequest.getRequestURL().toString().contains("login.jsf"))
		{
			chain.doFilter(serveletRequest, serveletResponse);
			
			
		}
		else
		{
			serveletResponse.sendRedirect(serveletRequest.getContextPath()+"/Omid/login.jsf");
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
