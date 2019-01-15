package br.com.algartelecom.adia.Enum;

public enum ProcessosEnum {
	
	GESPLAN_FATURAMENTO("3.1-FATURAMENTO_TESOURARIA");

	private String nome;
	
	ProcessosEnum(String nome){
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	

}
