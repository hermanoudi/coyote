package br.com.algartelecom.adia.mastersaf.to;

import br.com.algartelecom.adia.Enum.Servico_Mastersaf_Enum;
import br.com.algartelecom.adia.util.MontaCamposArquivosPosicionais;

public class Servico_MastersafTO {

	private String codServico; 	//	"COD_SERVICO"
	private String dataAtualizacao;//	"DTA_ATUALIZACAO"
	private String descricaoServico;//	"DSC_SERVICO"
	private String descricaoComplemento;//	"DSC_COMPLEMENTO"
	private String indTipoReceita;//	"IND_TIPO_RECEITA"
	private String indTipoServico;//	"IND_TIPO_SERVICO"
	private String codLc116_03;//	"COD_LC_116_03"
	private String descricaoOpenFlex_01;//	"DSC_OPENFLEX_01"
	private String descricaoOpenFlex_02;//	"DSC_OPENFLEX_02"
	private String descricaoOpenFlex_03;//	"DSC_OPENFLEX_03"
	private String descricaoOpenFlex_04;//	"DSC_OPENFLEX_04"
	private String descricaoOpenFlex_05;//	"DSC_OPENFLEX_05"
	private String descricaoOpenFlex_06;//	"DSC_OPENFLEX_06"
	private String descricaoOpenFlex_07;//	"DSC_OPENFLEX_07"
	private String descricaoOpenFlex_08;//	"DSC_OPENFLEX_08"
	
	public String getCodServico() {
		return codServico;
	}
	public void setCodServico(String codServico) throws Exception {
		codServico = MontaCamposArquivosPosicionais.preencherCampo(codServico, Servico_Mastersaf_Enum.COD_SERVICO.getTamanho(), false);
		this.codServico = codServico;
	}
	public String getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(String dataAtualizacao) throws Exception {
		dataAtualizacao = MontaCamposArquivosPosicionais.preencherCampo(dataAtualizacao, Servico_Mastersaf_Enum.DTA_ATUALIZACAO.getTamanho(), false);
		this.dataAtualizacao = dataAtualizacao;
	}
	public String getDescricaoServico() {
		return descricaoServico;
	}
	public void setDescricaoServico(String descricaoServico) throws Exception {
		descricaoServico = MontaCamposArquivosPosicionais.preencherCampo(descricaoServico, Servico_Mastersaf_Enum.DSC_SERVICO.getTamanho(), false);
		this.descricaoServico = descricaoServico;
	}
	public String getDescricaoComplemento() {
		return descricaoComplemento;
	}
	public void setDescricaoComplemento(String descricaoComplemento) throws Exception {
		descricaoComplemento = MontaCamposArquivosPosicionais.preencherCampo(descricaoComplemento, Servico_Mastersaf_Enum.DSC_COMPLEMENTO.getTamanho(), false);
		this.descricaoComplemento = descricaoComplemento;
	}
	public String getIndTipoReceita() {
		return indTipoReceita;
	}
	public void setIndTipoReceita(String indTipoReceita) throws Exception {
		indTipoReceita = MontaCamposArquivosPosicionais.preencherCampo(indTipoReceita, Servico_Mastersaf_Enum.IND_TIPO_RECEITA.getTamanho(), false);
		this.indTipoReceita = indTipoReceita;
	}
	public String getIndTipoServico() {
		return indTipoServico;
	}
	public void setIndTipoServico(String indTipoServico) throws Exception {
		indTipoServico = MontaCamposArquivosPosicionais.preencherCampo(indTipoServico, Servico_Mastersaf_Enum.IND_TIPO_SERVICO.getTamanho(), false);
		this.indTipoServico = indTipoServico;
	}
	public String getCodLc116_03() {
		return codLc116_03;
	}
	public void setCodLc116_03(String codLc116_03) throws Exception {
		codLc116_03 = MontaCamposArquivosPosicionais.preencherCampo(codLc116_03, Servico_Mastersaf_Enum.COD_LC_116_03.getTamanho(), false);
		this.codLc116_03 = codLc116_03;
	}
	public String getDescricaoOpenFlex_01() {
		return descricaoOpenFlex_01;
	}
	public void setDescricaoOpenFlex_01(String descricaoOpenFlex_01) throws Exception {
		descricaoOpenFlex_01 = MontaCamposArquivosPosicionais.preencherCampo(descricaoOpenFlex_01, Servico_Mastersaf_Enum.DSC_OPENFLEX_01.getTamanho(), false);
		this.descricaoOpenFlex_01 = descricaoOpenFlex_01;
	}
	public String getDescricaoOpenFlex_02() {
		return descricaoOpenFlex_02;
	}
	public void setDescricaoOpenFlex_02(String descricaoOpenFlex_02) throws Exception {
		descricaoOpenFlex_02 = MontaCamposArquivosPosicionais.preencherCampo(descricaoOpenFlex_02, Servico_Mastersaf_Enum.DSC_OPENFLEX_02.getTamanho(), false);
		this.descricaoOpenFlex_02 = descricaoOpenFlex_02;
	}
	public String getDescricaoOpenFlex_03() {
		return descricaoOpenFlex_03;
	}
	public void setDescricaoOpenFlex_03(String descricaoOpenFlex_03) throws Exception {
		descricaoOpenFlex_03 = MontaCamposArquivosPosicionais.preencherCampo(descricaoOpenFlex_03, Servico_Mastersaf_Enum.DSC_OPENFLEX_03.getTamanho(), false);
		this.descricaoOpenFlex_03 = descricaoOpenFlex_03;
	}
	public String getDescricaoOpenFlex_04() {
		return descricaoOpenFlex_04;
	}
	public void setDescricaoOpenFlex_04(String descricaoOpenFlex_04) throws Exception {
		descricaoOpenFlex_04 = MontaCamposArquivosPosicionais.preencherCampo(descricaoOpenFlex_04, Servico_Mastersaf_Enum.DSC_OPENFLEX_04.getTamanho(), false);
		this.descricaoOpenFlex_04 = descricaoOpenFlex_04;
	}
	public String getDescricaoOpenFlex_05() {
		return descricaoOpenFlex_05;
	}
	public void setDescricaoOpenFlex_05(String descricaoOpenFlex_05) throws Exception {
		descricaoOpenFlex_05 = MontaCamposArquivosPosicionais.preencherCampo(descricaoOpenFlex_05, Servico_Mastersaf_Enum.DSC_OPENFLEX_05.getTamanho(), false);
		this.descricaoOpenFlex_05 = descricaoOpenFlex_05;
	}
	public String getDescricaoOpenFlex_06() {
		return descricaoOpenFlex_06;
	}
	public void setDescricaoOpenFlex_06(String descricaoOpenFlex_06) throws Exception {
		descricaoOpenFlex_06 = MontaCamposArquivosPosicionais.preencherCampo(descricaoOpenFlex_06, Servico_Mastersaf_Enum.DSC_OPENFLEX_06.getTamanho(), false);
		this.descricaoOpenFlex_06 = descricaoOpenFlex_06;
	}
	public String getDescricaoOpenFlex_07() {
		return descricaoOpenFlex_07;
	}
	public void setDescricaoOpenFlex_07(String descricaoOpenFlex_07) throws Exception {
		descricaoOpenFlex_07 = MontaCamposArquivosPosicionais.preencherCampo(descricaoOpenFlex_07, Servico_Mastersaf_Enum.DSC_OPENFLEX_07.getTamanho(), false);
		this.descricaoOpenFlex_07 = descricaoOpenFlex_07;
	}
	public String getDescricaoOpenFlex_08() {
		return descricaoOpenFlex_08;
	}
	public void setDescricaoOpenFlex_08(String descricaoOpenFlex_08) throws Exception {
		descricaoOpenFlex_08 = MontaCamposArquivosPosicionais.preencherCampo(descricaoOpenFlex_08, Servico_Mastersaf_Enum.DSC_OPENFLEX_08.getTamanho(), false);
		this.descricaoOpenFlex_08 = descricaoOpenFlex_08;
	}

	@Override
	public String toString() {
		return this.codServico + this.dataAtualizacao + this.descricaoServico + this.descricaoComplemento + this.indTipoReceita + this.indTipoServico+
				this.codLc116_03 + this.descricaoOpenFlex_01 + this.descricaoOpenFlex_02 + this.descricaoOpenFlex_03 + this.descricaoOpenFlex_04 + this.descricaoOpenFlex_05 +
				this.descricaoOpenFlex_06 + this.descricaoOpenFlex_07 + this.descricaoOpenFlex_08;
	}
}