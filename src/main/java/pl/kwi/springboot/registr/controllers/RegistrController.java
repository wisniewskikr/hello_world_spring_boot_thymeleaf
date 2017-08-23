package pl.kwi.springboot.registr.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.kwi.springboot.enums.ConfirmationEnum;
import pl.kwi.springboot.registr.commands.RegistrCommand;
import pl.kwi.springboot.services.EmailService;
import pl.kwi.springboot.services.UserService;

@Controller
@RequestMapping(value="/registration")
public class RegistrController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	
	@RequestMapping
	public String displayPage() {
		return "registr/registr";
	}
	
	@RequestMapping(value="/handle-button-ok", method=RequestMethod.POST)
	public String handleButtonOk(
			@Valid @ModelAttribute("command")RegistrCommand command,
			RedirectAttributes redirectAttributes) {
		userService.registerUser(command.getEmail(), command.getPassword());
		emailService.sendRegistrationEmail(command.getEmail());
		redirectAttributes.addAttribute("confirmationEnum", ConfirmationEnum.REGISTRATION);
		return "redirect:/confirmation";
	}

}