package br.com.algartelecom.adia.mastersaf.to;

import br.com.algartelecom.adia.Enum.D_Auxiliar_Mastersaf_Enum;
import br.com.algartelecom.adia.util.MontaCamposArquivosPosicionais;

public class DAuxiliar_MastersafTO {
	
	private String codEmpresa;					// COD_EMPRESA(09),
	private String codFilial; 					//COD_FILIAL(09),
	private String codCategoriaPF_PF;			//COD_CATEGORIA_PF_PJ(02),
	private String codPF_PJ;					//COD_PF_PJ(16),
	private String dtaLancamento;				//DTA_LANCAMENTO(08),
	private String indTipoOperacao;				//IND_TIPO_OPERACAO(06),
	private String valLancamento;				//VAL_LANCAMENTO(17),
	private String indLancamento;				//IND_LANCAMENTO(01),
	private String indTipoDocumento;			//IND_TIPO_DOCUMENTO(03),
	private String numDocumento;				//NUM_DOCUMENTO(15),
	private String numSerieDocumento;			//NUM_SERIE_DOCUMENTO(05),
	private String dtaEmissao;					//DTA_EMISSAO(08),
	private String dtaVencimento;				//DTA_VENCIMENTO(08),
	private String valTotalDocto;				//VAL_TOTAL_DOCTO(17),
	private String numArquivamento;				//NUM_ARQUIVAMENTO(14),
	private String numContaContabil;			//NUM_CONTA_CONTABIL(12),
	private String dscOpenFlex_01;				//DSC_OPENFLEX_01(12),
	private String dscOpenFlex_02;				//DSC_OPENFLEX_02(11),
	private String dscOpenFlex_03;				//DSC_OPENFLEX_03(15),
	private String dscOpenFlex_04;				//DSC_OPENFLEX_04(150),
	private String dscOpenFlex_05;				//DSC_OPENFLEX_05(150),
	private String dscOpenFlex_06;				//DSC_OPENFLEX_06(17),
	private String dscOpenFlex_07;				//DSC_OPENFLEX_07(17),
	private String dscOpenFlex_08;				//DSC_OPENFLEX_08(17),
	
	public String getCodEmpresa() {
		return codEmpresa;
	}
	public void setCodEmpresa(String codEmpresa) throws Exception {
		codEmpresa = MontaCamposArquivosPosicionais.preencherCampo(codEmpresa, D_Auxiliar_Mastersaf_Enum.COD_EMPRESA.getTamanho(), D_Auxiliar_Mastersaf_Enum.COD_EMPRESA.getPosicoesAEsquerda());
		this.codEmpresa = codEmpresa;
	}
	public String getCodFilial() {
		return codFilial;
	}
	public void setCodFilial(String codFilial) throws Exception {
		codFilial = MontaCamposArquivosPosicionais.preencherCampo(codFilial, D_Auxiliar_Mastersaf_Enum.COD_FILIAL.getTamanho(), D_Auxiliar_Mastersaf_Enum.COD_FILIAL.getPosicoesAEsquerda());
		this.codFilial = codFilial;
	}
	public String getCodCategoriaPF_PF() {
		return codCategoriaPF_PF;
	}
	public void setCodCategoriaPF_PF(String codCategoriaPF_PF) throws Exception {
		codCategoriaPF_PF = MontaCamposArquivosPosicionais.preencherCampo(codCategoriaPF_PF, D_Auxiliar_Mastersaf_Enum.COD_CATEGORIA_PF_PJ.getTamanho(), D_Auxiliar_Mastersaf_Enum.COD_CATEGORIA_PF_PJ.getPosicoesAEsquerda());
		this.codCategoriaPF_PF = codCategoriaPF_PF;
	}
	public String getCodPF_PJ() {
		return codPF_PJ;
	}
	public void setCodPF_PJ(String codPF_PJ) throws Exception {
		codPF_PJ = MontaCamposArquivosPosicionais.preencherCampo(codPF_PJ, D_Auxiliar_Mastersaf_Enum.COD_PF_PJ.getTamanho(), D_Auxiliar_Mastersaf_Enum.COD_PF_PJ.getPosicoesAEsquerda());
		this.codPF_PJ = codPF_PJ;
	}
	public String getDtaLancamento() {
		return dtaLancamento;
	}
	public void setDtaLancamento(String dtaLancamento) throws Exception {
		dtaLancamento = MontaCamposArquivosPosicionais.preencherCampo(dtaLancamento, D_Auxiliar_Mastersaf_Enum.DTA_LANCAMENTO.getTamanho(), D_Auxiliar_Mastersaf_Enum.DTA_LANCAMENTO.getPosicoesAEsquerda());
		this.dtaLancamento = dtaLancamento;
	}
	public String getIndTipoOperacao() {
		return indTipoOperacao;
	}
	public void setIndTipoOperacao(String indTipoOperacao) throws Exception {
		indTipoOperacao = MontaCamposArquivosPosicionais.preencherCampo(indTipoOperacao, D_Auxiliar_Mastersaf_Enum.IND_TIPO_OPERACAO.getTamanho(), D_Auxiliar_Mastersaf_Enum.IND_TIPO_OPERACAO.getPosicoesAEsquerda());
		this.indTipoOperacao = indTipoOperacao;
	}
	public String getValLancamento() {
		return valLancamento;
	}
	public void setValLancamento(String valLancamento) throws Exception {
		valLancamento = MontaCamposArquivosPosicionais.preencherCampo(valLancamento, D_Auxiliar_Mastersaf_Enum.VAL_LANCAMENTO.getTamanho(), D_Auxiliar_Mastersaf_Enum.VAL_LANCAMENTO.getPosicoesAEsquerda());
		this.valLancamento = valLancamento;
	}
	public String getIndLancamento() {
		return indLancamento;
	}
	public void setIndLancamento(String indLancamento) throws Exception {
		indLancamento = MontaCamposArquivosPosicionais.preencherCampo(indLancamento, D_Auxiliar_Mastersaf_Enum.IND_LANCAMENTO.getTamanho(), D_Auxiliar_Mastersaf_Enum.IND_LANCAMENTO.getPosicoesAEsquerda());
		this.indLancamento = indLancamento;
	}
	public String getIndTipoDocumento() {
		return indTipoDocumento;
	}
	public void setIndTipoDocumento(String indTipoDocumento) throws Exception {
		indTipoDocumento = MontaCamposArquivosPosicionais.preencherCampo(indTipoDocumento, D_Auxiliar_Mastersaf_Enum.IND_TIPO_DOCUMENTO.getTamanho(), D_Auxiliar_Mastersaf_Enum.IND_TIPO_DOCUMENTO.getPosicoesAEsquerda());
		this.indTipoDocumento = indTipoDocumento;
	}
	public String getNumDocumento() {
		return numDocumento;
	}
	public void setNumDocumento(String numDocumento) throws Exception {
		numDocumento = MontaCamposArquivosPosicionais.preencherCampo(numDocumento, D_Auxiliar_Mastersaf_Enum.NUM_DOCUMENTO.getTamanho(), D_Auxiliar_Mastersaf_Enum.NUM_DOCUMENTO.getPosicoesAEsquerda());
		this.numDocumento = numDocumento;
	}
	public String getNumSerieDocumento() {
		return numSerieDocumento;
	}
	public void setNumSerieDocumento(String numSerieDocumento) throws Exception {
		numSerieDocumento = MontaCamposArquivosPosicionais.preencherCampo(numSerieDocumento, D_Auxiliar_Mastersaf_Enum.NUM_SERIE_DOCUMENTO.getTamanho(), D_Auxiliar_Mastersaf_Enum.NUM_SERIE_DOCUMENTO.getPosicoesAEsquerda());
		this.numSerieDocumento = numSerieDocumento;
	}
	public String getDtaEmissao() {
		return dtaEmissao;
	}
	public void setDtaEmissao(String dtaEmissao) throws Exception {
		dtaEmissao = MontaCamposArquivosPosicionais.preencherCampo(dtaEmissao, D_Auxiliar_Mastersaf_Enum.DTA_EMISSAO.getTamanho(), D_Auxiliar_Mastersaf_Enum.DTA_EMISSAO.getPosicoesAEsquerda());
		this.dtaEmissao = dtaEmissao;
	}
	public String getDtaVencimento() {
		return dtaVencimento;
	}
	public void setDtaVencimento(String dtaVencimento) throws Exception {
		dtaVencimento = MontaCamposArquivosPosicionais.preencherCampo(dtaVencimento, D_Auxiliar_Mastersaf_Enum.DTA_VENCIMENTO.getTamanho(), D_Auxiliar_Mastersaf_Enum.DTA_VENCIMENTO.getPosicoesAEsquerda());
		this.dtaVencimento = dtaVencimento;
	}
	public String getValTotalDocto() {
		return valTotalDocto;
	}
	public void setValTotalDocto(String valTotalDocto) throws Exception {
		valTotalDocto = MontaCamposArquivosPosicionais.preencherCampo(valTotalDocto, D_Auxiliar_Mastersaf_Enum.VAL_TOTAL_DOCTO.getTamanho(), D_Auxiliar_Mastersaf_Enum.VAL_TOTAL_DOCTO.getPosicoesAEsquerda());
		this.valTotalDocto = valTotalDocto;
	}
	public String getNumArquivamento() {
		return numArquivamento;
	}
	public void setNumArquivamento(String numArquivamento) throws Exception {
		numArquivamento = MontaCamposArquivosPosicionais.preencherCampo(numArquivamento, D_Auxiliar_Mastersaf_Enum.NUM_ARQUIVAMENTO.getTamanho(), D_Auxiliar_Mastersaf_Enum.NUM_ARQUIVAMENTO.getPosicoesAEsquerda());
		this.numArquivamento = numArquivamento;
	}
	public String getNumContaContabil() {
		return numContaContabil;
	}
	public void setNumContaContabil(String numContaContabil) throws Exception {
		numContaContabil = MontaCamposArquivosPosicionais.preencherCampo(numContaContabil, D_Auxiliar_Mastersaf_Enum.NUM_CONTA_CONTABIL.getTamanho(), D_Auxiliar_Mastersaf_Enum.NUM_CONTA_CONTABIL.getPosicoesAEsquerda());
		this.numContaContabil = numContaContabil;
	}
	public String getDscOpenFlex_01() {
		return dscOpenFlex_01;
	}
	public void setDscOpenFlex_01(String dscOpenFlex_01) throws Exception {
		dscOpenFlex_01 = MontaCamposArquivosPosicionais.preencherCampo(dscOpenFlex_01, D_Auxiliar_Mastersaf_Enum.DSC_OPENFLEX_01.getTamanho(), D_Auxiliar_Mastersaf_Enum.DSC_OPENFLEX_01.getPosicoesAEsquerda());
		this.dscOpenFlex_01 = dscOpenFlex_01;
	}
	public String getDscOpenFlex_02() {
		return dscOpenFlex_02;
	}
	public void setDscOpenFlex_02(String dscOpenFlex_02) throws Exception {
		dscOpenFlex_02 = MontaCamposArquivosPosicionais.preencherCampo(dscOpenFlex_02, D_Auxiliar_Mastersaf_Enum.DSC_OPENFLEX_02.getTamanho(), D_Auxiliar_Mastersaf_Enum.DSC_OPENFLEX_02.getPosicoesAEsquerda());
		this.dscOpenFlex_02 = dscOpenFlex_02;
	}
	public String getDscOpenFlex_03() {
		return dscOpenFlex_03;
	}
	public void setDscOpenFlex_03(String dscOpenFlex_03) throws Exception {
		dscOpenFlex_03 = MontaCamposArquivosPosicionais.preencherCampo(dscOpenFlex_03, D_Auxiliar_Mastersaf_Enum.DSC_OPENFLEX_03.getTamanho(), D_Auxiliar_Mastersaf_Enum.DSC_OPENFLEX_03.getPosicoesAEsquerda());
		this.dscOpenFlex_03 = dscOpenFlex_03;
	}
	public String getDscOpenFlex_04() {
		return dscOpenFlex_04;
	}
	public void setDscOpenFlex_04(String dscOpenFlex_04) throws Exception {
		dscOpenFlex_04 = MontaCamposArquivosPosicionais.preencherCampo(dscOpenFlex_04, D_Auxiliar_Mastersaf_Enum.DSC_OPENFLEX_04.getTamanho(), D_Auxiliar_Mastersaf_Enum.DSC_OPENFLEX_04.getPosicoesAEsquerda());
		this.dscOpenFlex_04 = dscOpenFlex_04;
	}
	public String getDscOpenFlex_05() {
		return dscOpenFlex_05;
	}
	public void setDscOpenFlex_05(String dscOpenFlex_05) throws Exception {
		dscOpenFlex_05 = MontaCamposArquivosPosicionais.preencherCampo(dscOpenFlex_05, D_Auxiliar_Mastersaf_Enum.DSC_OPENFLEX_05.getTamanho(), D_Auxiliar_Mastersaf_Enum.DSC_OPENFLEX_05.getPosicoesAEsquerda());
		this.dscOpenFlex_05 = dscOpenFlex_05;
	}
	public String getDscOpenFlex_06() {
		return dscOpenFlex_06;
	}
	public void setDscOpenFlex_06(String dscOpenFlex_06) throws Exception {
		dscOpenFlex_06 = MontaCamposArquivosPosicionais.preencherCampo(dscOpenFlex_06, D_Auxiliar_Mastersaf_Enum.DSC_OPENFLEX_06.getTamanho(), D_Auxiliar_Mastersaf_Enum.DSC_OPENFLEX_06.getPosicoesAEsquerda());
		this.dscOpenFlex_06 = dscOpenFlex_06;
	}
	public String getDscOpenFlex_07() {
		return dscOpenFlex_07;
	}
	public void setDscOpenFlex_07(String dscOpenFlex_07) throws Exception {
		dscOpenFlex_07 = MontaCamposArquivosPosicionais.preencherCampo(dscOpenFlex_07, D_Auxiliar_Mastersaf_Enum.DSC_OPENFLEX_07.getTamanho(), D_Auxiliar_Mastersaf_Enum.DSC_OPENFLEX_07.getPosicoesAEsquerda());
		this.dscOpenFlex_07 = dscOpenFlex_07;
	}
	public String getDscOpenFlex_08() {
		return dscOpenFlex_08;
	}
	public void setDscOpenFlex_08(String dscOpenFlex_08) throws Exception {
		dscOpenFlex_08 = MontaCamposArquivosPosicionais.preencherCampo(dscOpenFlex_08, D_Auxiliar_Mastersaf_Enum.DSC_OPENFLEX_08.getTamanho(), D_Auxiliar_Mastersaf_Enum.DSC_OPENFLEX_08.getPosicoesAEsquerda());
		this.dscOpenFlex_08 = dscOpenFlex_08;
	}
	
	@Override
	public String toString() {
		return this.codEmpresa + 			
				this.codFilial +  			
				this.codCategoriaPF_PF + 	
				this.codPF_PJ + 			
				this.dtaLancamento + 		
				this.indTipoOperacao + 		
				this.valLancamento + 		
				this.indLancamento + 		
				this.indTipoDocumento + 	
				this.numDocumento + 		
				this.numSerieDocumento + 	
				this.dtaEmissao + 			
				this.dtaVencimento + 		
				this.valTotalDocto + 		
				this.numArquivamento + 		
				this.numContaContabil + 	
				this.dscOpenFlex_01 + 		
				this.dscOpenFlex_02 + 		
				this.dscOpenFlex_03 + 		
				this.dscOpenFlex_04 + 		
				this.dscOpenFlex_05 + 		
				this.dscOpenFlex_06 + 		
				this.dscOpenFlex_07 + 		
				this.dscOpenFlex_08;
	}
	

}
