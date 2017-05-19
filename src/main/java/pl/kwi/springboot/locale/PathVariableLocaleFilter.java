package pl.kwi.springboot.locale;

import static pl.kwi.springboot.locale.LocaleAttributeChangeInterceptor.LOCALE_ATTRIBUTE_NAME;
import static org.apache.commons.lang3.StringUtils.defaultString;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.LocaleUtils;
import org.springframework.web.filter.OncePerRequestFilter;

public class PathVariableLocaleFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String url = defaultString(request.getRequestURI().substring(request.getContextPath().length()));
        String[] variables = url.split("/");

        if (variables.length > 2 && isLocale(variables[1])) {
            request.setAttribute(LOCALE_ATTRIBUTE_NAME, variables[1]);
        }
        filterChain.doFilter(request, response);
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