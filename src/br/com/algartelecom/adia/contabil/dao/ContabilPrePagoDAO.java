package br.com.algartelecom.adia.contabil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.conexao.Conexao;
import br.com.algartelecom.adia.contabil.to.FaturasPrePago;

public class ContabilPrePagoDAO {
	
	public List<FaturasPrePago> getFaturasPrePago(String primeiroDiaMesAnterior, String primeiroDiaMesAtual, String ultimoDiaMesAnteriorComHoras) {
		
		List<FaturasPrePago> faturasPrePago = new ArrayList<FaturasPrePago>();
		Connection conn = null;
		
		try{
			
			conn = Conexao.abreConexao();
			
			String query = " select sub.*, round(sub.val_consumo *  0.0165, 2) val_pis, round(sub.val_consumo * 0.076, 2) val_cofins " +
					"   from ( " +
					" select ID_CONTRATO_ODIN, data_ativacao, DATA_DESATIVACAO, VAL_MENSAL_ASSINATURA, o.cod_produto_contabil, p.cod_conta_contabil " +
					"      , str_to_date(date_format(if(DATA_ATIVACAO >= str_to_date(?,'%Y%m%d%H%i%s'), DATA_ATIVACAO, str_to_date(?,'%Y%m%d')), '%Y%m%d'), '%Y%m%d')  dta_inicio_periodo " +
					"      , str_to_date(date_format(if(DATA_DESATIVACAO >= str_to_date(?,'%Y%m%d%H%i%s'), str_to_date(?, '%Y%m%d'), DATA_DESATIVACAO), '%Y%m%d'), '%Y%m%d') dta_final_periodo " +
					"      , datediff( str_to_date(date_format(if(DATA_DESATIVACAO >= str_to_date(?,'%Y%m%d%H%i%s'), str_to_date(?, '%Y%m%d'), DATA_DESATIVACAO), '%Y%m%d'), '%Y%m%d') " +
					"                , str_to_date(date_format(if(DATA_ATIVACAO >= str_to_date(?,'%Y%m%d%H%i%s'), DATA_ATIVACAO, str_to_date(?,'%Y%m%d')), '%Y%m%d'), '%Y%m%d')) +1 qtd_dias " +
					"      , round(VAL_MENSAL_ASSINATURA/28, 2) val_diario " +
					"      , round((datediff( str_to_date(date_format(if(DATA_DESATIVACAO >= str_to_date(?,'%Y%m%d%H%i%s'), str_to_date(?, '%Y%m%d'), DATA_DESATIVACAO), '%Y%m%d'), '%Y%m%d') " +
					"                 , str_to_date(date_format(if(DATA_ATIVACAO >= str_to_date(?,'%Y%m%d%H%i%s'), DATA_ATIVACAO, str_to_date(?,'%Y%m%d')), '%Y%m%d'), '%Y%m%d')) +1) * (VAL_MENSAL_ASSINATURA/31), 2) val_consumo " +
					"      , ifnull(o.num_centro_resultado, '00') cod_centro_custos " +
					"   from adia_inventario i " +
					" inner join adia_cliente_odin c " +
					"     on i.id_cliente_odin = c.idcliente " +
					" inner join adia_produto_odin p " +
					"     on p.cod_plano_servico = i.cod_plano_servico " +
					" inner join (select distinct idt_cliente_odin, idt_contrato_odin, cod_plano_servico, num_documento_consultor, num_centro_resultado " +
					"                   , cod_sku_odin cod_produto_contabil " +
					"                from vw_dw_item_os_adia " +
					"              where nom_tipo_ordem = 'Sales Order') o " +
					" on o.idt_cliente_odin = i.ID_CLIENTE_ODIN " +
					"    and o.idt_contrato_odin = i.ID_CONTRATO_ODIN " +
					"    and o.cod_plano_servico = i.cod_plano_servico " +
					" where i.cod_plano_servico not in (991000342) " +
					"    and p.nom_tipo_planoservico = 'PRE-PAGO' " +
					"    and ((i.DATA_ATIVACAO < str_to_date(?, '%Y%m%d') " +
					"    and   (i.DATA_DESATIVACAO > str_to_date(?,'%Y%m%d') " +
					"     or    i.DATA_DESATIVACAO is null " +
					" or    i.DATA_DESATIVACAO = '')) " +
					"     or  (i.DATA_ATIVACAO > str_to_date(?, '%Y%m%d') " +
					"    and   i.DATA_ATIVACAO < str_to_date(?, '%Y%m%d') " +
					"    and   (i.DATA_DESATIVACAO is null " +
					" or    i.DATA_DESATIVACAO = '')))) sub";
			
			PreparedStatement stmt = conn.prepareStatement(query);
			 
			stmt.setString(1,primeiroDiaMesAnterior);
			stmt.setString(2,primeiroDiaMesAnterior);
			stmt.setString(3,primeiroDiaMesAtual);
			stmt.setString(4,ultimoDiaMesAnteriorComHoras);
			stmt.setString(5,primeiroDiaMesAtual);
			stmt.setString(6,ultimoDiaMesAnteriorComHoras);
			stmt.setString(7,primeiroDiaMesAnterior);
			stmt.setString(8,primeiroDiaMesAnterior);
			stmt.setString(9,primeiroDiaMesAtual);
			stmt.setString(10,ultimoDiaMesAnteriorComHoras);
			stmt.setString(11,primeiroDiaMesAnterior);
			stmt.setString(12,primeiroDiaMesAnterior);
			stmt.setString(13,primeiroDiaMesAtual);
			stmt.setString(14,primeiroDiaMesAnterior);
			stmt.setString(15,primeiroDiaMesAtual);
			stmt.setString(16,primeiroDiaMesAnterior);

			ResultSet resultSet = stmt.executeQuery();
			
			while (resultSet.next()) {
				
				FaturasPrePago prepago = new FaturasPrePago();
				prepago.setIdContratoOdin(resultSet.getInt("ID_CONTRATO_ODIN"));
				prepago.setCodProdutoContabil(resultSet.getString("cod_produto_contabil"));
				prepago.setCodContaContabil(resultSet.getString("cod_conta_contabil"));
				prepago.setDataInicioPeriodo(resultSet.getDate("dta_inicio_periodo"));
				prepago.setDataFinalPeriodo(resultSet.getDate("dta_final_periodo"));
				prepago.setValorConsumo(resultSet.getString("val_consumo"));
				prepago.setCodCentroCustos(resultSet.getString("cod_centro_custos"));
				prepago.setValorPIS(resultSet.getString("val_pis"));
				prepago.setValorCofins(resultSet.getString("val_cofins"));
				
				faturasPrePago.add(prepago);
			
			}

		
		return faturasPrePago;
			
			
		} catch(Exception e){
			e.printStackTrace();
			return null;
		} finally{
			Conexao.fechaConexao(conn);
		}
	
	}

}
