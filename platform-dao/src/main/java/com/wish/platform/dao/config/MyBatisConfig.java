package com.wish.platform.dao.config;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by fqh on 16-4-17.
 */
@Configuration
public class MyBatisConfig {
    
    public MyBatisConfig() {
    }

    private String url;
    private String username;
    private String password;

    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);

        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();

        sqlSessionFactoryBean.setMapperLocations(resolver.getResources("classpath:/mapper/*/*Mapper.xml"));

        Interceptor[] plugins = new Interceptor[]{pageHelper()};
        sqlSessionFactoryBean.setPlugins(plugins);

        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "dataSource", destroyMethod = "close")
    @Scope(value = BeanDefinition.SCOPE_SINGLETON)
    @Primary
    public DataSource dataSource() {
        HikariConfig hikariConfig = new HikariConfig();
        hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
        hikariConfig.setJdbcUrl(url);
        hikariConfig.setUsername(username);
        hikariConfig.setPassword(password);
        hikariConfig.setPoolName("springHikariCP");
        hikariConfig.setAutoCommit(false);
        hikariConfig.addDataSourceProperty("cachePrepStmts", "true");
        hikariConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        hikariConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        hikariConfig.addDataSourceProperty("useServerPrepStmts", "true");

        hikariConfig.setMinimumIdle(5);
        hikariConfig.setMaximumPoolSize(10);
        hikariConfig.setConnectionInitSql("SELECT 1");

        HikariDataSource dataSource = new HikariDataSource(hikariConfig);
        return dataSource;
    }

    //注册MyBatis分页插件PageHelper
    public PageHelper pageHelper() {
        System.out.println("MyBatisConfiguration.pageHelper()");
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        p.setProperty("offsetAsPageNum", "true");
        p.setProperty("rowBoundsWithCount", "true");
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }

    /**
     * 配置事务管理器
     */
    @Bean
    @Primary
    public DataSourceTransactionManager transactionManager(DataSource dataSource) throws Exception {
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        dataSourceTransactionManager.setRollbackOnCommitFailure(true);
        return dataSourceTransactionManager;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
