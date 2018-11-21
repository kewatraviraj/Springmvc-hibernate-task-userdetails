/**
 * 
 */
package org.springmvchibernate.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

/**
 * @author Dell
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="org.springmvchibernate")
public class WebMvcConfig implements WebMvcConfigurer {
	
	@Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.freeMarker();
    }
	
	@Bean 
	public static final FreeMarkerConfigurer freemarkerConfig() { 
	    FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer(); 
	    freeMarkerConfigurer.setTemplateLoaderPath("/");
	    return freeMarkerConfigurer; 
	}
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
          .addResourceHandler("/**")
          .addResourceLocations("/");
    }
	
	@Bean
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver resolver=new CommonsMultipartResolver();
	    resolver.setDefaultEncoding("utf-8");
	    return resolver;
	}
	
	/*@Bean
	public MessageSource messageSource() {
      ResourceBundleMessageSource source = new ResourceBundleMessageSource();
      source.setBasename("messages");
      return source;
	}
 
   @Override
   public Validator getValidator() {
      LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
      validator.setValidationMessageSource(messageSource());
      return validator;
   }*/
}
