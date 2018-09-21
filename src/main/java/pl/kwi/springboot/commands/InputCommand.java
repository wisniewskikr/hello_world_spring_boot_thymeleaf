package pl.kwi.springboot.commands;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;

import pl.kwi.springboot.daos.Language;

public class InputCommand {
	

	@NotEmpty
	private String name;
	private List<Language> languages;
	private String language;
	private String currentLanguage;

	
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
	
	public String getCurrentLanguage() {
		return currentLanguage;
	}
	public void setCurrentLanguage(String currentLanguage) {
		this.currentLanguage = currentLanguage;
	}	
		
}
