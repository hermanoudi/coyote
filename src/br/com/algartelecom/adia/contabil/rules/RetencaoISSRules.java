package br.com.algartelecom.adia.contabil.rules;

import br.com.algartelecom.adia.Enum.ContaContabilEnum;
import br.com.algartelecom.adia.Enum.DebitoCredito;
import br.com.algartelecom.adia.contabil.to.FaturaImpostos;
import br.com.algartelecom.adia.util.CentroDeResultado;
import br.com.algartelecom.adia.util.FormataData;
import br.com.algartelecom.adia.util.FormataValores;
import br.com.algartelecom.adia.util.MontaCamposArquivosPosicionais;

public class RetencaoISSRules extends AbstractContabilFaturamentoRules {

	public RetencaoISSRules(FaturaImpostos faturaImpostos, String creditoOuDebito) throws Exception {
		montaAtributos(faturaImpostos, creditoOuDebito);
	}

	private void montaAtributos(FaturaImpostos faturaImpostos, String creditoOuDebito) throws Exception {
		
		super.dataContabilizacaoLancamento = FormataData.formataDataPadraoBrasilSemHoras(faturaImpostos.getDtaEmissaoRPS());
		super.dataCriacaoLancamento = FormataData.formataDataPadraoBrasilSemHoras(faturaImpostos.getDtaProcessamentoNFSe());
		super.criadoPor = "0";
		super.categoriaLancamento = "Retencao";
		super.origem = "ODIN";
		super.empresa = "302";
		super.projeto = "0000";
		//TODO: Quando tiver intercompany, dever� ser alterado
		super.intercompany = "000";
		super.anatel = "0000";
		super.reserva1 = "00000";
		super.reserva2 = "00000";
		super.nomeLote = "107302 ODIN A 016" + FormataData.getDataHoraAtualSemSegundos_Americano();
		super.descricaoLote = "Retencao ODIN 016" + FormataData.getDataHoraAtualSemSegundos_Americano();
		super.nomeLancamento = "302016 ODIN";
		super.descricaoLancamento = "Retencao 302016 ODIN";
		super.periodoContabil = FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula();
		super.identificadorLote = "016" + FormataData.getDataHoraAtualSemSegundos_Americano();
		super.dataCredito = FormataData.formataDataPadraoBrasilSemHoras(faturaImpostos.getDtaEmissaoRPS());
		//TODO: Quando entrarem os outros produtos, Office, Backup, Monitoramento e Servicos Profissionais, como ficar� este campo
		super.dataCriacao = FormataData.formataDataAtualPadraoBrasilSemHoras();
		super.regulamento = "000";
		super.centroResultado = "000000000"; 
		super.produto = "000000000000";
		super.uf = "00";
		
		if (isCredito(creditoOuDebito)){
			montaAtributosDebito(faturaImpostos);
		} else{
			montaAtributosCredito(faturaImpostos);
		}

		
	}
	
	private void montaAtributosCredito(FaturaImpostos faturaImpostos) {
		
		super.contaContabil = ContaContabilEnum.ELASTIC_RETENCAO_ISS_CREDITO.getCodigo();
		super.codigoRastreamentoLote =  FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula() + "_Credito_POS-PAGO_Retencao_" + super.contaContabil + "_" + faturaImpostos.getCodItemFaturaOdin();
		super.valorDebito = "0,00"; 
		super.valorCredito = FormataValores.substituiSeparadorDecimalPontoPorVirgula(faturaImpostos.getValISS());
		super.valorDebito1 = "0,00";
		super.valorCredito1 = super.valorCredito;
		super.DescricaoLinhaLancamento = "RETENCAO_ISS Credito POS-PAGO Elastic Cloud " + FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula();	
	}

	private void montaAtributosDebito(FaturaImpostos faturaImpostos) throws Exception {

		super.contaContabil = ContaContabilEnum.ELASTIC_RETENCAO_ISS_DEBITO.getCodigo();
		super.codigoRastreamentoLote =  FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula() + "_Debito_POS-PAGO_Retencao_" + super.contaContabil + "_" + faturaImpostos.getCodItemFaturaOdin();
		super.valorDebito = FormataValores.substituiSeparadorDecimalPontoPorVirgula(faturaImpostos.getValISS());
		super.valorCredito = "0,00";
		super.valorDebito1 = super.valorDebito;
		super.valorCredito1 = "0,00";
		super.DescricaoLinhaLancamento = "RETENCAO_ISS Debito POS-PAGO Elastic Cloud " + FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula();
	}
	
	private boolean isCredito(String creditoOuDebito) {
		if (creditoOuDebito.equalsIgnoreCase(DebitoCredito.CREDITO.getNome())){
			return true;
		} else{
			return false;
		}
	}



	

}
