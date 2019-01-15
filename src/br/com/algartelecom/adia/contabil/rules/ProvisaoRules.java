package br.com.algartelecom.adia.contabil.rules;

import br.com.algartelecom.adia.Enum.ContaContabilEnum;
import br.com.algartelecom.adia.Enum.DebitoCredito;
import br.com.algartelecom.adia.contabil.service.ProvisaoService;
import br.com.algartelecom.adia.contabil.to.FaturaImpostos;
import br.com.algartelecom.adia.contabil.to.FaturasPrePago;
import br.com.algartelecom.adia.contabil.to.ReversaoProvisao;
import br.com.algartelecom.adia.util.CentroDeResultado;
import br.com.algartelecom.adia.util.FormataData;
import br.com.algartelecom.adia.util.FormataValores;
import br.com.algartelecom.adia.util.MontaCamposArquivosPosicionais;

public class ProvisaoRules extends AbstractContabilFaturamentoRules {

	public ProvisaoRules(ReversaoProvisao reversaoProvisao, String creditoOuDebito) throws Exception {
		montaAtributos(reversaoProvisao, creditoOuDebito);
	}

	private void montaAtributos(ReversaoProvisao reversaoProvisao, String creditoOuDebito) throws Exception {
		
		super.dataContabilizacaoLancamento = FormataData.formataDataPadraoBrasilSemHoras(reversaoProvisao.getDataFinalPeriodo());
		super.dataCriacaoLancamento = FormataData.formataDataPadraoBrasilSemHoras(reversaoProvisao.getDataFinalPeriodo());
		super.criadoPor = "0";
		super.categoriaLancamento = "Provisao";
		super.origem = "ODIN";
		super.empresa = "302";
		super.projeto = "0000";
		//TODO: Quando tiver intercompany, dever� ser alterado
		super.intercompany = "000";
		super.anatel = "0000";
		super.reserva1 = "00000";
		super.reserva2 = "00000";
		super.nomeLote = "101302 ODIN A 016" + FormataData.getDataHoraAtualSemSegundos_Americano();
		super.descricaoLote = "Provisao ODIN 016" + FormataData.getDataHoraAtualSemSegundos_Americano();
		super.nomeLancamento = "302016 ODIN";
		super.descricaoLancamento = "Provisao 302016 ODIN";
		super.periodoContabil = FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula();
		super.identificadorLote = "016" + FormataData.getDataHoraAtualSemSegundos_Americano();
		super.dataCredito = FormataData.formataDataPadraoBrasilSemHoras(reversaoProvisao.getDataFinalPeriodo());
		//TODO: Quando entrarem os outros produtos, Office, Backup, Monitoramento e Servicos Profissionais, como ficar� este campo
		super.dataCriacao = FormataData.formataDataAtualPadraoBrasilSemHoras();
		
		if (isCredito(creditoOuDebito)){
			montaAtributosDebito(reversaoProvisao);
		} else{
			montaAtributosCredito(reversaoProvisao);
		}

		
	}
	
	private void montaAtributosCredito(ReversaoProvisao reversaoProvisao) throws Exception {
		super.contaContabil = ContaContabilEnum.ELASTIC_PROVISAO_CREDITO.getCodigo();
		super.regulamento = "001";
		super.centroResultado = MontaCamposArquivosPosicionais.preencherCampo(CentroDeResultado.substituiCREmBrancoPorCRdeUberlandia(reversaoProvisao.getCodCentroCustos()), 9, true); 
		super.produto = MontaCamposArquivosPosicionais.preencherCampo(reversaoProvisao.getCodProdutoContabil(), 12, true);
		super.uf = "MG";
		super.valorDebito = "0,00";
		super.valorCredito = FormataValores.substituiSeparadorDecimalPontoPorVirgula(reversaoProvisao.getValProvisao());
		super.valorDebito1 = "0,00";
		super.valorCredito1 = super.valorCredito;
		super.codigoRastreamentoLote =  FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula() + "_Credito_POS-PAGO_Provisao_" + super.contaContabil + "_" + super.produto + "_"  + reversaoProvisao.getIdContratoOdin();
		super.DescricaoLinhaLancamento = "PROVISAO Credito POS-PAGO Elastic Cloud " + FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula();
	}

	private void montaAtributosDebito(ReversaoProvisao reversaoProvisao) throws Exception {
		super.contaContabil = ContaContabilEnum.ELASTIC_PROVISAO_DEBITO.getCodigo();
		super.regulamento = "000";
		super.centroResultado = "000000000"; 
		super.produto = "000000000000";
		super.uf = "00";
		super.valorDebito = FormataValores.substituiSeparadorDecimalPontoPorVirgula(reversaoProvisao.getValProvisao());
		super.valorCredito = "0,00"; 
		super.valorDebito1 = super.valorDebito;
		super.valorCredito1 = "0,00";
		super.codigoRastreamentoLote =  FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula() + "_Debito_POS-PAGO_Provisao_" + super.contaContabil + "_" + reversaoProvisao.getIdContratoOdin();
		super.DescricaoLinhaLancamento = "PROVISAO Debito_POS-PAGO Elastic Cloud " + FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula();
	}
	
	private boolean isCredito(String creditoOuDebito) {
		if (creditoOuDebito.equalsIgnoreCase(DebitoCredito.CREDITO.getNome())){
			return true;
		} else{
			return false;
		}
	}



	

}
