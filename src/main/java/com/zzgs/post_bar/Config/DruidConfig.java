package com.zzgs.post_bar.Config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Author:   Tang
 * Date:     2019/12/29 12:32
 * Description: druid配置类
 */
@Configuration
public class DruidConfig {

    /**
     * 配置druid
     * @return
     */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }
}
