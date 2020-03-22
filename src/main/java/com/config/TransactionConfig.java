package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * @Description: 和事务相关配置类
 * @author: HandSomeMaker
 * @date: 2020/3/22 18:06
 */
public class TransactionConfig {
    /**
     * 用于创建事务管理对象
     * @param dataSource
     * @return
     */
    @Bean(name = "platformTransactionManager")
    public PlatformTransactionManager createTransactionManger(DataSource dataSource){
        return new DataSourceTransactionManager(dataSource);
    }
}
