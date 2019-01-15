package br.com.algartelecom.adia.contabil.service;

import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.Enum.DebitoCredito;
import br.com.algartelecom.adia.contabil.rules.AjusteRules;
import br.com.algartelecom.adia.contabil.rules.ArrecacaoPosPagoRules;
import br.com.algartelecom.adia.contabil.to.AjusteFatura;
import br.com.algartelecom.adia.contabil.to.ArrecadacaoPosPago;

public class ArrecadacaoPosPagoService {

	public List<String> montaArrecadacaoCreditoDebito(List<ArrecadacaoPosPago> arrecadacaoPosPago) throws Exception {
		
		List<String> dadosArrecadacaoCredito = montaDadosArrecadacaoCredito(arrecadacaoPosPago);
		List<String> dadosArrecadacaoDebito =  montaDadosArrecadacaoDebito(arrecadacaoPosPago);;
		
		List<String> arrecadacoes = new ArrayList<String>();
				
		arrecadacoes.addAll(dadosArrecadacaoCredito);
		arrecadacoes.addAll(dadosArrecadacaoDebito);
		
		return arrecadacoes;
	}
	
	public List<String> montaDadosArrecadacaoDebito(List<ArrecadacaoPosPago> arrecadacaoCreditoDebito) throws Exception {
		
		List<String> dadosArrecadacao = new ArrayList<String>();
		for (ArrecadacaoPosPago arrecadacao : arrecadacaoCreditoDebito) {
			ArrecacaoPosPagoRules arrecadacaoDebito = new ArrecacaoPosPagoRules(arrecadacao, DebitoCredito.DEBITO.getNome());
			dadosArrecadacao.add(arrecadacaoDebito.toString());
		}
		return dadosArrecadacao;
	}

	public List<String> montaDadosArrecadacaoCredito(List<ArrecadacaoPosPago> arrecadacaoCreditoDebito) throws Exception {
		
		List<String> dadosArrecadacao= new ArrayList<String>();
		
		for (ArrecadacaoPosPago arrecadacao : arrecadacaoCreditoDebito) {
			ArrecacaoPosPagoRules arrecadacaoCredito = new ArrecacaoPosPagoRules(arrecadacao, DebitoCredito.CREDITO.getNome());
			dadosArrecadacao.add(arrecadacaoCredito.toString());
		}
		return dadosArrecadacao;
	}
	
	

}
