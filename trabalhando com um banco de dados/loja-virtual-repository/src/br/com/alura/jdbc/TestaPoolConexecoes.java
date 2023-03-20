package br.com.alura.jdbc;

import java.sql.SQLException;

import br.com.alura.jdbc.factory.ConnectionFactory;

public class TestaPoolConexecoes {

	public static void main(String[] args) throws SQLException {

		ConnectionFactory con = new ConnectionFactory();

		for (int i = 0; i < 20; i++) {
			con.abrindoConexao();
			System.out.println("conexão de numero: " + i);
		}

	}

}
