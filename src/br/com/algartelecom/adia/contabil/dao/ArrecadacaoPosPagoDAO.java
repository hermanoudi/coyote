package br.com.algartelecom.adia.contabil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.conexao.Conexao;
import br.com.algartelecom.adia.contabil.to.ArrecadacaoPosPago;

public class ArrecadacaoPosPagoDAO {
	
	public List<ArrecadacaoPosPago> getArrecadacaoPosPago(String primeiroDiaMesAnterior, String primeiroDiaMesAtual){
		
		Connection conn = null;
		
		try{
			conn = Conexao.abreConexao();
			
			String query = " select ife.DTA_PREVISTA_CREDITO, ife.COD_ITEMFATURA_ODIN, ife.COD_SKU_ODIN, ife.VAL_ITEM_FATURA, ife.COD_CONTA_CONTABIL, " +
							"   IFNULL(CASE WHEN ife.nom_vendedor IS NOT NULL AND ife.nom_vendedor <> '' AND c.segmentocliente = 'Corporativo'  " +
							" THEN (SELECT cr.num_centro_resultado  " +
							" FROM adia_cr_consultor_vantive cr  " +
							" WHERE cr.num_documento_consultor = ife.nom_vendedor LIMIT 1)  " +
							" WHEN ife.nom_vendedor IS NOT NULL AND ife.nom_vendedor <> '' AND c.segmentocliente <> 'Corporativo'  " +
							" THEN (SELECT crl.num_centro_resultado  " +
							" FROM adia_cr_localidade_cliente crl  " +
							" WHERE crl.nom_localidade = c.endereco_cidade  " +
							" AND crl.sgl_uf_localidade = c.endereco_estado LIMIT 1)  " +
							" WHEN ife.nom_vendedor IS NULL OR ife.nom_vendedor = ''  " +
							" THEN (SELECT crl.num_centro_resultado  " +
							" FROM adia_cr_localidade_cliente crl  " +
							" WHERE crl.nom_localidade = c.endereco_cidade  " +
							" AND crl.sgl_uf_localidade = c.endereco_estado LIMIT 1) " +
							" ELSE '00' " +
							" END, '00') cod_centro_custos " +
							"   from vw_itemfatura_nfe ife " +
							"   inner join adia_cliente_odin c " +
							"   on ife.idt_cliente_odin = c.idcliente " +
							"  where nom_modalidade_pagto = 'POS-PAGO'  " +//-- preencher conforme informação sendo tratada
							"   and dta_pagamento_item is not null " +
							"   and dta_pagamento_item <> '' " +
							"   and dta_prevista_credito >= str_to_date(?, '%Y%m%d')  " +//-- trocar o mes e o ano para o mes e o ano do período contabil
							"   and dta_prevista_credito < str_to_date(?, '%Y%m%d') ";
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1,primeiroDiaMesAnterior);					// = 2017032023595
			stmt.setString(2,primeiroDiaMesAtual);							 	// = 20170321

			
			ResultSet resultSet = stmt.executeQuery();
			
			List<ArrecadacaoPosPago> arrecadacoesPosPago = new ArrayList<ArrecadacaoPosPago>();

			while(resultSet.next()){
				ArrecadacaoPosPago arrecadacao = new ArrecadacaoPosPago();
				arrecadacao.setDataPrevistaCredito(resultSet.getDate("DTA_PREVISTA_CREDITO"));
				arrecadacao.setCodItemFaturaOdin(resultSet.getString("COD_ITEMFATURA_ODIN"));
				arrecadacao.setCodSkuOdin(resultSet.getString("COD_SKU_ODIN"));
				arrecadacao.setValorItemFatura(resultSet.getString("VAL_ITEM_FATURA"));
				arrecadacao.setCodCentroCustos(resultSet.getString("COD_CENTRO_CUSTOS"));
				
				arrecadacoesPosPago.add(arrecadacao);
			}
			
			return arrecadacoesPosPago;
			
		} catch(SQLException e){
			e.printStackTrace();
			return null;
		} finally{
			Conexao.fechaConexao(conn);
		}
		
		
	}

}
