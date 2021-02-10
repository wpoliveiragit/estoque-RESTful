package br.com.wellington.estoque.swagger;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import br.com.wellington.estoque.BaseProdutoApplication;
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
public class swaggerConfig {

	@Bean
	public Docket productApi() {
		
		System.out.println(BaseProdutoApplication.class.getPackageName());
		System.out.println(BaseProdutoApplication.class.getPackage());
		
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				//.apis(RequestHandlerSelectors.any())//qualquer base de pacote
				.apis(RequestHandlerSelectors.basePackage(BaseProdutoApplication.class.getPackageName()))
				.paths(Predicates.not(PathSelectors.regex("/error.*")))
				//.paths(PathSelectors.any())//permite todos os endpoints
				.paths(regex("/estoque.*"))//permite todos ester endpoints
				.build()
				.apiInfo(createApiInfo());
		
	}
	
	private ApiInfo createApiInfo() {
		return new ApiInfoBuilder()
				.title("Teste de projeto Spring boot")// titulo da documentacao
				.description("Controle de cadastro")// Descricao da documentacao
				.version("1.0")// A versão da documentacao
				.termsOfServiceUrl("https://www.meusite.com.br/termosdeServico")// Urs dos termos de servisoda aplicacao
				.license("GPL Software livre: Entre em contato para entender nossos termos de uso")// licensa de distribuicao do projeto
				.licenseUrl(ApiInfo.DEFAULT.getLicenseUrl())
				.extensions(ApiInfo.DEFAULT.getVendorExtensions())
				.contact(createContact())
				.build();
	}
	
	private Contact createContact() {
		return new Contact(
				"Wellington Pires de Oliveira", // Nome da organizacaoque criou a documentacao
				"https://www.meusite.com.br", // URL da organizacao
				"wp_oliveira@yahoo.com.br");// e-mail de contato da organizacao
	}

}
