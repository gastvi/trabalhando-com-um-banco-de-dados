package br.com.alura.jdbc.view;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.jdbc.dao.CategoriaDao;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Categoria;

public class TestaListagemComCategoria {

	public static void main(String[] args) throws SQLException {

		try (Connection connection = new ConnectionFactory().abrindoConexao()) {
			CategoriaDao categoriaDao = new CategoriaDao(connection);

			List<Categoria> listacat = categoriaDao.ListarComProdutos();
			for (Categoria categoria : listacat) {
				System.out.println(categoria.getId()+ "-" +categoria.getNome() + " - " + categoria.getProdutoss().getNome());
			}
		}

	}

}
