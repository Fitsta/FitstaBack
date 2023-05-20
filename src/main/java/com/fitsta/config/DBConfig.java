package com.fitsta.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(basePackages = "com.fitsta.model.dao")
public class DBConfig {

}
