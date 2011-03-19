package com.niccholaspage.nAliases;

import java.util.ArrayList;

public class Alias {
	private String command;
	private String alias;
	private ArrayList<String> permissions = new ArrayList<String>();
	public void setAlias(String alias) {
		this.alias = alias;
	}
	public String getAlias() {
		return alias;
	}
	public void setCommand(String command){
		this.command = command;
	}
	public String getCommand(){
		return command;
	}
	public void setPermissions(ArrayList<String> permissions){
		this.permissions = permissions;
	}
	public ArrayList<String> getPermissions(){
		return permissions;
	}
}
