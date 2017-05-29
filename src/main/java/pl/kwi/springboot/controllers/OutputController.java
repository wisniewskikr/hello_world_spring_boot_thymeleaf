package pl.kwi.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.kwi.springboot.commands.OutputCommand;
import pl.kwi.springboot.services.IdService;
import pl.kwi.springboot.services.UserService;


@Controller
@RequestMapping(value="/output")
public class OutputController{
	
	
	@Autowired
	private IdService idService;
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping
	public String displayPage(Model model){
		
		OutputCommand command = new OutputCommand();
		String id = idService.load();
		String name = userService.getNameUserById(Long.valueOf(id));
		command.setName(name);
		model.addAttribute("command", command);
		return "output";
		
	}
	
	@RequestMapping(value="/handle-button-back", method=RequestMethod.POST)
	public String handleButtonBack(){
		return "redirect:/input";
	}	

}
