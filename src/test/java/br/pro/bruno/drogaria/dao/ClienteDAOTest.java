package br.pro.bruno.drogaria.dao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import br.pro.bruno.drogaria.domain.Cliente;
import br.pro.bruno.drogaria.domain.Pessoa;

public class ClienteDAOTest {

	@Test
	@Ignore
	public void salvar() throws ParseException {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(2L);

		Cliente cliente = new Cliente();
		// Tipos de datas e formatos
		// cliente.setDataCadastro(new
		// SimpleDateFormat("dd/MM/yyyy").parse("09/06/2015"));
		cliente.setDataCadastro(new Date());
		cliente.setLiberado(false);
		cliente.setPessoa(pessoa);

		ClienteDAO clienteDAO = new ClienteDAO();
		clienteDAO.salvar(cliente);
		System.out.println("Cliente salvo com sucesso!");
	}

	@Test
	@Ignore
	public void listar() {
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> resultado = clienteDAO.listar();

		for (Cliente cliente : resultado) {
			System.out.println("Código do Cliente: " + cliente.getCodigo());
			System.out.println("Nome do Cliente: " + cliente.getPessoa().getNome());
			System.out.println("Data de Cadastro: " + cliente.getDataCadastro());
			System.out.println("Cadastro Liberado: " + cliente.getLiberado());
			System.out.println();
		}
	}

	@Test
	@Ignore
	public void buscar() {
		Long codigoCliente = 1L;

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigoCliente);
		System.out.println("Código do Cliente: " + cliente.getCodigo());
		System.out.println("Nome do Cliente: " + cliente.getPessoa().getNome());
		System.out.println("Data de Cadastro: " + cliente.getDataCadastro());
		System.out.println("Cadastro Liberado: " + cliente.getLiberado());
	}

	@Test
	@Ignore
	public void excluir() {
		Long codigoCliente = 2L;

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigoCliente);
		
		clienteDAO.excluir(cliente);
		
		System.out.println("Cliente Removido");
		System.out.println("Código do Cliente: " + cliente.getCodigo());
		System.out.println("Nome do Cliente: " + cliente.getPessoa().getNome());
		System.out.println("Data de Cadastro: " + cliente.getDataCadastro());
		System.out.println("Cadastro Liberado: " + cliente.getLiberado());
	}

	@Test
	@Ignore
	public void editar() {
		Long codigoCliente = 3L;
		Long codigoPessoa = 2L;

		ClienteDAO clienteDAO = new ClienteDAO();
		Cliente cliente = clienteDAO.buscar(codigoCliente);
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(codigoPessoa);
		
		System.out.println("Cliente a ser editado: ");
		System.out.println("Nome do cliente: " + pessoa.getNome());
		System.out.println("Código do cliente: " + cliente.getCodigo());
		System.out.println("Data de cadastro do cliente: " + cliente.getDataCadastro());
		System.out.println("Liberação do cliente: " + cliente.getLiberado());
		
		cliente.setDataCadastro(new Date());
		cliente.setLiberado(false);

		clienteDAO.editar(cliente);
		
		System.out.println("Cliente Data e Liberação Editada");
		System.out.println("Nome do cliente: " + pessoa.getNome());
		System.out.println("Código do cliente: " + cliente.getCodigo());
		System.out.println("Data de cadastro do cliente: " + cliente.getDataCadastro());
		System.out.println("Liberação do cliente: " + cliente.getLiberado());
	}
}
