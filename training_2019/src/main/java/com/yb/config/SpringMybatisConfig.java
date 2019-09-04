package com.yb.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.yb.dao.DaoMark;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * @author Jue-PC
 */
@Configuration
@PropertySource({"classpath:jdbc/jdbc.properties"})
@EnableTransactionManagement
@MapperScan(basePackageClasses = {DaoMark.class})
public class SpringMybatisConfig {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.url}")
    private String url;

    @Value("${jdbc.username}")
    private String username;

    @Value("${jdbc.password}")
    private String password;

    @Value("${druid.minIdle}")
    private int minIdle;

    @Value("${druid.maxActive}")
    private int maxActive;

    @Value("${druid.initialSize}")
    private int initialSize;

    @Value("${druid.maxWait}")
    private int maxWait;

    @Value("${druid.logAbandoned}")
    private boolean logAbandoned;

    @Value("${druid.removeAbandoned}")
    private boolean removeAbandoned;

    @Bean
    public DataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setMinIdle(minIdle);
        dataSource.setMaxActive(maxActive);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxWait(maxWait);
        dataSource.setLogAbandoned(logAbandoned);
        dataSource.setRemoveAbandoned(removeAbandoned);
        return dataSource;
    }

    @Bean
    public SqlSessionFactoryBean sessionFactory(DataSource dataSource) throws Exception {
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setTypeAliasesPackage("com.yb.entity");
        sessionFactory.setConfigLocation(resolver.getResource("mybatis/mybatis-cfg.xml"));
        sessionFactory.setMapperLocations(resolver.getResources("mapper/*.xml"));
        return sessionFactory;
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
}
