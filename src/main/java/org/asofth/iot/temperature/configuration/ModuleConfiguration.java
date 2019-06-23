package org.asofth.iot.temperature.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableConfigurationProperties
@ComponentScan(basePackages = { ModuleConfiguration.BASE_PACKAGE })
@EnableAutoConfiguration
@EnableSwagger2
@EnableScheduling
//@EnableMongoRepositories(basePackageClasses = DividaClienteRepository.class)
public class ModuleConfiguration {

	public static final String BASE_PACKAGE = "org.asofth.iot.temperature";

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("Template")
				.select()
				.apis(RequestHandlerSelectors
						.basePackage(BASE_PACKAGE))
				.paths(PathSelectors.any()).build().apiInfo(apiInfoGeral());
	}

	private ApiInfo apiInfoGeral() {
		return new ApiInfoBuilder().title("Listener temperatura e humidade")
				.description("")
				.version("Versão 1.0")
				.contact(new Contact("Empresa", "https://site.org.br", "desenvolvimento@empresa.org"))
				.build();

	}

}
