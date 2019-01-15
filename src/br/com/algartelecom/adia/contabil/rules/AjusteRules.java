package br.com.algartelecom.adia.contabil.rules;

import br.com.algartelecom.adia.Enum.ContaContabilEnum;
import br.com.algartelecom.adia.Enum.DebitoCredito;
import br.com.algartelecom.adia.contabil.to.AjusteFatura;
import br.com.algartelecom.adia.contabil.to.FaturaImpostos;
import br.com.algartelecom.adia.util.CentroDeResultado;
import br.com.algartelecom.adia.util.FormataData;
import br.com.algartelecom.adia.util.FormataValores;
import br.com.algartelecom.adia.util.MontaCamposArquivosPosicionais;

public class AjusteRules extends AbstractContabilFaturamentoRules {
	
	public AjusteRules(AjusteFatura ajuste, String creditoOuDebito) throws Exception {
		montaAtributos(ajuste, creditoOuDebito);
	}

	private void montaAtributos(AjusteFatura ajuste, String creditoOuDebito) throws Exception {
		
		super.dataContabilizacaoLancamento = FormataData.formataDataPadraoBrasilSemHoras(ajuste.getDataAplicacaoNota());
		super.dataCriacaoLancamento = FormataData.formataDataPadraoBrasilSemHoras(ajuste.getDataAplicacaoNota());
		super.criadoPor = "0";
		super.categoriaLancamento = "Ajuste";
		super.origem = "ODIN";
		super.empresa = "302";
		super.projeto = "0000";
		//TODO: Quando tiver intercompany, dever� ser alterado
		super.intercompany = "000";
		super.anatel = "0000";
		super.reserva1 = "00000";
		super.reserva2 = "00000";
		super.nomeLote = "103302 ODIN A 016" + FormataData.getDataHoraAtualSemSegundos_Americano();
		super.descricaoLote = "Ajuste ODIN 016" + FormataData.getDataHoraAtualSemSegundos_Americano();
		super.nomeLancamento = "302016 ODIN";
		super.descricaoLancamento = "Ajuste 302016 ODIN";
		super.periodoContabil = FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula();
		super.identificadorLote = "016" + FormataData.getDataHoraAtualSemSegundos_Americano();
		super.dataCredito = FormataData.formataDataPadraoBrasilSemHoras(ajuste.getDataAplicacaoNota());
		//TODO: Quando entrarem os outros produtos, Office, Backup, Monitoramento e Servicos Profissionais, como ficar� este campo
		super.dataCriacao = FormataData.formataDataAtualPadraoBrasilSemHoras();
		
		if (isCredito(creditoOuDebito)){
			montaAtributosDebito(ajuste);
		} else{
			montaAtributosCredito(ajuste);
		}

		
	}
	
	private void montaAtributosCredito(AjusteFatura ajuste) {
		
		super.contaContabil = ContaContabilEnum.ELASTIC_AJUSTE_CREDITO.getCodigo();
		super.regulamento = "000";
		super.centroResultado = "000000000"; 
		super.produto = "000000000000";
		super.uf = "00";
		super.valorDebito = "0,00"; 
		super.valorCredito = FormataValores.substituiSeparadorDecimalPontoPorVirgula(ajuste.getValorNotaCredito());
		super.valorDebito1 = "0,00";
		super.valorCredito1 = super.valorCredito;
		super.codigoRastreamentoLote =  FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula() + "_Credito_POS-PAGO_Ajuste_" + super.contaContabil + "_" + ajuste.getIdNotaCredito();
		super.DescricaoLinhaLancamento = "AJUSTE Credito POS-PAGO Elastic Cloud " + FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula();
	
	}

	private void montaAtributosDebito(AjusteFatura ajuste) throws Exception {
		
		super.contaContabil = ContaContabilEnum.ELASTIC_AJUSTE_DEBITO.getCodigo();
		super.regulamento = "001";
		super.centroResultado = MontaCamposArquivosPosicionais.preencherCampo(CentroDeResultado.substituiCREmBrancoPorCRdeUberlandia(ajuste.getCentroResultado()), 9, true); 
		super.produto = MontaCamposArquivosPosicionais.preencherCampo(ajuste.getCodSkuOdin(), 12, true);
		super.uf = "MG";
		super.valorDebito = FormataValores.substituiSeparadorDecimalPontoPorVirgula(ajuste.getValorNotaCredito());
		super.valorCredito = "0,00";
		super.valorDebito1 = super.valorDebito;
		super.valorCredito1 = "0,00";
		super.codigoRastreamentoLote =  FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula() + "_Debito_POS-PAGO_Ajuste_" + super.contaContabil + "_" + ajuste.getIdNotaCredito();
		super.DescricaoLinhaLancamento = "AJUSTE Debito POS-PAGO Elastic Cloud " + FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula();
	}
	
	private boolean isCredito(String creditoOuDebito) {
		if (creditoOuDebito.equalsIgnoreCase(DebitoCredito.CREDITO.getNome())){
			return true;
		} else{
			return false;
		}
	}



}
