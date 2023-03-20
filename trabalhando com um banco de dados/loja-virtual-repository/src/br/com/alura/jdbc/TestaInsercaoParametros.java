package br.com.alura.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaInsercaoParametros {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory connectionFactory = new ConnectionFactory();
		try (Connection con = connectionFactory.abrindoConexao()) {

			con.setAutoCommit(false);
			try (PreparedStatement stm = con.prepareStatement("INSERT INTO PRODUTO (nome, descricao) VALUES (?,?);",
					Statement.RETURN_GENERATED_KEYS)) {

				adicioarVariavel("SmartTV", "45 polegadas", stm);
				adicioarVariavel("Radio", "radio de Bateria", stm);

				con.commit();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("ROLLBACK EXECUTADO");
			}
		}
	}

	private static void adicioarVariavel(String nome, String descricao, PreparedStatement stm) throws SQLException {
		stm.setString(1, nome);
		stm.setString(2, descricao);

//		if (nome.equals("Radio")) {
//			throw new RuntimeException("Não foi possivel adicionar o produto!!");
//		}

		stm.execute();

		try (ResultSet rst = stm.getGeneratedKeys()) {

			while (rst.next()) {
				Integer id = rst.getInt(1);
				System.out.println("o id criado foi: " + id);
			}

		}

	}
}
