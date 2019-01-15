package br.com.algartelecom.adia.contabil.service;

import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.contabil.dao.ContabilPrePagoDAO;
import br.com.algartelecom.adia.contabil.to.FaturasPrePago;

public class ContabilFaturamentoPrePagoService {
	
	public List<String> getFaturamentoEAjustes(String primeiroDiaMesAnterior, String primeiroDiaMesAtual, String ultimoDiaMesAnteriorComHoras) throws Exception{
		
		List<String> FaturasPrePago = new ArrayList<String>();
		
		List<String> prePagoDebitoCreditoEImpostosEAjustes =  getFaturasImpostosCeDAjustes(primeiroDiaMesAnterior, primeiroDiaMesAtual, ultimoDiaMesAnteriorComHoras);
		FaturasPrePago.addAll(prePagoDebitoCreditoEImpostosEAjustes);
		
		return FaturasPrePago;
	}

	public List<String> getFaturasImpostosCeDAjustes(String primeiroDiaMesAnterior, String primeiroDiaMesAtual, String ultimoDiaMesAnteriorComHoras) throws Exception {
		
		List<String> dadosToFilePrePago = new ArrayList<String>();
		ContabilPrePagoDAO faturasDAO = new ContabilPrePagoDAO();
		
		//ContabilAjustesDAO ajusteDAO = new ContabilAjustesDAO();
		
		List<String> dadosFaturamentoCreditoDebito = montaRespostaParaFaturamentoEImpostos(faturasDAO.getFaturasPrePago(primeiroDiaMesAnterior, primeiroDiaMesAtual, ultimoDiaMesAnteriorComHoras));
		dadosToFilePrePago.addAll(dadosFaturamentoCreditoDebito);
		
		return dadosToFilePrePago;
	}

	private List<String> montaRespostaParaFaturamentoEImpostos(List<FaturasPrePago> FaturasPrePago) throws Exception {
		return montaRegrasParaArquivo(FaturasPrePago);
	}

	private List<String> montaRegrasParaArquivo(List<FaturasPrePago> contabilFaturamentoImpostosCreditoEDebito) throws Exception {
		
		FaturamentoCreditoEDebitoPrePago faturamentoPrePago = new FaturamentoCreditoEDebitoPrePago();
		ImpostosContabilPrePago impostos = new ImpostosContabilPrePago();
		//AjusteCreditoEDebito ajuste = new AjusteCreditoEDebito();
		
		ArrayList<String> dadosArquivoPrePago = new ArrayList<String>();
		List<String> faturamentoCreditoDebito = faturamentoPrePago.montaFaturamentoCreditoDebito(contabilFaturamentoImpostosCreditoEDebito);
		List<String> faturamentoImpostos = impostos.montaImpostos(contabilFaturamentoImpostosCreditoEDebito);
		
		//List<String> ajustes = ajuste.montaAjusteCreditoDebito(ajustesCreditoEDebito);
		
		dadosArquivoPrePago.addAll(faturamentoCreditoDebito);
		dadosArquivoPrePago.addAll(faturamentoImpostos);
		
		//dadosArquivoFaturamento.addAll(ajustes);

		return dadosArquivoPrePago;
	}



}
