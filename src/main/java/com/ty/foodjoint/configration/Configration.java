package com.ty.foodjoint.configration;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Configration {
	@Bean
	public Docket getDocket() {

		springfox.documentation.service.Contact contact = new springfox.documentation.service.Contact("Alpha Team",
				"www.google", "google@gmail.com");
		List<VendorExtension> extensions = new ArrayList<VendorExtension>();
		ApiInfo info = new ApiInfo("Food joint api", "----------", "ty-1.01", "https://tedtyantra.com", contact, "gt",
				" http://localhost:8080/swagger-ui.html", extensions);
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ty.foodjoint")).build().apiInfo(info)
				.useDefaultResponseMessages(false);
	}

}
