package br.com.algartelecom.adia.contabil.service;

import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.Enum.DebitoCredito;
import br.com.algartelecom.adia.contabil.rules.ArrecadacaoContabilISSPrePagoRules;
import br.com.algartelecom.adia.contabil.to.ArrecadacaoPrePago;

public class ArrecadacaoImpostosContabilPrePago {

	public List<String> montaImpostos(List<ArrecadacaoPrePago> arrecadacaoPrePago) throws Exception {
		
		List<String> faturasAjustadas = new ArrayList<String>();

		List<String> dadosISSCredito = montaDadosISSCredito(arrecadacaoPrePago);
		List<String> dadosISSDebito =  montaDadosISSDebito(arrecadacaoPrePago);
		
		
		faturasAjustadas.addAll(dadosISSCredito);
		faturasAjustadas.addAll(dadosISSDebito);
		
		return faturasAjustadas;

	}

	private List<String> montaDadosISSDebito(List<ArrecadacaoPrePago> arrecadacaoPrePago) throws Exception {

		List<String> dadosISSDebito = new ArrayList<String>();
		
		for (ArrecadacaoPrePago arrecadacaoISS : arrecadacaoPrePago) {
			ArrecadacaoContabilISSPrePagoRules issDebito = new ArrecadacaoContabilISSPrePagoRules(arrecadacaoISS, DebitoCredito.DEBITO.getNome());
			dadosISSDebito.add(issDebito.toString());
		}
		return dadosISSDebito;
	}

	private List<String> montaDadosISSCredito(List<ArrecadacaoPrePago> arrecadacaoPrePago) throws Exception {

		List<String> dadosISSCredito = new ArrayList<String>();
		
		for (ArrecadacaoPrePago arrecadacaoISS : arrecadacaoPrePago) {
			ArrecadacaoContabilISSPrePagoRules issCredito = new ArrecadacaoContabilISSPrePagoRules(arrecadacaoISS, DebitoCredito.CREDITO.getNome());
			dadosISSCredito.add(issCredito.toString());
		}
		return dadosISSCredito;
	}

}
