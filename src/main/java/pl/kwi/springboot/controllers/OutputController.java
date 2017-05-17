package pl.kwi.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.kwi.springboot.commands.OutputCommand;
import pl.kwi.springboot.services.NameService;


@Controller
@RequestMapping(value="/output")
public class OutputController{
	
	
	@Autowired
	private NameService nameService;
	
	@Value("${output.template}")
	private String template;
	
	
	@RequestMapping
	public String displayPage(Model model){
		OutputCommand command = new OutputCommand();
		command.setName(nameService.load());
		model.addAttribute("command", command);
		return template;
	}
	
	@RequestMapping(value="/handle-button-back", method=RequestMethod.POST)
	public String handleButtonBack(){
		return "redirect:/input";
	}	

}
