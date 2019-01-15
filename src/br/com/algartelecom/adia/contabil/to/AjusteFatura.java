package br.com.algartelecom.adia.contabil.to;

import java.util.Date;

public class AjusteFatura {
	
	private String idNotaCredito;
	private String valorNotaCredito;
	private Date dataAplicacaoNota;
	private String centroResultado;
	private String codSkuOdin;
	
	public String getIdNotaCredito() {
		return idNotaCredito;
	}
	public void setIdNotaCredito(String idNotaCredito) {
		this.idNotaCredito = idNotaCredito;
	}
	public String getValorNotaCredito() {
		return valorNotaCredito;
	}
	public void setValorNotaCredito(String valorNotaCredito) {
		this.valorNotaCredito = valorNotaCredito;
	}
	public Date getDataAplicacaoNota() {
		return dataAplicacaoNota;
	}
	public void setDataAplicacaoNota(Date dataAplicacaoNota) {
		this.dataAplicacaoNota = dataAplicacaoNota;
	}
	public String getCentroResultado() {
		return centroResultado;
	}
	public void setCentroResultado(String centroResultado) {
		this.centroResultado = centroResultado;
	}
	public String getCodSkuOdin() {
		return codSkuOdin;
	}
	public void setCodSkuOdin(String codSkuOdin) {
		this.codSkuOdin = codSkuOdin;
	}

	
	
	

}
