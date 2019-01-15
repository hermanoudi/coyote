package br.com.algartelecom.adia.mastersaf.to;

import br.com.algartelecom.adia.Enum.CISS_NFSD_Mastersaf_Enum;
import br.com.algartelecom.adia.Enum.CliFornecTransp_Mastersaf_Enum;
import br.com.algartelecom.adia.util.MontaCamposArquivosPosicionais;

public class CISS_MastersafTO {
	
	private String codEmpresa;			            //COD_EMPRESA(09),
	private String codFilial;			            //COD_FILIAL(09),
	private String numSerieNotaFiscal;	            //NUM_SERIE_NOTA_FISCAL(05),
	private String numNotaFiscal;		            //NUM_NOTA_FISCAL(15),
	private String dtaEmissao;			            //DTA_EMISSAO(08),
	private String numItem;				            //NUM_ITEM(05),
	private String valBaseCalculoPisCofins;         //VAL_BASE_CALCULO_PIS_COFINS(17),
	private String valAliqIncIDPis;					//VAL_ALIQ_INCID_PIS(17),
	private String valDebitoPis;					//VAL_DEBITO_PIS(17),
	private String valAliqIncIDCofins;				//VAL_ALIQ_INCID_COFINS(17),
	private String valDebitoCofins;					//VAL_DEBITO_COFINS(17),
	private String codContato;						//COD_CONTRATO(20),
	private String valPisRetido;					//VAL_PIS_RETIDO(17),
	private String valCofinsRetida;					//VAL_COFINS_RETIDA(17),
	private String valCsllRetida;					//VAL_CSLL_RETIDA(17),
	private String valIR;							//VAL_IR(17),
	private String codSituacaoTributPis;			//COD_SITUACAO_TRIBUT_PIS(02),
	private String codSituacaoTributCofins;			//COD_SITUACAO_TRIBUT_COFINS(02),
	
	
	
	
	public String getCodEmpresa() {
		return codEmpresa;
	}




	public void setCodEmpresa(String codEmpresa) throws Exception {
		codEmpresa = MontaCamposArquivosPosicionais.preencherCampo(codEmpresa, CISS_NFSD_Mastersaf_Enum.COD_EMPRESA.getTamanho(), CISS_NFSD_Mastersaf_Enum.COD_EMPRESA.getPosicoesAEsquerda());
		this.codEmpresa = codEmpresa;
	}




	public String getCodFilial() {
		return codFilial;
	}




	public void setCodFilial(String codFilial) throws Exception {
		codFilial = MontaCamposArquivosPosicionais.preencherCampo(codFilial, CISS_NFSD_Mastersaf_Enum.COD_FILIAL.getTamanho(), CISS_NFSD_Mastersaf_Enum.COD_FILIAL.getPosicoesAEsquerda());
		this.codFilial = codFilial;
	}




	public String getNumSerieNotaFiscal() {
		return numSerieNotaFiscal;
	}




	public void setNumSerieNotaFiscal(String numSerieNotaFiscal) throws Exception {
		numSerieNotaFiscal = MontaCamposArquivosPosicionais.preencherCampo(numSerieNotaFiscal, CISS_NFSD_Mastersaf_Enum.NUM_SERIE_NOTA_FISCAL.getTamanho(), CISS_NFSD_Mastersaf_Enum.NUM_SERIE_NOTA_FISCAL.getPosicoesAEsquerda());
		this.numSerieNotaFiscal = numSerieNotaFiscal;
	}




	public String getNumNotaFiscal() {
		return numNotaFiscal;
	}




	public void setNumNotaFiscal(String numNotaFiscal) throws Exception {
		numNotaFiscal = MontaCamposArquivosPosicionais.preencherCampo(numNotaFiscal, CISS_NFSD_Mastersaf_Enum.NUM_NOTA_FISCAL.getTamanho(), CISS_NFSD_Mastersaf_Enum.NUM_NOTA_FISCAL.getPosicoesAEsquerda());
		this.numNotaFiscal = numNotaFiscal;
	}




	public String getDtaEmissao() {
		return dtaEmissao;
	}




	public void setDtaEmissao(String dtaEmissao) throws Exception {
		dtaEmissao = MontaCamposArquivosPosicionais.preencherCampo(dtaEmissao, CISS_NFSD_Mastersaf_Enum.DTA_EMISSAO.getTamanho(), CISS_NFSD_Mastersaf_Enum.DTA_EMISSAO.getPosicoesAEsquerda());
		this.dtaEmissao = dtaEmissao;
	}




	public String getNumItem() {
		return numItem;
	}




	public void setNumItem(String numItem) throws Exception {
		numItem = MontaCamposArquivosPosicionais.preencherCampo(numItem, CISS_NFSD_Mastersaf_Enum.NUM_ITEM.getTamanho(), CISS_NFSD_Mastersaf_Enum.NUM_ITEM.getPosicoesAEsquerda());
		this.numItem = numItem;
	}




	public String getValBaseCalculoPis() {
		return valBaseCalculoPisCofins;
	}




	public void setValBaseCalculoPis(String valBaseCalculoPisCofins) throws Exception {
		valBaseCalculoPisCofins = MontaCamposArquivosPosicionais.preencherCampo(valBaseCalculoPisCofins, CISS_NFSD_Mastersaf_Enum.VAL_BASE_CALCULO_PIS_COFINS.getTamanho(), CISS_NFSD_Mastersaf_Enum.VAL_BASE_CALCULO_PIS_COFINS.getPosicoesAEsquerda());
		this.valBaseCalculoPisCofins = valBaseCalculoPisCofins;
	}




	public String getValAliqAltoIncidPis() {
		return valAliqIncIDPis;
	}




	public void setValAliqAltoIncidPis(String valAliqIncIDPis) throws Exception {
		valAliqIncIDPis = MontaCamposArquivosPosicionais.preencherCampo(valAliqIncIDPis, CISS_NFSD_Mastersaf_Enum.VAL_ALIQ_INCID_PIS.getTamanho(), CISS_NFSD_Mastersaf_Enum.VAL_ALIQ_INCID_PIS.getPosicoesAEsquerda());
		this.valAliqIncIDPis = valAliqIncIDPis;
	}




	public String getValDebitoPis() {
		return valDebitoPis;
	}




	public void setValDebitoPis(String valDebitoPis) throws Exception {
		valDebitoPis = MontaCamposArquivosPosicionais.preencherCampo(valDebitoPis, CISS_NFSD_Mastersaf_Enum.VAL_DEBITO_PIS.getTamanho(), CISS_NFSD_Mastersaf_Enum.VAL_DEBITO_PIS.getPosicoesAEsquerda());
		this.valDebitoPis = valDebitoPis;
	}




	public String getValAliqIncIDCofins() {
		return valAliqIncIDCofins;
	}




	public void setValAliqIncIDCofins(String valAliqIncIDCofins) throws Exception {
		valAliqIncIDCofins = MontaCamposArquivosPosicionais.preencherCampo(valAliqIncIDCofins, CISS_NFSD_Mastersaf_Enum.VAL_ALIQ_INCID_COFINS.getTamanho(), CISS_NFSD_Mastersaf_Enum.VAL_ALIQ_INCID_COFINS.getPosicoesAEsquerda());
		this.valAliqIncIDCofins = valAliqIncIDCofins;
	}




	public String getValDebitoCofins() {
		return valDebitoCofins;
	}




	public void setValDebitoCofins(String valDebitoCofins) throws Exception {
		valDebitoCofins = MontaCamposArquivosPosicionais.preencherCampo(valDebitoCofins, CISS_NFSD_Mastersaf_Enum.VAL_DEBITO_COFINS.getTamanho(), CISS_NFSD_Mastersaf_Enum.VAL_DEBITO_COFINS.getPosicoesAEsquerda());
		this.valDebitoCofins = valDebitoCofins;
	}




	public String getCodContato() {
		return codContato;
	}




	public void setCodContato(String codContato) throws Exception {
		codContato = MontaCamposArquivosPosicionais.preencherCampo(codContato, CISS_NFSD_Mastersaf_Enum.COD_CONTRATO.getTamanho(), CISS_NFSD_Mastersaf_Enum.COD_CONTRATO.getPosicoesAEsquerda());
		this.codContato = codContato;
	}




	public String getValPisRetido() {
		return valPisRetido;
	}




	public void setValPisRetido(String valPisRetido) throws Exception {
		valPisRetido = MontaCamposArquivosPosicionais.preencherCampo(valPisRetido, CISS_NFSD_Mastersaf_Enum.VAL_PIS_RETIDO.getTamanho(), CISS_NFSD_Mastersaf_Enum.VAL_PIS_RETIDO.getPosicoesAEsquerda());
		this.valPisRetido = valPisRetido;
	}




	public String getValCofinsRetida() {
		return valCofinsRetida;
	}




	public void setValCofinsRetida(String valCofinsRetida) throws Exception {
		valCofinsRetida = MontaCamposArquivosPosicionais.preencherCampo(valCofinsRetida, CISS_NFSD_Mastersaf_Enum.VAL_COFINS_RETIDA.getTamanho(), CISS_NFSD_Mastersaf_Enum.VAL_COFINS_RETIDA.getPosicoesAEsquerda());
		this.valCofinsRetida = valCofinsRetida;
	}




	public String getValCsllRetida() {
		return valCsllRetida;
	}




	public void setValCsllRetida(String valCsllRetida) throws Exception {
		valCsllRetida = MontaCamposArquivosPosicionais.preencherCampo(valCsllRetida, CISS_NFSD_Mastersaf_Enum.VAL_CSLL_RETIDA.getTamanho(), CISS_NFSD_Mastersaf_Enum.VAL_CSLL_RETIDA.getPosicoesAEsquerda());
		this.valCsllRetida = valCsllRetida;
	}




	public String getValIR() {
		return valIR;
	}




	public void setValIR(String valIR) throws Exception {
		valIR = MontaCamposArquivosPosicionais.preencherCampo(valIR, CISS_NFSD_Mastersaf_Enum.VAL_IR.getTamanho(), CISS_NFSD_Mastersaf_Enum.VAL_IR.getPosicoesAEsquerda());
		this.valIR = valIR;
	}




	public String getCodSituacaoTributPis() {
		return codSituacaoTributPis;
	}




	public void setCodSituacaoTributPis(String codSituacaoTributPis) throws Exception {
		codSituacaoTributPis = MontaCamposArquivosPosicionais.preencherCampo(codSituacaoTributPis, CISS_NFSD_Mastersaf_Enum.COD_SITUACAO_TRIBUT_PIS.getTamanho(), CISS_NFSD_Mastersaf_Enum.COD_SITUACAO_TRIBUT_PIS.getPosicoesAEsquerda());
		this.codSituacaoTributPis = codSituacaoTributPis;
	}




	public String getCodSituacaoTributCofins() {
		return codSituacaoTributCofins;
	}




	public void setCodSituacaoTributCofins(String codSituacaoTributCofins) throws Exception {
		codSituacaoTributCofins = MontaCamposArquivosPosicionais.preencherCampo(codSituacaoTributCofins, CISS_NFSD_Mastersaf_Enum.COD_SITUACAO_TRIBUT_COFINS.getTamanho(), CISS_NFSD_Mastersaf_Enum.COD_SITUACAO_TRIBUT_COFINS.getPosicoesAEsquerda());
		this.codSituacaoTributCofins = codSituacaoTributCofins;
	}




	@Override
	public String toString() {
		return this.codEmpresa + this.codFilial + this.numSerieNotaFiscal + this.numNotaFiscal + this.dtaEmissao + 			   
		       this.numItem + this.valBaseCalculoPisCofins + this.valAliqIncIDPis + this.valDebitoPis + this.valAliqIncIDCofins + this.valDebitoCofins + 			
		       this.codContato + this.valPisRetido + this.valCofinsRetida + this.valCsllRetida + this.valIR + this.codSituacaoTributPis + this.codSituacaoTributCofins;
	}

}
