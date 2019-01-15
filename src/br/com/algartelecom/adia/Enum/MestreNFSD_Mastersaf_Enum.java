package br.com.algartelecom.adia.Enum;

public enum MestreNFSD_Mastersaf_Enum {
	
	COD_EMPRESA(9),
	COD_FILIAL(9), 
	NUM_SERIE_NOTA_FISCAL(5), 
	NUM_NOTA_FISCAL(15), 
	DTA_EMISSAO(8), 
	COD_CATEGORIA_PF_PJ(2), 
	COD_PF_PJ(16), 
	IND_TIPO_DOCUMENTO(3), 
	NUM_ITENS(5), 
	COD_MODELO_DOCUMENTO(3), 
	VAL_TOTAL_SERVICO(17, true), 
	VAL_DESCONTO(17), 
	VAL_ALIQ_IRRF(17),
	VAL_BASE_CALCULO_IRRF(17), 
	VAL_IRRF(17),
	IND_CANCELAMENTO(1), 
	VAL_INSS(17), 
	VAL_ALIQ_INSS(17), 
	VAL_ISS_RETIDO_PELO_TOMADOR(17, true),
	DSC_OBSERVACAO_NFE(150),
	VAL_BASE_CALCULO_RET_INSS(17),
	IND_TIPO_DOCTO_MUNICIPIO(5), 
	VAL_BASE_CALCULO_ISS(17, true), 
	DSC_CHAVE_NFE(60),
	DTA_EXECUCAO_CONCLUSAO(8), 
	IND_TIPO_PAGAMENTO(1),
	DSC_OPENFLEX_01(12), 
	DSC_OPENFLEX_02(11), 
	DSC_OPENFLEX_03(15),
	DSC_OPENFLEX_04(150),
	DSC_OPENFLEX_05(150),
	DSC_OPENFLEX_06(17),
	DSC_OPENFLEX_07(17),
	DSC_OPENFLEX_08(17);
	
	private int tamanho;
	private boolean posicoesAEsquerda;
	  
	MestreNFSD_Mastersaf_Enum(int tamanho){
	  this.tamanho = tamanho;
	  this.posicoesAEsquerda = false;
	}
	
	MestreNFSD_Mastersaf_Enum(int tamanho, boolean posicoesAEsquerda){
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
