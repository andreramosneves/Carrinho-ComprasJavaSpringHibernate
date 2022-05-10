package org.com.br.configuration;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = "org.com.br")
//@PropertySource(value = { "classpath:application.properties" })
@EnableWebMvc
public class AppConfiguration extends WebMvcConfigurerAdapterr{

	
    @Bean
    public ViewResolver jspViewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setViewClass(JstlView.class);
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }	
}
