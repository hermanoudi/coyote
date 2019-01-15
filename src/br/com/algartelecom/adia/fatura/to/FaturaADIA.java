package br.com.algartelecom.adia.fatura.to;

import java.util.Date;

public class FaturaADIA {
	
	private String codFaturaOdin;
	private String codItemFaturaOdin;
	private Date dtaPagamentoItem;
	private String nomFormaPagto;
	private Date dtaVencimento;
	private String valItemFatura;
	private String valorDoPagamento;
	private Date dtaPrevistaCredito;
	private String nomBandeira;
	
	
	public String getCodFaturaOdin() {
		return codFaturaOdin;
	}
	public void setCodFaturaOdin(String codFaturaOdin) {
		this.codFaturaOdin = codFaturaOdin;
	}
	public String getCodItemFaturaOdin() {
		return codItemFaturaOdin;
	}
	public void setCodItemFaturaOdin(String codItemFaturaOdin) {
		this.codItemFaturaOdin = codItemFaturaOdin;
	}
	public Date getDtaPagamentoItem() {
		return dtaPagamentoItem;
	}
	public void setDtaPagamentoItem(Date dtaPagamentoItem) {
		this.dtaPagamentoItem = dtaPagamentoItem;
	}
	public String getNomFormaPagto() {
		return nomFormaPagto;
	}
	public void setNomFormaPagto(String nomFormaPagto) {
		this.nomFormaPagto = nomFormaPagto;
	}
	public String getValItemFatura() {
		return valItemFatura;
	}
	public void setValItemFatura(String valItemFatura) {
		this.valItemFatura = valItemFatura;
	}
	public String getValorDoPagamento() {
		return valorDoPagamento;
	}
	public void setValorDoPagamento(String valorDoPagamento) {
		this.valorDoPagamento = valorDoPagamento;
	}
	public Date getDtaPrevistaCredito() {
		return dtaPrevistaCredito;
	}
	public void setDtaPrevistaCredito(Date dtaPrevistaCredito) {
		this.dtaPrevistaCredito = dtaPrevistaCredito;
	}
	public String getNomBandeira() {
		return nomBandeira;
	}
	public void setNomBandeira(String nomBandeira) {
		this.nomBandeira = nomBandeira;
	}
	public Date getDtaVencimento() {
		return dtaVencimento;
	}
	public void setDtaVencimento(Date dtaVencimento) {
		this.dtaVencimento = dtaVencimento;
	}
	
	

}
