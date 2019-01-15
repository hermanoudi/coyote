package br.com.algartelecom.adia.contabil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.conexao.Conexao;
import br.com.algartelecom.adia.contabil.to.Tarifa;

public class TarifasDAO {

	public List<Tarifa>  getTarifas(String primeiroDiaMesAnterior, String primeiroDiaMesAtual, String modalidadePgto) {
		
		Connection conn = null;
		
		try{
			conn = Conexao.abreConexao();
			
			String query = " select ife.num_contrato, ife.dta_prevista_credito, ife.dta_pagamento_item, ife.cod_itemfatura_odin, ife.cod_sku_odin, ife.cod_conta_contabil, ife.nom_modalidade_pagto " +
								" , truncate(val_item_fatura * val_perc_taxa_adm, 2) val_tarifa_cartao, " +
								"   IFNULL(CASE WHEN ife.nom_vendedor IS NOT NULL AND ife.nom_vendedor <> '' AND c.segmentocliente = 'Corporativo' " +
								"   THEN (SELECT cr.num_centro_resultado " +
								"   FROM adia_cr_consultor_vantive cr " +
								"   WHERE cr.num_documento_consultor = ife.nom_vendedor LIMIT 1) " +
								"   WHEN ife.nom_vendedor IS NOT NULL AND ife.nom_vendedor <> '' AND c.segmentocliente <> 'Corporativo' " +
								"   THEN (SELECT crl.num_centro_resultado " +
								"   FROM adia_cr_localidade_cliente crl " +
								"   WHERE crl.nom_localidade = c.endereco_cidade " +
								"   AND crl.sgl_uf_localidade = c.endereco_estado LIMIT 1) " +
								"   WHEN ife.nom_vendedor IS NULL OR ife.nom_vendedor = '' " +
								"   THEN (SELECT crl.num_centro_resultado " +
								"   FROM adia_cr_localidade_cliente crl " +
								"   WHERE crl.nom_localidade = c.endereco_cidade " +
								"   AND crl.sgl_uf_localidade = c.endereco_estado LIMIT 1) " +
								"   ELSE '00' " +
								"   END, '00') cod_centro_custos " +
						"   from vw_itemfatura_nfe ife " +
						 "  inner join adia_cliente_odin c " +
						 	    "   on ife.idt_cliente_odin = c.idcliente " +
						"   left join adia_acordo_financeiro acf " +
						       "   on ife.nom_forma_pagto = acf.tipo " +
							  "   and ife.nom_bandeira_cartao = acf.regra " +
						"  where nom_forma_pagto = 'CARTÃO DE CRÉDITO' " + //preencher conforme informação sendo tratada
						"   and dta_pagamento_item is not null " +
						"   and dta_pagamento_item <> '' " +
						"   and dta_prevista_credito >= str_to_date(?, '%Y%m%d') " + //-- trocar o mes e o ano para o mes e o ano do período contabil
						"   and dta_prevista_credito < str_to_date(?, '%Y%m%d') "
						+ " and ife.nom_modalidade_pagto = ? ";
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, primeiroDiaMesAnterior);
			stmt.setString(2, primeiroDiaMesAtual);
			stmt.setString(3, modalidadePgto);
			
			ResultSet resultSet = stmt.executeQuery();
			
			List<Tarifa> tarifas = new ArrayList<Tarifa>();
			while(resultSet.next()){
				
				Tarifa tarifa = new Tarifa();
				tarifa.setDataPrevistaCredito(resultSet.getDate("dta_prevista_credito"));
				tarifa.setNumContrato(resultSet.getString("num_contrato"));
				tarifa.setDataPagamentoItem(resultSet.getDate("dta_pagamento_item"));
				tarifa.setCodItemFaturaOdin(resultSet.getString("cod_itemfatura_odin"));
				tarifa.setCodSKUOdin(resultSet.getString("cod_sku_odin"));
				tarifa.setCodContaContabil(resultSet.getString("cod_conta_contabil"));
				tarifa.setValTarifaCartao(resultSet.getString("val_tarifa_cartao"));
				tarifa.setCodCentroCusto(resultSet.getString("cod_centro_custos"));
				tarifa.setNomModalidadePagto(resultSet.getString("nom_modalidade_pagto"));
				
				tarifas.add(tarifa);
				
			}
			
			return tarifas;
			
		} catch (Exception e){
			e.printStackTrace();
			return null;
		} finally{
			Conexao.fechaConexao(conn);
		}
		
		
	}
	
	

}
