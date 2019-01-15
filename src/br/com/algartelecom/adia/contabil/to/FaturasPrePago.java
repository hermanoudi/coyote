package br.com.algartelecom.adia.contabil.to;

import java.util.Date;

public class FaturasPrePago {
	
	private Integer idContratoOdin;
	private String codProdutoContabil;
	private String codContaContabil;
	private Date dataInicioPeriodo;
	private Date dataFinalPeriodo;
	private String valorConsumo;
	private String codCentroCustos;
	private String valorPIS;
	private String valorCofins;
	
	public Integer getIdContratoOdin() {
		return idContratoOdin;
	}
	public void setIdContratoOdin(Integer idContratoOdin) {
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
	public Date getDataInicioPeriodo() {
		return dataInicioPeriodo;
	}
	public void setDataInicioPeriodo(Date dataInicioPeriodo) {
		this.dataInicioPeriodo = dataInicioPeriodo;
	}
	public Date getDataFinalPeriodo() {
		return dataFinalPeriodo;
	}
	public void setDataFinalPeriodo(Date dataFinalPeriodo) {
		this.dataFinalPeriodo = dataFinalPeriodo;
	}
	public String getValorConsumo() {
		return valorConsumo;
	}
	public void setValorConsumo(String valorConsumo) {
		this.valorConsumo = valorConsumo;
	}
	public String getCodCentroCustos() {
		return codCentroCustos;
	}
	public void setCodCentroCustos(String codCentroCustos) {
		this.codCentroCustos = codCentroCustos;
	}
	public String getValorPIS() {
		return valorPIS;
	}
	public void setValorPIS(String valorPIS) {
		this.valorPIS = valorPIS;
	}
	public String getValorCofins() {
		return valorCofins;
	}
	public void setValorCofins(String valorCofins) {
		this.valorCofins = valorCofins;
	}
	
	

}
