package br.com.algartelecom.adia.contabil.rules;

import br.com.algartelecom.adia.Enum.ContaContabilEnum;
import br.com.algartelecom.adia.Enum.DebitoCredito;
import br.com.algartelecom.adia.contabil.to.FaturaImpostos;
import br.com.algartelecom.adia.util.CentroDeResultado;
import br.com.algartelecom.adia.util.FormataData;
import br.com.algartelecom.adia.util.FormataValores;
import br.com.algartelecom.adia.util.MontaCamposArquivosPosicionais;

public class ContabilPISRules extends AbstractContabilFaturamentoRules {

	public ContabilPISRules(FaturaImpostos faturaImpostos, String creditoOuDebito) throws Exception {
		montaAtributos(faturaImpostos, creditoOuDebito);
	}

	private void montaAtributos(FaturaImpostos faturaImpostos, String creditoOuDebito) throws Exception {
		
		super.dataContabilizacaoLancamento = FormataData.formataDataPadraoBrasilSemHoras(faturaImpostos.getDtaEmissaoRPS());
		super.dataCriacaoLancamento = FormataData.formataDataPadraoBrasilSemHoras(faturaImpostos.getDtaProcessamentoNFSe());
		super.criadoPor = "0";
		super.categoriaLancamento = "Impostos";
		super.origem = "ODIN";
		super.empresa = "302";
		super.projeto = "0000";
		//TODO: Quando tiver intercompany, dever� ser alterado
		super.intercompany = "000";
		super.anatel = "0000";
		super.reserva1 = "00000";
		super.reserva2 = "00000";
		super.nomeLote = "108302 ODIN A 016" + FormataData.getDataHoraAtualSemSegundos_Americano();
		super.descricaoLote = "Impostos ODIN 016" + FormataData.getDataHoraAtualSemSegundos_Americano();
		super.nomeLancamento = "302016 ODIN";
		super.descricaoLancamento = "Impostos 302016 ODIN";
		super.periodoContabil = FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula();
		super.identificadorLote = "016" + FormataData.getDataHoraAtualSemSegundos_Americano();
		super.dataCredito = FormataData.formataDataPadraoBrasilSemHoras(faturaImpostos.getDtaEmissaoRPS());
		//TODO: Quando entrarem os outros produtos, Office, Backup, Monitoramento e Servicos Profissionais, como ficar� este campo
		super.DescricaoLinhaLancamento = "PIS Elastic Cloud " + FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula();
		super.dataCriacao = FormataData.formataDataAtualPadraoBrasilSemHoras();
		
		if (isCredito(creditoOuDebito)){
			montaAtributosDebito(faturaImpostos);
		} else{
			montaAtributosCredito(faturaImpostos);
		}

		
	}
	
	private void montaAtributosCredito(FaturaImpostos faturaImpostos) {
		
		super.contaContabil = ContaContabilEnum.ELASTIC_IMPOSTO_PIS_CREDITO.getCodigo();
		super.regulamento = "000";
		super.centroResultado = "000000000"; 
		super.produto = "000000000000";
		super.uf = "00";
		super.valorDebito = "0,00"; 
		super.valorCredito = FormataValores.substituiSeparadorDecimalPontoPorVirgula(faturaImpostos.getValPis());
		super.valorDebito1 = "0,00";
		super.valorCredito1 = super.valorCredito;
		super.codigoRastreamentoLote =  FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula() + "_Credito_POS-PAGO_Impostos_" + super.contaContabil + "_" + faturaImpostos.getCodItemFaturaOdin();
	
	}

	private void montaAtributosDebito(FaturaImpostos faturaImpostos) throws Exception {
		
		super.contaContabil = ContaContabilEnum.ELASTIC_IMPOSTO_PIS_DEBITO.getCodigo();
		super.regulamento = "001";
		super.centroResultado = MontaCamposArquivosPosicionais.preencherCampo(CentroDeResultado.substituiCREmBrancoPorCRdeUberlandia(faturaImpostos.getCodCentroCustos()), 9, true); 
		super.produto = MontaCamposArquivosPosicionais.preencherCampo(faturaImpostos.getCodSkuOdin(), 12, true);
		super.uf = "MG";
		super.valorDebito = FormataValores.substituiSeparadorDecimalPontoPorVirgula(faturaImpostos.getValPis());
		super.valorCredito = "0,00";
		super.valorDebito1 = super.valorDebito;
		super.valorCredito1 = "0,00";
		super.codigoRastreamentoLote =  FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula() + "_Debito_POS-PAGO_Impostos_" + super.contaContabil + "_" + faturaImpostos.getCodItemFaturaOdin();
	
	}
	
	private boolean isCredito(String creditoOuDebito) {
		if (creditoOuDebito.equalsIgnoreCase(DebitoCredito.CREDITO.getNome())){
			return true;
		} else{
			return false;
		}
	}



	

}
