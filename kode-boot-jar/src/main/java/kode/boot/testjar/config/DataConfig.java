package kode.boot.testjar.config;

import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @since 2016/7/7
 */
@Configuration
//@MapperScan("kode.boot.testjar.mapper")
public class DataConfig {

/*	@Bean
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}

	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource());
		bean.setTypeAliasesPackage("kode.boot.testjar.domain");

		//配置 mapper.xml 文件的加载
		ResourcePatternResolver rpr = new PathMatchingResourcePatternResolver();
		Resource[] resources = rpr.getResources("classpath:mapper*//*.xml");
		bean.setMapperLocations(resources);
		return bean;
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}*/
}
