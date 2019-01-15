package br.com.algartelecom.adia.gesplan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.conexao.Conexao;
import br.com.algartelecom.adia.fatura.to.FaturaADIA;

import com.mysql.jdbc.Statement;

public class GesplanFaturamentoDAO {
	
	public List<FaturaADIA> getFaturasPrePago(String idProcesso){
	
	List<FaturaADIA> faturasPrePago = new ArrayList<FaturaADIA>();
	
	Connection conn = null;

	try {
		conn = Conexao.abreConexao();
		
		String query = " SELECT p.idfatura as cod_fatura_odin " +
								" , p.iditemfatura as cod_itemfatura_odin " +
								" , p.datadopagamento as dta_pagamento_item " +
								" , p.formadepagamento as nom_forma_pagto " +
								" , p.datadopagamento as dta_vencimento "+
								" , p.valoritem as val_item_fatura " +
								" , CASE formadepagamento " +
								"             WHEN 'BOLETO' THEN valoritem " +
								"             ELSE (valoritem - IFNULL((TRUNCATE((SELECT val_perc_taxa_adm " +
								"													FROM adia_acordo_financeiro " +
								" 												   WHERE regra = bandeiracartao "+
								" 													 AND TIPO = formadepagamento  LIMIT 1)*valoritem,2)),0))  " +
								"       END as val_item_liquido " +
								" , p.datadearrecadacao as dta_prevista_credito " +
								" , p.bandeiracartao as nom_bandeira_cartao " +
						    " FROM adia_pagamento_odin p " +
							" JOIN (SELECT Tipo_Registro, id_Registro " +
									 " FROM adia_controle_execucao_registro_processado " +
									" WHERE Tipo_Registro = '3.1-FATURAMENTO_TESOURARIA' " +
									  " AND Executado_sucesso = 1 AND id_processo = ?) c " +
									  " ON CAST(CONCAT(p.idfatura, '|', p.iditemfatura) AS CHAR) = c.id_Registro " +
						  " WHERE modalidadedepagamento in ('PRE-PAGO') " +
					   " order by dta_pagamento_item ";
		
		PreparedStatement stmt = conn.prepareStatement(query);
		stmt.setString(1, idProcesso);
		
		ResultSet resultSet = stmt.executeQuery();
		while (resultSet.next()){
			
			FaturaADIA faturaAdia = new FaturaADIA();
			faturaAdia.setCodFaturaOdin(resultSet.getString("cod_fatura_odin"));
			faturaAdia.setCodItemFaturaOdin(resultSet.getString("cod_itemfatura_odin"));
			faturaAdia.setDtaPagamentoItem(resultSet.getDate("dta_pagamento_item"));
			faturaAdia.setNomFormaPagto(resultSet.getString("nom_forma_pagto"));
			faturaAdia.setValItemFatura(resultSet.getString("val_item_fatura"));
			
			faturaAdia.setValorDoPagamento(resultSet.getString("val_item_liquido"));
			
			faturaAdia.setDtaPrevistaCredito(resultSet.getDate("dta_prevista_credito"));
			faturaAdia.setNomBandeira(resultSet.getString("nom_bandeira_cartao"));
			
			faturasPrePago.add(faturaAdia);
		}

	
	return faturasPrePago;
	
	} catch (SQLException e) {
		e.printStackTrace();
		return null;
	} finally{
		Conexao.fechaConexao(conn);
	}
	
 }
	
	
	public List<FaturaADIA> getFaturasPosPago(String idProcesso){
		
	List<FaturaADIA> faturasPrePago = new ArrayList<FaturaADIA>();
	
	Connection conn;

	try {
		conn = Conexao.abreConexao();
		
		String query = " SELECT p.cod_fatura_odin " +
				" , p.cod_itemfatura_odin " +
				" , p.dta_pagamento_item " +
				" , p.nom_forma_pagto " +
				" , p.dta_vencimento " +
				" , p.val_item_fatura " +
				" , CASE (p.nom_forma_pagto) " +
				"             WHEN 'BOLETO' THEN p.val_item_fatura " +
				"             ELSE (p.val_item_fatura - IFNULL((TRUNCATE((SELECT val_perc_taxa_adm FROM adia_acordo_financeiro WHERE regra = p.nom_bandeira_cartao AND TIPO = p.nom_forma_pagto  LIMIT 1)*p.val_item_fatura,2)),0))  " +
				"       END ValordoPagamento " +
				" , p.dta_prevista_credito " +
				" , p.nom_bandeira_cartao " +
				" FROM vw_itemfatura_nfe p " +
				" JOIN (SELECT Tipo_Registro, id_Registro " +
				" FROM adia_controle_execucao_registro_processado " +
				" WHERE Tipo_Registro = '3.1-FATURAMENTO_TESOURARIA' " +
				" AND Executado_sucesso = 1 AND id_processo = ?) c " +
				" ON CAST(CONCAT(p.cod_fatura_odin, '|', p.cod_itemfatura_odin) AS CHAR) = c.id_Registro " +
				" WHERE p.dta_pagamento_item IS NOT NULL " +
				" AND p.nom_modalidade_pagto = 'POS-PAGO' " +
				" order by dta_vencimento ";
		
		PreparedStatement stmt = conn.prepareStatement(query);
		// preenche os valores
		stmt.setString(1, idProcesso);
		ResultSet resultSet = stmt.executeQuery(); 
		while (resultSet.next()){
			
			FaturaADIA faturaAdia = new FaturaADIA();
			faturaAdia.setCodFaturaOdin(resultSet.getString("cod_fatura_odin"));
			faturaAdia.setCodItemFaturaOdin(resultSet.getString("cod_itemfatura_odin"));
			faturaAdia.setDtaPagamentoItem(resultSet.getDate("dta_pagamento_item"));
			faturaAdia.setNomFormaPagto(resultSet.getString("nom_forma_pagto"));
			faturaAdia.setDtaVencimento(resultSet.getDate("dta_vencimento"));
			faturaAdia.setValItemFatura(resultSet.getString("val_item_fatura"));
			faturaAdia.setValorDoPagamento(resultSet.getString("ValordoPagamento"));
			faturaAdia.setDtaPrevistaCredito(resultSet.getDate("dta_prevista_credito"));
			faturaAdia.setNomBandeira(resultSet.getString("nom_bandeira_cartao"));
			
			faturasPrePago.add(faturaAdia);
		}

	
	return faturasPrePago;
	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	
 }


	public String buscaUltExecucaoGesplanFaturamento(String nome) {
		
		Connection conn;
		try {
			conn = Conexao.abreConexao();
			
			String query = "select id from adia_controle_execucao where processo = ? "
					+ " order by id desc limit 1";
			
			PreparedStatement stmt = conn.prepareStatement(query);
			// preenche os valores
			stmt.setString(1, nome);
			ResultSet resultSet = stmt.executeQuery();
			
			while (resultSet.next()){
				return resultSet.getString("id");
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	

}
