package kode.boot.testjar.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.SecurityMetadataSource;
import org.springframework.security.access.intercept.AbstractSecurityInterceptor;
import org.springframework.security.access.intercept.InterceptorStatusToken;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import javax.servlet.*;
import java.io.IOException;

/**
 * 自定义权限拦截器，该过滤器的主要作用就是通过 spring 著名的 IOC 生成 securityMetadataSource。
 * securityMetadataSource 相当于本包中自定义的 CustomSecurityMetadataSource。
 * 该 CustomSecurityMetadataSource 的作用提从数据库提取权限和资源，装配到HashMap中，
 * 供 Spring Security 使用，用于权限校验。
 *
 * @author Stark
 * @since 1.0
 */
public class CustomFilterSecurityInterceptor extends AbstractSecurityInterceptor implements Filter {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	private FilterInvocationSecurityMetadataSource securityMetadataSource;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		logger.debug("===== CustomSecurityInterceptor.init");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		logger.debug("===== CustomSecurityInterceptor.doFilter() ===== 开始拦截了");
		FilterInvocation fi = new FilterInvocation(request, response, chain);

		logger.debug("===== 用户发送请求！");
		InterceptorStatusToken token = super.beforeInvocation(fi);

		try {
			fi.getChain().doFilter(fi.getRequest(), fi.getResponse());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			super.afterInvocation(token, null);
		}

		logger.debug("===== MyFilterSecurityInterceptor.doFilter() ===== 拦截结束了");
	}

	@Override
	public void destroy() {
	}

	@Override
	public Class<?> getSecureObjectClass() {
		return FilterInvocation.class;
	}

	public FilterInvocationSecurityMetadataSource getSecurityMetadataSource() {
		return securityMetadataSource;
	}

	public void setSecurityMetadataSource(FilterInvocationSecurityMetadataSource securityMetadataSource) {
		this.securityMetadataSource = securityMetadataSource;
	}

	@Override
	public SecurityMetadataSource obtainSecurityMetadataSource() {
		return this.securityMetadataSource;
	}
}
