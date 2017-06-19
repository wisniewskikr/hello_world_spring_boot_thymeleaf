package pl.kwi.springboot.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import pl.kwi.springboot.services.NameService;

@Controller
@RequestMapping(value="/input")
public class InputController {
	
	@Autowired
	private NameService nameService;

	@RequestMapping
	public String displayPage() {
		return "input";
	}
	
	@RequestMapping(value="/handle-button-ok", method=RequestMethod.POST)
	public String handleButtonOk(@RequestParam("file") MultipartFile file) throws IOException {
		
		String name = new String(file.getBytes());
		nameService.save(name);
		return "redirect:/output";
		
	}

}