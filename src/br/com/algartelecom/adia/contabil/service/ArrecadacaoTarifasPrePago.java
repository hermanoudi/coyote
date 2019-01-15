package br.com.algartelecom.adia.contabil.service;

import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.Enum.DebitoCredito;
import br.com.algartelecom.adia.contabil.rules.TarifasPosPagoRules;
import br.com.algartelecom.adia.contabil.rules.TarifasPrePagoRules;
import br.com.algartelecom.adia.contabil.to.Tarifa;

public class ArrecadacaoTarifasPrePago {

	public List<String> montaTarifas(List<Tarifa> tarifasPrePago, List<Tarifa> tarifasPosPago) throws Exception {
	
		List<String> tarifasAjustadas = new ArrayList<String>();

		List<String> dadosTarifasCreditoPrePago =  montaDadosTarifasCreditoPrePago(tarifasPrePago);
		List<String> dadosTarifasDebitoPrePago  =  montaDadosTarifasDebitoPrePago(tarifasPrePago);
		
		List<String> dadosTarifasCreditoPosPago =  montaDadosTarifasCreditoPosPago(tarifasPosPago);
		List<String> dadosTarifasDebitoPosPago  =  montaDadosTarifasDebitoPosPago(tarifasPosPago);
		
		
		tarifasAjustadas.addAll(dadosTarifasCreditoPrePago);
		tarifasAjustadas.addAll(dadosTarifasDebitoPrePago);
		
		tarifasAjustadas.addAll(dadosTarifasCreditoPosPago);
		tarifasAjustadas.addAll(dadosTarifasDebitoPosPago);
		
		return tarifasAjustadas;

	}

	private List<String> montaDadosTarifasDebitoPosPago(List<Tarifa> tarifasPosPago) throws Exception {
		
		List<String> dadosTarifasDebitoPosPago = new ArrayList<String>();
		for (Tarifa tarifa : tarifasPosPago) {
			
			TarifasPosPagoRules tarifaPrePago = new TarifasPosPagoRules(tarifa, DebitoCredito.DEBITO.getNome());
			dadosTarifasDebitoPosPago.add(tarifaPrePago.toString());
		}
		return dadosTarifasDebitoPosPago;
	}

	private List<String> montaDadosTarifasCreditoPosPago(List<Tarifa> tarifasPosPago) throws Exception {
		
		List<String> dadosTarifasCreditoPosPago = new ArrayList<String>();
		for (Tarifa tarifa : tarifasPosPago) {
			
			TarifasPosPagoRules tarifaPrePago = new TarifasPosPagoRules(tarifa, DebitoCredito.CREDITO.getNome());
			dadosTarifasCreditoPosPago.add(tarifaPrePago.toString());
		}
		return dadosTarifasCreditoPosPago;
	}

	private List<String> montaDadosTarifasDebitoPrePago(List<Tarifa> tarifasPeriodo) throws Exception {
		
		List<String> dadosTarifasDebitoPrePago = new ArrayList<String>();
		
		for (Tarifa tarifa : tarifasPeriodo) {
			
			TarifasPrePagoRules tarifaPrePago = new TarifasPrePagoRules(tarifa, DebitoCredito.DEBITO.getNome());
			dadosTarifasDebitoPrePago.add(tarifaPrePago.toString());
		}
		return dadosTarifasDebitoPrePago;
	}

	private List<String> montaDadosTarifasCreditoPrePago(List<Tarifa> tarifasPeriodo) throws Exception {
		
		List<String> dadosTarifasCreditoPrePago = new ArrayList<String>();
		
		for (Tarifa tarifa : tarifasPeriodo) {
			
			TarifasPrePagoRules tarifaPrePago = new TarifasPrePagoRules(tarifa, DebitoCredito.CREDITO.getNome());
			dadosTarifasCreditoPrePago.add(tarifaPrePago.toString());
		}
		return dadosTarifasCreditoPrePago;
	}

}
