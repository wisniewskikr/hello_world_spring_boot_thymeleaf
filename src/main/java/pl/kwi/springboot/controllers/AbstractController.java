package pl.kwi.springboot.controllers;

import javax.servlet.http.HttpServletRequest;

import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AbstractController {
	
	@SuppressWarnings("unchecked")
	@ModelAttribute("userName")
    public String getKeycloakUserName(HttpServletRequest request) {
		KeycloakPrincipal<KeycloakSecurityContext> principal = (KeycloakPrincipal<KeycloakSecurityContext>) request.getUserPrincipal();
		return principal.getKeycloakSecurityContext().getToken().getPreferredUsername();
    }

}
