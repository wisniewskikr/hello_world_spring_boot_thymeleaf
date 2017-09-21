package pl.kwi.springboot.controllers;

import javax.servlet.http.HttpServletRequest;

import org.opensaml.saml2.core.impl.NameIDImpl;
import org.springframework.security.providers.ExpiringUsernameAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public abstract class AbstractController {
	
	@ModelAttribute("userName")
    public String getKeycloakUserName(HttpServletRequest request) {
		ExpiringUsernameAuthenticationToken value = ((ExpiringUsernameAuthenticationToken)request.getUserPrincipal());
		NameIDImpl principal = (NameIDImpl)value.getPrincipal();
		return principal.getValue();
    }

}
