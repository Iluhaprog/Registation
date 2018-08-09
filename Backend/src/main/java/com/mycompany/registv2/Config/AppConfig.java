package com.mycompany.registv2.Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration 
@ComponentScan(basePackages = "com.mycompany.registv2") 
@EnableWebMvc
public class AppConfig {
}
