package br.com.algartelecom.adia.Enum;

public enum EventosArquivoFaturamentoContabilEnum {
	
	Faturamento("Faturamento"), 
	PIS("PIS"), 
	COFINS("COFINS"), 
	ISS("ISS"), 
	Ajuste("Ajuste");
	
	private String nome;
	  
	EventosArquivoFaturamentoContabilEnum(String nome){
	  this.nome = nome;
	}

	public String getNome(){
	  return this.nome;
	}

}
