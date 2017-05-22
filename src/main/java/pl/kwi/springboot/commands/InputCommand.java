package pl.kwi.springboot.commands;

import java.util.List;

import pl.kwi.springboot.commands.abstr.AbstractCommand;
import pl.kwi.springboot.daos.Language;

public class InputCommand extends AbstractCommand {
	

	private String name;
	private List<Language> languages;
	private String language;

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Language> getLanguages() {
		return languages;
	}
	public void setLanguages(List<Language> languages) {
		this.languages = languages;
	}
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}	
	
	
}
