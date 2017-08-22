package pl.kwi.springboot.registr.commands;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import pl.kwi.springboot.db.entities.UserEntity;

public class RegistrConsoleCommand implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	
	private List<UserEntity> users = new ArrayList<UserEntity>();
	private List<String> selectedUsers = new ArrayList<String>();


	public List<UserEntity> getUsers() {
		return users;
	}
	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}
	
	public List<String> getSelectedUsers() {
		return selectedUsers;
	}
	public void setSelectedUsers(List<String> selectedUsers) {
		this.selectedUsers = selectedUsers;
	}

	
}
