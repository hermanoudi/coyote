package br.com.algartelecom.adia.Enum;

public enum DebitoCredito {
	
	CREDITO("CREDITO"), 
	DEBITO("DEBITO");
	
	private String nome;
	
	DebitoCredito(String nome){
		this.nome = nome;
	}
	
	public String getNome() {
		return nome;
	}
	
	
	
}
