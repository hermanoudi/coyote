package br.com.algartelecom.adia.contabil.service;

import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.Enum.DebitoCredito;
import br.com.algartelecom.adia.contabil.rules.ArrecacaoPosPagoRules;
import br.com.algartelecom.adia.contabil.rules.ArrecacaoPrePagoRules;
import br.com.algartelecom.adia.contabil.to.ArrecadacaoPrePago;

public class ArrecadacaoPrePagoService {
	
	public List<String> montaArrecadacaoCreditoDebito(List<ArrecadacaoPrePago> ArrecadacaoPrePago) throws Exception {
		
		List<String> dadosArrecadacaoCredito = montaDadosArrecadacaoCredito(ArrecadacaoPrePago);
		List<String> dadosArrecadacaoDebito =  montaDadosArrecadacaoDebito(ArrecadacaoPrePago);;
		
		List<String> arrecadacoes = new ArrayList<String>();
				
		arrecadacoes.addAll(dadosArrecadacaoCredito);
		arrecadacoes.addAll(dadosArrecadacaoDebito);
		
		return arrecadacoes;
	}
	
	public List<String> montaDadosArrecadacaoDebito(List<ArrecadacaoPrePago> arrecadacaoCreditoDebito) throws Exception {
		
		List<String> dadosArrecadacao = new ArrayList<String>();
		for (ArrecadacaoPrePago arrecadacao : arrecadacaoCreditoDebito) {
			ArrecacaoPrePagoRules arrecadacaoDebito = new ArrecacaoPrePagoRules(arrecadacao, DebitoCredito.DEBITO.getNome());
			dadosArrecadacao.add(arrecadacaoDebito.toString());
		}
		return dadosArrecadacao;
	}

	public List<String> montaDadosArrecadacaoCredito(List<ArrecadacaoPrePago> arrecadacaoCreditoDebito) throws Exception {
		
		List<String> dadosArrecadacao= new ArrayList<String>();
		
		for (ArrecadacaoPrePago arrecadacao : arrecadacaoCreditoDebito) {
			ArrecacaoPrePagoRules arrecadacaoCredito = new ArrecacaoPrePagoRules(arrecadacao, DebitoCredito.CREDITO.getNome());
			dadosArrecadacao.add(arrecadacaoCredito.toString());
		}
		return dadosArrecadacao;
	}


}
