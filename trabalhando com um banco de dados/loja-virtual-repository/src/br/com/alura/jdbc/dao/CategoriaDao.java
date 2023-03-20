package br.com.alura.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.jdbc.modelo.Categoria;
import br.com.alura.jdbc.modelo.Produto;

public class CategoriaDao {

	public Connection connection;

	public CategoriaDao(Connection connection) {
		this.connection = connection;

	}

	public List<Categoria> ListarCategorias() {
		try {
			List<Categoria> listacatagoria = new ArrayList<>();

			String sql = "select * from categoria";

			try (PreparedStatement pstm = connection.prepareStatement(sql)) {
				pstm.execute();
				try (ResultSet rst = pstm.getResultSet()) {

					while (rst.next()) {
						Categoria categoria = new Categoria(rst.getInt(1), rst.getString(2));
						listacatagoria.add(categoria);
					}
				}

			}
			return listacatagoria;
			
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Categoria> ListarComProdutos() throws SQLException {
		List<Categoria> listacatagoria = new ArrayList<>();

		String sql = "select p.id, p.nome, c.nome, c.id, p.descricao from produto p, categoria c where p.CATEGORIA_ID = c.id";

		try (PreparedStatement pstm = connection.prepareStatement(sql)) {
			pstm.execute();
			try (ResultSet rst = pstm.getResultSet()) {

				while (rst.next()) {
					Produto produto = new Produto(rst.getInt(1), rst.getString(2), rst.getString(5));
					Categoria categoria = new Categoria(rst.getInt(4), rst.getString(3), produto);
					listacatagoria.add(categoria);
				}
			}

		}
		return listacatagoria;
	}

}
