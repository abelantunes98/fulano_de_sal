package br.com.marmitaria.rest.login;

public enum TokenKey{
	
	TOKEN_KEY("chavededescriptografiadotoken"),
	TOKEN_RECUPERAR_SENHA("chevededescriptografiadotokenderecuperarsenha");
	
	private String value;
	
	TokenKey(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}

}
