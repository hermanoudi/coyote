package br.com.algartelecom.adia.mastersaf.to;

import br.com.algartelecom.adia.Enum.CliFornecTransp_Mastersaf_Enum;
import br.com.algartelecom.adia.Enum.ItemNFSD_Mastersaf_Enum;
import br.com.algartelecom.adia.util.MontaCamposArquivosPosicionais;

public class ItemNFSD_MastersafTO {
	
	private String codEmpresa; 								//COD_EMPRESA(09),
	private String codFilial;								//COD_FILIAL(09),
	private String numSerieNotaFiscal;						//NUM_SERIE_NOTA_FISCAL(05),
	private String numNotaFiscal;							//NUM_NOTA_FISCAL(15),
	private String dtaEmissao;								//DTA_EMISSAO(08),
	private String codCategoriaPF_PJ;						//COD_CATEGORIA_PF_PJ(02),
	private String numItem;									//NUM_ITEM(05),
	private String codPF_PJ;								//COD_PF_PJ(16),
	private String indTiposDocumento;						//IND_TIPO_DOCUMENTO(03),
	private String codParaServico;							//COD_PARA_SERVICO(20),
	private String dscComplementar;							//DSC_COMPLEMENTAR(150),
	private String valServico;								//VAL_SERVICO(17)
	private String valDesconto;								//VAL_DESCONTO(17),
	private String valAliqISS;								//VAL_ALIQ_ISS(17)
	private String valBaseCalculoISS;						//VAL_BASE_CALCULO_ISS(17)
	private String valISS;									//VAL_ISS(17),
	private String valTotalDocumento;						//VAL_TOTAL_DOCUMENTO(17)
	private String codFiscalServico;						//COD_FISCAL_SERVICO(06),
	private String valMaterialAplicado;						//VAL_MATERIAL_APLICADO(17),
	private String valSubEmpreitada;						//VAL_SUBEMPREITADA(17),
	private String indTipoLocalidade;						//IND_TIPO_LOCALIDADE(02),
	private String nomLocalidade;							//NOM_LOCALIDADE(10),
	private String indTipoDoctoMunicipio;					//IND_TIPO_DOCTO_MUNICIPIO(05),
	private String numContaContabil;						// NUM_CONTA_CONTABIL(28),
	private String codCentroCustos;							//COD_CENTRO_CUSTOS(28),
	private String dscOpenFlex_01;							//DSC_OPENFLEX_01(12),
	private String dscOpenFlex_02;
	private String dscOpenFlex_03;
	private String dscOpenFlex_04;
	private String dscOpenFlex_05;
	private String dscOpenFlex_06;
	private String dscOpenFlex_07;
	private String dscOpenFlex_08;
	
	public String getCodEmpresa() {
		return codEmpresa;
	}
	public void setCodEmpresa(String codEmpresa) throws Exception {
		codEmpresa = MontaCamposArquivosPosicionais.preencherCampo(codEmpresa, ItemNFSD_Mastersaf_Enum.COD_EMPRESA.getTamanho(), ItemNFSD_Mastersaf_Enum.COD_EMPRESA.getPosicoesAEsquerda());
		this.codEmpresa = codEmpresa;
	}
	public String getCodFilial() {
		return codFilial;
	}
	public void setCodFilial(String codFilial) throws Exception {
		codFilial = MontaCamposArquivosPosicionais.preencherCampo(codFilial, ItemNFSD_Mastersaf_Enum.COD_FILIAL.getTamanho(), ItemNFSD_Mastersaf_Enum.COD_FILIAL.getPosicoesAEsquerda());
		this.codFilial = codFilial;
	}
	public String getNumSerieNotaFiscal() {
		return numSerieNotaFiscal;
	}
	public void setNumSerieNotaFiscal(String numSerieNotaFiscal) throws Exception {
		numSerieNotaFiscal = MontaCamposArquivosPosicionais.preencherCampo(numSerieNotaFiscal, ItemNFSD_Mastersaf_Enum.NUM_SERIE_NOTA_FISCAL.getTamanho(), ItemNFSD_Mastersaf_Enum.NUM_SERIE_NOTA_FISCAL.getPosicoesAEsquerda());
		this.numSerieNotaFiscal = numSerieNotaFiscal;
	}
	public String getNumNotaFiscal() {
		return numNotaFiscal;
	}
	public void setNumNotaFiscal(String numNotaFiscal) throws Exception {
		numNotaFiscal = MontaCamposArquivosPosicionais.preencherCampo(numNotaFiscal, ItemNFSD_Mastersaf_Enum.NUM_NOTA_FISCAL.getTamanho(), ItemNFSD_Mastersaf_Enum.NUM_NOTA_FISCAL.getPosicoesAEsquerda());
		this.numNotaFiscal = numNotaFiscal;
	}
	public String getDtaEmissao() {
		return dtaEmissao;
	}
	public void setDtaEmissao(String dtaEmissao) throws Exception {
		dtaEmissao = MontaCamposArquivosPosicionais.preencherCampo(dtaEmissao, ItemNFSD_Mastersaf_Enum.DTA_EMISSAO.getTamanho(), ItemNFSD_Mastersaf_Enum.DTA_EMISSAO.getPosicoesAEsquerda());
		this.dtaEmissao = dtaEmissao;
	}
	public String getCodCategoriaPF_PJ() {
		return codCategoriaPF_PJ;
	}
	public void setCodCategoriaPF_PJ(String codCategoriaPF_PJ) throws Exception {
		codCategoriaPF_PJ = MontaCamposArquivosPosicionais.preencherCampo(codCategoriaPF_PJ, ItemNFSD_Mastersaf_Enum.COD_CATEGORIA_PF_PJ.getTamanho(), ItemNFSD_Mastersaf_Enum.COD_CATEGORIA_PF_PJ.getPosicoesAEsquerda());
		this.codCategoriaPF_PJ = codCategoriaPF_PJ;
	}
	public String getNumItem() {
		return numItem;
	}
	public void setNumItem(String numItem) throws Exception {
		numItem = MontaCamposArquivosPosicionais.preencherCampo(numItem, ItemNFSD_Mastersaf_Enum.NUM_ITEM.getTamanho(), ItemNFSD_Mastersaf_Enum.NUM_ITEM.getPosicoesAEsquerda());
		this.numItem = numItem;
	}
	public String getCodPF_PJ() {
		return codPF_PJ;
	}
	public void setCodPF_PJ(String codPF_PJ) throws Exception {
		codPF_PJ = MontaCamposArquivosPosicionais.preencherCampo(codPF_PJ, ItemNFSD_Mastersaf_Enum.COD_PF_PJ.getTamanho(), ItemNFSD_Mastersaf_Enum.COD_PF_PJ.getPosicoesAEsquerda());
		this.codPF_PJ = codPF_PJ;
	}
	public String getIndTiposDocumento() {
		return indTiposDocumento;
	}
	public void setIndTiposDocumento(String indTiposDocumento) throws Exception {
		indTiposDocumento = MontaCamposArquivosPosicionais.preencherCampo(indTiposDocumento, ItemNFSD_Mastersaf_Enum.IND_TIPO_DOCUMENTO.getTamanho(), ItemNFSD_Mastersaf_Enum.IND_TIPO_DOCUMENTO.getPosicoesAEsquerda());
		this.indTiposDocumento = indTiposDocumento;
	}
	public String getCodParaServico() {
		return codParaServico;
	}
	public void setCodParaServico(String codParaServico) throws Exception {
		codParaServico = MontaCamposArquivosPosicionais.preencherCampo(codParaServico, ItemNFSD_Mastersaf_Enum.COD_PARA_SERVICO.getTamanho(), ItemNFSD_Mastersaf_Enum.COD_PARA_SERVICO.getPosicoesAEsquerda());
		this.codParaServico = codParaServico;
	}
	public String getDscComplementar() {
		return dscComplementar;
	}
	public void setDscComplementar(String dscComplementar) throws Exception {
		dscComplementar = MontaCamposArquivosPosicionais.preencherCampo(dscComplementar, ItemNFSD_Mastersaf_Enum.DSC_COMPLEMENTAR.getTamanho(), ItemNFSD_Mastersaf_Enum.DSC_COMPLEMENTAR.getPosicoesAEsquerda());
		this.dscComplementar = dscComplementar;
	}
	public String getValServico() {
		return valServico;
	}
	public void setValServico(String valServico) throws Exception {
		valServico = MontaCamposArquivosPosicionais.preencherCampo(valServico, ItemNFSD_Mastersaf_Enum.VAL_SERVICO.getTamanho(), ItemNFSD_Mastersaf_Enum.VAL_SERVICO.getPosicoesAEsquerda());
		this.valServico = valServico;
	}
	public String getValDesconto() {
		return valDesconto;
	}
	public void setValDesconto(String valDesconto) throws Exception {
		valDesconto = MontaCamposArquivosPosicionais.preencherCampo(valDesconto, ItemNFSD_Mastersaf_Enum.VAL_DESCONTO.getTamanho(), ItemNFSD_Mastersaf_Enum.VAL_DESCONTO.getPosicoesAEsquerda());
		this.valDesconto = valDesconto;
	}
	public String getValAliqISS() {
		return valAliqISS;
	}
	public void setValAliqISS(String valAliqISS) throws Exception {
		valAliqISS = MontaCamposArquivosPosicionais.preencherCampo(valAliqISS, ItemNFSD_Mastersaf_Enum.VAL_ALIQ_ISS.getTamanho(), ItemNFSD_Mastersaf_Enum.VAL_ALIQ_ISS.getPosicoesAEsquerda());
		this.valAliqISS = valAliqISS;
	}
	public String getValBaseCalculoISS() {
		return valBaseCalculoISS;
	}
	public void setValBaseCalculoISS(String valBaseCalculoISS) throws Exception {
		valBaseCalculoISS = MontaCamposArquivosPosicionais.preencherCampo(valBaseCalculoISS, ItemNFSD_Mastersaf_Enum.VAL_BASE_CALCULO_ISS.getTamanho(), ItemNFSD_Mastersaf_Enum.VAL_BASE_CALCULO_ISS.getPosicoesAEsquerda());
		this.valBaseCalculoISS = valBaseCalculoISS;
	}
	public String getValISS() {
		return valISS;
	}
	public void setValISS(String valISS) throws Exception {
		valISS = MontaCamposArquivosPosicionais.preencherCampo(valISS, ItemNFSD_Mastersaf_Enum.VAL_ISS.getTamanho(), ItemNFSD_Mastersaf_Enum.VAL_ISS.getPosicoesAEsquerda());
		this.valISS = valISS;
	}
	public String getValTotalDocumento() {
		return valTotalDocumento;
	}
	public void setValTotalDocumento(String valTotalDocumento) throws Exception {
		valTotalDocumento = MontaCamposArquivosPosicionais.preencherCampo(valTotalDocumento, ItemNFSD_Mastersaf_Enum.VAL_TOTAL_DOCUMENTO.getTamanho(), ItemNFSD_Mastersaf_Enum.VAL_TOTAL_DOCUMENTO.getPosicoesAEsquerda());
		this.valTotalDocumento = valTotalDocumento;
	}
	public String getCodFiscalServico() {
		return codFiscalServico;
	}
	public void setCodFiscalServico(String codFiscalServico) throws Exception {
		codFiscalServico = MontaCamposArquivosPosicionais.preencherCampo(codFiscalServico, ItemNFSD_Mastersaf_Enum.COD_FISCAL_SERVICO.getTamanho(), ItemNFSD_Mastersaf_Enum.COD_FISCAL_SERVICO.getPosicoesAEsquerda());
		this.codFiscalServico = codFiscalServico;
	}
	public String getValMaterialAplicado() {
		return valMaterialAplicado;
	}
	public void setValMaterialAplicado(String valMaterialAplicado) throws Exception {
		valMaterialAplicado = MontaCamposArquivosPosicionais.preencherCampo(valMaterialAplicado, ItemNFSD_Mastersaf_Enum.VAL_MATERIAL_APLICADO.getTamanho(), ItemNFSD_Mastersaf_Enum.VAL_MATERIAL_APLICADO.getPosicoesAEsquerda());
		this.valMaterialAplicado = valMaterialAplicado;
	}
	public String getValSubEmpreitada() {
		return valSubEmpreitada;
	}
	public void setValSubEmpreitada(String valSubEmpreitada) throws Exception {
		valSubEmpreitada = MontaCamposArquivosPosicionais.preencherCampo(valSubEmpreitada, ItemNFSD_Mastersaf_Enum.VAL_SUBEMPREITADA.getTamanho(), ItemNFSD_Mastersaf_Enum.VAL_SUBEMPREITADA.getPosicoesAEsquerda());
		this.valSubEmpreitada = valSubEmpreitada;
	}
	public String getIndTipoLocalidade() {
		return indTipoLocalidade;
	}
	public void setIndTipoLocalidade(String indTipoLocalidade) throws Exception {
		indTipoLocalidade = MontaCamposArquivosPosicionais.preencherCampo(indTipoLocalidade, ItemNFSD_Mastersaf_Enum.IND_TIPO_LOCALIDADE.getTamanho(), ItemNFSD_Mastersaf_Enum.IND_TIPO_LOCALIDADE.getPosicoesAEsquerda());
		this.indTipoLocalidade = indTipoLocalidade;
	}
	public String getNomLocalidade() {
		return nomLocalidade;
	}
	public void setNomLocalidade(String nomLocalidade) throws Exception {
		nomLocalidade = MontaCamposArquivosPosicionais.preencherCampo(nomLocalidade, ItemNFSD_Mastersaf_Enum.NOM_LOCALIDADE.getTamanho(), ItemNFSD_Mastersaf_Enum.NOM_LOCALIDADE.getPosicoesAEsquerda());
		this.nomLocalidade = nomLocalidade;
	}
	public String getIndTipoDoctoMunicipio() {
		return indTipoDoctoMunicipio;
	}
	public void setIndTipoDoctoMunicipio(String indTipoDoctoMunicipio) throws Exception {
		indTipoDoctoMunicipio = MontaCamposArquivosPosicionais.preencherCampo(indTipoDoctoMunicipio, ItemNFSD_Mastersaf_Enum.IND_TIPO_DOCTO_MUNICIPIO.getTamanho(), ItemNFSD_Mastersaf_Enum.IND_TIPO_DOCTO_MUNICIPIO.getPosicoesAEsquerda());
		this.indTipoDoctoMunicipio = indTipoDoctoMunicipio;
	}
	public String getNumContaContabil() {
		return numContaContabil;
	}
	public void setNumContaContabil(String numContaContabil) throws Exception {
		numContaContabil = MontaCamposArquivosPosicionais.preencherCampo(numContaContabil, ItemNFSD_Mastersaf_Enum.NUM_CONTA_CONTABIL.getTamanho(), ItemNFSD_Mastersaf_Enum.NUM_CONTA_CONTABIL.getPosicoesAEsquerda());
		this.numContaContabil = numContaContabil;
	}
	public String getCodCentroCustos() {
		return codCentroCustos;
	}
	public void setCodCentroCustos(String codCentroCustos) throws Exception {
		codCentroCustos = MontaCamposArquivosPosicionais.preencherCampo(codCentroCustos, ItemNFSD_Mastersaf_Enum.COD_CENTRO_CUSTOS.getTamanho(), ItemNFSD_Mastersaf_Enum.COD_CENTRO_CUSTOS.getPosicoesAEsquerda());
		this.codCentroCustos = codCentroCustos;
	}
	public String getDscOpenFlex_01() {
		return dscOpenFlex_01;
	}
	public void setDscOpenFlex_01(String dscOpenFlex_01) throws Exception {
		dscOpenFlex_01 = MontaCamposArquivosPosicionais.preencherCampo(dscOpenFlex_01, ItemNFSD_Mastersaf_Enum.DSC_OPENFLEX_01.getTamanho(), ItemNFSD_Mastersaf_Enum.DSC_OPENFLEX_01.getPosicoesAEsquerda());
		this.dscOpenFlex_01 = dscOpenFlex_01;
	}
	public String getDscOpenFlex_02() {
		return dscOpenFlex_02;
	}
	public void setDscOpenFlex_02(String dscOpenFlex_02) throws Exception {
		dscOpenFlex_02 = MontaCamposArquivosPosicionais.preencherCampo(dscOpenFlex_02, ItemNFSD_Mastersaf_Enum.DSC_OPENFLEX_02.getTamanho(), ItemNFSD_Mastersaf_Enum.DSC_OPENFLEX_02.getPosicoesAEsquerda());
		this.dscOpenFlex_02 = dscOpenFlex_02;
	}
	public String getDscOpenFlex_03() {
		return dscOpenFlex_03;
	}
	public void setDscOpenFlex_03(String dscOpenFlex_03) throws Exception {
		dscOpenFlex_03 = MontaCamposArquivosPosicionais.preencherCampo(dscOpenFlex_03, ItemNFSD_Mastersaf_Enum.DSC_OPENFLEX_03.getTamanho(), ItemNFSD_Mastersaf_Enum.DSC_OPENFLEX_03.getPosicoesAEsquerda());
		this.dscOpenFlex_03 = dscOpenFlex_03;
	}
	public String getDscOpenFlex_04() {
		return dscOpenFlex_04;
	}
	public void setDscOpenFlex_04(String dscOpenFlex_04) throws Exception {
		dscOpenFlex_04 = MontaCamposArquivosPosicionais.preencherCampo(dscOpenFlex_04, ItemNFSD_Mastersaf_Enum.DSC_OPENFLEX_04.getTamanho(), ItemNFSD_Mastersaf_Enum.DSC_OPENFLEX_04.getPosicoesAEsquerda());
		this.dscOpenFlex_04 = dscOpenFlex_04;
	}
	public String getDscOpenFlex_05() {
		return dscOpenFlex_05;
	}
	public void setDscOpenFlex_05(String dscOpenFlex_05) throws Exception {
		dscOpenFlex_05 = MontaCamposArquivosPosicionais.preencherCampo(dscOpenFlex_05, ItemNFSD_Mastersaf_Enum.DSC_OPENFLEX_05.getTamanho(), ItemNFSD_Mastersaf_Enum.DSC_OPENFLEX_05.getPosicoesAEsquerda());
		this.dscOpenFlex_05 = dscOpenFlex_05;
	}
	public String getDscOpenFlex_06() {	
		return dscOpenFlex_06;
	}
	public void setDscOpenFlex_06(String dscOpenFlex_06) throws Exception {
		dscOpenFlex_06 = MontaCamposArquivosPosicionais.preencherCampo(dscOpenFlex_06, ItemNFSD_Mastersaf_Enum.DSC_OPENFLEX_06.getTamanho(), ItemNFSD_Mastersaf_Enum.DSC_OPENFLEX_06.getPosicoesAEsquerda());
		this.dscOpenFlex_06 = dscOpenFlex_06;
	}
	public String getDscOpenFlex_07() {
		return dscOpenFlex_07;
	}
	public void setDscOpenFlex_07(String dscOpenFlex_07) throws Exception {
		dscOpenFlex_07 = MontaCamposArquivosPosicionais.preencherCampo(dscOpenFlex_07, ItemNFSD_Mastersaf_Enum.DSC_OPENFLEX_07.getTamanho(), ItemNFSD_Mastersaf_Enum.DSC_OPENFLEX_07.getPosicoesAEsquerda());
		this.dscOpenFlex_07 = dscOpenFlex_07;
	}
	public String getDscOpenFlex_08() {
		return dscOpenFlex_08;
	}
	public void setDscOpenFlex_08(String dscOpenFlex_08) throws Exception {
		dscOpenFlex_08 = MontaCamposArquivosPosicionais.preencherCampo(dscOpenFlex_08, ItemNFSD_Mastersaf_Enum.DSC_OPENFLEX_08.getTamanho(), ItemNFSD_Mastersaf_Enum.DSC_OPENFLEX_08.getPosicoesAEsquerda());
		this.dscOpenFlex_08 = dscOpenFlex_08;
	}
	
	@Override
	public String toString() {
		return  this.codEmpresa + this.codFilial + this.numSerieNotaFiscal + this.numNotaFiscal + this.dtaEmissao +				
				this.codCategoriaPF_PJ + this.numItem + this.codPF_PJ + this.indTiposDocumento + this.codParaServico + this.dscComplementar + this.valServico +		
				this.valDesconto +  this.valAliqISS + this.valBaseCalculoISS + this.valISS + this.valTotalDocumento + this.codFiscalServico + this.valMaterialAplicado +		
				this.valSubEmpreitada + this.indTipoLocalidade + this.nomLocalidade + this.indTipoDoctoMunicipio + this.numContaContabil + this.codCentroCustos +			
				this.dscOpenFlex_01 + this.dscOpenFlex_02 + this.dscOpenFlex_03 + this.dscOpenFlex_04 + this.dscOpenFlex_05 + this.dscOpenFlex_06 + this.dscOpenFlex_07 +         
				this.dscOpenFlex_08;    
	}
	

}
