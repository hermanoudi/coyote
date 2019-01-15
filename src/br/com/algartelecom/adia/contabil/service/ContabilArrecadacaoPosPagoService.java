package br.com.algartelecom.adia.contabil.service;

import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.contabil.dao.ArrecadacaoPosPagoDAO;
import br.com.algartelecom.adia.contabil.to.ArrecadacaoPosPago;

public class ContabilArrecadacaoPosPagoService {

	public List<String> getArrecadacaoPosPago(String primeiroDiaMesAnterior, String primeiroDiaMesAtual) throws Exception {
		
		List<String> arrecadacoesPosPago= new ArrayList<String>();
		List<String> arrecadacoesCreditoEImpostosPosPago =  getArrecadacoesCreditoEDebitoPosPago(primeiroDiaMesAnterior, primeiroDiaMesAtual);
		arrecadacoesPosPago.addAll(arrecadacoesCreditoEImpostosPosPago);
		
		return arrecadacoesPosPago;	
	
	}

	private List<String> getArrecadacoesCreditoEDebitoPosPago(String primeiroDiaMesAnterior, String primeiroDiaMesAtual) throws Exception {
		
		List<String> dadosToFileArrecadacao= new ArrayList<String>();
		
		ArrecadacaoPosPagoDAO arrecadacaoDAO = new ArrecadacaoPosPagoDAO();
		
		List<String> dadosArrecadacaoPosPago = montaRespostaParaArrecadacao(arrecadacaoDAO.getArrecadacaoPosPago(primeiroDiaMesAnterior, primeiroDiaMesAtual));
		dadosToFileArrecadacao.addAll(dadosArrecadacaoPosPago);
		
		return dadosToFileArrecadacao;

	}

	private List<String> montaRespostaParaArrecadacao(List<ArrecadacaoPosPago> arrecadacaoPosPago) throws Exception {

		ArrecadacaoPosPagoService arrecadacao = new ArrecadacaoPosPagoService();
//		ImpostosContabilPosPago impostos = new ImpostosContabilPosPago();
		
		ArrayList<String> dadosArquivoArrecadacao = new ArrayList<String>();
		List<String> arrecadacaoCeD = arrecadacao.montaArrecadacaoCreditoDebito(arrecadacaoPosPago);
//		List<String> faturamentoImpostos = impostos.montaImpostos(contabilFaturamentoImpostosCreditoEDebito);
//		List<String> ajustes = ajuste.montaAjusteCreditoDebito(ajustesCreditoEDebito);
		
		dadosArquivoArrecadacao.addAll(arrecadacaoCeD);
//		dadosArquivoArrecadacao.addAll(faturamentoImpostos);
//		dadosArquivoArrecadacao.addAll(ajustes);

		return dadosArquivoArrecadacao;

	}

}
