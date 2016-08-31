package kode.boot.testjar.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.*;

/**
 * 自定义安全信息数据元。
 * 提供某个资源对应的权限定义，即 getAttributes 方法返回的结果。
 * 此类在初始化时，应该取到所有资源及其对应角色的定义。
 *
 * @author Stark
 * @since 1.0
 */
@Component
public class CustomFilterSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	private AntPathMatcher urlMatcher = new AntPathMatcher();

	private static Map<String, Collection<ConfigAttribute>> resourceMap = new LinkedHashMap<>();

	public CustomFilterSecurityMetadataSource() {
		logger.debug("===== CustomSecurityMetadataSource.<init>");
		loadResource();
		logger.debug("===== 初始化资源文件映射");
	}

	@Override
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		// object 是一个URL，被用户请求的url。
		String url = ((FilterInvocation) object).getRequestUrl();

		int firstQuestionMarkIndex = url.indexOf("?");
		if (firstQuestionMarkIndex != -1) {
			url = url.substring(0, firstQuestionMarkIndex);
		}

		for (String resURL : resourceMap.keySet()) {
			if (urlMatcher.match(url, resURL)) {
				return resourceMap.get(resURL);
			}
		}

		return Collections.emptyList();
	}

	@Override
	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return resourceMap.values().stream().reduce(new ArrayList<>(), (a, b) -> {
			b.addAll(a);
			return b;
		});
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	private void loadResource() {

	}
}
