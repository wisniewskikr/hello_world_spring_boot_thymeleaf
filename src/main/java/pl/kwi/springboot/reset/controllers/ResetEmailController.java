package pl.kwi.springboot.reset.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.kwi.springboot.enums.ConfirmationEnum;
import pl.kwi.springboot.reset.commands.ResetEmailCommand;
import pl.kwi.springboot.services.EmailService;
import pl.kwi.springboot.services.TokenService;
import pl.kwi.springboot.services.UserService;

@Controller
@RequestMapping(value="/resetEmail")
public class ResetEmailController {
	
	
	private static final String LINK = "http://www.localhost:8080/resetChange?token=";

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UserService userService;
	
	 
	@RequestMapping
	public String displayPage() {
		return "reset/resetEmail";
	}
	
	@RequestMapping(value="/handle-button-ok", method=RequestMethod.POST)
	public String handleButtonOk(
			@Valid @ModelAttribute("command")ResetEmailCommand command,
			RedirectAttributes redirectAttributes) {
		
		String token = tokenService.generateTokenForEmail(command.getEmail());
		userService.addToken(command.getEmail(), token);
		emailService.sendResetEmail(command.getEmail(), createLink(command.getEmail(), token));
		
		redirectAttributes.addAttribute("confirmationEnum", ConfirmationEnum.RESET_EMAIL);
		return "redirect:/confirmation";
	}
	
	private String createLink(String email, String token) {						
		return LINK + token;
	}

}