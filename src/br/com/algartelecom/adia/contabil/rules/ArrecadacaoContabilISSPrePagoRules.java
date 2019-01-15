package br.com.algartelecom.adia.contabil.rules;

import br.com.algartelecom.adia.Enum.ContaContabilEnum;
import br.com.algartelecom.adia.Enum.DebitoCredito;
import br.com.algartelecom.adia.contabil.to.ArrecadacaoPrePago;
import br.com.algartelecom.adia.contabil.to.FaturaImpostos;
import br.com.algartelecom.adia.util.CentroDeResultado;
import br.com.algartelecom.adia.util.FormataData;
import br.com.algartelecom.adia.util.FormataValores;
import br.com.algartelecom.adia.util.MontaCamposArquivosPosicionais;

public class ArrecadacaoContabilISSPrePagoRules extends AbstractContabilFaturamentoRules {

	public ArrecadacaoContabilISSPrePagoRules(ArrecadacaoPrePago arrecadacaoPrePago, String creditoOuDebito) throws Exception {
		montaAtributos(arrecadacaoPrePago, creditoOuDebito);
	}

	private void montaAtributos(ArrecadacaoPrePago arrecadacaoPrePago, String creditoOuDebito) throws Exception {
		
		super.dataContabilizacaoLancamento = FormataData.formataDataPadraoBrasilSemHoras(arrecadacaoPrePago.getDataPrevistaCredito());
		super.dataCriacaoLancamento = FormataData.formataDataPadraoBrasilSemHoras(arrecadacaoPrePago.getDataPrevistaCredito());
		super.criadoPor = "0";
		super.categoriaLancamento = "Impostos";
		super.origem = "ODIN_ARRECADACAO";
		super.empresa = "302";
		super.projeto = "0000";
		//TODO: Quando tiver intercompany, dever� ser alterado
		super.intercompany = "000";
		super.anatel = "0000";
		super.reserva1 = "00000";
		super.reserva2 = "00000";
		super.nomeLote = "108302 ODIN A 016" + FormataData.getDataHoraAtualSemSegundos_Americano();
		super.descricaoLote = "Impostos ODIN 016" + FormataData.getDataHoraAtualSemSegundos_Americano();
		super.nomeLancamento = "302016 ODIN";
		super.descricaoLancamento = "Impostos 302016 ODIN";
		super.periodoContabil = FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula();
		super.identificadorLote = "016" + FormataData.getDataHoraAtualSemSegundos_Americano();
		super.dataCredito = FormataData.formataDataPadraoBrasilSemHoras(arrecadacaoPrePago.getDataPrevistaCredito());
		//TODO: Quando entrarem os outros produtos, Office, Backup, Monitoramento e Servicos Profissionais, como ficar� este campo
		super.dataCriacao = FormataData.formataDataAtualPadraoBrasilSemHoras();
		
		if (isCredito(creditoOuDebito)){
			montaAtributosDebito(arrecadacaoPrePago);
		} else{
			montaAtributosCredito(arrecadacaoPrePago);
		}

		
	}
	
	private void montaAtributosCredito(ArrecadacaoPrePago arrecadacaoPrePago) {
		
		super.contaContabil = ContaContabilEnum.ELASTIC_IMPOSTO_ISS_CREDITO.getCodigo();
		super.regulamento = "000";
		super.centroResultado = "000000000"; 
		super.produto = "000000000000";
		super.uf = "00";
		super.valorDebito = "0,00"; 
		super.valorCredito = FormataValores.substituiSeparadorDecimalPontoPorVirgula(arrecadacaoPrePago.getValISS());
		super.valorDebito1 = "0,00";
		super.valorCredito1 = super.valorCredito;
		super.codigoRastreamentoLote =  FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula() + "_Credito_PRE-PAGO_Impostos_" + super.contaContabil + "_" + super.produto + "_" + arrecadacaoPrePago.getCodItemFaturaOdin();
		super.DescricaoLinhaLancamento = "ISS_Credito PRE-PAGO Elastic Cloud " + FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula();
	}

	private void montaAtributosDebito(ArrecadacaoPrePago arrecadacaoPrePago) throws Exception {
		
		super.contaContabil = ContaContabilEnum.ELASTIC_IMPOSTO_ISS_DEBITO.getCodigo();
		super.regulamento = "001";
		super.centroResultado = MontaCamposArquivosPosicionais.preencherCampo(CentroDeResultado.substituiCREmBrancoPorCRdeUberlandia(arrecadacaoPrePago.getCodCentroCustos()), 9, true); 
		super.produto = MontaCamposArquivosPosicionais.preencherCampo(arrecadacaoPrePago.getCodSkuOdin(), 12, true);
		super.uf = "MG";
		super.valorDebito = FormataValores.substituiSeparadorDecimalPontoPorVirgula(arrecadacaoPrePago.getValISS());
		super.valorCredito = "0,00";
		super.valorDebito1 = super.valorDebito;
		super.valorCredito1 = "0,00";
		super.codigoRastreamentoLote =  FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula() + "_Debito_PRE-PAGO_Impostos_" + super.contaContabil + "_" + super.produto + "_" +  arrecadacaoPrePago.getCodItemFaturaOdin();
		super.DescricaoLinhaLancamento = "ISS Debito PRE-PAGO Elastic Cloud " + FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula();
	
	}
	
	private boolean isCredito(String creditoOuDebito) {
		if (creditoOuDebito.equalsIgnoreCase(DebitoCredito.CREDITO.getNome())){
			return true;
		} else{
			return false;
		}
	}



	

}
