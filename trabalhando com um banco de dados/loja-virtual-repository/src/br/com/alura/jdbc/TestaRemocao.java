package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaRemocao {
	
	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con = connectionFactory.abrindoConexao();

		PreparedStatement stm = con.prepareStatement("Delete from produto where id > ?");
		
		stm.setInt(1, 3);
		
		stm.execute();
		
		Integer linhasModificadas = stm.getUpdateCount();
		
		System.out.println("qunatidade de linhas que foram modificadas: " + linhasModificadas);
		
	}
}
