package br.com.algartelecom.adia.mastersaf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.Enum.TipoPessoa;
import br.com.algartelecom.adia.conexao.Conexao;
import br.com.algartelecom.adia.mastersaf.to.CliFornecTransp_MastersafTO;
import br.com.algartelecom.adia.mastersaf.to.Servico_MastersafTO;

import com.mysql.jdbc.Field;
import com.mysql.jdbc.Statement;

public class CliFornecTransp_MastersafDAO {
	
	public List<CliFornecTransp_MastersafTO> getCliFornecTransp(String mesAno) throws Exception{
		List<CliFornecTransp_MastersafTO> cliFornecTranspList = new ArrayList<CliFornecTransp_MastersafTO>();
		
		Connection conn = null;
		try {
			conn = Conexao.abreConexao();

			
			//TODO: Alterar a query para a nova enviada pela Ana.
			
			String query = " select distinct " + 
					"        date_format(c.data_atualizacao, '%d%m%Y') DTA_ATUALIZACAO, " +
					"        'CL' COD_CATEGORIA_PF_PJ,  " +
					"        concat('CD', lpad(c.IdCliente, 8, 0)) COD_PF_PJ,  " +
					"        IF (c.DocumentoCliente is null or c.DocumentoCliente = '', ' ', c.DocumentoCliente) NUM_CNPJ_CPF,  " +
					"        case when c.categoriadocliente = '" +  TipoPessoa.PESSOA_FISICA.getNome() +"' then 'F'  " +
					"             when c.categoriadocliente = '"+ TipoPessoa.PESSOA_JURIDICA.getNome() +"' then 'J' end IND_PESSOA,  " +
					"        IF( ra.num_inscricao_estadual IS NULL OR ra.num_inscricao_estadual = '', 'ISENTO', ra.num_inscricao_estadual) NUM_INSCRICAO_ESTADUAL,  " +
					"        'ISENTO' NUM_INSCRICAO_MUNICIPAL,  " +
					"        upper(fc_caracesp_converter( " +
					"             case when c.CategoriadoCliente = '" +  TipoPessoa.PESSOA_FISICA.getNome() +"' then c.NomeCliente  " +
					"                  when c.CategoriadoCliente = '"+ TipoPessoa.PESSOA_JURIDICA.getNome() +"' and ra.nom_cliente is null then c.NomeCliente  " +
					"                  when c.CategoriadoCliente = '"+ TipoPessoa.PESSOA_JURIDICA.getNome() +"' and ra.nom_cliente is not null then ra.nom_cliente " +
					"             end)) NOM_RAZAO_SOCIAL,  " +
					"         fc_caracesp_converter(UPPER(case c.CategoriadoCliente " +
					"                                          when '" +  TipoPessoa.PESSOA_FISICA.getNome() +"' then c.nomecliente " +
					"                                          when '"+ TipoPessoa.PESSOA_JURIDICA.getNome() +"' then case when ra.idt_retorno_audicon is null or ra.idt_retorno_audicon = '' then c.nomecliente " +
					"                                                                                                   else case when ra.nom_fantasia_cliente is null and (ra.nom_cliente is null or ra.nom_cliente = '') then c.nomecliente " +
					"                                                                                                                                              when ra.nom_fantasia_cliente = '' and (ra.nom_cliente is null or ra.nom_cliente = '') then c.nomecliente  " +
					"                                                                                     when ra.nom_fantasia_cliente = '********' and ra.nom_cliente is not null and ra.nom_cliente <> '' then ra.nom_cliente  " +
					"                                                                                     else ra.nom_fantasia_cliente " +
					"                                                                                end " +
					"                                                                           end " +
					"                                          end)) NOM_FANTASIA,  " +
					"         upper(fc_caracesp_converter( " +
					"             case when c.CategoriadoCliente = '" +  TipoPessoa.PESSOA_FISICA.getNome() +"' then c.endereco_logradouro  " +
					"                  when c.CategoriadoCliente = '"+ TipoPessoa.PESSOA_JURIDICA.getNome() +"' and ra.nom_logradouro_endereco is null then c.endereco_logradouro " +
					"                  when c.CategoriadoCliente = '"+ TipoPessoa.PESSOA_JURIDICA.getNome() +"' and ra.nom_logradouro_endereco is not null then ra.nom_logradouro_endereco " +
					"             end)) DSC_ENDERECO,  " +
					"         upper(fc_numeroender_tratar( " +
					"             case when c.CategoriadoCliente = '" +  TipoPessoa.PESSOA_FISICA.getNome() +"' then c.endereco_numero  " +
					"                  when c.CategoriadoCliente = '"+ TipoPessoa.PESSOA_JURIDICA.getNome() +"' and ra.nom_logradouro_endereco is null then c.endereco_numero " +
					"                  when c.CategoriadoCliente = '"+ TipoPessoa.PESSOA_JURIDICA.getNome() +"' and ra.nom_logradouro_endereco is not null then ra.num_endereco " +
					"             end)) NUM_END_LEGAL,  " +
					"         upper(ltrim(fc_caracesp_converter(fc_complemento_tratar( " +
					"             case when c.CategoriadoCliente = '" +  TipoPessoa.PESSOA_FISICA.getNome() +"' then c.endereco_numero  " +
					"                  when c.CategoriadoCliente = '"+ TipoPessoa.PESSOA_JURIDICA.getNome() +"' and ra.nom_logradouro_endereco is null then c.endereco_numero " +
					"                  when c.CategoriadoCliente = '"+ TipoPessoa.PESSOA_JURIDICA.getNome() +"' and ra.nom_logradouro_endereco is not null then ra.num_endereco " +
					"             end, " + // -- numero
					"             case when c.CategoriadoCliente = '" +  TipoPessoa.PESSOA_FISICA.getNome() +"' then c.endereco_complemento " +
					"                  when c.CategoriadoCliente = '"+ TipoPessoa.PESSOA_JURIDICA.getNome() +"' and ra.nom_logradouro_endereco is null then c.endereco_complemento " +
					"                  when c.CategoriadoCliente = '"+ TipoPessoa.PESSOA_JURIDICA.getNome() +"' and ra.nom_logradouro_endereco is not null then ra.dsc_complemento_endereco " +
					"             end)))) DSC_COMPLEMENTO_ENDERECO,  " +
					"         upper(fc_caracesp_converter( " +
					"             case when c.CategoriadoCliente = '" +  TipoPessoa.PESSOA_FISICA.getNome() +"' then c.endereco_bairro  " +
					"                  when c.CategoriadoCliente = '"+ TipoPessoa.PESSOA_JURIDICA.getNome() +"' and ra.nom_logradouro_endereco is null then c.endereco_bairro " +
					"                  when c.CategoriadoCliente = '"+ TipoPessoa.PESSOA_JURIDICA.getNome() +"' and ra.nom_logradouro_endereco is not null then ra.nom_bairro_endereco " +
					"             end)) NOM_BAIRRO,  " +
					"         upper(fc_caracesp_converter(m.nome_municipio)) NOM_MUNICIPIO,  " +
					"         upper(m.nome_uf) SGL_UF,  " +
					"         upper( " +
					"             case when c.CategoriadoCliente = '" +  TipoPessoa.PESSOA_FISICA.getNome() +"' then c.endereco_cep  " +
					"                  when c.CategoriadoCliente = '"+ TipoPessoa.PESSOA_JURIDICA.getNome() +"' and ra.nom_logradouro_endereco is null then c.endereco_cep " +
					"                  when c.CategoriadoCliente = '"+ TipoPessoa.PESSOA_JURIDICA.getNome() +"' and ra.nom_logradouro_endereco is not null then ra.num_cep_endereco " +
					"             end) NUM_CEP,  " +
					"         'N' IND_EQUIPAR_PROD_RURAL,  " +
					"         'BRA' COD_PAIS_ORIGEM_PF_PJ,  " +
					"         rpad(' ', 14, ' ') NUM_INSCRICAO_SUFRAMA,  " +
					"         '01' IND_TIPO_LOCALIDADE,  " +
					"         m.municipio COD_MUNICIPIO_IBGE,  " +
					"         'CLOUD2.0' DSC_OPENFLEX_01,  " +
					"         'FATURAMENTO' DSC_OPENFLEX_02,  " +
					"         date_format(sysdate(), '%d%m%Y%H%i%s') DSC_OPENFLEX_03,  " +
					"         rpad(' ', 150, ' ') DSC_OPENFLEX_04,  " +
					"         rpad(' ', 150, ' ') DSC_OPENFLEX_05,  " +
					"         lpad('0', 17, 0) DSC_OPENFLEX_06,  " +
					"         lpad('0', 17, 0) DSC_OPENFLEX_07,  " +
					"         lpad('0', 17, 0) DSC_OPENFLEX_08 " +
					"   from adia_cliente_odin c " +
					" inner join vw_itemfatura_nfe ife " +
					"     ON ife.idt_cliente_odin = c.idcliente " +
					"   left join (select * from adia_retorno_audicon where ind_status_execucao = 0) ra  " +
					"     ON ra.idt_cliente_odin = c.idCliente    " +
					"  inner join adia_municipios_ibge m  " +
					"     ON m.nome_municipio = upper(case when c.CategoriadoCliente = '" +  TipoPessoa.PESSOA_FISICA.getNome() +"' then c.endereco_cidade  " +
					"                                      when c.CategoriadoCliente = '"+ TipoPessoa.PESSOA_JURIDICA.getNome() +"' and ra.nom_logradouro_endereco is null or ra.nom_logradouro_endereco = '' then c.endereco_cidade " +
					"                                      when c.CategoriadoCliente = '"+ TipoPessoa.PESSOA_JURIDICA.getNome() +"' and ra.nom_logradouro_endereco is not null and ra.nom_logradouro_endereco <> '' then ra.nom_cidade_endereco " +
					"                                               end) " +
					"    and m.nome_uf = case when c.CategoriadoCliente = '" +  TipoPessoa.PESSOA_FISICA.getNome() +"' then c.endereco_estado  " +
					"                         when c.CategoriadoCliente = '"+ TipoPessoa.PESSOA_JURIDICA.getNome() +"' and ra.nom_logradouro_endereco is null or ra.nom_logradouro_endereco = '' then c.endereco_estado " +
					"                                      when c.CategoriadoCliente = '"+ TipoPessoa.PESSOA_JURIDICA.getNome() +"' and ra.nom_logradouro_endereco is not null and ra.nom_logradouro_endereco <> '' then ra.sgl_uf_endereco " +
					"                    end " +
					" where date_format(ife.dta_emissao_rps, '%m%Y') = ? "; 
									
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, mesAno);
			
			ResultSet resultSet = stmt.executeQuery();

			while (resultSet.next()){
				
				CliFornecTransp_MastersafTO cliFornecTransp_MastersafTO = new CliFornecTransp_MastersafTO();
				
				cliFornecTransp_MastersafTO.setDataAtualizacao(resultSet.getString("DTA_ATUALIZACAO"));
				cliFornecTransp_MastersafTO.setCodCategoria(resultSet.getString("COD_CATEGORIA_PF_PJ"));
				cliFornecTransp_MastersafTO.setCodPFPJ(resultSet.getString("COD_PF_PJ"));
				cliFornecTransp_MastersafTO.setNumCnpjCPF(resultSet.getString("NUM_CNPJ_CPF"));
				cliFornecTransp_MastersafTO.setIndPessoa(resultSet.getString("IND_PESSOA"));
				cliFornecTransp_MastersafTO.setNumInscricaoEstadual(resultSet.getString("NUM_INSCRICAO_ESTADUAL"));
				cliFornecTransp_MastersafTO.setNumInscricaoMunicipal(resultSet.getString("NUM_INSCRICAO_MUNICIPAL"));
				cliFornecTransp_MastersafTO.setNomRazaoSocial(resultSet.getString("NOM_RAZAO_SOCIAL"));
				cliFornecTransp_MastersafTO.setNomFantasia(resultSet.getString("NOM_FANTASIA"));
				cliFornecTransp_MastersafTO.setDscEndereco(resultSet.getString("DSC_ENDERECO"));
				cliFornecTransp_MastersafTO.setNumEnderecoLegal(resultSet.getString("NUM_END_LEGAL"));
				cliFornecTransp_MastersafTO.setDscComplementoEndereco(resultSet.getString("DSC_COMPLEMENTO_ENDERECO"));
				cliFornecTransp_MastersafTO.setNomBairro(resultSet.getString("NOM_BAIRRO"));
				cliFornecTransp_MastersafTO.setNomMunicipio(resultSet.getString("NOM_MUNICIPIO"));
				cliFornecTransp_MastersafTO.setSiglaUF(resultSet.getString("SGL_UF"));
				cliFornecTransp_MastersafTO.setNumCep(resultSet.getString("NUM_CEP"));
				cliFornecTransp_MastersafTO.setIndEquiparProdRural(resultSet.getString("IND_EQUIPAR_PROD_RURAL"));
				cliFornecTransp_MastersafTO.setCodPaisOrigemPFPJ(resultSet.getString("COD_PAIS_ORIGEM_PF_PJ"));
				cliFornecTransp_MastersafTO.setNumInscricaoSuframa(resultSet.getString("NUM_INSCRICAO_SUFRAMA"));
				cliFornecTransp_MastersafTO.setIndTipoLocalidade(resultSet.getString("IND_TIPO_LOCALIDADE"));
				cliFornecTransp_MastersafTO.setCodMunicipioIBGE(resultSet.getString("COD_MUNICIPIO_IBGE"));
				cliFornecTransp_MastersafTO.setDescOpenFlex01(resultSet.getString("DSC_OPENFLEX_01"));
				cliFornecTransp_MastersafTO.setDescOpenFlex02(resultSet.getString("DSC_OPENFLEX_02"));
				cliFornecTransp_MastersafTO.setDescOpenFlex03(resultSet.getString("DSC_OPENFLEX_03"));
				cliFornecTransp_MastersafTO.setDescOpenFlex04(resultSet.getString("DSC_OPENFLEX_04"));
				cliFornecTransp_MastersafTO.setDescOpenFlex05(resultSet.getString("DSC_OPENFLEX_05"));
				cliFornecTransp_MastersafTO.setDescOpenFlex06(resultSet.getString("DSC_OPENFLEX_06"));
				cliFornecTransp_MastersafTO.setDescOpenFlex07(resultSet.getString("DSC_OPENFLEX_07"));
				cliFornecTransp_MastersafTO.setDescOpenFlex08(resultSet.getString("DSC_OPENFLEX_08"));
				
				cliFornecTranspList.add(cliFornecTransp_MastersafTO);
			}
			return cliFornecTranspList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally{
			Conexao.fechaConexao(conn);
		}
		
	}

}
