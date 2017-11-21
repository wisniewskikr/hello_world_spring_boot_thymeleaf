package pl.kwi.springboot.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
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
	        System.err.println("AddUser: error adding entry." + e);  
	    }
	    
	    return uid;
	    
	}
	
	public String load(String uid){
		String searchFilter = getSearchFilter("uid", uid);
		List<String> attributes = getFilteredAttributesByKey(searchFilter, "sn");
		
		if(attributes.isEmpty()){
			return null;
		}
		
		return attributes.get(0);
	}
	
	
	// ************ HELP METHODS *************** //
    
	
    private List<String> getFilteredAttributesByKey(String searchFilter, String attributeKey) {
    	
    	List<String> result = new ArrayList<String>();
        
        try {
        	           
            SearchControls searchCtls = getSearchControls(attributeKey);
            NamingEnumeration<SearchResult> answer = ldapContext.search(LDAP_DN, searchFilter, searchCtls);

            while (answer.hasMoreElements()) {
                SearchResult sr = answer.next();
                NamingEnumeration<? extends Attribute> allAttributes = sr.getAttributes().getAll();
                while (allAttributes.hasMoreElements()) {
                    Attribute attribute = allAttributes.next();
                    for (int i = 0; i < attribute.size(); i++) {
                        result.add(attribute.get(i).toString());
                    }
                }
            }
            
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return result;

    }
    
    private String getSearchFilter(String filterKey, String filterValue) {
    	
    	StringBuilder sb = new StringBuilder();
    	sb.append("(");
    	sb.append(filterKey);
    	sb.append("=");
    	sb.append(filterValue);
    	sb.append(")");
    	
        return sb.toString();
    	
    }
    
    private SearchControls getSearchControls(String attributeKey){
    	
    	String returnedAtts[] = { attributeKey };
    	
        SearchControls searchCtls = new SearchControls();
        searchCtls.setSearchScope(SearchControls.SUBTREE_SCOPE);
        searchCtls.setReturningAttributes(returnedAtts);
        
        return searchCtls;
    	
    }

}
