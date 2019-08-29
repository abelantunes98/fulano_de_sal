package br.com.marmitaria.rest.login;

public enum TokenKey{
	
	TOKEN_KEY("chavededescriptografiadotoken");
	
	private String value;
	
	TokenKey(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
