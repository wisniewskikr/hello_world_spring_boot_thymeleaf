package pl.kwi.springboot.reset.controllers;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pl.kwi.springboot.enums.ConfirmationEnum;
import pl.kwi.springboot.reset.commands.ResetChangeCommand;
import pl.kwi.springboot.services.TokenService;
import pl.kwi.springboot.services.UserService;

@Controller
@RequestMapping(value="/resetChange")
public class ResetChangeController {
	
	
	@Autowired
	private TokenService tokenService;
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping
	public String displayPage(
			@ModelAttribute("command")ResetChangeCommand command,
			RedirectAttributes redirectAttributes) {
		
		if (!validToken(command)) {
			redirectAttributes.addAttribute("confirmationEnum", ConfirmationEnum.NOT_VALID_TOKEN);
			return "redirect:/confirmation";
		} 
		
		return "reset/resetChange";
		
	}	
	
	@RequestMapping(value="/handle-button-ok", method=RequestMethod.POST)
	public String handleButtonOk(
			@Valid @ModelAttribute("command")ResetChangeCommand command,
			BindingResult bindingResult,
			RedirectAttributes redirectAttributes
			) {
		
		if (!validToken(command)) {
			redirectAttributes.addAttribute("confirmationEnum", ConfirmationEnum.NOT_VALID_TOKEN);
			return "redirect:/confirmation";
		}
		
		if (bindingResult.hasErrors()) {
			return "reset/resetChange";
		}
		
		String email = tokenService.decodeEmailFromToken(command.getToken());
		userService.updatePassword(email, command.getPassword());
		userService.removeToken(email);
		
		redirectAttributes.addAttribute("confirmationEnum", ConfirmationEnum.RESET_CHANGE);
		return "redirect:/confirmation";
	}
	
	private boolean validToken(ResetChangeCommand command) {
		String token = command.getToken();
		if (StringUtils.isBlank(token)) {
			return false;
		}
		String email = tokenService.decodeEmailFromToken(token);
		String userToken = userService.getToken(email);
		if (StringUtils.isBlank(userToken) || !token.equals(userToken)) {
			return false;
		}
		return true;
	}


}