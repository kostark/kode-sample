package kode.boot.testjar.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Stark
 * @since 1.0, 2016/7/24
 */
@ConfigurationProperties(locations = "classpath:config.yml", prefix = "jdbc")
public class DruidConfig {

	private String driver;
	private String url;
	private String user;
	private String password;

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
