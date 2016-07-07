package kode.boot.testjar.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @version 1.0
 * @since 2016/7/7
 */
@Component
@ConfigurationProperties(prefix = "environments")
public class DevelopmentConfig {
	private UrlConfig dev;
	private UrlConfig prod;

	public UrlConfig getDev() {
		return dev;
	}

	public void setDev(UrlConfig dev) {
		this.dev = dev;
	}

	public UrlConfig getProd() {
		return prod;
	}

	public void setProd(UrlConfig prod) {
		this.prod = prod;
	}

	public static class UrlConfig {
		private String name;
		private List<String> url;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<String> getUrl() {
			return url;
		}

		public void setUrl(List<String> url) {
			this.url = url;
		}
	}
}
