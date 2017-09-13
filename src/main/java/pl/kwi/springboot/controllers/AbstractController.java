package pl.kwi.springboot.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class AbstractController {
	
	@ModelAttribute("userName")
    public String getKeycloakUserName(HttpServletRequest request) {
		return request.getUserPrincipal().getName();
    }

}
