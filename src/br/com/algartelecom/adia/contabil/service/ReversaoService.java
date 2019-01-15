package br.com.algartelecom.adia.contabil.service;

import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.Enum.DebitoCredito;
import br.com.algartelecom.adia.contabil.rules.ProvisaoRules;
import br.com.algartelecom.adia.contabil.rules.ReversaoRules;
import br.com.algartelecom.adia.contabil.to.ReversaoProvisao;

public class ReversaoService {

	public List<String> montaReversaoCreditoDebito(List<ReversaoProvisao> provisaoReversao) throws Exception {
		
		List<String> reversoes = new ArrayList<String>();

		List<String> dadosReversaoCredito = montaDadosReversaoCredito(provisaoReversao);
		List<String> dadosReversaoDebito =  montaDadosReversaoDebito(provisaoReversao);
		
		
		reversoes.addAll(dadosReversaoDebito);
		reversoes.addAll(dadosReversaoCredito);
		
		
		return reversoes;
	}
	
	private List<String> montaDadosReversaoDebito(List<ReversaoProvisao> provisaoReversao) throws Exception {
		
		List<String> dadosReversaoDebito = new ArrayList<String>();
		
		for (ReversaoProvisao reversao : provisaoReversao) {
			if (reversao.getValProvisao() == null || reversao.getValProvisao().equals("")
					|| reversao.getCodContaContabil() == null || reversao.getCodContaContabil().equals("")	){
				continue;
			}

			ReversaoRules reversaoDebito = new ReversaoRules(reversao, DebitoCredito.DEBITO.getNome());
			dadosReversaoDebito.add(reversaoDebito.toString());
		}
		return dadosReversaoDebito;
	}

	private List<String> montaDadosReversaoCredito(List<ReversaoProvisao> provisaoReversao) throws Exception {
		
		List<String> dadosReversaoCredito = new ArrayList<String>();
		
		for (ReversaoProvisao reversao : provisaoReversao) {
			if (reversao.getValProvisao() == null || reversao.getValProvisao().equals("")
					|| reversao.getCodContaContabil() == null || reversao.getCodContaContabil().equals("")	){
				continue;
			}

			ReversaoRules provisaoDebito = new ReversaoRules(reversao, DebitoCredito.CREDITO.getNome());
			dadosReversaoCredito.add(provisaoDebito.toString());
		}
		return dadosReversaoCredito;
	}

}
