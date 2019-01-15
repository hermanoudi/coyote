package br.com.algartelecom.adia.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	
	public static Connection abreConexao() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://IPXXXXX/adia_eai", "xxxxxx", "xxxxxx");
	}
	
	public static void fechaConexao(Connection conn) {
		if (conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
