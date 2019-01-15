package br.com.algartelecom.adia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import br.com.algartelecom.adia.Enum.ProcessosEnum;
import br.com.algartelecom.adia.fatura.to.FaturaADIA;
import br.com.algartelecom.adia.gesplan.dao.GesplanFaturamentoDAO;
import br.com.algartelecom.adia.gesplan.to.ArquivoGesplanTO;
import br.com.algartelecom.adia.util.FormataData;

public class GesplanFaturamentoService {
	
	public List<String> montaConteudoArquivoDestino(List<ArquivoGesplanTO> objetosGesplanFaturamento){
		
		List<String> conteudoArquivoDestino = new ArrayList<String>();
//		for (ArquivoFaturamentoTO faturamento : objetosGesplanFaturamento) {
//			conteudoArquivoDestino.add(faturamento.toString());
//		}
		
		for (int i = 0; i < objetosGesplanFaturamento.size(); i++){
			ArquivoGesplanTO faturamento = objetosGesplanFaturamento.get(i);
			faturamento.setNrOrdemProcessamento(Integer.toString(i+1));
			conteudoArquivoDestino.add(faturamento.toString());
		}
		
		return conteudoArquivoDestino;
		
	}
	
	
	public List<ArquivoGesplanTO> montaListaObjetosGesplanFaturamento(List<String> conteudoArquivo) {
		
		GesplanFaturamentoDAO gesplanFaturamentoDAO = new GesplanFaturamentoDAO();
		
		String idProcesso = gesplanFaturamentoDAO.buscaUltExecucaoGesplanFaturamento(ProcessosEnum.GESPLAN_FATURAMENTO.getNome());
		
		System.out.println("Ultimo processo de GESPLAN FATURAMENTO: " + idProcesso);
		
		List<ArquivoGesplanTO> objetosGesplanFaturamento = new ArrayList<ArquivoGesplanTO>();
		for (String sLinha : conteudoArquivo) {
			//System.out.println(sLinha);
			String[] vLinha = sLinha.split(";");
			ArquivoGesplanTO faturamento = transformaStringEmObjetoFaturamentoGesplan(vLinha);
			
			if (isPosPago(faturamento, idProcesso)){
				ajustaBandeiraCartaoEValores(faturamento, idProcesso);
				objetosGesplanFaturamento.add(faturamento);
				faturamento.setRemovido("Analisar");
			} 
			//TODO: Remover essa linha quando for a automação definitiva.
			else{
				System.out.println(sLinha);
				faturamento.setRemovido("Excluir");
				objetosGesplanFaturamento.add(faturamento);
			}
		}
		
		return objetosGesplanFaturamento;
	}


	private void ajustaBandeiraCartaoEValores(ArquivoGesplanTO faturamento, String idProcesso) {
		
		GesplanFaturamentoDAO gesplanFaturamentoDAO = new GesplanFaturamentoDAO();
		List<FaturaADIA> faturasPospago = gesplanFaturamentoDAO.getFaturasPosPago(idProcesso);
		
		double somaValorDoPagamentoSQL = 0;
		double somaValItemFatura = 0;
		
		for (FaturaADIA faturaADIA : faturasPospago) {
			
			if (mesmaDataArquivoESQLPosPago(faturamento, faturaADIA) && faturamento.getIdFormaPagamento().equalsIgnoreCase("CARTAO DE CREDITO") 
															  && faturaADIA.getNomFormaPagto().equalsIgnoreCase("CARTÃO DE CRÉDITO") ){
				
				String valorLancado = faturamento.getVlLancado().replace(",", ".");
				double dValorLancado = Double.valueOf(valorLancado).doubleValue();
				
				double valorDoPagamentoSQL = Double.valueOf(faturaADIA.getValorDoPagamento()).doubleValue();
				double valItemFatura = Double.valueOf(faturaADIA.getValItemFatura()).doubleValue();
				
				if(dValorLancado == valorDoPagamentoSQL || dValorLancado == valItemFatura){
					faturamento.setIdFormaPagamento(faturamento.getIdFormaPagamento().replaceAll("CARTAO DE CREDITO", "CARTAO ("+ faturaADIA.getNomBandeira() +")"));
					faturamento.setDsFormaPagamento(faturamento.getDsFormaPagamento().replaceAll("CARTAO DE CREDITO", "CARTAO ("+ faturaADIA.getNomBandeira() +")"));
					
					faturamento.setVlLancado(faturaADIA.getValorDoPagamento().replaceAll(Pattern.quote("."), ","));
					faturamento.setVlLiquido(faturaADIA.getValorDoPagamento().replaceAll(Pattern.quote("."), ","));
				} else{
					somaValorDoPagamentoSQL = somaValorDoPagamentoSQL + valorDoPagamentoSQL;
					somaValItemFatura = somaValItemFatura + valItemFatura;
					
						if(dValorLancado == somaValorDoPagamentoSQL || dValorLancado == somaValItemFatura){
							faturamento.setIdFormaPagamento(faturamento.getIdFormaPagamento().replaceAll("CARTAO DE CREDITO", "CARTAO ("+ faturaADIA.getNomBandeira() +")"));
							faturamento.setDsFormaPagamento(faturamento.getDsFormaPagamento().replaceAll("CARTAO DE CREDITO", "CARTAO ("+ faturaADIA.getNomBandeira() +")"));
							
							faturamento.setVlLancado(faturaADIA.getValorDoPagamento().replaceAll(Pattern.quote("."), ","));
							faturamento.setVlLiquido(faturaADIA.getValorDoPagamento().replaceAll(Pattern.quote("."), ","));
						}
				
					}
			
		} else{
			somaValorDoPagamentoSQL = 0;
			somaValItemFatura = 0;
		}
	  }
  }
	


	private boolean isPosPago(ArquivoGesplanTO faturamento, String idProcesso) {
		GesplanFaturamentoDAO prepagoDAO = new GesplanFaturamentoDAO();
		List<FaturaADIA> prepagos = prepagoDAO.getFaturasPrePago(idProcesso);
		
		for (FaturaADIA faturaADIA : prepagos) {
			
			if (mesmaDataArquivoESQLPrePago(faturamento, faturaADIA)){
				
				String valorLancado = faturamento.getVlLancado().replace(",", ".");
				double dValorLancado = Double.valueOf(valorLancado).doubleValue();
				
				double valorDoPagamentoSQL = Double.valueOf(faturaADIA.getValorDoPagamento()).doubleValue();
				double valItemFatura = Double.valueOf(faturaADIA.getValItemFatura()).doubleValue();
				
				if(dValorLancado == valorDoPagamentoSQL || dValorLancado == valItemFatura){
					System.out.println("---- PRE PAGO ----");
					System.out.println(faturamento.getDtVencimento());
					System.out.println(faturamento.getVlLancado());
					System.out.println();
					return false;
				} 
				//System.out.println();
			} 
			
		}
		return true;
	}


	private boolean mesmaDataArquivoESQLPrePago(ArquivoGesplanTO faturamento,
			FaturaADIA faturaADIA) {
		return faturamento.getDtVencimento().equalsIgnoreCase(FormataData.formataDataPadraoBrasilSemHoras(faturaADIA.getDtaPagamentoItem()));
	}
	
	private boolean mesmaDataArquivoESQLPosPago(ArquivoGesplanTO faturamento,
			FaturaADIA faturaADIA) {
		return faturamento.getDtVencimento().equalsIgnoreCase(FormataData.formataDataPadraoBrasilSemHoras(faturaADIA.getDtaVencimento()));
	}


	public ArquivoGesplanTO transformaStringEmObjetoFaturamentoGesplan(String[] linha){
		ArquivoGesplanTO faturamento = new ArquivoGesplanTO();
		faturamento.setDataCriacao((linha[0] == null) ? "" : linha[0]);
		faturamento.setDsKeyOrigem((linha[1] == null) ? "" : linha[1]);
		faturamento.setDtInterface((linha[2] == null) ? "" : linha[2]);
		faturamento.setBlInterface((linha[3] == null) ? "": linha[3]);
		faturamento.setIdSistemaOrigem((linha[4] == null) ? "": linha[4]);
		faturamento.setBlEntradaSaida((linha[5] == null) ? "": linha[5]);
		faturamento.setDsAgrupador((linha[6] == null) ? "": linha[6]);
		faturamento.setIdEmpresa((linha[7] == null) ? "": linha[7]);
		faturamento.setIdBanco((linha[8] == null) ? "": linha[8]);
		faturamento.setNrAgencia((linha[9] == null) ? "": linha[9]);
		faturamento.setNrContaCorrente((linha[10] == null) ? "": linha[10]);
		faturamento.setIdFormaPagamento((linha[11] == null) ? "": linha[11]);
		faturamento.setDsFormaPagamento((linha[12] == null) ? "": linha[12]);
		faturamento.setNrFormaPagamento((linha[13] == null) ? "": linha[13]);
		faturamento.setIdTipoResponsavel((linha[14] == null) ? "": linha[14]);
		faturamento.setIdResponsavel((linha[15] == null) ? "": linha[15]);
		faturamento.setIdCnpjCpfResponsavel((linha[16] == null) ? "": linha[16]);
		faturamento.setCdCnpjCpfResponsavel((linha[17] == null) ? "": linha[17]);
		faturamento.setDsResponsavel((linha[18] == null) ? "": linha[18]);
		faturamento.setDtPagamento((linha[19] == null) ? "": linha[19]);
		faturamento.setIdFormaEmissao((linha[20] == null) ? "": linha[20]);
		faturamento.setDtVencimento((linha[21] == null) ? "": linha[21]);
		faturamento.setIdEmpresaDevedora((linha[22] == null) ? "": linha[22]);
		faturamento.setIdUnidadeNegocioDevedor((linha[23] == null) ? "": linha[23]);
		faturamento.setVlLancado((linha[24] == null) ? "": linha[24]);
		faturamento.setTxImpostoRenda((linha[25] == null) ? "": linha[25]);
		faturamento.setVlImpostoRenda((linha[26] == null) ? "": linha[26]);
		faturamento.setVlJuros((linha[27] == null) ? "": linha[27]);
		faturamento.setVlMulta((linha[28] == null) ? "": linha[28]);
		faturamento.setVlDesconto((linha[29] == null) ? "": linha[29]);
		faturamento.setVlLiquido((linha[30] == null) ? "": linha[30]);
		faturamento.setIdTipoDocto((linha[31] == null) ? "": linha[31]);
		faturamento.setDsTipoDocto((linha[32] == null) ? "": linha[32]);
		faturamento.setNrDocto((linha[33] == null) ? "": linha[33]);
		faturamento.setIdTipoResponsavelReal((linha[34] == null) ? "": linha[34]);
		faturamento.setIdResponsavelReal((linha[35] == null) ? "": linha[35]);
		faturamento.setIdCnpjCpfResponsavelReal((linha[36] == null) ? "": linha[36]);
		faturamento.setCdCnpjCpfResponsavelReal((linha[37] == null) ? "": linha[37]);
		faturamento.setDsResponsavelReal((linha[38] == null) ? "": linha[38]);
		faturamento.setIdBancoDestinoOrigem((linha[39] == null) ? "": linha[39]);
		faturamento.setIdAgenciaDestinoOrigem((linha[40] == null) ? "": linha[40]);
		faturamento.setNrContaDestinoOrigem((linha[41] == null) ? "": linha[41]);
		faturamento.setIdContaFinanceira((linha[42] == null) ? "": linha[42]);
		faturamento.setDsRejeitado((linha[43] == null) ? "": linha[43]);
		faturamento.setIdContaContabil((linha[44] == null) ? "": linha[44]);
		faturamento.setNrOrdemProcessamento((linha[45] == null) ? "": linha[45]);
		faturamento.setDtRegistro((linha[46] == null) ? "": linha[46]);
		faturamento.setDsObservacao((linha[47] == null) ? "": linha[47]);
		faturamento.setDsCodOrigemCusto((linha[48] == null) ? "": linha[48]);
		faturamento.setDsDeParaVencimento((linha[49] == null) ? "": linha[49]);
		faturamento.setTxMoeda((linha[50] == null) ? "": linha[50]);
		faturamento.setBlTaxaFixa((linha[51] == null) ? "": linha[51]);
		faturamento.setIdMoeda((linha[52] == null) ? "": linha[52]);
		faturamento.setBlAntecipaVencimento((linha[53] == null) ? "": linha[53]);
		faturamento.setBlContabiliza((linha[54] == null) ? "": linha[54]);
		faturamento.setBlReserva("");
		faturamento.setDtVencimentoOriginal("");
		faturamento.setBlAgrupaLancto("");
		faturamento.setDsContaContabil("");
		faturamento.setBlRecebivel("");
		faturamento.setIdClassContaContabil("");
		faturamento.setDsCentroCusto("");
		faturamento.setIdIndexGerenc("");
		
		return faturamento;
	}

}
