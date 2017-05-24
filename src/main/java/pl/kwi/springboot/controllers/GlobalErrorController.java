package pl.kwi.springboot.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class GlobalErrorController implements ErrorController{
	
	
	private static final String ERROR_PATH = "/error";
	
	
	@RequestMapping(value = ERROR_PATH)
    public String handleException(HttpServletRequest request, HttpServletResponse response, Model model){
		
		return "globalError";
		
	}
	
	@RequestMapping(value="/error/handle-button-ok", method=RequestMethod.POST)
	public String handleButtonOk() {
		
		return "redirect:/";
		
	}

	@Override
	public String getErrorPath() {
		return ERROR_PATH;
	}
	

}
