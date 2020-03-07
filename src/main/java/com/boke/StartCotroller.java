package com.boke;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.bind.annotation.RestController;


@RestController
@MapperScan("com.boke.mapper") //实现自动接口映射
@SpringBootApplication
public class StartCotroller extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
		return application.sources(StartCotroller.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(StartCotroller.class, args);
	}
}
