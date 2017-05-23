package pl.kwi.springboot.services;

import java.util.Locale;

import org.apache.commons.lang3.LocaleUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
	
	@Autowired
	private MessageSource messageSource;
	
	public String getMessage(String name, String loc) {
		Locale locale = LocaleUtils.toLocale(loc);
		return messageSource.getMessage(name, null, locale);
	}

}
