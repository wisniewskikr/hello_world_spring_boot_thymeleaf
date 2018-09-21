package pl.kwi.springboot.interceptors;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LocaleInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    	
    	LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
    	Locale locale = localeResolver.resolveLocale(request);
    	if (!"en_US".equals(locale.toString()) && !"pl_PL".equals(locale.toString())) {
    		localeResolver.setLocale(request, response, StringUtils.parseLocaleString("en_US"));
    	}
        
        // Proceed in any case.
        return true;
    }
    

    
}