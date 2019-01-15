package br.com.algartelecom.adia.Enum;

public enum Categoria {
	
	ARRECADACAO("ARRECADAÇÃO"),
	FATURAMENTO("FATURAMENTO");
	
	private String nome;
	
	Categoria(String nome){
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}

}
