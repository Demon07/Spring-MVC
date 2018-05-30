package com.example.demo.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Configuration {
	
	@Bean
	public Docket buildDocket() {
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(buildApiInf())
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo"))
				.paths(PathSelectors.any())
				.build();
		
	}

	private ApiInfo buildApiInf() {
		return new ApiInfoBuilder()
				.title("接口文档")
				.description("前端人员参照此文档进行开发")
				.termsOfServiceUrl("http://tech.taiji.com.cn/space/lpc")
				.contact(new Contact("lpc", "http://tech.taiji.com.cn/space/lpc", "747576536@qq.com"))
				.build();
	}

}
