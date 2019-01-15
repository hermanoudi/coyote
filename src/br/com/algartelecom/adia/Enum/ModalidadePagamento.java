package br.com.algartelecom.adia.Enum;

public enum ModalidadePagamento {
	
	PRE_PAGO("PRE-PAGO"),
	POS_PAGO("POS-PAGO");
	
	private String modalidade;
	
	ModalidadePagamento(String modalidade){
		this.modalidade = modalidade;
	}
	
	public String getModalidade(){
		return this.modalidade;
	}

}
