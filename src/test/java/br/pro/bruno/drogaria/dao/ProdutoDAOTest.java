package br.pro.bruno.drogaria.dao;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.bruno.drogaria.domain.Fabricante;
import br.pro.bruno.drogaria.domain.Produto;

public class ProdutoDAOTest {

	@Test
	@Ignore
	public void salvar() {
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(3L);

		Produto produto = new Produto();
		produto.setDescricao("Cataflan 50mg com 20 comprimidos");
		produto.setFabricante(fabricante);
		produto.setPreco(new BigDecimal("13.70"));
		produto.setQuantidade(new Short("7"));

		ProdutoDAO produtoDAO = new ProdutoDAO();
		produtoDAO.salvar(produto);

		System.out.println("Produto salvo com sucesso!");
	}

	@Test
	@Ignore
	public void listar() {
		ProdutoDAO produtoDAO = new ProdutoDAO();
		List<Produto> resultado = produtoDAO.listar();

		for (Produto produto : resultado) {
			System.out.println("Código do produto: " + produto.getCodigo());
			System.out.println("Descrição do produto: " + produto.getDescricao());
			System.out.println("Quantidade do produto: " + produto.getQuantidade());
			System.out.println("Preço do produto: " + produto.getPreco());
			System.out.println("Nome do fabricante: " + produto.getFabricante().getDescricao());
			System.out.println();
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigoProduto = 1L;

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigoProduto);

		System.out.println("Código do produto: " + produto.getCodigo());
		System.out.println("Descrição do produto: " + produto.getDescricao());
		System.out.println("Quantidade do produto: " + produto.getQuantidade());
		System.out.println("Preço do produto: " + produto.getPreco());
		System.out.println("Nome do fabricante: " + produto.getFabricante().getDescricao());

	}
	
	@Test
	@Ignore
	public void excluir() {
		Long codigoProduto = 2L;

		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigoProduto);
		
		produtoDAO.excluir(produto);

		System.out.println("Código do produto: " + produto.getCodigo());
		System.out.println("Descrição do produto: " + produto.getDescricao());
		System.out.println("Quantidade do produto: " + produto.getQuantidade());
		System.out.println("Preço do produto: " + produto.getPreco());
		System.out.println("Nome do fabricante: " + produto.getFabricante().getDescricao());
		System.out.println("O produto " + produto.getDescricao() + " foi removido com sucesso!");

	}
	
	@Test
	@Ignore
	public void editar() {
		Long codigoProduto = 2L;
		Long codigoFabricante = 3L;
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		Fabricante fabricante = fabricanteDAO.buscar(codigoFabricante);
		
		ProdutoDAO produtoDAO = new ProdutoDAO();
		Produto produto = produtoDAO.buscar(codigoProduto);
		
		System.out.println("Código do Fabricante: " + fabricante.getCodigo());
		System.out.println("Nome do fabricante: " + fabricante.getDescricao());

		
		System.out.println("Produto a ser editado");
		System.out.println("Código do produto: " + produto.getCodigo());
		System.out.println("Descrição do produto: " + produto.getDescricao());
		System.out.println("Quantidade do produto: " + produto.getQuantidade());
		System.out.println("Preço do produto: " + produto.getPreco());
		System.out.println("Nome do fabricante: " + produto.getFabricante().getDescricao());
		
		produto.setDescricao("Cataflan 100mg 20 comprimidos");
		produto.setFabricante(fabricante);
		
		produtoDAO.editar(produto);

		System.out.println("Produto Editado");
		System.out.println("Código do produto: " + produto.getCodigo());
		System.out.println("Descrição do produto: " + produto.getDescricao());
		System.out.println("Quantidade do produto: " + produto.getQuantidade());
		System.out.println("Preço do produto: " + produto.getPreco());
		System.out.println("Nome do fabricante: " + produto.getFabricante().getDescricao());
		System.out.println("O produto " + produto.getDescricao() + " foi alterado sucesso!");

	}
}
