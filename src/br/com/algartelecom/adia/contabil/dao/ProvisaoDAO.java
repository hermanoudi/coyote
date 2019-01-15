package br.com.algartelecom.adia.contabil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.conexao.Conexao;
import br.com.algartelecom.adia.contabil.to.ReversaoProvisao;

public class ProvisaoDAO {
	
	public List<ReversaoProvisao> getReversaoProvisao(String ultimaDataAntesFaturamento, String dataFaturamento, String ultimoDiaMesAnterior,
													  String primeiroDiaMesAtual, String dataCorteFaturamentoSemHoras, int qtdDiasMesAnterior){
		
		Connection conn = null;	
		
		try {
			conn = Conexao.abreConexao();
			String query = " select i.ID_CONTRATO_ODIN, i.DATA_DESATIVACAO, i.VAL_MENSAL_ASSINATURA, o.cod_produto_contabil, p.cod_conta_contabil " +
						"      , str_to_date(date_format(if(DATA_ATIVACAO > str_to_date(?,'%Y%m%d%H%i%s'), DATA_ATIVACAO, str_to_date(?,'%Y%m%d')), '%Y%m%d'), '%Y%m%d') dta_inicio_periodo " +
						"      , str_to_date(date_format(ifnull(DATA_DESATIVACAO, str_to_date(?, '%Y%m%d')), '%Y%m%d'), '%Y%m%d') dta_final_periodo " +
						"      , datediff( str_to_date(date_format(ifnull(DATA_DESATIVACAO, str_to_date(?, '%Y%m%d')), '%Y%m%d'), '%Y%m%d') " +
						"                , str_to_date(date_format(if(DATA_ATIVACAO > str_to_date(?,'%Y%m%d%H%i%s'), DATA_ATIVACAO, str_to_date(?,'%Y%m%d')), '%Y%m%d'), '%Y%m%d')) +1 qtd_dias " +
						"      , round(VAL_MENSAL_ASSINATURA/?, 2) val_diario " +
						"      , round((datediff( str_to_date(date_format(ifnull(DATA_DESATIVACAO, str_to_date(?, '%Y%m%d')), '%Y%m%d'), '%Y%m%d') " +
						"                       , str_to_date(date_format(if(DATA_ATIVACAO > str_to_date(?,'%Y%m%d%H%i%s'), DATA_ATIVACAO, str_to_date(?,'%Y%m%d')), '%Y%m%d'), '%Y%m%d')) +1) * (VAL_MENSAL_ASSINATURA/?), 2) val_provisao " +   //dividir pela quantidade de dias do mês sendo tratado  
						"      , ifnull(o.num_centro_resultado, '00') cod_centro_custos " +
						"   from adia_inventario i " +
						" inner join adia_cliente_odin c " +
						"     on i.id_cliente_odin = c.idcliente " +
						" inner join adia_produto_odin p " +
						"     on p.cod_plano_servico = i.cod_plano_servico " +
						" inner join (select distinct idt_cliente_odin, idt_contrato_odin, cod_plano_servico, num_documento_consultor, num_centro_resultado " +
						"                   , cod_sku_odin cod_produto_contabil " +
						"                from vw_dw_item_os_adia " +
						"               where nom_tipo_ordem = 'Sales Order') o " +
						" on o.idt_cliente_odin = i.ID_CLIENTE_ODIN " +
						"    and o.idt_contrato_odin = i.ID_CONTRATO_ODIN " +
						"    and o.cod_plano_servico = i.cod_plano_servico " +
						" where i.cod_plano_servico not in (186, 1000342) " +
						"    and p.nom_tipo_planoservico = 'POS-PAGO' " +
						"    and ((i.DATA_ATIVACAO < str_to_date(?, '%Y%m%d') " +
						"    and   (i.DATA_DESATIVACAO > str_to_date(?,'%Y%m%d') " +
						"     or    i.DATA_DESATIVACAO is null " +
						" or    i.DATA_DESATIVACAO = '')) " +
						"     or  (i.DATA_ATIVACAO > str_to_date(?, '%Y%m%d') " +
						"    and   i.DATA_ATIVACAO < str_to_date(?, '%Y%m%d') " +
						"    and   (i.DATA_DESATIVACAO is null " +
						" or    i.DATA_DESATIVACAO = ''))) ";
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1,ultimaDataAntesFaturamento);					// = 2017032023595
			stmt.setString(2,dataFaturamento);							 	// = 20170321
			stmt.setString(3,ultimoDiaMesAnterior);						 	// = 20170331235959
			stmt.setString(4,ultimoDiaMesAnterior);                          
			stmt.setString(5,ultimaDataAntesFaturamento);                    
			stmt.setString(6,dataFaturamento);                               
			stmt.setInt(7,qtdDiasMesAnterior);     
			
			stmt.setString(8,ultimoDiaMesAnterior);                          
			stmt.setString(9,ultimaDataAntesFaturamento);                    
			stmt.setString(10, dataFaturamento);        
			stmt.setInt(11,qtdDiasMesAnterior);  
			stmt.setString(12, primeiroDiaMesAtual);						// = 20170401
			stmt.setString(13, dataCorteFaturamentoSemHoras);			 	// = 20170320
			stmt.setString(14, dataCorteFaturamentoSemHoras);
			stmt.setString(15, primeiroDiaMesAtual);
			
			ResultSet resultSet = stmt.executeQuery();
			
			List<ReversaoProvisao> listaReversaoProvisao = new ArrayList<ReversaoProvisao>();
			while(resultSet.next()){
				ReversaoProvisao reversaoProvisao = new ReversaoProvisao();
				reversaoProvisao.setIdContratoOdin(resultSet.getString("ID_CONTRATO_ODIN"));
				reversaoProvisao.setCodProdutoContabil(resultSet.getString("cod_produto_contabil"));
				reversaoProvisao.setCodContaContabil(resultSet.getString("cod_conta_contabil"));
				reversaoProvisao.setDataFinalPeriodo(resultSet.getDate("dta_final_periodo"));
				reversaoProvisao.setValProvisao(resultSet.getString("val_provisao"));
				reversaoProvisao.setCodCentroCustos(resultSet.getString("cod_centro_custos"));
				
				listaReversaoProvisao.add(reversaoProvisao);
			}
			
			return listaReversaoProvisao;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally{
			Conexao.fechaConexao(conn);
		}
		
		
	}

}
