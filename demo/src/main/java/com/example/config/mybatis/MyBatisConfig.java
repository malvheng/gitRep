package com.example.config.mybatis;

import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import com.github.pagehelper.PageHelper;

@Configuration  
@MapperScan(basePackages={"com.example.mapper"})
@EnableTransactionManagement
public class MyBatisConfig implements TransactionManagementConfigurer{
	@Resource(name="druidDataSource")  
    private DataSource dataSource;
  
    @Bean(name = "sqlSessionFactory")  
    public SqlSessionFactory sqlSessionFactoryBean() {  
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();  
        bean.setDataSource(dataSource);
  
        //分页插件  
        PageHelper pageHelper = new PageHelper();  
        Properties properties = new Properties();  
        properties.setProperty("reasonable", "true");  
        properties.setProperty("supportMethodsArguments", "true");  
        properties.setProperty("returnPageInfo", "check");  
        properties.setProperty("params", "count=countSql");  
        pageHelper.setProperties(properties);  
  
        //添加插件  
        bean.setPlugins(new Interceptor[]{pageHelper});  
  
        //添加XML目录  
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();  
        try {  
            bean.setMapperLocations(resolver.getResources("classpath:mybatis/*.xml"));  
            return bean.getObject();  
        } catch (Exception e) {  
            e.printStackTrace();  
            throw new RuntimeException(e);  
        }  
    }  
  
    @Bean  
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {  
        return new SqlSessionTemplate(sqlSessionFactory);  
    }  
  
    @Bean  
    @Override  
    public PlatformTransactionManager annotationDrivenTransactionManager() {  
        return new DataSourceTransactionManager(dataSource);  
    }  
}