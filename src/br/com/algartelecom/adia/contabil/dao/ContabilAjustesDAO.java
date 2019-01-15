package br.com.algartelecom.adia.contabil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.conexao.Conexao;
import br.com.algartelecom.adia.contabil.to.AjusteFatura;

public class ContabilAjustesDAO {

		
	public List<AjusteFatura> getAjustesFaturas(String primeiroDiaMesAnterior, String primeiroDiaMesAtual) {
		
		List<AjusteFatura> ajustes = new ArrayList<AjusteFatura>();
		Connection conn = null;
			
			try{
				conn = Conexao.abreConexao();
				
				String query = " SELECT " +
								"     nc.idt_nota_credito, nc.val_nota_credito, nc.dta_aplicacao_nota, crl.num_centro_resultado, nc.cod_sku_odin " +
								" FROM " +
								"     adia_notacredito_odin nc " +
								"         INNER JOIN " +
								"     adia_cliente_odin c ON nc.idt_cliente_odin = c.idcliente " +
								"         LEFT JOIN " +
								"     adia_cr_localidade_cliente crl ON c.endereco_estado = crl.sgl_uf_localidade " +
								"         AND c.endereco_cidade = crl.nom_localidade " +
								" WHERE " +
								"     ind_credito_contestacao = 'S' " +
								"         AND dta_aplicacao_nota >= STR_TO_DATE(?, '%Y%m%d') " +
								"         AND dta_aplicacao_nota < STR_TO_DATE(?, '%Y%m%d') ";
	
				PreparedStatement stmt = conn.prepareStatement(query);
				stmt.setString(1, primeiroDiaMesAnterior);
				stmt.setString(2, primeiroDiaMesAtual);
				ResultSet resultSet = stmt.executeQuery();
				
				while (resultSet.next()) {
					
					AjusteFatura ajuste = new AjusteFatura();
					ajuste.setIdNotaCredito(resultSet.getString("idt_nota_credito"));
					ajuste.setValorNotaCredito(resultSet.getString("val_nota_credito"));
					ajuste.setDataAplicacaoNota(resultSet.getDate("dta_aplicacao_nota"));
					ajuste.setCentroResultado(resultSet.getString("num_centro_resultado"));
					ajuste.setCodSkuOdin(resultSet.getString("cod_sku_odin"));
					
					ajustes.add(ajuste);
				
				}
	
			
			return ajustes;
		} catch(Exception e){
			e.printStackTrace();
			return null;
		} finally{
			Conexao.fechaConexao(conn);
		}
			
	}
}
