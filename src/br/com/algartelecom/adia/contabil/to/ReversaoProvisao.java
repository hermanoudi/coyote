package br.com.algartelecom.adia.contabil.to;

import java.util.Date;

public class ReversaoProvisao {
	
	private String idContratoOdin; 				//ID_CONTRATO_ODIN
	private String codProdutoContabil; 			//cod_produto_contabil
	private String codContaContabil; 			//cod_conta_contabil
	private Date dataFinalPeriodo;			//dta_final_periodo
	private String valProvisao;					//val_provisao
	private String codCentroCustos;				//cod_centro_custos
	
	public String getIdContratoOdin() {
		return idContratoOdin;
	}
	public void setIdContratoOdin(String idContratoOdin) {
		this.idContratoOdin = idContratoOdin;
	}
	public String getCodProdutoContabil() {
		return codProdutoContabil;
	}
	public void setCodProdutoContabil(String codProdutoContabil) {
		this.codProdutoContabil = codProdutoContabil;
	}
	public String getCodContaContabil() {
		return codContaContabil;
	}
	public void setCodContaContabil(String codContaContabil) {
		this.codContaContabil = codContaContabil;
	}
	public Date getDataFinalPeriodo() {
		return dataFinalPeriodo;
	}
	public void setDataFinalPeriodo(Date dataFinalPeriodo) {
		this.dataFinalPeriodo = dataFinalPeriodo;
	}
	public String getValProvisao() {
		return valProvisao;
	}
	public void setValProvisao(String valProvisao) {
		this.valProvisao = valProvisao;
	}
	public String getCodCentroCustos() {
		return codCentroCustos;
	}
	public void setCodCentroCustos(String codCentroCustos) {
		this.codCentroCustos = codCentroCustos;
	}
	
	

}
