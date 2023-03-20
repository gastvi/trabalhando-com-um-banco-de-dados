package br.com.alura.jdbc.controller;

import java.sql.Connection;
import java.util.List;

import br.com.alura.jdbc.dao.CategoriaDao;
import br.com.alura.jdbc.factory.ConnectionFactory;
import br.com.alura.jdbc.modelo.Categoria;

public class CategoriaController {
	
	private CategoriaDao categoriaDao;
	
	public CategoriaController() {
		Connection con = new ConnectionFactory().abrindoConexao();
		
		this.categoriaDao = new CategoriaDao(con);
	}
	

	public List<Categoria> listar() {
		return this.categoriaDao.ListarCategorias();
	}
}
