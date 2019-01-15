package br.com.algartelecom.adia.mastersaf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.conexao.Conexao;
import br.com.algartelecom.adia.mastersaf.to.Servico_MastersafTO;

import com.mysql.jdbc.Field;
import com.mysql.jdbc.Statement;

public class Servico_MastersafDAO {
	
	public List<Servico_MastersafTO> getServico(String mesAno) throws Exception{
		List<Servico_MastersafTO> servicosMastersaf = new ArrayList<Servico_MastersafTO>();
		
		Connection conn = null;
		try {
			conn = Conexao.abreConexao();

			
			String query = "select distinct concat('CD', p.cod_plano_servico) COD_SERVICO, " +
											" date_format(p.dta_criacao, '%d%m%Y') DTA_ATUALIZACAO, "+
											" fc_caracesp_converter(p.nom_plano_servico) DSC_SERVICO, "+
											" 'CLOUD 2.0' DSC_COMPLEMENTO, "+
											" 'P' IND_TIPO_RECEITA, "+
										    " 'S' IND_TIPO_SERVICO, "+
										    " ci.cod_item_servico COD_LC_116_03, "+
										    " 'CLOUD2.0' DSC_OPENFLEX_01, "+
										    " 'FATURAMENTO' DSC_OPENFLEX_02, "+
										    " date_format(sysdate(), '%d%m%Y%H%i%s') DSC_OPENFLEX_03, "+
										    " '' DSC_OPENFLEX_04, "+
										    " '' DSC_OPENFLEX_05, "+
										    " lpad('0', 17, '0') DSC_OPENFLEX_06, "+
										    " lpad('0', 17, '0') DSC_OPENFLEX_07, "+
																    " lpad('0', 17, '0') DSC_OPENFLEX_08 "+
						"  from adia_produto_odin p "+
						"     , vw_itemfatura_nfe o "+
						"     , (select distinct ci1.cod_atividade, concat('0', substr(cod_item_servico, 1, 1), '.', substr(cod_item_servico, 2)) cod_item_servico from adia_classificacao_impostos ci1) ci "+
						"where o.cod_atividade_item = ci.cod_atividade "+
						"   and o.cod_plano_servico = p.cod_plano_servico "+
						"   and o.cod_atividade_item is not null "+
						"   and o.cod_atividade_item <> '' "+
						"   and date_format(o.dta_criacao_item, '%m%Y') = ? "+ //passar parametro aqui!
						"";
									
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, mesAno );
			
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()){
				
				Servico_MastersafTO mastersafServico = new Servico_MastersafTO();
				mastersafServico.setCodServico(resultSet.getString("COD_SERVICO"));
				mastersafServico.setDataAtualizacao(resultSet.getString("DTA_ATUALIZACAO"));
				mastersafServico.setDescricaoServico(resultSet.getString("DSC_SERVICO"));
				mastersafServico.setDescricaoServico(resultSet.getString("DSC_SERVICO"));
				mastersafServico.setDescricaoComplemento(resultSet.getString("DSC_COMPLEMENTO"));
				mastersafServico.setIndTipoReceita(resultSet.getString("IND_TIPO_RECEITA"));
				mastersafServico.setIndTipoServico(resultSet.getString("IND_TIPO_SERVICO"));
				mastersafServico.setCodLc116_03(resultSet.getString("COD_LC_116_03"));
				mastersafServico.setDescricaoOpenFlex_01(resultSet.getString("DSC_OPENFLEX_01"));
				mastersafServico.setDescricaoOpenFlex_02(resultSet.getString("DSC_OPENFLEX_02"));
				mastersafServico.setDescricaoOpenFlex_03(resultSet.getString("DSC_OPENFLEX_03"));
				mastersafServico.setDescricaoOpenFlex_04(resultSet.getString("DSC_OPENFLEX_04"));
				mastersafServico.setDescricaoOpenFlex_05(resultSet.getString("DSC_OPENFLEX_05"));
				mastersafServico.setDescricaoOpenFlex_06(resultSet.getString("DSC_OPENFLEX_06"));
				mastersafServico.setDescricaoOpenFlex_07(resultSet.getString("DSC_OPENFLEX_07"));
				mastersafServico.setDescricaoOpenFlex_08(resultSet.getString("DSC_OPENFLEX_08"));
				
				servicosMastersaf.add(mastersafServico);
			}
			return servicosMastersaf;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally{
			Conexao.fechaConexao(conn);
		}
		
	}

}
