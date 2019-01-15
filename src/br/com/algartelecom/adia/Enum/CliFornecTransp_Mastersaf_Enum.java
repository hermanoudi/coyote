package br.com.algartelecom.adia.Enum;

public enum CliFornecTransp_Mastersaf_Enum {
	  DTA_ATUALIZACAO(8),
	  COD_CATEGORIA_PF_PJ(2),
	  COD_PF_PJ(16),
	  NUM_CNPJ_CPF(16),
	  IND_PESSOA(1),
	  NUM_INSCRICAO_ESTADUAL(14),
	  NUM_INSCRICAO_MUNICIPAL(14),
	  NOM_RAZAO_SOCIAL (70),
	  NOM_FANTASIA (70),
	  DSC_ENDERECO (70),
	  NUM_END_LEGAL (12),
	  DSC_COMPLEMENTO_ENDERECO (45),
	  NOM_BAIRRO (20),
	  NOM_MUNICIPIO (50),
	  SGL_UF (2),
	  NUM_CEP (8),
	  IND_EQUIPAR_PROD_RURAL (1),
	  COD_PAIS_ORIGEM_PF_PJ (3),
	  NUM_INSCRICAO_SUFRAMA (14),
	  IND_TIPO_LOCALIDADE (2),
	  COD_MUNICIPIO_IBGE (7),
	  DSC_OPENFLEX_01 (12),
	  DSC_OPENFLEX_02 (11),
	  DSC_OPENFLEX_03 (15),
	  DSC_OPENFLEX_04 (150),
	  DSC_OPENFLEX_05 (150),
	  DSC_OPENFLEX_06 (17),
	  DSC_OPENFLEX_07 (17),
	  DSC_OPENFLEX_08 (17);
	  
	  private int tamanho;
	  
	  CliFornecTransp_Mastersaf_Enum(int tamanho){
	   this.tamanho = tamanho;
	  }

	   public int getTamanho(){
	   return this.tamanho;
	  }

}
