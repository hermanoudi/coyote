package br.com.algartelecom.adia.mastersaf.to;

import br.com.algartelecom.adia.Enum.CliFornecTransp_Mastersaf_Enum;
import br.com.algartelecom.adia.Enum.MestreNFSD_Mastersaf_Enum;
import br.com.algartelecom.adia.util.MontaCamposArquivosPosicionais;

public class MestreNFSD_MastersafTO {
	
	private String codEmpresa; 								//COD_EMPRESA(9),
	private String codFilial;								//COD_FILIAL(9), 
	private String numSerieNotaFiscal;						//NUM_SERIE_NOTA_FISCAL(5), 
	private String numNotaFiscal;							//NUM_NOTA_FISCAL(15), 
	private String dtaEmissao;								//DTA_EMISSAO(8), 
	private String codCategoriaPFPJ;						//COD_CATEGORIA_PF_PJ(2), 
	private String codPFPJ;									//COD_PF_PJ(16), 
	private String indTipoDocumento;						//IND_TIPO_DOCUMENTO(3), 
	private String numItens;								//NUM_ITENS(5), 
	private String codModeloDocumento;						//COD_MODELO_DOCUMENTO(3), 
	private String valTotalServico;							//VAL_TOTAL_SERVICO(17), 
	private String valDesconto;								//VAL_DESCONTO(17), 
	private String valAliqIRRF;								//VAL_ALIQ_IRRF(17),
	private String valBaseCalculoIRRF;						//VAL_BASE_CALCULO_IRRF(17), 
	private String valIRRF;									//VAL_IRRF(17),
	private String indCancelamento;							//IND_CANCELAMENTO(1), 
	private String valINSS;									//VAL_INSS(17), 
	private String valAliqINSS;								//VAL_ALIQ_INSS(17), 
	private String valISSRetidoPeloTomador;					//VAL_ISS_RETIDO_PELO_TOMADOR(17),
	private String dscObservacaoNFe;						//DSC_OBSERVACAO_NFE(150),
	private String valBaseCalculoRetINSS;					//VAL_BASE_CALCULO_RET_INSS(17),
	private String indTipoDoctoMunicipio;					//IND_TIPO_DOCTO_MUNICIPIO(5), 
	private String valBaseCalculoISS;						//VAL_BASE_CALCULO_ISS(17), 
	private String dscChaveNFe;								//DSC_CHAVE_NFE(60),
	private String dtaExecucaoConclusao;					//DTA_EXECUCAO_CONCLUSAO(8), 
	private String indTipoPagamento;						//IND_TIPO_PAGAMENTO(1),
	private String dscOpenFlex_01;							//DSC_OPENFLEX_01(12), 
	private String dscOpenFlex_02;					 		//DSC_OPENFLEX_02(11), 
	private String dscOpenFlex_03;							//DSC_OPENFLEX_03(15),;
	private String dscOpenFlex_04;							//DSC_OPENFLEX_04(150),
	private String dscOpenFlex_05;							//DSC_OPENFLEX_05(150),
	private String dscOpenFlex_06;							//DSC_OPENFLEX_06(17),
	private String dscOpenFlex_07;							//DSC_OPENFLEX_07(17),
	private String dscOpenFlex_08;							//DSC_OPENFLEX_08(17);
	
	
	public String getCodEmpresa() {
		return codEmpresa;
	}
	public void setCodEmpresa(String codEmpresa) throws Exception {
		codEmpresa = MontaCamposArquivosPosicionais.preencherCampo(codEmpresa, MestreNFSD_Mastersaf_Enum.COD_EMPRESA.getTamanho(), MestreNFSD_Mastersaf_Enum.COD_EMPRESA.getPosicoesAEsquerda());
		this.codEmpresa = codEmpresa;
	}
	public String getCodFilial() {
		return codFilial;
	}
	public void setCodFilial(String codFilial) throws Exception {
		codFilial = MontaCamposArquivosPosicionais.preencherCampo(codFilial, MestreNFSD_Mastersaf_Enum.COD_FILIAL.getTamanho(), MestreNFSD_Mastersaf_Enum.COD_FILIAL.getPosicoesAEsquerda());
		this.codFilial = codFilial;
	}
	public String getNumSerieNotaFiscal() {
		return numSerieNotaFiscal;
	}
	public void setNumSerieNotaFiscal(String numSerieNotaFiscal) throws Exception {
		numSerieNotaFiscal = MontaCamposArquivosPosicionais.preencherCampo(numSerieNotaFiscal, MestreNFSD_Mastersaf_Enum.NUM_SERIE_NOTA_FISCAL.getTamanho(), MestreNFSD_Mastersaf_Enum.NUM_SERIE_NOTA_FISCAL.getPosicoesAEsquerda());
		this.numSerieNotaFiscal = numSerieNotaFiscal;
	}
	public String getNumNotaFiscal() {
		return numNotaFiscal;
	}
	public void setNumNotaFiscal(String numNotaFiscal) throws Exception {
		numNotaFiscal = MontaCamposArquivosPosicionais.preencherCampo(numNotaFiscal, MestreNFSD_Mastersaf_Enum.NUM_NOTA_FISCAL.getTamanho(), MestreNFSD_Mastersaf_Enum.NUM_NOTA_FISCAL.getPosicoesAEsquerda());
		this.numNotaFiscal = numNotaFiscal;
	}
	public String getDtaEmissao() {
		return dtaEmissao;
	}
	public void setDtaEmissao(String dtaEmissao) throws Exception {
		dtaEmissao = MontaCamposArquivosPosicionais.preencherCampo(dtaEmissao, MestreNFSD_Mastersaf_Enum.DTA_EMISSAO.getTamanho(), MestreNFSD_Mastersaf_Enum.DTA_EMISSAO.getPosicoesAEsquerda());
		this.dtaEmissao = dtaEmissao;
	}
	public String getCodCategoriaPFPJ() {
		return codCategoriaPFPJ;
	}
	public void setCodCategoriaPFPJ(String codCategoriaPFPJ) throws Exception {
		codCategoriaPFPJ = MontaCamposArquivosPosicionais.preencherCampo(codCategoriaPFPJ, MestreNFSD_Mastersaf_Enum.COD_CATEGORIA_PF_PJ.getTamanho(), MestreNFSD_Mastersaf_Enum.COD_CATEGORIA_PF_PJ.getPosicoesAEsquerda());
		this.codCategoriaPFPJ = codCategoriaPFPJ;
	}
	public String getCodPFPJ() {
		return codPFPJ;
	}
	public void setCodPFPJ(String codPFPJ) throws Exception {
		codPFPJ = MontaCamposArquivosPosicionais.preencherCampo(codPFPJ, MestreNFSD_Mastersaf_Enum.COD_PF_PJ.getTamanho(), MestreNFSD_Mastersaf_Enum.COD_PF_PJ.getPosicoesAEsquerda());
		this.codPFPJ = codPFPJ;
	}
	public String getIndTipoDocumento() {
		return indTipoDocumento;
	}
	public void setIndTipoDocumento(String indTipoDocumento) throws Exception {
		indTipoDocumento = MontaCamposArquivosPosicionais.preencherCampo(indTipoDocumento, MestreNFSD_Mastersaf_Enum.IND_TIPO_DOCUMENTO.getTamanho(), MestreNFSD_Mastersaf_Enum.IND_TIPO_DOCUMENTO.getPosicoesAEsquerda());
		this.indTipoDocumento = indTipoDocumento;
	}
	public String getNumItens() {
		return numItens;
	}
	public void setNumItens(String numItens) throws Exception {
		numItens = MontaCamposArquivosPosicionais.preencherCampo(numItens, MestreNFSD_Mastersaf_Enum.NUM_ITENS.getTamanho(), MestreNFSD_Mastersaf_Enum.NUM_ITENS.getPosicoesAEsquerda());
		this.numItens = numItens;
	}
	public String getCodModeloDocumento() {
		return codModeloDocumento;
	}
	public void setCodModeloDocumento(String codModeloDocumento) throws Exception {
		codModeloDocumento = MontaCamposArquivosPosicionais.preencherCampo(codModeloDocumento, MestreNFSD_Mastersaf_Enum.COD_MODELO_DOCUMENTO.getTamanho(), MestreNFSD_Mastersaf_Enum.COD_MODELO_DOCUMENTO.getPosicoesAEsquerda());
		this.codModeloDocumento = codModeloDocumento;
	}
	public String getValTotalServico() {
		return valTotalServico;
	}
	public void setValTotalServico(String valTotalServico) throws Exception {
		valTotalServico = MontaCamposArquivosPosicionais.preencherCampo(valTotalServico, MestreNFSD_Mastersaf_Enum.VAL_TOTAL_SERVICO.getTamanho(), MestreNFSD_Mastersaf_Enum.VAL_TOTAL_SERVICO.getPosicoesAEsquerda());
		this.valTotalServico = valTotalServico;
	}
	public String getValDesconto() {
		return valDesconto;
	}
	public void setValDesconto(String valDesconto) throws Exception {
		valDesconto = MontaCamposArquivosPosicionais.preencherCampo(valDesconto, MestreNFSD_Mastersaf_Enum.VAL_DESCONTO.getTamanho(), MestreNFSD_Mastersaf_Enum.VAL_DESCONTO.getPosicoesAEsquerda());
		this.valDesconto = valDesconto;
	}
	public String getValAliqIRRF() {
		return valAliqIRRF;
	}
	public void setValAliqIRRF(String valAliqIRRF) throws Exception {
		valAliqIRRF = MontaCamposArquivosPosicionais.preencherCampo(valAliqIRRF, MestreNFSD_Mastersaf_Enum.VAL_ALIQ_IRRF.getTamanho(), MestreNFSD_Mastersaf_Enum.VAL_ALIQ_IRRF.getPosicoesAEsquerda());
		this.valAliqIRRF = valAliqIRRF;
	}
	public String getValBaseCalculoIRRF() {
		return valBaseCalculoIRRF;
	}
	public void setValBaseCalculoIRRF(String valBaseCalculoIRRF) throws Exception {
		valBaseCalculoIRRF = MontaCamposArquivosPosicionais.preencherCampo(valBaseCalculoIRRF, MestreNFSD_Mastersaf_Enum.VAL_BASE_CALCULO_IRRF.getTamanho(), MestreNFSD_Mastersaf_Enum.VAL_BASE_CALCULO_IRRF.getPosicoesAEsquerda());
		this.valBaseCalculoIRRF = valBaseCalculoIRRF;
	}
	public String getValIRRF() {
		return valIRRF;
	}
	public void setValIRRF(String valIRRF) throws Exception {
		valIRRF = MontaCamposArquivosPosicionais.preencherCampo(valIRRF, MestreNFSD_Mastersaf_Enum.VAL_IRRF.getTamanho(), MestreNFSD_Mastersaf_Enum.VAL_IRRF.getPosicoesAEsquerda());
		this.valIRRF = valIRRF;
	}
	public String getIndCancelamento() {
		return indCancelamento;
	}
	public void setIndCancelamento(String indCancelamento) throws Exception {
		indCancelamento = MontaCamposArquivosPosicionais.preencherCampo(indCancelamento, MestreNFSD_Mastersaf_Enum.IND_CANCELAMENTO.getTamanho(), MestreNFSD_Mastersaf_Enum.IND_CANCELAMENTO.getPosicoesAEsquerda());
		this.indCancelamento = indCancelamento;
	}
	public String getValINSS() {
		return valINSS;
	}
	public void setValINSS(String valINSS) throws Exception {
		valINSS = MontaCamposArquivosPosicionais.preencherCampo(valINSS, MestreNFSD_Mastersaf_Enum.VAL_INSS.getTamanho(), MestreNFSD_Mastersaf_Enum.VAL_INSS.getPosicoesAEsquerda());
		this.valINSS = valINSS;
	}
	public String getValAliqINSS() {
		return valAliqINSS;
	}
	public void setValAliqINSS(String valAliqINSS) throws Exception {
		valAliqINSS = MontaCamposArquivosPosicionais.preencherCampo(valAliqINSS, MestreNFSD_Mastersaf_Enum.VAL_ALIQ_INSS.getTamanho(), MestreNFSD_Mastersaf_Enum.VAL_ALIQ_INSS.getPosicoesAEsquerda());
		this.valAliqINSS = valAliqINSS;
	}
	public String getValISSRetidoPeloTomador() {
		return valISSRetidoPeloTomador;
	}
	public void setValISSRetidoPeloTomador(String valISSRetidoPeloTomador) throws Exception {
		valISSRetidoPeloTomador = MontaCamposArquivosPosicionais.preencherCampo(valISSRetidoPeloTomador, MestreNFSD_Mastersaf_Enum.VAL_ISS_RETIDO_PELO_TOMADOR.getTamanho(), MestreNFSD_Mastersaf_Enum.VAL_ISS_RETIDO_PELO_TOMADOR.getPosicoesAEsquerda());
		this.valISSRetidoPeloTomador = valISSRetidoPeloTomador;
	}
	public String getDscObservacaoNFe() {
		return dscObservacaoNFe;
	}
	public void setDscObservacaoNFe(String dscObservacaoNFe) throws Exception {
		dscObservacaoNFe = MontaCamposArquivosPosicionais.preencherCampo(dscObservacaoNFe, MestreNFSD_Mastersaf_Enum.DSC_OBSERVACAO_NFE.getTamanho(), MestreNFSD_Mastersaf_Enum.DSC_OBSERVACAO_NFE.getPosicoesAEsquerda());
		this.dscObservacaoNFe = dscObservacaoNFe;
	}
	public String getValBaseCalculoRetINSS() {
		return valBaseCalculoRetINSS;
	}
	public void setValBaseCalculoRetINSS(String valBaseCalculoRetINSS) throws Exception {
		valBaseCalculoRetINSS = MontaCamposArquivosPosicionais.preencherCampo(valBaseCalculoRetINSS, MestreNFSD_Mastersaf_Enum.VAL_BASE_CALCULO_RET_INSS.getTamanho(), MestreNFSD_Mastersaf_Enum.VAL_BASE_CALCULO_RET_INSS.getPosicoesAEsquerda());
		this.valBaseCalculoRetINSS = valBaseCalculoRetINSS;
	}
	public String getIndTipoDoctoMunicipio() {
		return indTipoDoctoMunicipio;
	}
	public void setIndTipoDoctoMunicipio(String indTipoDoctoMunicipio) throws Exception {
		indTipoDoctoMunicipio = MontaCamposArquivosPosicionais.preencherCampo(indTipoDoctoMunicipio, MestreNFSD_Mastersaf_Enum.IND_TIPO_DOCTO_MUNICIPIO.getTamanho(), MestreNFSD_Mastersaf_Enum.IND_TIPO_DOCTO_MUNICIPIO.getPosicoesAEsquerda());
		this.indTipoDoctoMunicipio = indTipoDoctoMunicipio;
	}
	public String getValBaseCalculoISS() {
		return valBaseCalculoISS;
	}
	public void setValBaseCalculoISS(String valBaseCalculoISS) throws Exception {
		valBaseCalculoISS = MontaCamposArquivosPosicionais.preencherCampo(valBaseCalculoISS, MestreNFSD_Mastersaf_Enum.VAL_BASE_CALCULO_ISS.getTamanho(), MestreNFSD_Mastersaf_Enum.VAL_BASE_CALCULO_ISS.getPosicoesAEsquerda());
		this.valBaseCalculoISS = valBaseCalculoISS;
	}
	public String getDscChaveNFe() {
		return dscChaveNFe;
	}
	public void setDscChaveNFe(String dscChaveNFe) throws Exception {
		dscChaveNFe = MontaCamposArquivosPosicionais.preencherCampo(dscChaveNFe, MestreNFSD_Mastersaf_Enum.DSC_CHAVE_NFE.getTamanho(), MestreNFSD_Mastersaf_Enum.DSC_CHAVE_NFE.getPosicoesAEsquerda());
		this.dscChaveNFe = dscChaveNFe;
	}
	public String getDtaExecucaoConclusao() {
		return dtaExecucaoConclusao;
	}
	public void setDtaExecucaoConclusao(String dtaExecucaoConclusao) throws Exception {
		dtaExecucaoConclusao = MontaCamposArquivosPosicionais.preencherCampo(dtaExecucaoConclusao, MestreNFSD_Mastersaf_Enum.DTA_EXECUCAO_CONCLUSAO.getTamanho(), MestreNFSD_Mastersaf_Enum.DTA_EXECUCAO_CONCLUSAO.getPosicoesAEsquerda());
		this.dtaExecucaoConclusao = dtaExecucaoConclusao;
	}
	public String getIndTipoPagamento() {
		return indTipoPagamento;
	}
	public void setIndTipoPagamento(String indTipoPagamento) throws Exception {
		indTipoPagamento = MontaCamposArquivosPosicionais.preencherCampo(indTipoPagamento, MestreNFSD_Mastersaf_Enum.IND_TIPO_PAGAMENTO.getTamanho(), MestreNFSD_Mastersaf_Enum.IND_TIPO_PAGAMENTO.getPosicoesAEsquerda());
		this.indTipoPagamento = indTipoPagamento;
	}
	public String getDscOpenFlex_01() {
		return dscOpenFlex_01;
	}
	public void setDscOpenFlex_01(String dscOpenFlex_01) throws Exception {
		dscOpenFlex_01 = MontaCamposArquivosPosicionais.preencherCampo(dscOpenFlex_01, MestreNFSD_Mastersaf_Enum.DSC_OPENFLEX_01.getTamanho(), MestreNFSD_Mastersaf_Enum.DSC_OPENFLEX_01.getPosicoesAEsquerda());
		this.dscOpenFlex_01 = dscOpenFlex_01;
	}
	public String getDscOpenFlex_02() {
		return dscOpenFlex_02;
	}
	public void setDscOpenFlex_02(String dscOpenFlex_02) throws Exception {
		dscOpenFlex_02 = MontaCamposArquivosPosicionais.preencherCampo(dscOpenFlex_02, MestreNFSD_Mastersaf_Enum.DSC_OPENFLEX_02.getTamanho(), MestreNFSD_Mastersaf_Enum.DSC_OPENFLEX_02.getPosicoesAEsquerda());
		this.dscOpenFlex_02 = dscOpenFlex_02;
	}
	public String getDscOpenFlex_03() {
		return dscOpenFlex_03;
	}
	public void setDscOpenFlex_03(String dscOpenFlex_03) throws Exception {
		dscOpenFlex_03 = MontaCamposArquivosPosicionais.preencherCampo(dscOpenFlex_03, MestreNFSD_Mastersaf_Enum.DSC_OPENFLEX_03.getTamanho(), MestreNFSD_Mastersaf_Enum.DSC_OPENFLEX_03.getPosicoesAEsquerda());
		this.dscOpenFlex_03 = dscOpenFlex_03;
	}
	public String getDscOpenFlex_04() {
		return dscOpenFlex_04;
	}
	public void setDscOpenFlex_04(String dscOpenFlex_04) throws Exception {
		dscOpenFlex_04 = MontaCamposArquivosPosicionais.preencherCampo(dscOpenFlex_04, MestreNFSD_Mastersaf_Enum.DSC_OPENFLEX_04.getTamanho(), MestreNFSD_Mastersaf_Enum.DSC_OPENFLEX_04.getPosicoesAEsquerda());
		this.dscOpenFlex_04 = dscOpenFlex_04;
	}
	public String getDscOpenFlex_05() {
		return dscOpenFlex_05;
	}
	public void setDscOpenFlex_05(String dscOpenFlex_05) throws Exception {
		dscOpenFlex_05 = MontaCamposArquivosPosicionais.preencherCampo(dscOpenFlex_05, MestreNFSD_Mastersaf_Enum.DSC_OPENFLEX_05.getTamanho(), MestreNFSD_Mastersaf_Enum.DSC_OPENFLEX_05.getPosicoesAEsquerda());
		this.dscOpenFlex_05 = dscOpenFlex_05;
	}
	public String getDscOpenFlex_06() {
		return dscOpenFlex_06;
	}
	public void setDscOpenFlex_06(String dscOpenFlex_06) throws Exception {
		dscOpenFlex_06 = MontaCamposArquivosPosicionais.preencherCampo(dscOpenFlex_06, MestreNFSD_Mastersaf_Enum.DSC_OPENFLEX_06.getTamanho(), MestreNFSD_Mastersaf_Enum.DSC_OPENFLEX_06.getPosicoesAEsquerda());
		this.dscOpenFlex_06 = dscOpenFlex_06;
	}
	public String getDscOpenFlex_07() {
		return dscOpenFlex_07;
	}
	public void setDscOpenFlex_07(String dscOpenFlex_07) throws Exception {
		dscOpenFlex_07 = MontaCamposArquivosPosicionais.preencherCampo(dscOpenFlex_07, MestreNFSD_Mastersaf_Enum.DSC_OPENFLEX_07.getTamanho(), MestreNFSD_Mastersaf_Enum.DSC_OPENFLEX_07.getPosicoesAEsquerda());
		this.dscOpenFlex_07 = dscOpenFlex_07;
	}
	public String getDscOpenFlex_08() {
		return dscOpenFlex_08;
	}
	public void setDscOpenFlex_08(String dscOpenFlex_08) throws Exception {
		dscOpenFlex_08 = MontaCamposArquivosPosicionais.preencherCampo(dscOpenFlex_08, MestreNFSD_Mastersaf_Enum.DSC_OPENFLEX_08.getTamanho(), MestreNFSD_Mastersaf_Enum.DSC_OPENFLEX_08.getPosicoesAEsquerda());
		this.dscOpenFlex_08 = dscOpenFlex_08;
	}
	
	@Override
	public String toString() {
		return  this.codEmpresa + this.codFilial + this.numSerieNotaFiscal + this.numNotaFiscal + this.dtaEmissao + this.codCategoriaPFPJ +		
				this.codPFPJ + this.indTipoDocumento + this.numItens + this.codModeloDocumento + this.valTotalServico + this.valDesconto +
				this.valAliqIRRF + this.valBaseCalculoIRRF + this.valIRRF + this.indCancelamento + this.valINSS + this.valAliqINSS + 				
				this.valISSRetidoPeloTomador + this.dscObservacaoNFe + this.valBaseCalculoRetINSS + this.indTipoDoctoMunicipio + this.valBaseCalculoISS +
				this.dscChaveNFe +	this.dtaExecucaoConclusao + this.indTipoPagamento + this.dscOpenFlex_01 + this.dscOpenFlex_02 + this.dscOpenFlex_03 +			
				this.dscOpenFlex_04 + this.dscOpenFlex_05 + this.dscOpenFlex_06 + this.dscOpenFlex_07 + this.dscOpenFlex_08;
	}

}
