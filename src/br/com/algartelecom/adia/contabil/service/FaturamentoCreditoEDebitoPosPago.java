package br.com.algartelecom.adia.contabil.service;

import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.Enum.DebitoCredito;
import br.com.algartelecom.adia.contabil.rules.ContabilFaturamentoPosPagoRules;
import br.com.algartelecom.adia.contabil.to.FaturaImpostos;
import br.com.algartelecom.adia.contabil.to.FaturasPrePago;

public class FaturamentoCreditoEDebitoPosPago {
	
	public List<String> montaFaturamentoCreditoDebito(List<FaturaImpostos> contabilFaturamentoImpostosCreditoEDebito) throws Exception {
		
		List<String> dadosFaturamentoCredito = montaDadosFaturamentoCredito(contabilFaturamentoImpostosCreditoEDebito);
		List<String> dadosFaturamentoDebito =  montaDadosFaturamentoDebito(contabilFaturamentoImpostosCreditoEDebito);;
		
		List<String> faturasAjustadas = new ArrayList<String>();
				
		faturasAjustadas.addAll(dadosFaturamentoCredito);
		faturasAjustadas.addAll(dadosFaturamentoDebito);
		
		return faturasAjustadas;
	}

	public List<String> montaDadosFaturamentoDebito(List<FaturaImpostos> contabilFaturamentoImpostosCreditoEDebito) throws Exception {
		
		List<String> dadosFaturamentoDebito = new ArrayList<String>();
		for (FaturaImpostos faturaImpostos : contabilFaturamentoImpostosCreditoEDebito) {
			ContabilFaturamentoPosPagoRules faturamentoDebito = new ContabilFaturamentoPosPagoRules(faturaImpostos, DebitoCredito.DEBITO.getNome());
			dadosFaturamentoDebito.add(faturamentoDebito.toString());
		}
		return dadosFaturamentoDebito;
	}

	public List<String> montaDadosFaturamentoCredito(List<FaturaImpostos> contabilFaturamentoImpostosCreditoEDebito) throws Exception {
		
		List<String> dadosFaturamentoCredito = new ArrayList<String>();
		
		for (FaturaImpostos faturaImpostos : contabilFaturamentoImpostosCreditoEDebito) {
			ContabilFaturamentoPosPagoRules faturamentoCredito = new ContabilFaturamentoPosPagoRules(faturaImpostos, DebitoCredito.CREDITO.getNome());
			dadosFaturamentoCredito.add(faturamentoCredito.toString());
		}
		return dadosFaturamentoCredito;
	}

}
