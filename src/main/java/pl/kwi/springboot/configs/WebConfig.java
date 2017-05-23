package pl.kwi.springboot.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;

import pl.kwi.springboot.interceptors.LocaleInterceptor;


@Configuration
public class WebConfig  extends WebMvcConfigurerAdapter {
	
	@Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LocaleInterceptor());
    }
	
	@Bean
    public ReloadableResourceBundleMessageSource messageSource() {
        ReloadableResourceBundleMessageSource resourceBundleMessageSource = new ReloadableResourceBundleMessageSource();
        resourceBundleMessageSource.setBasenames("classpath:props/locale");
        return resourceBundleMessageSource;
    }	
	
	@Bean(name = "localeResolver")
    public LocaleResolver getLocaleResolver() {
        return new CookieLocaleResolver();
    }
	
	@Bean
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean validator = new LocalValidatorFactoryBean();
		validator.setValidationMessageSource(messageSource());
		return validator;
	}

}