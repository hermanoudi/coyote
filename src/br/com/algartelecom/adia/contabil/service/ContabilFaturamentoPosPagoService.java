package br.com.algartelecom.adia.contabil.service;

import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.contabil.dao.ContabilAjustesDAO;
import br.com.algartelecom.adia.contabil.dao.ContabilFaturamentoImpostosCreditoeDebitoDAO;
import br.com.algartelecom.adia.contabil.rules.AjusteRules;
import br.com.algartelecom.adia.contabil.to.AjusteFatura;
import br.com.algartelecom.adia.contabil.to.FaturaImpostos;
import br.com.algartelecom.adia.util.FormataData;

public class ContabilFaturamentoPosPagoService {
	
	public List<String> getFaturamentoEAjustes(String primeiroDiaMesAnterior, String primeiroDiaMesAtual ) throws Exception{
		
		List<String> faturamentoPosPago = new ArrayList<String>();
		
		List<String> faturamentoDebitoCreditoEImpostosEAjustes =  getFaturasImpostosCeDAjustes(primeiroDiaMesAnterior, primeiroDiaMesAtual);
		faturamentoPosPago.addAll(faturamentoDebitoCreditoEImpostosEAjustes);
		
		return faturamentoPosPago;
	}

	public List<String> getFaturasImpostosCeDAjustes(String primeiroDiaMesAnterior, String primeiroDiaMesAtual) throws Exception {
		List<String> dadosToFileFaturamento = new ArrayList<String>();
		
		ContabilFaturamentoImpostosCreditoeDebitoDAO faturasDAO = new ContabilFaturamentoImpostosCreditoeDebitoDAO();
		ContabilAjustesDAO ajusteDAO = new ContabilAjustesDAO();
		
		List<String> dadosFaturamentoCreditoDebito = montaRespostaParaFaturamentoEImpostos(faturasDAO.getContabilFaturamentoImpostosCreditoEDebito(primeiroDiaMesAnterior, primeiroDiaMesAtual),
																						   ajusteDAO.getAjustesFaturas(primeiroDiaMesAnterior, primeiroDiaMesAtual));
		dadosToFileFaturamento.addAll(dadosFaturamentoCreditoDebito);
		
		return dadosToFileFaturamento;
	}

	private List<String> montaRespostaParaFaturamentoEImpostos(List<FaturaImpostos> contabilFaturamentoImpostosCreditoEDebito, List<AjusteFatura> ajustesCreditoEDebito) throws Exception {
		return montaRegrasParaArquivo(contabilFaturamentoImpostosCreditoEDebito, ajustesCreditoEDebito);
	}

	private List<String> montaRegrasParaArquivo(List<FaturaImpostos> contabilFaturamentoImpostosCreditoEDebito, List<AjusteFatura> ajustesCreditoEDebito) throws Exception {
		
		FaturamentoCreditoEDebitoPosPago faturamento = new FaturamentoCreditoEDebitoPosPago();
		ImpostosContabilPosPago impostos = new ImpostosContabilPosPago();
		AjusteCreditoEDebito ajuste = new AjusteCreditoEDebito();
		
		ArrayList<String> dadosArquivoFaturamento = new ArrayList<String>();
		List<String> faturamentoCreditoDebito = faturamento.montaFaturamentoCreditoDebito(contabilFaturamentoImpostosCreditoEDebito);
		List<String> faturamentoImpostos = impostos.montaImpostos(contabilFaturamentoImpostosCreditoEDebito);
		List<String> ajustes = ajuste.montaAjusteCreditoDebito(ajustesCreditoEDebito);
		
		dadosArquivoFaturamento.addAll(faturamentoCreditoDebito);
		dadosArquivoFaturamento.addAll(faturamentoImpostos);
		dadosArquivoFaturamento.addAll(ajustes);

		return dadosArquivoFaturamento;
	}



}
