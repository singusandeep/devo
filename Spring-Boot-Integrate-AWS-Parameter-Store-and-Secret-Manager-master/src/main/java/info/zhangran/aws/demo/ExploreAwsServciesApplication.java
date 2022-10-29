package info.zhangran.aws.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;


@SpringBootApplication
@EnableSwagger2
public class ExploreAwsServciesApplication {

  public static void main(String[] args) {
    SpringApplication.run(ExploreAwsServciesApplication.class, args);
  }


  @Bean
  public Docket swaggerConfiguration() {
    return new Docket(DocumentationType.SWAGGER_2)
            .select()
            .paths(PathSelectors.any())
            .apis(RequestHandlerSelectors.basePackage("info.zhangran.aws.demo"))
            .build()
            .apiInfo(ApiDetails());
  }

  private ApiInfo ApiDetails() {
    return new ApiInfo(
            "Devops Api",
            "Api for first Project",
            "1.0",
            "Free to use",
            new springfox.documentation.service.Contact("sandeep singu", "", "Sandysingu@16gmail.com"),
            "Api License",
            "http://localhost:3000",
            Collections.emptyList());

  }
}