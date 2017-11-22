package pl.kwi.springboot.services;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.BasicAttribute;
import javax.naming.directory.BasicAttributes;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import org.springframework.stereotype.Service;

@Service
public class LdapService {
	
	private static final String LDAP_URL = "ldap://localhost:389";
	private static final String LDAP_USER = "cn=Manager,dc=maxcrc,dc=com";	
	private static final String LDAP_PASSWORD = "secret";
	private static final String LDAP_DN = "dc=maxcrc,dc=com";
	private LdapContext ldapContext;
	
	public LdapService(){
		
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
		
	}
	
	public String save(String name) {
		
		String uid = name.toLowerCase();
		
        // entry's DN 
		String entryDN = String.format("uid=%s,ou=People,dc=maxcrc,dc=com", uid);  
	
	    // entry's attributes  	
		Attribute cn = new BasicAttribute("cn", name); 
		Attribute sn = new BasicAttribute("sn", name);  
	    Attribute oc = new BasicAttribute("objectClass");  
	    oc.add("top");  
	    oc.add("person");  
	    oc.add("organizationalPerson");  
	    oc.add("inetOrgPerson");  
	
	    try {  

	    	BasicAttributes entry = new BasicAttributes();  
	    	entry.put(cn);
	    	entry.put(sn);  
	        entry.put(oc);  
	        ldapContext.createSubcontext(entryDN, entry);  
	
	    } catch (NamingException e) {  
	        System.err.println("save: error adding entry." + e);  
	    }
	    
	    return uid;
	    
	}
	
	public String load(String uid){
		
		String result = null;
		
		//filter
		String filter = String.format("(uid=%s)", uid);
		
		// search controls
		SearchControls sc = new SearchControls();
	    String[] attributeFilter = { "cn" };
	    sc.setReturningAttributes(attributeFilter);
	    sc.setSearchScope(SearchControls.SUBTREE_SCOPE);
	    
	    try {
			NamingEnumeration<SearchResult> results = ldapContext.search(LDAP_DN, filter, sc);
			while (results.hasMore()) {
			      SearchResult sr = results.next();
			      Attributes attrs = sr.getAttributes();
			      result = (String)attrs.get("cn").get();
			    }
		} catch (NamingException e) {
			System.err.println("load: error reading entry." + e);
		}
	    
	    return result;
	
	}

}
