package pl.kwi.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.kwi.springboot.commands.OutputCommand;
import pl.kwi.springboot.services.NameService;


@Controller
@RequestMapping(value="/output")
public class OutputController{
	
	
	@Autowired
	private NameService nameService;
	
	
	/**
	 * Method displays default page connected with this controller.
	 * 
	 * @param command object InputCommand with page data
	 * @param request object HttpServletRequest with request from page
	 * @param response object HttpServletResponse with response to page
	 * @return object ModelAndView with default page connected with this controller
	 */
	@RequestMapping
	public String displayPage(){
		System.out.println("name: " + nameService.load());
		return "output";
	}
	
	/**
	 * Method handles action on button "Back".
	 * 
	 * @param command object OutputCommand with page data
	 * @param request object HttpServletRequest with request from page
	 * @param response object HttpServletResponse with response to page
	 * @return object ModelAndView after action on button "Back"
	 */
	@RequestMapping(value="/handle-button-back", method=RequestMethod.POST)
	public String handleButtonBack(@ModelAttribute("command")OutputCommand command){
		return "output";
	}	

}
