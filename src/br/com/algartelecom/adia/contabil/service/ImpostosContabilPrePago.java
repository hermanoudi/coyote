package br.com.algartelecom.adia.contabil.service;

import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.Enum.DebitoCredito;
import br.com.algartelecom.adia.contabil.rules.ContabilCofinsRules;
import br.com.algartelecom.adia.contabil.rules.ContabilCofinsRulesPrePago;
import br.com.algartelecom.adia.contabil.rules.ContabilISSRules;
import br.com.algartelecom.adia.contabil.rules.ContabilPISPrePagoRules;
import br.com.algartelecom.adia.contabil.rules.ContabilPISRules;
import br.com.algartelecom.adia.contabil.to.FaturaImpostos;
import br.com.algartelecom.adia.contabil.to.FaturasPrePago;

public class ImpostosContabilPrePago {

	public List<String> montaImpostos(List<FaturasPrePago> contabilFaturamentoImpostosCreditoEDebito) throws Exception {
			
		List<String> faturasAjustadas = new ArrayList<String>();

		List<String> dadosCOFINSCredito = montaDadosCOFINSCredito(contabilFaturamentoImpostosCreditoEDebito);
		List<String> dadosCOFINSDebito =  montaDadosCOFINSDebito(contabilFaturamentoImpostosCreditoEDebito);
		
		List<String> dadosPISCredito = montaDadosPISCredito(contabilFaturamentoImpostosCreditoEDebito);
		List<String> dadosPISDebito =  montaDadosPISDebito(contabilFaturamentoImpostosCreditoEDebito);
		
		faturasAjustadas.addAll(dadosCOFINSCredito);
		faturasAjustadas.addAll(dadosCOFINSDebito);
		
		faturasAjustadas.addAll(dadosPISCredito);
		faturasAjustadas.addAll(dadosPISDebito);
		
		return faturasAjustadas;

	}
	
	private List<String> montaDadosPISDebito(List<FaturasPrePago> contabilFaturamentoImpostosCreditoEDebito) throws Exception {
		
		List<String> dadosPISDebito = new ArrayList<String>();
		
		for (FaturasPrePago faturaImpostos : contabilFaturamentoImpostosCreditoEDebito) {
			if (faturaImpostos.getValorConsumo() == null || faturaImpostos.getValorConsumo().equals("")){
				continue;
			}
			ContabilPISPrePagoRules issDebito = new ContabilPISPrePagoRules(faturaImpostos, DebitoCredito.DEBITO.getNome());
			dadosPISDebito.add(issDebito.toString());
		}
		return dadosPISDebito;
	}

	private List<String> montaDadosPISCredito(List<FaturasPrePago> contabilFaturamentoImpostosCreditoEDebito) throws Exception {
		
		List<String> dadosPISCredito = new ArrayList<String>();
		
		for (FaturasPrePago faturaImpostos : contabilFaturamentoImpostosCreditoEDebito) {
			if (faturaImpostos.getValorConsumo() == null || faturaImpostos.getValorConsumo().equals("")){
				continue;
			}
			ContabilPISPrePagoRules pisCredito = new ContabilPISPrePagoRules(faturaImpostos, DebitoCredito.CREDITO.getNome());
			dadosPISCredito.add(pisCredito.toString());
		}
		return dadosPISCredito;
	}

	private List<String> montaDadosCOFINSDebito(List<FaturasPrePago> contabilFaturamentoImpostosCreditoEDebito) throws Exception {
		
		List<String> dadosCofinsDebito = new ArrayList<String>();
		
		for (FaturasPrePago faturasPrePago : contabilFaturamentoImpostosCreditoEDebito) {
			if (faturasPrePago.getValorConsumo() == null || faturasPrePago.getValorConsumo().equals("")){
				continue;
			}

			ContabilCofinsRulesPrePago cofinsDebito = new ContabilCofinsRulesPrePago(faturasPrePago, DebitoCredito.DEBITO.getNome());
			dadosCofinsDebito.add(cofinsDebito.toString());
		}
		return dadosCofinsDebito;
	}

	private List<String> montaDadosCOFINSCredito(List<FaturasPrePago> contabilFaturamentoImpostosCreditoEDebito) throws Exception {
		
		List<String> dadosCofinsCredito = new ArrayList<String>();
		
		for (FaturasPrePago faturasPrePago : contabilFaturamentoImpostosCreditoEDebito) {
			if (faturasPrePago.getValorConsumo() == null || faturasPrePago.getValorConsumo().equals("")){
				continue;
			}

			ContabilCofinsRulesPrePago cofinsCredito = new ContabilCofinsRulesPrePago(faturasPrePago, DebitoCredito.CREDITO.getNome());
			dadosCofinsCredito.add(cofinsCredito.toString());
		}
		return dadosCofinsCredito;
	}

}