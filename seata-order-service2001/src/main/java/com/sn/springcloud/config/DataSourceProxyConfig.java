package com.sn.springcloud.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
/**
 * @Author: shinan
 * @Version: 1.8
 * @create: 2020/11/25 20:05
 * @Description: 这个是配置使用 seata 管理数据源，所以必须配置
 */
@Configuration
public class DataSourceProxyConfig {

    /**
     * 从配置文件中获取  指定的mapper.xml文件的位置
     */
    @Value("${mybatis.mapperLocations}")
    private String mapperLocations;

    /**
     *
     * @return 获取一个数据源
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    /**
     *
     * @param dataSource 数据源
     * @return  返回一个数据源的动态代理 io.seata.rm.datasource.DataSourceProxy 即将数据源交个seata来管理
     */
    @Bean
    public DataSourceProxy dataSourceProxy(DataSource dataSource){
        return new DataSourceProxy(dataSource);
    }

    /**
     * 为dataSourceProxy创建一个SqlSessionFactory
     * @param dataSourceProxy 创建的数据源代理对象 由seata管理
     * @return 返回一个SqlSessionFactory
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DataSourceProxy dataSourceProxy) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSourceProxy);
        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(mapperLocations));
        sqlSessionFactoryBean.setTransactionFactory(new SpringManagedTransactionFactory());
        return sqlSessionFactoryBean.getObject();
    }
}