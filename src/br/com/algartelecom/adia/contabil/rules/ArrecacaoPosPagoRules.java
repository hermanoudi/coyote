package br.com.algartelecom.adia.contabil.rules;

import br.com.algartelecom.adia.Enum.ContaContabilEnum;
import br.com.algartelecom.adia.Enum.DebitoCredito;
import br.com.algartelecom.adia.contabil.to.ArrecadacaoPosPago;
import br.com.algartelecom.adia.util.FormataData;
import br.com.algartelecom.adia.util.FormataValores;
import br.com.algartelecom.adia.util.MontaCamposArquivosPosicionais;

public class ArrecacaoPosPagoRules extends AbstractContabilFaturamentoRules{
	
	public ArrecacaoPosPagoRules(ArrecadacaoPosPago arrecadacao, String creditoOuDebito) throws Exception {
		montaAtributos(arrecadacao, creditoOuDebito);
	}

	private void montaAtributos(ArrecadacaoPosPago arrecadacao, String creditoOuDebito) throws Exception {
		
		super.dataContabilizacaoLancamento = FormataData.formataDataPadraoBrasilSemHoras(arrecadacao.getDataPrevistaCredito());
		super.dataCriacaoLancamento = FormataData.formataDataPadraoBrasilSemHoras(arrecadacao.getDataPrevistaCredito());
		super.criadoPor = "0";
		super.categoriaLancamento = "Baixa";
		super.origem = "ODIN_ARRECADACAO";
		super.empresa = "302";
		super.projeto = "0000";
		//TODO: Quando tiver intercompany, dever� ser alterado
		super.intercompany = "000";
		super.anatel = "0000";
		super.reserva1 = "00000";
		super.reserva2 = "00000";
		super.nomeLote = "105302 ODIN A 016" + FormataData.getDataHoraAtualSemSegundos_Americano();
		super.descricaoLote = "Baixa ODIN 016" + FormataData.getDataHoraAtualSemSegundos_Americano();
		super.nomeLancamento = "302016 ODIN";
		super.descricaoLancamento = "Baixa 302016 ODIN";
		super.periodoContabil = FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula();
		super.identificadorLote = "016" + FormataData.getDataHoraAtualSemSegundos_Americano();
		super.dataCredito = FormataData.formataDataPadraoBrasilSemHoras(arrecadacao.getDataPrevistaCredito());
		//TODO: Quando entrarem os outros produtos, Office, Backup, Monitoramento e Servicos Profissionais, como ficar� este campo
		super.dataCriacao = FormataData.formataDataAtualPadraoBrasilSemHoras();
		super.regulamento = "000";
		super.centroResultado = "000000000"; 
		super.produto = "000000000000";
		super.uf = "00";
		arrecadacao.setCodSkuOdin(MontaCamposArquivosPosicionais.preencherCampo(arrecadacao.getCodSkuOdin(), 12, true));
		
		if (isCredito(creditoOuDebito)){
			montaAtributosDebito(arrecadacao);
		} else{
			montaAtributosCredito(arrecadacao);
		}

		
	}
	
	private void montaAtributosCredito(ArrecadacaoPosPago arrecadacao) throws Exception {
		super.contaContabil = ContaContabilEnum.ELASTIC_ARRECADACAO_POS_CREDITO.getCodigo();
		super.valorDebito = "0,00"; 
		super.valorCredito = FormataValores.substituiSeparadorDecimalPontoPorVirgula(arrecadacao.getValorItemFatura());
		super.valorDebito1 = "0,00";
		super.valorCredito1 = super.valorCredito;
		super.codigoRastreamentoLote =  FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula() + "_Credito_POS-PAGO_Baixa_" + super.contaContabil + "_" + arrecadacao.getCodSkuOdin() + "_" +  arrecadacao.getCodItemFaturaOdin();
		super.DescricaoLinhaLancamento = "BAIXA Credito POS-PAGO Elastic Cloud " + FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula();
	}

	private void montaAtributosDebito(ArrecadacaoPosPago arrecadacao) throws Exception {
		
		super.contaContabil = ContaContabilEnum.ELASTIC_ARRECADACAO_POS_DEBITO.getCodigo();
		super.valorDebito = FormataValores.substituiSeparadorDecimalPontoPorVirgula(arrecadacao.getValorItemFatura());
		super.valorCredito = "0,00";
		super.valorDebito1 = super.valorDebito;
		super.valorCredito1 = "0,00";
		super.codigoRastreamentoLote =  FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula() + "_Debito_POS-PAGO_Baixa_" + super.contaContabil + "_" + arrecadacao.getCodSkuOdin() + "_" + arrecadacao.getCodItemFaturaOdin();
		super.DescricaoLinhaLancamento = "BAIXA_Debito POS-PAGO Elastic Cloud " + FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula();
	
	}
	
	private boolean isCredito(String creditoOuDebito) {
		if (creditoOuDebito.equalsIgnoreCase(DebitoCredito.CREDITO.getNome())){
			return true;
		} else{
			return false;
		}
	}


}
