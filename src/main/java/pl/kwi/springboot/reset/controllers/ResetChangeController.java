package pl.kwi.springboot.reset.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.kwi.springboot.enums.ConfirmationEnum;
import pl.kwi.springboot.reset.commands.ResetChangeCommand;

@Controller
@RequestMapping(value="/resetChange")
public class ResetChangeController {
	
	
	@RequestMapping
	public String displayPage() {
		return "reset/resetChange";
	}
	
	@RequestMapping(value="/handle-button-ok", method=RequestMethod.POST)
	public String handleButtonOk(
			@Valid @ModelAttribute("command")ResetChangeCommand command,
			RedirectAttributes redirectAttributes) {
		
		redirectAttributes.addAttribute("confirmationEnum", ConfirmationEnum.RESET_CHANGE);
		return "redirect:/confirmation";
	}


}