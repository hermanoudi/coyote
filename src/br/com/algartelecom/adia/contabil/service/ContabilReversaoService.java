package br.com.algartelecom.adia.contabil.service;

import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.contabil.dao.ProvisaoDAO;
import br.com.algartelecom.adia.contabil.to.ReversaoProvisao;

public class ContabilReversaoService {
	
	public List<String> getReversao(String ultimaDataAntesFaturamento, String dataFaturamento, String ultimoDiaMesAnterior, 
			   						String primeiroDiaMesAtual, String dataCorteFaturamentoSemHoras, int qtdDiasMesAnterior) throws Exception {
		
		return getReversaoCreditoEDebito(ultimaDataAntesFaturamento, dataFaturamento, ultimoDiaMesAnterior, 
				   						 primeiroDiaMesAtual, dataCorteFaturamentoSemHoras, qtdDiasMesAnterior);
	}

	private List<String> getReversaoCreditoEDebito(String ultimaDataAntesFaturamento, String dataFaturamento, String ultimoDiaMesAnterior, 
												   String primeiroDiaMesAtual, String dataCorteFaturamentoSemHoras, int qtdDiasMesAnterior) throws Exception {

		ProvisaoDAO provisaoDAO = new ProvisaoDAO();
		return montaRespostaParaReversao(provisaoDAO.getReversaoProvisao(ultimaDataAntesFaturamento, dataFaturamento, ultimoDiaMesAnterior,
																		 primeiroDiaMesAtual, dataCorteFaturamentoSemHoras, qtdDiasMesAnterior));
	}

	private List<String> montaRespostaParaReversao(List<ReversaoProvisao> provisaoReversao) throws Exception {

		ReversaoService provisao = new ReversaoService();
		
		ArrayList<String> dadosArquivoReversao = new ArrayList<String>();
		List<String> reversaoCeD = provisao.montaReversaoCreditoDebito(provisaoReversao);
		
		dadosArquivoReversao.addAll(reversaoCeD);

		return dadosArquivoReversao;

	}

}
