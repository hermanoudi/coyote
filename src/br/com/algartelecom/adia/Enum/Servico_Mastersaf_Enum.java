package br.com.algartelecom.adia.Enum;

public enum Servico_Mastersaf_Enum {
	  COD_SERVICO(20),
	  DTA_ATUALIZACAO(8),
	  DSC_SERVICO(150),
	  DSC_COMPLEMENTO(150),
	  IND_TIPO_RECEITA(1),
	  IND_TIPO_SERVICO(1),
	  COD_LC_116_03(5),
	  DSC_OPENFLEX_01(12),
	  DSC_OPENFLEX_02(11),
	  DSC_OPENFLEX_03(14),
	  DSC_OPENFLEX_04(150),
	  DSC_OPENFLEX_05(150),
	  DSC_OPENFLEX_06(17),
	  DSC_OPENFLEX_07(17),
	  DSC_OPENFLEX_08(17);
	  
	  private int tamanho;
	  
	  Servico_Mastersaf_Enum(int tamanho){
	   this.tamanho = tamanho;
	  }

	   public int getTamanho(){
	   return this.tamanho;
	  }

}
