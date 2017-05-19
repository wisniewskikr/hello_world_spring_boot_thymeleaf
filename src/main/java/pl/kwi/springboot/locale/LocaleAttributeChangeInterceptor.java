package pl.kwi.springboot.locale;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LocaleAttributeChangeInterceptor extends HandlerInterceptorAdapter {

    public static final String LOCALE_ATTRIBUTE_NAME = LocaleAttributeChangeInterceptor.class.getName() + ".LOCALE";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

        Object newLocale = request.getAttribute(LOCALE_ATTRIBUTE_NAME);
        if (newLocale != null) {
            LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
            if (localeResolver == null) {
                throw new IllegalStateException("No LocaleResolver found: not in a DispatcherServlet request?");
            }
            localeResolver.setLocale(request, response, StringUtils.parseLocaleString(newLocale.toString()));
        }
        // Proceed in any case.
        return true;
    }
}