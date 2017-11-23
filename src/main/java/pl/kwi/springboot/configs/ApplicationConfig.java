package pl.kwi.springboot.configs;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.naming.Context;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	
	private static final String LDAP_URL = "ldap://localhost:389";
	private static final String LDAP_USER = "cn=Manager,dc=maxcrc,dc=com";	
	private static final String LDAP_PASSWORD = "secret";
	
	@Bean
	public LdapContext ldapContext() {
		
		LdapContext ldapContext = null;
		
		try {
			
			Map<String, String> map = new HashMap<String, String>();	        
			map.put(Context.SECURITY_AUTHENTICATION, "simple");
			map.put(Context.PROVIDER_URL, LDAP_URL);
			map.put(Context.SECURITY_PRINCIPAL, LDAP_USER);
			map.put(Context.SECURITY_CREDENTIALS, LDAP_PASSWORD);
			map.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
	        
	        ldapContext = new InitialLdapContext(
	                new Hashtable<String, String>(map), null);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return ldapContext;
		
	}

}
