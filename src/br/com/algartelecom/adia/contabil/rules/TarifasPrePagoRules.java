package br.com.algartelecom.adia.contabil.rules;

import br.com.algartelecom.adia.Enum.ContaContabilEnum;
import br.com.algartelecom.adia.Enum.DebitoCredito;
import br.com.algartelecom.adia.contabil.to.ArrecadacaoPrePago;
import br.com.algartelecom.adia.contabil.to.Tarifa;
import br.com.algartelecom.adia.util.CentroDeResultado;
import br.com.algartelecom.adia.util.FormataData;
import br.com.algartelecom.adia.util.FormataValores;
import br.com.algartelecom.adia.util.MontaCamposArquivosPosicionais;

public class TarifasPrePagoRules extends AbstractContabilFaturamentoRules {
	
	public TarifasPrePagoRules(Tarifa tarifa, String creditoOuDebito) throws Exception {
		montaAtributos(tarifa, creditoOuDebito);
	}

	private void montaAtributos(Tarifa tarifa, String creditoOuDebito) throws Exception {
		
		super.dataContabilizacaoLancamento = FormataData.formataDataPadraoBrasilSemHoras(tarifa.getDataPrevistaCredito());
		super.dataCriacaoLancamento = FormataData.formataDataPadraoBrasilSemHoras(tarifa.getDataPrevistaCredito());
		super.criadoPor = "0";
		super.categoriaLancamento = "Tarifa";
		super.origem = "ODIN_ARRECADACAO";
		super.empresa = "302";
		super.projeto = "0000";
		//TODO: Quando tiver intercompany, dever� ser alterado
		super.intercompany = "000";
		super.anatel = "0000";
		super.reserva1 = "00000";
		super.reserva2 = "00000";
		super.nomeLote = "204302 ODIN A 016" + FormataData.getDataHoraAtualSemSegundos_Americano();
		super.descricaoLote = "Tarifa ODIN 016" + FormataData.getDataHoraAtualSemSegundos_Americano();
		super.nomeLancamento = "302016 ODIN";
		super.descricaoLancamento = "Tarifa 302016 ODIN";
		super.periodoContabil = FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula();
		super.identificadorLote = "016" + FormataData.getDataHoraAtualSemSegundos_Americano();
		super.dataCredito = FormataData.formataDataPadraoBrasilSemHoras(tarifa.getDataPrevistaCredito());
		//TODO: Quando entrarem os outros produtos, Office, Backup, Monitoramento e Servicos Profissionais, como ficar� este campo
		super.dataCriacao = FormataData.formataDataAtualPadraoBrasilSemHoras();
		tarifa.setCodSKUOdin(MontaCamposArquivosPosicionais.preencherCampo(tarifa.getCodSKUOdin(), 12, true));
		
		if (isCredito(creditoOuDebito)){
			montaAtributosDebito(tarifa);
		} else{
			montaAtributosCredito(tarifa);
		}

		
	}
	
	private void montaAtributosCredito(Tarifa tarifa) throws Exception {
		
		super.contaContabil = ContaContabilEnum.ELASTIC_TARIFA_PRE_CREDITO.getCodigo();
		super.regulamento = "000";
		super.centroResultado = "000000000"; 
		super.uf = "00";
		super.produto = "000000000000";
		super.valorDebito = "0,00"; 
		super.valorCredito = FormataValores.substituiSeparadorDecimalPontoPorVirgula(tarifa.getValTarifaCartao());
		super.valorDebito1 = "0,00";
		super.valorCredito1 = super.valorCredito;
		super.codigoRastreamentoLote =  FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula() + "_Credito_PRE-PAGO_Tarifa_" + super.contaContabil + "_" + tarifa.getCodSKUOdin() + "_" +  tarifa.getCodItemFaturaOdin();
		super.DescricaoLinhaLancamento = "TARIFA  C/C Credito_PRE-PAGO Elastic Cloud " + FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula();	
	}

	private void montaAtributosDebito(Tarifa tarifa) throws Exception {
		
		super.contaContabil = ContaContabilEnum.ELASTIC_TARIFA_PRE_DEBITO.getCodigo();
		super.regulamento = "001";
		super.uf = "MG";
		super.centroResultado = super.centroResultado = MontaCamposArquivosPosicionais.preencherCampo(CentroDeResultado.substituiCREmBrancoPorCRdeUberlandia(tarifa.getCodCentroCusto()), 9, true); 
		super.produto = MontaCamposArquivosPosicionais.preencherCampo(tarifa.getCodSKUOdin(), 12, true);
		super.valorDebito = FormataValores.substituiSeparadorDecimalPontoPorVirgula(tarifa.getValTarifaCartao());
		super.valorCredito = "0,00";
		super.valorDebito1 = super.valorDebito;
		super.valorCredito1 = "0,00";
		super.codigoRastreamentoLote =  FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula() + "_Debito_PRE-PAGO_Tarifa_" + super.contaContabil + "_" + tarifa.getCodSKUOdin() + "_" + tarifa.getCodItemFaturaOdin();
		super.DescricaoLinhaLancamento = "TARIFA  C/C Debito PRE-PAGO Elastic Cloud " + FormataData.getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula();
	}
	
	private boolean isCredito(String creditoOuDebito) {
		if (creditoOuDebito.equalsIgnoreCase(DebitoCredito.CREDITO.getNome())){
			return true;
		} else{
			return false;
		}
	}


}
