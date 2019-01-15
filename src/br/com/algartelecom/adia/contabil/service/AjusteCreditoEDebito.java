package br.com.algartelecom.adia.contabil.service;

import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.Enum.DebitoCredito;
import br.com.algartelecom.adia.contabil.rules.AjusteRules;
import br.com.algartelecom.adia.contabil.to.AjusteFatura;

public class AjusteCreditoEDebito {
	
	public List<String> montaAjusteCreditoDebito(List<AjusteFatura> ajustesCreditoDebito) throws Exception {
		
		List<String> dadosFaturamentoCredito = montaDadosAjusteCredito(ajustesCreditoDebito);
		List<String> dadosFaturamentoDebito =  montaDadosAjusteDebito(ajustesCreditoDebito);;
		
		List<String> faturasAjustadas = new ArrayList<String>();
				
		faturasAjustadas.addAll(dadosFaturamentoCredito);
		faturasAjustadas.addAll(dadosFaturamentoDebito);
		
		return faturasAjustadas;
	}

	public List<String> montaDadosAjusteDebito(List<AjusteFatura> ajustesCreditoDebito) throws Exception {
		
		List<String> dadosAjuste = new ArrayList<String>();
		for (AjusteFatura ajuste : ajustesCreditoDebito) {
			AjusteRules ajusteDebito = new AjusteRules(ajuste, DebitoCredito.DEBITO.getNome());
			dadosAjuste.add(ajusteDebito.toString());
		}
		return dadosAjuste;
	}

	public List<String> montaDadosAjusteCredito(List<AjusteFatura> ajustesCreditoDebito) throws Exception {
		
		List<String> dadosAjuste = new ArrayList<String>();
		
		for (AjusteFatura ajuste : ajustesCreditoDebito) {
			AjusteRules ajusteCredito = new AjusteRules(ajuste, DebitoCredito.CREDITO.getNome());
			dadosAjuste.add(ajusteCredito.toString());
		}
		return dadosAjuste;
	}

}
