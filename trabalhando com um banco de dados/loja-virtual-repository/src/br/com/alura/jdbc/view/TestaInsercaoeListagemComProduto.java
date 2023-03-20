package br.com.alura.jdbc.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.dao.ProdutoDAO;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Produto;

public class TestaInsercaoeListagemComProduto {

	public static void main(String[] args) throws SQLException {

		Produto comoda = new Produto("comoda", "comoda vertical");

		try (Connection connection = new ConnectionFactory().abrindoConexao()) {
			ProdutoDAO produtoDao = new ProdutoDAO(connection);
			produtoDao.salvar(comoda);
			
			List<Produto> listaprod = produtoDao.listar();
				for (Produto produto : listaprod) {
					System.out.println(produto);
				}
		}
	}
}
