package br.com.algartelecom.adia.Enum;

public enum D_Auxiliar_Mastersaf_Enum {
	
	COD_EMPRESA(9),
	COD_FILIAL(9),
	COD_CATEGORIA_PF_PJ(2),
	COD_PF_PJ(16),
	DTA_LANCAMENTO(8),
	IND_TIPO_OPERACAO(6),
	VAL_LANCAMENTO(17, true),
	IND_LANCAMENTO(1),
	IND_TIPO_DOCUMENTO(3),
	NUM_DOCUMENTO(15),
	NUM_SERIE_DOCUMENTO(5),
	DTA_EMISSAO(8),
	DTA_VENCIMENTO(8),
	VAL_TOTAL_DOCTO(17, true),
	NUM_ARQUIVAMENTO(14),
	NUM_CONTA_CONTABIL(12),
	DSC_OPENFLEX_01(12),
	DSC_OPENFLEX_02(11),
	DSC_OPENFLEX_03(15),
	DSC_OPENFLEX_04(150),
	DSC_OPENFLEX_05(150),
	DSC_OPENFLEX_06(17, true),
	DSC_OPENFLEX_07(17, true),
	DSC_OPENFLEX_08(17, true);

	
	private int tamanho;
	private boolean posicoesAEsquerda;
	  
	D_Auxiliar_Mastersaf_Enum(int tamanho){
	  this.tamanho = tamanho;
	  this.posicoesAEsquerda = false;
	}
	
	D_Auxiliar_Mastersaf_Enum(int tamanho, boolean posicoesAEsquerda){
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
