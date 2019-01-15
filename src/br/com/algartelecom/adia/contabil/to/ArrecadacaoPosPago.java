package br.com.algartelecom.adia.contabil.to;

import java.util.Date;

public class ArrecadacaoPosPago {
	
	private Date dataPrevistaCredito; 
	private String codItemFaturaOdin; 	
	private String codSkuOdin; 		
	private String valorItemFatura; 	
	private String codContaContabil; 	
	private String codCentroCustos;
	
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
	public String getCodSkuOdin() {
		return codSkuOdin;
	}
	public void setCodSkuOdin(String codSkuOdin) {
		this.codSkuOdin = codSkuOdin;
	}
	public String getValorItemFatura() {
		return valorItemFatura;
	}
	public void setValorItemFatura(String valorItemFatura) {
		this.valorItemFatura = valorItemFatura;
	}
	public String getCodContaContabil() {
		return codContaContabil;
	}
	public void setCodContaContabil(String codContaContabil) {
		this.codContaContabil = codContaContabil;
	}
	public String getCodCentroCustos() {
		return codCentroCustos;
	}
	public void setCodCentroCustos(String codCentroCustos) {
		this.codCentroCustos = codCentroCustos;
	}	
	
	

	

}
