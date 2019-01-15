package br.com.algartelecom.adia.contabil.to;

import java.util.Date;

public class ArrecadacaoPrePago {
	
	private String valorItemFatura; 		//Val_item_fatura,
	private Date dataPrevistaCredito; 		//dta_prevista_credito,
	private String codItemFaturaOdin; 		//cod_item_fatura_odin, 
	private String codContaContabil; 		//cod_conta_contabil,
	private String codSkuOdin; 				//cod_sku_odin,
	private String codCentroCustos; 		//cod_centro_custos,
	private String modalidadePagto; 		//nom_modalidade_pagto,
	private String numContrato;			 	//num_contrato
	private String valPIS;					//val_pis
	private String valISS;					//val_iss
	private String valCofins; 				//val_cofins
	
	
	
	
	public String getValPIS() {
		return valPIS;
	}
	public void setValPIS(String valPIS) {
		this.valPIS = valPIS;
	}
	public String getValISS() {
		return valISS;
	}
	public void setValISS(String valISS) {
		this.valISS = valISS;
	}
	public String getValCofins() {
		return valCofins;
	}
	public void setValCofins(String valCofins) {
		this.valCofins = valCofins;
	}
	public String getValorItemFatura() {
		return valorItemFatura;
	}
	public void setValorItemFatura(String valorItemFatura) {
		this.valorItemFatura = valorItemFatura;
	}
	public Date getDataPrevistaCredito() {
		return dataPrevistaCredito;
	}
	public void setDataPrevistaCredito(Date dataPrevistaCredito) {
		this.dataPrevistaCredito = dataPrevistaCredito;
	}
	public String getCodItemFaturaOdin() {
		return codItemFaturaOdin;
	}
	public void setCodItemFaturaOdin(String codItemFaturaOdin) {
		this.codItemFaturaOdin = codItemFaturaOdin;
	}
	public String getCodContaContabil() {
		return codContaContabil;
	}
	public void setCodContaContabil(String codContaContabil) {
		this.codContaContabil = codContaContabil;
	}
	public String getCodSkuOdin() {
		return codSkuOdin;
	}
	public void setCodSkuOdin(String codSkuOdin) {
		this.codSkuOdin = codSkuOdin;
	}
	public String getCodCentroCustos() {
		return codCentroCustos;
	}
	public void setCodCentroCustos(String codCentroCustos) {
		this.codCentroCustos = codCentroCustos;
	}
	public String getModalidadePagto() {
		return modalidadePagto;
	}
	public void setModalidadePagto(String modalidadePagto) {
		this.modalidadePagto = modalidadePagto;
	}
	public String getNumContrato() {
		return numContrato;
	}
	public void setNumContrato(String numContrato) {
		this.numContrato = numContrato;
	}
	
	

}
