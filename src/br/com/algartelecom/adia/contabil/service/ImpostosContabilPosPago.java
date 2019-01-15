package br.com.algartelecom.adia.contabil.service;

import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.Enum.DebitoCredito;
import br.com.algartelecom.adia.contabil.rules.ContabilCofinsRules;
import br.com.algartelecom.adia.contabil.rules.ContabilISSRules;
import br.com.algartelecom.adia.contabil.rules.ContabilPISRules;
import br.com.algartelecom.adia.contabil.rules.RetencaoISSRules;
import br.com.algartelecom.adia.contabil.to.FaturaImpostos;

public class ImpostosContabilPosPago {

	public List<String> montaImpostos(List<FaturaImpostos> contabilFaturamentoImpostosCreditoEDebito) throws Exception {
			
		List<String> faturasAjustadas = new ArrayList<String>();
		List<FaturaImpostos> faturasRetencaoMunicipal = new ArrayList<FaturaImpostos>();

		List<String> dadosISSCredito = montaDadosISSCredito(contabilFaturamentoImpostosCreditoEDebito, faturasRetencaoMunicipal);
		List<String> dadosISSDebito =  montaDadosISSDebito(contabilFaturamentoImpostosCreditoEDebito);
		
		List<String> dadosCOFINSCredito = montaDadosCOFINSCredito(contabilFaturamentoImpostosCreditoEDebito);
		List<String> dadosCOFINSDebito =  montaDadosCOFINSDebito(contabilFaturamentoImpostosCreditoEDebito);
		
		List<String> dadosPISCredito = montaDadosPISCredito(contabilFaturamentoImpostosCreditoEDebito);
		List<String> dadosPISDebito =  montaDadosPISDebito(contabilFaturamentoImpostosCreditoEDebito);
		
		//TODO: Montar os dados de retenção aqui
		List<String> dadosRetencaoISSCredito = montaDadosRetencaoISSCredito(faturasRetencaoMunicipal);
		List<String> dadosRetencaoISSDebito =  montaDadosRetencaoISSDebito(faturasRetencaoMunicipal);
			
		faturasAjustadas.addAll(dadosISSCredito);
		faturasAjustadas.addAll(dadosISSDebito);
		
		faturasAjustadas.addAll(dadosCOFINSCredito);
		faturasAjustadas.addAll(dadosCOFINSDebito);
		
		faturasAjustadas.addAll(dadosPISCredito);
		faturasAjustadas.addAll(dadosPISDebito);
		
		faturasAjustadas.addAll(dadosRetencaoISSCredito);
		faturasAjustadas.addAll(dadosRetencaoISSDebito);
		
		return faturasAjustadas;

	}

	private List<String> montaDadosRetencaoISSDebito(List<FaturaImpostos> faturasRetencaoMunicipal) throws Exception {
		List<String> dadosPISDebito = new ArrayList<String>();
		
		for (FaturaImpostos faturaImpostos : faturasRetencaoMunicipal) {
			RetencaoISSRules issDebito = new RetencaoISSRules(faturaImpostos, DebitoCredito.DEBITO.getNome());
			dadosPISDebito.add(issDebito.toString());
		}
		return dadosPISDebito;
	}

	private List<String> montaDadosRetencaoISSCredito(List<FaturaImpostos> contabilFaturamentoImpostosCreditoEDebito) throws Exception {
		
		List<String> dadosPISDebito = new ArrayList<String>();
		
		for (FaturaImpostos faturaImpostos : contabilFaturamentoImpostosCreditoEDebito) {
			RetencaoISSRules issDebito = new RetencaoISSRules(faturaImpostos, DebitoCredito.CREDITO.getNome());
			dadosPISDebito.add(issDebito.toString());
		}
		return dadosPISDebito;
	}

	private boolean isRetencaoMunicipal(FaturaImpostos faturaImpostos) {
		if (faturaImpostos.getRetencao().equalsIgnoreCase("Municipal")){
			return true;
		} else{
			return false;
		}
	}

	private List<String> montaDadosPISDebito(List<FaturaImpostos> contabilFaturamentoImpostosCreditoEDebito) throws Exception {
		
		List<String> dadosPISDebito = new ArrayList<String>();
		
		for (FaturaImpostos faturaImpostos : contabilFaturamentoImpostosCreditoEDebito) {
			ContabilPISRules issDebito = new ContabilPISRules(faturaImpostos, DebitoCredito.DEBITO.getNome());
			dadosPISDebito.add(issDebito.toString());
		}
		return dadosPISDebito;
	}

	private List<String> montaDadosPISCredito(List<FaturaImpostos> contabilFaturamentoImpostosCreditoEDebito) throws Exception {
		
		List<String> dadosPISCredito = new ArrayList<String>();
		
		for (FaturaImpostos faturaImpostos : contabilFaturamentoImpostosCreditoEDebito) {
			ContabilPISRules pisCredito = new ContabilPISRules(faturaImpostos, DebitoCredito.CREDITO.getNome());
			dadosPISCredito.add(pisCredito.toString());
		}
		return dadosPISCredito;
	}

	private List<String> montaDadosCOFINSDebito(List<FaturaImpostos> contabilFaturamentoImpostosCreditoEDebito) throws Exception {
		
		List<String> dadosCofinsDebito = new ArrayList<String>();
		
		for (FaturaImpostos faturaImpostos : contabilFaturamentoImpostosCreditoEDebito) {
			ContabilCofinsRules cofinsDebito = new ContabilCofinsRules(faturaImpostos, DebitoCredito.DEBITO.getNome());
			dadosCofinsDebito.add(cofinsDebito.toString());
		}
		return dadosCofinsDebito;
	}

	private List<String> montaDadosCOFINSCredito(List<FaturaImpostos> contabilFaturamentoImpostosCreditoEDebito) throws Exception {
		
		List<String> dadosCofinsCredito = new ArrayList<String>();
		
		for (FaturaImpostos faturaImpostos : contabilFaturamentoImpostosCreditoEDebito) {
			ContabilCofinsRules cofinsCredito = new ContabilCofinsRules(faturaImpostos, DebitoCredito.CREDITO.getNome());
			dadosCofinsCredito.add(cofinsCredito.toString());
		}
		return dadosCofinsCredito;
	}

	private List<String> montaDadosISSDebito(List<FaturaImpostos> contabilFaturamentoImpostosCreditoEDebito) throws Exception {

		List<String> dadosISSDebito = new ArrayList<String>();
		
		for (FaturaImpostos faturaImpostos : contabilFaturamentoImpostosCreditoEDebito) {
			ContabilISSRules issDebito = new ContabilISSRules(faturaImpostos, DebitoCredito.DEBITO.getNome());
			dadosISSDebito.add(issDebito.toString());
		}
		return dadosISSDebito;
	}

	private List<String> montaDadosISSCredito(List<FaturaImpostos> contabilFaturamentoImpostosCreditoEDebito, List<FaturaImpostos> faturasRetencaoMunicipal) throws Exception {

		List<String> dadosISSCredito = new ArrayList<String>();
		
		for (FaturaImpostos faturaImpostos : contabilFaturamentoImpostosCreditoEDebito) {
			
			if (isRetencaoMunicipal(faturaImpostos)){
				faturasRetencaoMunicipal.add(faturaImpostos);			
				}
			
			ContabilISSRules issCredito = new ContabilISSRules(faturaImpostos, DebitoCredito.CREDITO.getNome());
			dadosISSCredito.add(issCredito.toString());
		}
		return dadosISSCredito;
	}
}