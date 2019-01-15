package br.com.algartelecom.adia.contabil.to;

import java.util.Date;

public class Tarifa {
	
	private String numContrato; 			//num_contrato
	private Date dataPagamentoItem; 		//dta_pagamento_item
	private String codItemFaturaOdin;			//cod_fatura_odin
	private String codSKUOdin;  			//cod_sku_odin
	private String codContaContabil;		//cod_conta_contabil
	private String valTarifaCartao;			//val_tarifa_cartao
	private String codCentroCusto;			//cod_centro_custo
	private String nomModalidadePagto;  	//nom_modalidade_pagto
	private Date dataPrevistaCredito;
	
	public Date getDataPrevistaCredito() {
		return dataPrevistaCredito;
	}
	public void setDataPrevistaCredito(Date dataPrevistaCredito) {
		this.dataPrevistaCredito = dataPrevistaCredito;
	}
	public String getNomModalidadePagto() {
		return nomModalidadePagto;
	}
	public void setNomModalidadePagto(String nomModalidadePagto) {
		this.nomModalidadePagto = nomModalidadePagto;
	}
	public String getNumContrato() {
		return numContrato;
	}
	public void setNumContrato(String numContrato) {
		this.numContrato = numContrato;
	}
	public Date getDataPagamentoItem() {
		return dataPagamentoItem;
	}
	public void setDataPagamentoItem(Date dataPagamentoItem) {
		this.dataPagamentoItem = dataPagamentoItem;
	}
	public String getCodItemFaturaOdin() {
		return codItemFaturaOdin;
	}
	public void setCodItemFaturaOdin(String codFaturaOdin) {
		this.codItemFaturaOdin = codFaturaOdin;
	}
	public String getCodSKUOdin() {
		return codSKUOdin;
	}
	public void setCodSKUOdin(String codSKUOdin) {
		this.codSKUOdin = codSKUOdin;
	}
	public String getCodContaContabil() {
		return codContaContabil;
	}
	public void setCodContaContabil(String codContaContabil) {
		this.codContaContabil = codContaContabil;
	}
	public String getValTarifaCartao() {
		return valTarifaCartao;
	}
	public void setValTarifaCartao(String valTarifaCartao) {
		this.valTarifaCartao = valTarifaCartao;
	}
	public String getCodCentroCusto() {
		return codCentroCusto;
	}
	public void setCodCentroCusto(String codCentroCusto) {
		this.codCentroCusto = codCentroCusto;
	}
	
	

}
