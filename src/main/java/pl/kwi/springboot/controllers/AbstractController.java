package pl.kwi.springboot.controllers;

import javax.servlet.http.HttpServletRequest;

import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public abstract class AbstractController {
	
	@ModelAttribute("userName")
    public String getKeycloakUserName(HttpServletRequest request) {
		return ((KeycloakAuthenticationToken) request.getUserPrincipal()).getAccount().getKeycloakSecurityContext().getToken().getPreferredUsername();
    }

}
