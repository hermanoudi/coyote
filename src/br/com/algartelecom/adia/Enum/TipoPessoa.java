package br.com.algartelecom.adia.Enum;

public enum TipoPessoa {
	
	PESSOA_FISICA("Pessoa Física"),
	PESSOA_JURIDICA("Pessoa Jurídica");
	
	private String nome;
	
	TipoPessoa(String nome){
		this.nome = nome;
	}
	
	public String getNome(){
		return this.nome;
	}

}
