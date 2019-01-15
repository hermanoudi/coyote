package br.com.algartelecom.adia.contabil.service;

import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.Enum.DebitoCredito;
import br.com.algartelecom.adia.contabil.rules.ProvisaoRules;
import br.com.algartelecom.adia.contabil.to.ReversaoProvisao;

public class ProvisaoService {

	public List<String> montaProvisaoCreditoDebito(List<ReversaoProvisao> provisaoReversao) throws Exception {
		
		List<String> provisoes = new ArrayList<String>();

		List<String> dadosProvisaoCredito = montaDadosProvisaoCredito(provisaoReversao);
		List<String> dadosProvisaoDebito =  montaDadosProvisaoDebito(provisaoReversao);
		
		
		provisoes.addAll(dadosProvisaoDebito);
		provisoes.addAll(dadosProvisaoCredito);
		
		
		return provisoes;
	}
	
	private List<String> montaDadosProvisaoDebito(List<ReversaoProvisao> provisaoReversao) throws Exception {
		
		List<String> dadosProvisaoDebito = new ArrayList<String>();
		
		for (ReversaoProvisao provisao : provisaoReversao) {
			if (provisao.getValProvisao() == null || provisao.getValProvisao().equals("")
					|| provisao.getCodContaContabil() == null || provisao.getCodContaContabil().equals("")	){
				continue;
			}

			ProvisaoRules provisaoDebito = new ProvisaoRules(provisao, DebitoCredito.DEBITO.getNome());
			dadosProvisaoDebito.add(provisaoDebito.toString());
		}
		return dadosProvisaoDebito;
	}

	private List<String> montaDadosProvisaoCredito(List<ReversaoProvisao> provisaoReversao) throws Exception {
		
		List<String> dadosProvisaoCredito = new ArrayList<String>();
		
		for (ReversaoProvisao provisao : provisaoReversao) {
			if (provisao.getValProvisao() == null || provisao.getValProvisao().equals("")
					|| provisao.getCodContaContabil() == null || provisao.getCodContaContabil().equals("")	){
				continue;
			}

			ProvisaoRules provisaoDebito = new ProvisaoRules(provisao, DebitoCredito.CREDITO.getNome());
			dadosProvisaoCredito.add(provisaoDebito.toString());
		}
		return dadosProvisaoCredito;
	}

}
