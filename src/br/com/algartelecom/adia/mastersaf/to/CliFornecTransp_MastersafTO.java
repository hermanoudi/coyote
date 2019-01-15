package br.com.algartelecom.adia.mastersaf.to;

import br.com.algartelecom.adia.Enum.CliFornecTransp_Mastersaf_Enum;
import br.com.algartelecom.adia.util.MontaCamposArquivosPosicionais;

public class CliFornecTransp_MastersafTO {

	  private String dataAtualizacao;       //DTA_ATUALIZACAO(8),
	  private String codCategoria;       //COD_CATEGORIA_PF_PJ(2),
	  private String codPFPJ;       //COD_PF_PJ(16),
	  private String numCnpjCPF;       //NUM_CNPJ_CPF(16),
	  private String indPessoa;       //IND_PESSOA(1),
	  private String numInscricaoEstadual;       //NUM_INSCRICAO_ESTADUAL(14),
	  private String numInscricaoMunicipal;       //NUM_INSCRICAO_MUNICIPAL(14),
	  private String nomRazaoSocial;       //NOM_RAZAO_SOCIAL (70),
	  private String nomFantasia;       //NOM_FANTASIA (70),
	  private String dscEndereco;       //DSC_ENDERECO (70),
	  private String numEnderecoLegal;       //NUM_END_LEGAL (12),
	  private String dscComplementoEndereco;       //DSC_COMPLEMENTO_ENDERECO (45),
	  private String nomBairro;       //NOM_BAIRRO (20),
	  private String nomMunicipio;       //NOM_MUNICIPIO (50),
	  private String siglaUF;       //SGL_UF (2),
	  private String numCep;       //NUM_CEP (8),
	  private String indEquiparProdRural;       //IND_EQUIPAR_PROD_RURAL (1),
	  private String codPaisOrigemPFPJ;       //COD_PAIS_ORIGEM_PF_PJ (3),
	  private String numInscricaoSuframa;       //NUM_INSCRICAO_SUFRAMA (14),
	  private String indTipoLocalidade;       //IND_TIPO_LOCALIDADE (2),
	  private String codMunicipioIBGE;       //COD_MUNICIPIO_IBGE (7),
	  private String descOpenFlex01;       //DSC_OPENFLEX_01 (12),
	  private String descOpenFlex02;       //DSC_OPENFLEX_02 (11),
	  private String descOpenFlex03;       //DSC_OPENFLEX_03 (15),
	  private String descOpenFlex04;       //DSC_OPENFLEX_04 (150),
	  private String descOpenFlex05;       //DSC_OPENFLEX_05 (150),
	  private String descOpenFlex06;       //DSC_OPENFLEX_06 (17),
	  private String descOpenFlex07;       //DSC_OPENFLEX_07 (17),
	  private String descOpenFlex08;       //DSC_OPENFLEX_08 (17);
	    
	public String getDataAtualizacao() {
		return dataAtualizacao;
	}
	public void setDataAtualizacao(String dataAtualizacao) throws Exception {
		dataAtualizacao = MontaCamposArquivosPosicionais.preencherCampo(dataAtualizacao, CliFornecTransp_Mastersaf_Enum.DTA_ATUALIZACAO.getTamanho(), false);
		this.dataAtualizacao = dataAtualizacao;
	}
	public String getCodCategoria() {
		return codCategoria;
	}
	public void setCodCategoria(String codCategoria) throws Exception {
		codCategoria = MontaCamposArquivosPosicionais.preencherCampo(codCategoria, CliFornecTransp_Mastersaf_Enum.COD_CATEGORIA_PF_PJ.getTamanho(), false);
		this.codCategoria = codCategoria;
	}
	public String getCodPFPJ() {
		return codPFPJ;
	}
	public void setCodPFPJ(String codPFPJ) throws Exception {
		codPFPJ = MontaCamposArquivosPosicionais.preencherCampo(codPFPJ, CliFornecTransp_Mastersaf_Enum.COD_PF_PJ.getTamanho(), false);
		this.codPFPJ = codPFPJ;
	}
	public String getNumCnpjCPF() {
		return numCnpjCPF;
	}
	public void setNumCnpjCPF(String numCnpjCPF) throws Exception {
		numCnpjCPF = MontaCamposArquivosPosicionais.preencherCampo(numCnpjCPF, CliFornecTransp_Mastersaf_Enum.NUM_CNPJ_CPF.getTamanho(), false);
		this.numCnpjCPF = numCnpjCPF;
	}
	public String getIndPessoa() {
		return indPessoa;
	}
	public void setIndPessoa(String indPessoa) throws Exception {
		indPessoa = MontaCamposArquivosPosicionais.preencherCampo(indPessoa, CliFornecTransp_Mastersaf_Enum.IND_PESSOA.getTamanho(), false);
		this.indPessoa = indPessoa;
	}
	public String getNumInscricaoEstadual() {
		return numInscricaoEstadual;
	}
	public void setNumInscricaoEstadual(String numInscricaoEstadual) throws Exception {
		numInscricaoEstadual = MontaCamposArquivosPosicionais.preencherCampo(numInscricaoEstadual, CliFornecTransp_Mastersaf_Enum.NUM_INSCRICAO_ESTADUAL.getTamanho(), false);
		this.numInscricaoEstadual = numInscricaoEstadual;
	}
	public String getNumInscricaoMunicipal() {
		return numInscricaoMunicipal;
	}
	public void setNumInscricaoMunicipal(String numInscricaoMunicipal) throws Exception {
		numInscricaoMunicipal = MontaCamposArquivosPosicionais.preencherCampo(numInscricaoMunicipal, CliFornecTransp_Mastersaf_Enum.NUM_INSCRICAO_MUNICIPAL.getTamanho(), false);
		this.numInscricaoMunicipal = numInscricaoMunicipal;
	}
	public String getNomRazaoSocial() {
		return nomRazaoSocial;
	}
	public void setNomRazaoSocial(String nomRazaoSocial) throws Exception {
		nomRazaoSocial = MontaCamposArquivosPosicionais.preencherCampo(nomRazaoSocial, CliFornecTransp_Mastersaf_Enum.NOM_RAZAO_SOCIAL.getTamanho(), false);
		this.nomRazaoSocial = nomRazaoSocial;
	}
	public String getNomFantasia() {
		return nomFantasia;
	}
	public void setNomFantasia(String nomFantasia) throws Exception {
		nomFantasia = MontaCamposArquivosPosicionais.preencherCampo(nomFantasia, CliFornecTransp_Mastersaf_Enum.NOM_FANTASIA.getTamanho(), false);
		this.nomFantasia = nomFantasia;
	}
	public String getDscEndereco() {
		return dscEndereco;
	}
	public void setDscEndereco(String dscEndereco) throws Exception {
		dscEndereco = MontaCamposArquivosPosicionais.preencherCampo(dscEndereco, CliFornecTransp_Mastersaf_Enum.DSC_ENDERECO.getTamanho(), false);
		this.dscEndereco = dscEndereco;
	}
	public String getNumEnderecoLegal() {
		return numEnderecoLegal;
	}
	public void setNumEnderecoLegal(String numEnderecoLegal) throws Exception {
		numEnderecoLegal = MontaCamposArquivosPosicionais.preencherCampo(numEnderecoLegal, CliFornecTransp_Mastersaf_Enum.NUM_END_LEGAL.getTamanho(), false);
		this.numEnderecoLegal = numEnderecoLegal;
	}
	public String getDscComplementoEndereco() {
		return dscComplementoEndereco;
	}
	public void setDscComplementoEndereco(String dscComplementoEndereco) throws Exception {
		dscComplementoEndereco = MontaCamposArquivosPosicionais.preencherCampo(dscComplementoEndereco, CliFornecTransp_Mastersaf_Enum.DSC_COMPLEMENTO_ENDERECO.getTamanho(), false);
		this.dscComplementoEndereco = dscComplementoEndereco;
	}
	public String getNomBairro() {
		return nomBairro;
	}
	public void setNomBairro(String nomBairro) throws Exception {
		nomBairro = MontaCamposArquivosPosicionais.preencherCampo(nomBairro, CliFornecTransp_Mastersaf_Enum.NOM_BAIRRO.getTamanho(), false);
		this.nomBairro = nomBairro;
	}
	public String getNomMunicipio() {
		return nomMunicipio;
	}
	public void setNomMunicipio(String nomMunicipio) throws Exception {
		nomMunicipio = MontaCamposArquivosPosicionais.preencherCampo(nomMunicipio, CliFornecTransp_Mastersaf_Enum.NOM_MUNICIPIO.getTamanho(), false);
		this.nomMunicipio = nomMunicipio;
	}
	public String getSiglaUF() {
		return siglaUF;
	}
	public void setSiglaUF(String siglaUF) throws Exception {
		siglaUF = MontaCamposArquivosPosicionais.preencherCampo(siglaUF, CliFornecTransp_Mastersaf_Enum.SGL_UF.getTamanho(), false);
		this.siglaUF = siglaUF;
	}
	public String getNumCep() {
		return numCep;
	}
	public void setNumCep(String numCep) throws Exception {
		//TODO: verificar porque esta cortando o cep e o mesmo esta indo desformatado
		numCep = MontaCamposArquivosPosicionais.preencherCampo(numCep, CliFornecTransp_Mastersaf_Enum.NUM_CEP.getTamanho(), false);
		this.numCep = numCep;
	}
	public String getIndEquiparProdRural() {
		return indEquiparProdRural;
	}
	public void setIndEquiparProdRural(String indEquiparProdRural) throws Exception {
		indEquiparProdRural = MontaCamposArquivosPosicionais.preencherCampo(indEquiparProdRural, CliFornecTransp_Mastersaf_Enum.IND_EQUIPAR_PROD_RURAL.getTamanho(), false);
		this.indEquiparProdRural = indEquiparProdRural;
	}
	public String getCodPaisOrigemPFPJ() {
		return codPaisOrigemPFPJ;
	}
	public void setCodPaisOrigemPFPJ(String codPaisOrigemPFPJ) throws Exception {
		codPaisOrigemPFPJ = MontaCamposArquivosPosicionais.preencherCampo(codPaisOrigemPFPJ, CliFornecTransp_Mastersaf_Enum.COD_PAIS_ORIGEM_PF_PJ.getTamanho(), false);
		this.codPaisOrigemPFPJ = codPaisOrigemPFPJ;
	}
	public String getNumInscricaoSuframa() {
		return numInscricaoSuframa;
	}
	public void setNumInscricaoSuframa(String numInscricaoSuframa) throws Exception {
		numInscricaoSuframa = MontaCamposArquivosPosicionais.preencherCampo(numInscricaoSuframa, CliFornecTransp_Mastersaf_Enum.NUM_INSCRICAO_SUFRAMA.getTamanho(), false);
		this.numInscricaoSuframa = numInscricaoSuframa;
	}
	public String getIndTipoLocalidade() {
		return indTipoLocalidade;
	}
	public void setIndTipoLocalidade(String indTipoLocalidade) throws Exception {
		indTipoLocalidade = MontaCamposArquivosPosicionais.preencherCampo(indTipoLocalidade, CliFornecTransp_Mastersaf_Enum.IND_TIPO_LOCALIDADE.getTamanho(), false);
		this.indTipoLocalidade = indTipoLocalidade;
	}
	public String getCodMunicipioIBGE() {
		return codMunicipioIBGE;
	}
	public void setCodMunicipioIBGE(String codMunicipioIBGE) throws Exception {
		codMunicipioIBGE = MontaCamposArquivosPosicionais.preencherCampo(codMunicipioIBGE, CliFornecTransp_Mastersaf_Enum.COD_MUNICIPIO_IBGE.getTamanho(), false);
		this.codMunicipioIBGE = codMunicipioIBGE;
	}
	public String getDescOpenFlex01() {
		return descOpenFlex01;
	}
	public void setDescOpenFlex01(String descOpenFlex01) throws Exception {
		descOpenFlex01 = MontaCamposArquivosPosicionais.preencherCampo(descOpenFlex01, CliFornecTransp_Mastersaf_Enum.DSC_OPENFLEX_01.getTamanho(), false);
		this.descOpenFlex01 = descOpenFlex01;
	}
	public String getDescOpenFlex02() {
		return descOpenFlex02;
	}
	public void setDescOpenFlex02(String descOpenFlex02) throws Exception {
		descOpenFlex02 = MontaCamposArquivosPosicionais.preencherCampo(descOpenFlex02, CliFornecTransp_Mastersaf_Enum.DSC_OPENFLEX_02.getTamanho(), false);
		this.descOpenFlex02 = descOpenFlex02;
	}
	public String getDescOpenFlex03() {
		return descOpenFlex03;
	}
	public void setDescOpenFlex03(String descOpenFlex03) throws Exception {
		descOpenFlex03 = MontaCamposArquivosPosicionais.preencherCampo(descOpenFlex03, CliFornecTransp_Mastersaf_Enum.DSC_OPENFLEX_03.getTamanho(), false);
		this.descOpenFlex03 = descOpenFlex03;
	}
	public String getDescOpenFlex04() {
		return descOpenFlex04;
	}
	public void setDescOpenFlex04(String descOpenFlex04) throws Exception {
		descOpenFlex04 = MontaCamposArquivosPosicionais.preencherCampo(descOpenFlex04, CliFornecTransp_Mastersaf_Enum.DSC_OPENFLEX_04.getTamanho(), false);
		this.descOpenFlex04 = descOpenFlex04;
	}
	public String getDescOpenFlex05() {
		return descOpenFlex05;
	}
	public void setDescOpenFlex05(String descOpenFlex05) throws Exception {
		descOpenFlex05 = MontaCamposArquivosPosicionais.preencherCampo(descOpenFlex05, CliFornecTransp_Mastersaf_Enum.DSC_OPENFLEX_05.getTamanho(), false);
		this.descOpenFlex05 = descOpenFlex05;
	}
	public String getDescOpenFlex06() {
		return descOpenFlex06;
	}
	public void setDescOpenFlex06(String descOpenFlex06) throws Exception {
		descOpenFlex06 = MontaCamposArquivosPosicionais.preencherCampo(descOpenFlex06, CliFornecTransp_Mastersaf_Enum.DSC_OPENFLEX_06.getTamanho(), false);
		this.descOpenFlex06 = descOpenFlex06;
	}
	public String getDescOpenFlex07() {
		return descOpenFlex07;
	}
	public void setDescOpenFlex07(String descOpenFlex07) throws Exception {
		descOpenFlex07 = MontaCamposArquivosPosicionais.preencherCampo(descOpenFlex07, CliFornecTransp_Mastersaf_Enum.DSC_OPENFLEX_07.getTamanho(), false);
		this.descOpenFlex07 = descOpenFlex07;
	}
	public String getDescOpenFlex08() {
		return descOpenFlex08;
	}
	public void setDescOpenFlex08(String descOpenFlex08) throws Exception {
		descOpenFlex08 = MontaCamposArquivosPosicionais.preencherCampo(descOpenFlex08, CliFornecTransp_Mastersaf_Enum.DSC_OPENFLEX_08.getTamanho(), false);
		this.descOpenFlex08 = descOpenFlex08;
	}
	@Override
	public String toString() {
		return this.dataAtualizacao + this.codCategoria + this.codPFPJ + this.numCnpjCPF + this.indPessoa + this.numInscricaoEstadual +
			   this.numInscricaoMunicipal + this.nomRazaoSocial + this.nomFantasia + this.dscEndereco + this.numEnderecoLegal +
			   this.dscComplementoEndereco + this.nomBairro + this.nomMunicipio + this.siglaUF + this.numCep + this.indEquiparProdRural +
			   this.codPaisOrigemPFPJ + this.numInscricaoSuframa + this.indTipoLocalidade + this.codMunicipioIBGE + this.descOpenFlex01 +
			   this.descOpenFlex02 + this.descOpenFlex03 + this.descOpenFlex04 + this.descOpenFlex05 + this.descOpenFlex06 + this.descOpenFlex07 + this.descOpenFlex08;
	}
	  
	  


}