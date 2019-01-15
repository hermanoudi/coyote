package br.com.algartelecom.adia.mastersaf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.algartelecom.adia.conexao.Conexao;

public class ListaClientesComSegmentoProvisorio {
	public static void main(String[] args) throws SQLException {
		
		Connection conn = Conexao.abreConexao();
		System.out.println("conectado...");
		
		String query = "select c.idt_cliente_odin as cod_cliente, " +
											    "c.nom_cliente as cliente, c.num_documento_cliente as cpfcnpj, " +
											    "c.cod_atividade_principal as cnae, " +
											    "c.val_faturamento_presumido as fat_presumido, " +
											    "c.qtd_filial_empresa as qtd_filial, " +
											    "c.nom_segmento_cliente as segmento, " +
											    "dta_ult_alteracao data " +
											"from vw_dw_cliente_adia c " +
										"where c.nom_segmento_cliente not in (?);";
				
		PreparedStatement stmt = conn.prepareStatement(query);
		// preenche os valores
		stmt.setString(1, "'Corporativo','Empresarial'");
		
		boolean resultado = stmt.execute(); 
		ResultSet resultSet = stmt.getResultSet();
		while (resultSet.next()){
			if (resultSet.getString("segmento").equals("PROVISÓRIO")){
				System.out.println(resultSet.getString("cpfcnpj") + " - " + resultSet.getString("cliente") + " - "+ resultSet.getString("segmento"));
			}
		}
		stmt.close();
		conn.close();
	}
}