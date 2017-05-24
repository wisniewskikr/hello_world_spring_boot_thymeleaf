package pl.kwi.springboot.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;


@Controller
public class GlobalErrorController implements ErrorController{
	
	
	private static final String ERROR_PATH = "/error";
	private static final String TRACE = "trace";
	private static final String MESSAGE = "message";
	private static final String ERROR = "error";
	private static final String TIMESTAMP = "timestamp";
	
	
	@Autowired
    private ErrorAttributes errorAttributes;
	
	
	@RequestMapping(value = ERROR_PATH)
    public String handleException(HttpServletRequest request, HttpServletResponse response){
		
		displayErrorInConsole(request, response);
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
	
	private void displayErrorInConsole(HttpServletRequest request, HttpServletResponse response) {
		
		Map<String, Object> errorAttributes = getErrorAttributes(request, true);
		System.out.println("Timestamp: " + errorAttributes.get(TIMESTAMP).toString());
		System.out.println("Status: " + response.getStatus());
		System.out.println("Error: " + errorAttributes.get(ERROR));
		System.out.println("Message: " + errorAttributes.get(MESSAGE));
		System.out.println("Trace: " + errorAttributes.get(TRACE));
		
	}
	
	private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
        RequestAttributes requestAttributes = new ServletRequestAttributes(request);
        return errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
    }
	

}
