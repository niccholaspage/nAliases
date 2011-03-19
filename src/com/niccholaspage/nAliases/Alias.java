package com.niccholaspage.nAliases;

public class Alias {
	private String command;
	private String alias;
	private String permissions;
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
	public void setPermissions(String permissions){
		this.permissions = permissions;
	}
	public String getPermissions(){
		return permissions;
	}
}
