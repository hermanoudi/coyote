package br.com.algartelecom.adia.contabil.service;

import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.Enum.ModalidadePagamento;
import br.com.algartelecom.adia.contabil.dao.ArrecadacaoPrePagoDAO;
import br.com.algartelecom.adia.contabil.dao.TarifasDAO;
import br.com.algartelecom.adia.contabil.to.ArrecadacaoPrePago;
import br.com.algartelecom.adia.contabil.to.Tarifa;

public class ContabilArrecadacaoPrePagoService {

	public List<String> getArrecadacaoPrePago(String primeiroDiaMesAnterior, String primeiroDiaMesAtual) throws Exception {
		
		List<String> arrecadacoesPrePago= new ArrayList<String>();
		List<String> vendasImpostosTarifas =  getVendasImpostosTarifas(primeiroDiaMesAnterior, primeiroDiaMesAtual);
		arrecadacoesPrePago.addAll(vendasImpostosTarifas);
		
		return arrecadacoesPrePago;	

	}
	
	private List<String> getVendasImpostosTarifas(String primeiroDiaMesAnterior, String primeiroDiaMesAtual) throws Exception {
		
		List<String> dadosToFileArrecadacao= new ArrayList<String>();
		
		ArrecadacaoPrePagoDAO arrecadacaoDAO = new ArrecadacaoPrePagoDAO();
		
		List<String> dadosArrecadacaoPrePago = montaRespostaParaArrecadacao(arrecadacaoDAO.getArrecadacaoPrePago(primeiroDiaMesAnterior, primeiroDiaMesAtual), primeiroDiaMesAnterior, primeiroDiaMesAtual);
		dadosToFileArrecadacao.addAll(dadosArrecadacaoPrePago);
		
		return dadosToFileArrecadacao;

	}

	private List<String> montaRespostaParaArrecadacao(List<ArrecadacaoPrePago> arrecadacaoPrePago, String primeiroDiaMesAnterior, String primeiroDiaMesAtual) throws Exception {

		ArrecadacaoPrePagoService arrecadacao = new ArrecadacaoPrePagoService();
		ArrecadacaoImpostosContabilPrePago impostos = new ArrecadacaoImpostosContabilPrePago();
		ArrecadacaoTarifasPrePago tarifa = new ArrecadacaoTarifasPrePago();
		TarifasDAO tarifasDAO = new TarifasDAO();
		
		ArrayList<String> dadosArquivoArrecadacao = new ArrayList<String>();
		List<String> arrecadacaoCeD = arrecadacao.montaArrecadacaoCreditoDebito(arrecadacaoPrePago);
		List<String> arrecadacaoImpostos = impostos.montaImpostos(arrecadacaoPrePago);
		
		List<String> tarifas = tarifa.montaTarifas(tarifasDAO.getTarifas(primeiroDiaMesAnterior, primeiroDiaMesAtual, ModalidadePagamento.PRE_PAGO.getModalidade()),
														  tarifasDAO.getTarifas(primeiroDiaMesAnterior, primeiroDiaMesAtual, ModalidadePagamento.POS_PAGO.getModalidade()));
		dadosArquivoArrecadacao.addAll(arrecadacaoCeD);
		dadosArquivoArrecadacao.addAll(arrecadacaoImpostos);
		dadosArquivoArrecadacao.addAll(tarifas);

		return dadosArquivoArrecadacao;

	}


}
