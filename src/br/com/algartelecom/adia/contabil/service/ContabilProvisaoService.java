package br.com.algartelecom.adia.contabil.service;

import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.contabil.dao.ProvisaoDAO;
import br.com.algartelecom.adia.contabil.to.ReversaoProvisao;

public class ContabilProvisaoService {
	
	public List<String> getProvisao(String ultimaDataAntesFaturamento, String dataFaturamento, String ultimoDiaMesAnterior, 
			   						String primeiroDiaMesAtual, String dataCorteFaturamentoSemHoras, int qtdDiasMesAnterior) throws Exception {
		
		return getProvisaoCreditoEDebito(ultimaDataAntesFaturamento, dataFaturamento, ultimoDiaMesAnterior, 
				   						 primeiroDiaMesAtual, dataCorteFaturamentoSemHoras, qtdDiasMesAnterior);
	}

	private List<String> getProvisaoCreditoEDebito(String ultimaDataAntesFaturamento, String dataFaturamento, String ultimoDiaMesAnterior, 
												   String primeiroDiaMesAtual, String dataCorteFaturamentoSemHoras, int qtdDiasMesAnterior) throws Exception {

		ProvisaoDAO provisaoDAO = new ProvisaoDAO();
		return montaRespostaParaProvisao(provisaoDAO.getReversaoProvisao(ultimaDataAntesFaturamento, dataFaturamento, ultimoDiaMesAnterior,
																		 primeiroDiaMesAtual, dataCorteFaturamentoSemHoras, qtdDiasMesAnterior));
		
	}

	private List<String> montaRespostaParaProvisao(List<ReversaoProvisao> provisaoReversao) throws Exception {

		ProvisaoService provisao = new ProvisaoService();
		
		ArrayList<String> dadosArquivoProvisao = new ArrayList<String>();
		List<String> arrecadacaoCeD = provisao.montaProvisaoCreditoDebito(provisaoReversao);
		
		dadosArquivoProvisao.addAll(arrecadacaoCeD);

		return dadosArquivoProvisao;

	}

}
