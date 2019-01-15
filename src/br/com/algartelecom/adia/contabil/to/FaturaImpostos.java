package br.com.algartelecom.adia.contabil.to;

import java.util.Date;

public class FaturaImpostos {
	
	private String indTipoChave; //ind_tipo_chave
	private String idtChaveFatura; //idt_chave_fatura
	private String idtClienteOdin; //idt_cliente_odin
	private String nomModalidadePagto; //nom_modalidade_pagto
	private String nomFormaPagamento; //nom_forma_pagto
	private String nomBandeiraCartao; //nom_bandeira_cartao
	private String numContrato; //num_contrato
	private String codPlanoServico; //cod_plano_servico
	private String dscItemFatura; //dsc_item_fatura
	private String dtaAtivacao; //dta_ativacao
	private String valItemFatura; //val_item_fatura
	private String dtaCriacaoItem; //dta_criacao_item
	private String dtaVencimento; //dta_vencimento
	private String dtaPagamentoItem; //dta_pagamento_item
	private String dtaPrevistaCredito; //dta_prevista_credito
	private String codFaturaOdin; //cod_fatura_odin
	private String codItemFaturaOdin; //cod_itemfatura_odin
	private String numPercAliqISS; //num_perc_aliq_iss
	private String valISS; //val_iss
	private String numPercAliqCofins; //num_perc_aliq_cofins
	private String valCofins; //val_cofins
	private String numPercAliqPis; //num_perc_aliq_pis
	private String valPis; //val_pis
	private String codContaContabil; //cod_conta_contabil
	private String nomVendedor; //nom_vendedor
	private String codAtividadeItem; //cod_atividade_item
	private String codSkuOdin; //cod_sku_odin
	private String codVendedor; //cod_vendedor
	private String idtControleNFE; //idt_controle_nfe
	private String idtFatura; //idt_fatura
	private String numDocumentoCliente; //num_documento_cliente
	private String numRPSBatChid; //num_rpsbatchid
	private String nomSerieRps; //nom_serie_rps
	private String numRPS; //num_rps
	private Date dtaEmissaoRPS; //dta_emissao_rps
	private String nomStatusLote; //nom_status_lote
	private String nomStatusRPS; //nom_status_rps
	private String codMunicipioSiaf; //cod_municipio_siaf
	private String dtaPrimeiroEnvio; //dta_primeiro_envio
	private String dtaPrimeiroRetorno; //dta_primeiro_retorno
	private String dtaUltimoEnvio; //dta_ultimo_envio
	private String dtaUltimoRetorno; //dta_ultimo_retorno
	private String numNFSe; //num_nfse
	private String codChaveNFSe; //cod_chave_nfse
	private Date dtaProcessamentoNFSe; //dta_processamento_nfse
	private String dtaCriacao; //dta_criacao
	private String codCentroCustos; //cod_centro_custos
	private String retencao;
	
	public String getIndTipoChave() {
		return indTipoChave;
	}
	public void setIndTipoChave(String indTipoChave) {
		this.indTipoChave = indTipoChave;
	}
	public String getIdtChaveFatura() {
		return idtChaveFatura;
	}
	public void setIdtChaveFatura(String idtChaveFatura) {
		this.idtChaveFatura = idtChaveFatura;
	}
	public String getIdtClienteOdin() {
		return idtClienteOdin;
	}
	public void setIdtClienteOdin(String idtClienteOdin) {
		this.idtClienteOdin = idtClienteOdin;
	}
	public String getNomModalidadePagto() {
		return nomModalidadePagto;
	}
	public void setNomModalidadePagto(String nomModalidadePagto) {
		this.nomModalidadePagto = nomModalidadePagto;
	}
	public String getNomFormaPagamento() {
		return nomFormaPagamento;
	}
	public void setNomFormaPagamento(String nomFormaPagamento) {
		this.nomFormaPagamento = nomFormaPagamento;
	}
	public String getNomBandeiraCartao() {
		return nomBandeiraCartao;
	}
	public void setNomBandeiraCartao(String nomBandeiraCartao) {
		this.nomBandeiraCartao = nomBandeiraCartao;
	}
	public String getNumContrato() {
		return numContrato;
	}
	public void setNumContrato(String numContrato) {
		this.numContrato = numContrato;
	}
	public String getCodPlanoServico() {
		return codPlanoServico;
	}
	public void setCodPlanoServico(String codPlanoServico) {
		this.codPlanoServico = codPlanoServico;
	}
	public String getDscItemFatura() {
		return dscItemFatura;
	}
	public void setDscItemFatura(String dscItemFatura) {
		this.dscItemFatura = dscItemFatura;
	}
	public String getDtaAtivacao() {
		return dtaAtivacao;
	}
	public void setDtaAtivacao(String dtaAtivacao) {
		this.dtaAtivacao = dtaAtivacao;
	}
	public String getValItemFatura() {
		return valItemFatura;
	}
	public void setValItemFatura(String valItemFatura) {
		this.valItemFatura = valItemFatura;
	}
	public String getDtaCriacaoItem() {
		return dtaCriacaoItem;
	}
	public void setDtaCriacaoItem(String dtaCriacaoItem) {
		this.dtaCriacaoItem = dtaCriacaoItem;
	}
	public String getDtaVencimento() {
		return dtaVencimento;
	}
	public void setDtaVencimento(String dtaVencimento) {
		this.dtaVencimento = dtaVencimento;
	}
	public String getDtaPagamentoItem() {
		return dtaPagamentoItem;
	}
	public void setDtaPagamentoItem(String dtaPagamentoItem) {
		this.dtaPagamentoItem = dtaPagamentoItem;
	}
	public String getDtaPrevistaCredito() {
		return dtaPrevistaCredito;
	}
	public void setDtaPrevistaCredito(String dtaPrevistaCredito) {
		this.dtaPrevistaCredito = dtaPrevistaCredito;
	}
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
	public String getNumPercAliqISS() {
		return numPercAliqISS;
	}
	public void setNumPercAliqISS(String numPercAliqISS) {
		this.numPercAliqISS = numPercAliqISS;
	}
	public String getValISS() {
		return valISS;
	}
	public void setValISS(String valISS) {
		this.valISS = valISS;
	}
	public String getNumPercAliqCofins() {
		return numPercAliqCofins;
	}
	public void setNumPercAliqCofins(String numPercAliqCofins) {
		this.numPercAliqCofins = numPercAliqCofins;
	}
	public String getValCofins() {
		return valCofins;
	}
	public void setValCofins(String valCofins) {
		this.valCofins = valCofins;
	}
	public String getNumPercAliqPis() {
		return numPercAliqPis;
	}
	public void setNumPercAliqPis(String numPercAliqPis) {
		this.numPercAliqPis = numPercAliqPis;
	}
	public String getValPis() {
		return valPis;
	}
	public void setValPis(String valPis) {
		this.valPis = valPis;
	}
	public String getCodContaContabil() {
		return codContaContabil;
	}
	public void setCodContaContabil(String codContaContabil) {
		this.codContaContabil = codContaContabil;
	}
	public String getNomVendedor() {
		return nomVendedor;
	}
	public void setNomVendedor(String nomVendedor) {
		this.nomVendedor = nomVendedor;
	}
	public String getCodAtividadeItem() {
		return codAtividadeItem;
	}
	public void setCodAtividadeItem(String codAtividadeItem) {
		this.codAtividadeItem = codAtividadeItem;
	}
	public String getCodSkuOdin() {
		return codSkuOdin;
	}
	public void setCodSkuOdin(String codSkuOdin) {
		this.codSkuOdin = codSkuOdin;
	}
	public String getCodVendedor() {
		return codVendedor;
	}
	public void setCodVendedor(String codVendedor) {
		this.codVendedor = codVendedor;
	}
	public String getIdtControleNFE() {
		return idtControleNFE;
	}
	public void setIdtControleNFE(String idtControleNFE) {
		this.idtControleNFE = idtControleNFE;
	}
	public String getIdtFatura() {
		return idtFatura;
	}
	public void setIdtFatura(String idtFatura) {
		this.idtFatura = idtFatura;
	}
	public String getNumDocumentoCliente() {
		return numDocumentoCliente;
	}
	public void setNumDocumentoCliente(String numDocumentoCliente) {
		this.numDocumentoCliente = numDocumentoCliente;
	}
	public String getNumRPSBatChid() {
		return numRPSBatChid;
	}
	public void setNumRPSBatChid(String numRPSBatChid) {
		this.numRPSBatChid = numRPSBatChid;
	}
	public String getNomSerieRps() {
		return nomSerieRps;
	}
	public void setNomSerieRps(String nomSerieRps) {
		this.nomSerieRps = nomSerieRps;
	}
	public String getNumRPS() {
		return numRPS;
	}
	public void setNumRPS(String numRPS) {
		this.numRPS = numRPS;
	}
	public Date getDtaEmissaoRPS() {
		return dtaEmissaoRPS;
	}
	public void setDtaEmissaoRPS(Date dtaEmissaoRPS) {
		this.dtaEmissaoRPS = dtaEmissaoRPS;
	}
	public String getNomStatusLote() {
		return nomStatusLote;
	}
	public void setNomStatusLote(String nomStatusLote) {
		this.nomStatusLote = nomStatusLote;
	}
	public String getNomStatusRPS() {
		return nomStatusRPS;
	}
	public void setNomStatusRPS(String nomStatusRPS) {
		this.nomStatusRPS = nomStatusRPS;
	}
	public String getCodMunicipioSiaf() {
		return codMunicipioSiaf;
	}
	public void setCodMunicipioSiaf(String codMunicipioSiaf) {
		this.codMunicipioSiaf = codMunicipioSiaf;
	}
	public String getDtaPrimeiroEnvio() {
		return dtaPrimeiroEnvio;
	}
	public void setDtaPrimeiroEnvio(String dtaPrimeiroEnvio) {
		this.dtaPrimeiroEnvio = dtaPrimeiroEnvio;
	}
	public String getDtaPrimeiroRetorno() {
		return dtaPrimeiroRetorno;
	}
	public void setDtaPrimeiroRetorno(String dtaPrimeiroRetorno) {
		this.dtaPrimeiroRetorno = dtaPrimeiroRetorno;
	}
	public String getDtaUltimoEnvio() {
		return dtaUltimoEnvio;
	}
	public void setDtaUltimoEnvio(String dtaUltimoEnvio) {
		this.dtaUltimoEnvio = dtaUltimoEnvio;
	}
	public String getDtaUltimoRetorno() {
		return dtaUltimoRetorno;
	}
	public void setDtaUltimoRetorno(String dtaUltimoRetorno) {
		this.dtaUltimoRetorno = dtaUltimoRetorno;
	}
	public String getNumNFSe() {
		return numNFSe;
	}
	public void setNumNFSe(String numNFSe) {
		this.numNFSe = numNFSe;
	}
	public String getCodChaveNFSe() {
		return codChaveNFSe;
	}
	public void setCodChaveNFSe(String codChaveNFSe) {
		this.codChaveNFSe = codChaveNFSe;
	}
	public Date getDtaProcessamentoNFSe() {
		return dtaProcessamentoNFSe;
	}
	public void setDtaProcessamentoNFSe(Date dtaProcessamentoNFSe) {
		this.dtaProcessamentoNFSe = dtaProcessamentoNFSe;
	}
	public String getDtaCriacao() {
		return dtaCriacao;
	}
	public void setDtaCriacao(String dtaCriacao) {
		this.dtaCriacao = dtaCriacao;
	}
	public String getCodCentroCustos() {
		return codCentroCustos;
	}
	public void setCodCentroCustos(String codCentroCustos) {
		this.codCentroCustos = codCentroCustos;
	}
	public String getRetencao() {
		return retencao;
	}
	public void setRetencao(String retencao) {
		this.retencao = retencao;
	}

	

}
