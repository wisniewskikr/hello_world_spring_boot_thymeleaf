package pl.kwi.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.kwi.springboot.commands.OutputCommand;
import pl.kwi.springboot.controllers.abstr.AbstractController;
import pl.kwi.springboot.services.NameService;


@Controller
public class OutputController extends AbstractController {
	
	
	@Autowired
	private NameService nameService;
	
	
	@RequestMapping(value="/output")
	public String displayPage(
			@ModelAttribute("command")OutputCommand command,
			Model model){

		command.setName(nameService.load());
		model.addAttribute("command", command);
		return "output";
		
	}
	
	@RequestMapping(value="/output/handle-button-back", method=RequestMethod.POST)
	public String handleButtonBack(
			@ModelAttribute("command")OutputCommand command){
		
		return "redirect:/" + command.getLoc() + "/input";
		
	}	

}
