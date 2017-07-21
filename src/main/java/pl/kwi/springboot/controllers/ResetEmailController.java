package pl.kwi.springboot.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.kwi.springboot.commands.ResetEmailCommand;
import pl.kwi.springboot.enums.ConfirmationEnum;

@Controller
@RequestMapping(value="/resetEmail")
public class ResetEmailController {
	
	
	@RequestMapping
	public String displayPage() {
		return "resetEmail";
	}
	
	@RequestMapping(value="/handle-button-ok", method=RequestMethod.POST)
	public String handleButtonOk(
			@Valid @ModelAttribute("command")ResetEmailCommand command,
			RedirectAttributes redirectAttributes) {
		redirectAttributes.addAttribute("confirmationEnum", ConfirmationEnum.RESET_EMAIL);
		return "redirect:/confirmation";
	}

}