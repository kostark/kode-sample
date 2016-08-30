package kode.boot.testjar.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 基础服务
 *
 * @version 1.0
 * @since 2016/8/30
 */
public class AppBaseService {
	protected final Logger logger;

	public AppBaseService() {
		logger = LoggerFactory.getLogger(this.getClass());
	}
}
