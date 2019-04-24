import org.junit.Ignore;
import org.junit.Test;

import br.pro.bruno.drogaria.dao.PessoaDAO;
import br.pro.bruno.drogaria.dao.UsuarioDAO;
import br.pro.bruno.drogaria.domain.Pessoa;
import br.pro.bruno.drogaria.domain.Usuario;

public class UsuarioDAOTest {

	@Test
	@Ignore
	public void salvar() {
		PessoaDAO pessoaDAO = new PessoaDAO();
		Pessoa pessoa = pessoaDAO.buscar(1L);
		
		System.out.println("Pessoa Encontrada");
		System.out.println("Nome: " + pessoa.getNome());
		System.out.println("CPF: " + pessoa.getCpf());
		System.out.println("Whatsapp: " + pessoa.getCelular());
		
		Usuario usuario = new Usuario();
		usuario.setAtivo(true);
		usuario.setPessoa(pessoa);
		usuario.setSenha("q1w2e3r4");
		usuario.setTipo('A');
		
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.salvar(usuario);
		
		System.out.println("Usuário salvo com sucesso!");
	}
	
	@Test
	@Ignore
	public void listar() {
			
	}

	@Test
	@Ignore
	public void buscar() {
			
	}
		
	@Test
	@Ignore
	public void excluir() {
			
	}
		
	@Test
	@Ignore
	public void editar() {
			
	}
}
