package kode.boot.testjar.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.Map;

/**
 * Created by Stark on 2016/8/28.
 *
 * @author Stark
 * @since 1.0
 */
public class CustomSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    protected Logger logger = LoggerFactory.getLogger(getClass());

    private AntPathMatcher urlMatcher = new AntPathMatcher();

    private static Map<String, Collection<ConfigAttribute>> resourceMap = null;


    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }
}
