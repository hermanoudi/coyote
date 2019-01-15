package br.com.algartelecom.adia.Enum;

public enum ItemNFSD_Mastersaf_Enum {
	
	COD_EMPRESA(9),
	COD_FILIAL(9),
	NUM_SERIE_NOTA_FISCAL(5),
	NUM_NOTA_FISCAL(15),
	DTA_EMISSAO(8),
	COD_CATEGORIA_PF_PJ(2),
	NUM_ITEM(5),
	COD_PF_PJ(16),
	IND_TIPO_DOCUMENTO(3),
	COD_PARA_SERVICO(20),
	DSC_COMPLEMENTAR(150),
	VAL_SERVICO(17, true),
	VAL_DESCONTO(17),
	VAL_ALIQ_ISS(17, true),
	VAL_BASE_CALCULO_ISS(17, true),
	VAL_ISS(17, true),
	VAL_TOTAL_DOCUMENTO(17, true),
	COD_FISCAL_SERVICO(6),
	VAL_MATERIAL_APLICADO(17),
	VAL_SUBEMPREITADA(17),
	IND_TIPO_LOCALIDADE(2),
	NOM_LOCALIDADE(10),
	IND_TIPO_DOCTO_MUNICIPIO(5),
	NUM_CONTA_CONTABIL(28),
	COD_CENTRO_CUSTOS(28),
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
	  
	ItemNFSD_Mastersaf_Enum(int tamanho){
	  this.tamanho = tamanho;
	  this.posicoesAEsquerda = false;
	}
	
	ItemNFSD_Mastersaf_Enum(int tamanho, boolean posicoesAEsquerda){
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
