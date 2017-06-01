package com.qf.farmer.client.config;
import org.springframework.context.annotation.Configuration;  
import org.springframework.context.annotation.ImportResource;  
import org.springframework.context.annotation.PropertySource;  

/**
 * 注意配置文件不能有空格,
 * @author qinfei
 *
 */
@Configuration  
@PropertySource("classpath:config/dubbo.properties")  
@ImportResource({ "classpath:config/dubbo-consume.xml" })  
public class DubboConfig {  
  
} 