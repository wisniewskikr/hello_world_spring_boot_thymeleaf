package pl.kwi.springboot.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.kwi.springboot.commands.OutputCommand;
import pl.kwi.springboot.services.NameService;


@Controller
@RequestMapping(value="/output")
public class OutputController{
	
	
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private NameService nameService;
	
	
	@RequestMapping
	public String displayPage(Model model){
		LOG.debug("displayPage()");
		OutputCommand command = new OutputCommand();
		command.setName(nameService.load());
		model.addAttribute("command", command);
		return "output";
	}
	
	@RequestMapping(value="/handle-button-back", method=RequestMethod.POST)
	public String handleButtonBack(){
		LOG.debug("handleButtonBack()");
		return "redirect:/input";
	}	

}
