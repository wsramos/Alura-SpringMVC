package br.com.alura.mvc.mudi;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JSONPrettyPrintConfig {

	@Bean
	 public Jackson2ObjectMapperBuilderCustomizer customJson() {
	     return builder -> builder.indentOutput(true);
	 }
}