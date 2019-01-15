package br.com.algartelecom.adia.contabil.rules;


public abstract class AbstractContabilFaturamentoRules {
	
	protected String dataContabilizacaoLancamento;
	protected String dataCriacaoLancamento;
	protected String criadoPor;
	protected String categoriaLancamento;
	protected String origem;
	protected String empresa;
	protected String regulamento;
	protected String projeto;
	protected String contaContabil;
	protected String centroResultado;
	protected String produto;
	protected String intercompany;
	protected String uf;
	protected String anatel;
	protected String reserva1;
	protected String reserva2;
	protected String valorDebito;
	protected String valorCredito;
	protected String valorDebito1;
	protected String valorCredito1;
	protected String nomeLote;
	protected String descricaoLote;
	protected String nomeLancamento;
	protected String descricaoLancamento;
	protected String DescricaoLinhaLancamento;
	protected String codigoRastreamentoLote;
	protected String periodoContabil;
	protected String dataCriacao;
	protected String identificadorLote;
	protected String dataCredito;
	
	@Override
	public String toString() {
		return this.dataContabilizacaoLancamento +";"+
				this.dataCriacaoLancamento +";"+
				this.criadoPor +";"+
				this.categoriaLancamento +";"+
				this.origem +";"+
				this.empresa +";"+
				this.regulamento +";"+
				this.projeto +";"+
				this.contaContabil +";"+
				this.centroResultado +";"+
				this.produto +";"+
				this.intercompany +";"+
				this.uf +";"+
				this.anatel +";"+
				this.reserva1 +";"+
				this.reserva2 +";"+
				this.valorDebito +";"+
				this.valorCredito +";"+
				this.valorDebito1 +";"+
				this.valorCredito1 +";"+
				this.nomeLote +";"+
				this.descricaoLote +";"+
				this.nomeLancamento +";"+
				this.descricaoLancamento +";"+
				this.DescricaoLinhaLancamento +";"+
				this.codigoRastreamentoLote +";"+
				this.periodoContabil +";"+
				this.dataCriacao +";"+
				this.identificadorLote +";"+
				this.dataCredito;
	}
	
	
	
}
