package br.com.algartelecom.adia.Enum;

public enum CISS_NFSD_Mastersaf_Enum {
	
	COD_EMPRESA(9),
	COD_FILIAL(9),
	NUM_SERIE_NOTA_FISCAL(5),
	NUM_NOTA_FISCAL(15),
	DTA_EMISSAO(8),
	NUM_ITEM(5),
	VAL_BASE_CALCULO_PIS_COFINS(17, true),
	VAL_ALIQ_INCID_PIS(17, true),
	VAL_DEBITO_PIS(17,true),
	VAL_ALIQ_INCID_COFINS(17, true),
	VAL_DEBITO_COFINS(17, true),
	COD_CONTRATO(20),
	VAL_PIS_RETIDO(17, true),
	VAL_COFINS_RETIDA(17, true),
	VAL_CSLL_RETIDA(17),
	VAL_IR(17),
	COD_SITUACAO_TRIBUT_PIS(2),
	COD_SITUACAO_TRIBUT_COFINS(2);
	
	private int tamanho;
	private boolean posicoesAEsquerda;
	  
	CISS_NFSD_Mastersaf_Enum(int tamanho){
	  this.tamanho = tamanho;
	  this.posicoesAEsquerda = false;
	}
	
	CISS_NFSD_Mastersaf_Enum(int tamanho, boolean posicoesAEsquerda){
		  this.tamanho = tamanho;
		  this.posicoesAEsquerda = posicoesAEsquerda;
		}

	public int getTamanho(){
	   return this.tamanho;
	}
	
	public boolean getPosicoesAEsquerda(){
		return this.posicoesAEsquerda;
	}


}
