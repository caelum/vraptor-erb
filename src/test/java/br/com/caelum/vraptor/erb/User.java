package br.com.caelum.vraptor.erb;

public class User {

	private String sirname;
	private String name;

	public String getSirname() {
		return sirname;
	}

	public String getName() {
		return name;
	}

	public User(String name, String sirname) {
		this.name = name;
		this.sirname = sirname;	
	}

}
