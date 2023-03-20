package br.com.alura.jdbc.modelo;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	
	public Categoria(int id, String nome) {
		this.id = id;
		this.nome = nome;
		
	}
	
	public Categoria(int id, String nome, Produto produto) {
		this.id = id;
		this.nome = nome;
		this.produtos.add(produto);
	}
	
	private Integer id;
	private String nome;
	private List<Produto> produtos = new ArrayList<Produto>();
	
	public String getNome() {
		return nome;
	}

	public int getId() {
		return id;
	}

	public void adicionar(Produto produto) {
		produtos.add(produto);
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	@Override
	public String toString() {
		return this.nome;
	}

	public Produto getProdutoss() {
		return produtos.get(0);
	}

}
