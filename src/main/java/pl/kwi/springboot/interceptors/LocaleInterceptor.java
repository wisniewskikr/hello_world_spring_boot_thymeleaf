package pl.kwi.springboot.interceptors;

import org.apache.commons.lang3.LocaleUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

import static org.apache.commons.lang3.StringUtils.defaultString;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LocaleInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
    	
    	String loc = getLocaleFromPath(request); 
    	if (loc == null) {
    		return true;
    	}
    	
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
        if (localeResolver == null) {
            throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
        }
        localeResolver.setLocale(request, response, StringUtils.parseLocaleString(loc));
        
        // Proceed in any case.
        return true;
    }
    
    private String getLocaleFromPath(HttpServletRequest request) {
    	
    	String loc = null;
    	
    	String url = defaultString(request.getRequestURI().substring(request.getContextPath().length()));
        String[] variables = url.split("/");

        if (variables.length > 2 && isLocale(variables[1])) {
        	loc = variables[1];
        } 
        
        return loc;
    	
    }
    
    private boolean isLocale(String locale) {
        //validate the string here against an accepted list of locales or whatever
        try {
            Locale parsedLocale = LocaleUtils.toLocale(locale);
            return LocaleUtils.isAvailableLocale(parsedLocale);
        } catch (IllegalArgumentException e) {
        }
        return false;
    }
    
}