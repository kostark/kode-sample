package kode.boot.testjar.config;

import kode.boot.testjar.security.CustomAccessDecisionManager;
import kode.boot.testjar.security.CustomFilterSecurityInterceptor;
import kode.boot.testjar.security.CustomFilterSecurityMetadataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.intercept.RunAsManager;
import org.springframework.security.access.intercept.RunAsManagerImpl;
import org.springframework.security.access.vote.RoleVoter;
import org.springframework.security.authentication.dao.ReflectionSaltSource;
import org.springframework.security.authentication.dao.SaltSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.expression.WebExpressionVoter;

import java.util.ArrayList;
import java.util.List;

/**
 * 安全信息配置
 * Created by Stark on 2016/8/16.
 *
 * @author Stark
 * @since 1.0
 */
@Configuration
@EnableWebSecurity // 开启安全验证
@EnableGlobalMethodSecurity(prePostEnabled = true, jsr250Enabled = true, securedEnabled = true) // 开启全局方法安全验证
public class SecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;


	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// @formatter:off
		//auth.inMemoryAuthentication().withUser("u").password("p");
		auth.userDetailsService(userDetailsService);
		// @formatter:on
	}

	@Bean
	public CustomAccessDecisionManager accessDecisionManager() throws Exception {
		List<AccessDecisionVoter<? extends Object>> voters = new ArrayList<>();
		voters.add(new WebExpressionVoter());
		voters.add(new RoleVoter());
		CustomAccessDecisionManager manager = new CustomAccessDecisionManager(voters);
		manager.setAllowIfAllAbstainDecisions(false);
		manager.afterPropertiesSet();

		return manager;
	}

//	@Bean
//	public CustomFilterSecurityInterceptor securityInterceptor() throws Exception {
//		CustomFilterSecurityInterceptor interceptor = new CustomFilterSecurityInterceptor();
//		interceptor.setAccessDecisionManager(accessDecisionManager());
//		interceptor.setAuthenticationManager(authenticationManager());
//		interceptor.setSecurityMetadataSource(securityMetadataSource());
//		interceptor.setRunAsManager(runAsManager());
//		interceptor.afterPropertiesSet();
//
//		return interceptor;
//	}

	@Bean
	public CustomFilterSecurityMetadataSource securityMetadataSource() {
		return new CustomFilterSecurityMetadataSource();
	}

	@Bean
	public RunAsManager runAsManager() throws Exception {
		RunAsManagerImpl runAsManager = new RunAsManagerImpl();
		runAsManager.setKey("V_RUN_AS");
		runAsManager.afterPropertiesSet();
		return runAsManager;
	}

	@Bean
	public SaltSource saltSource() throws Exception {
		ReflectionSaltSource saltSource = new ReflectionSaltSource();
		saltSource.setUserPropertyToUse("salt");
		saltSource.afterPropertiesSet();
		return saltSource;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	/**
	 * Api 调用安全设置
	 */
	@Configuration
	@Order(1)
	public static class ApiSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {
			http
					.antMatcher("/api/**")
					.authorizeRequests()
					.anyRequest().hasRole("ADMIN")
					.and()
					.httpBasic();
		}
	}

	/**
	 * 普通请求安全设置
	 */
	@Configuration // no @Order defaults to last
	public static class FormWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

		@Override
		public void configure(WebSecurity web) throws Exception {
			// 开启调试信息
			// web.debug(true);

			// 过滤对应匹配路径下的请求，优于 HttpSecurity 中用拦截路径来过滤
			web.ignoring().antMatchers("/webjars/**",
					"/resources/**",
					"/static/**",
					"/**/*.ico");
		}

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			// 该方法用来配置 HttpSecurity，不要调用 super.configure(http)，否则有可能覆盖自定义配置

			// 首行引入对应过滤器，缩进进行配置
			// @formatter:off
			http
					//关闭 csrf（跨站点请求伪造保护） 支持
					.csrf()
					.disable()

//					.addFilterBefore(securityInterceptor(), FilterSecurityInterceptor.class)

                /*
				.antMatcher("")
                .requestMatchers()
                    .antMatchers("")
                .and()
                */


					// 请求授权
					.authorizeRequests()
//					.accessDecisionManager(accessDecisionManager())
//                    .antMatchers("/", "/home", "/test").permitAll()
					.anyRequest().authenticated()
					.expressionHandler(null)


					// form 登陆，必须保证登陆页面
					.and().formLogin()
					.loginPage("/login").permitAll()

					.and().exceptionHandling()
					.accessDeniedPage("/access_denied")

					// 退出过滤器
					.and().logout()
					.permitAll()

					// 开启记住登陆
					.and().rememberMe()

					// 要求特定通道
					.and().requiresChannel()
					.anyRequest().requiresSecure()

					// 配置端口隐射
					.and().portMapper()
					.http(8080).mapsTo(8443)
					.http(80).mapsTo(443)

					// session 管理
					.and().sessionManagement()
					.maximumSessions(1);

			// @formatter:on
		}
	}
}
