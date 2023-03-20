package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaListagem {
	
	public static void main(String[] args) throws SQLException {

		
		ConnectionFactory connectionFactory = new ConnectionFactory();
		Connection con  = connectionFactory.abrindoConexao();
		
		PreparedStatement stm = con.prepareStatement("Select * from produto");
		
		stm.execute();
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			Integer id = rst.getInt("id");
			System.out.println(id);
			String nome = rst.getString("nome");
			System.out.println(nome);
			String descricao = rst.getString("descricao");
			System.out.println(descricao);
		}
			
		
		System.out.println("fechando conexão!!");
		
		con.close();
	}
}
