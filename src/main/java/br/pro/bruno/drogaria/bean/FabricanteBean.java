package br.pro.bruno.drogaria.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import org.omnifaces.util.Messages;

import br.pro.bruno.drogaria.dao.EstadoDAO;
import br.pro.bruno.drogaria.dao.FabricanteDAO;
import br.pro.bruno.drogaria.domain.Estado;
import br.pro.bruno.drogaria.domain.Fabricante;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FabricanteBean implements Serializable {
	private Fabricante fabricante;
	private List<Fabricante> fabricantes;

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	public List<Fabricante> getFabricantes() {
		return fabricantes;
	}

	public void setFabricantes(List<Fabricante> fabricantes) {
		this.fabricantes = fabricantes;
	}

	@PostConstruct
	public void listar() {
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricantes = fabricanteDAO.listar();			
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar listar os Fabricantes");
			erro.printStackTrace();
		}
	}

	public void novo() {
		fabricante = new Fabricante();
	}

	public void salvar() {
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.merge(fabricante);

			novo();
			fabricantes = fabricanteDAO.listar();

			Messages.addGlobalInfo("Fabricante salvo com sucesso");
		} catch (RuntimeException erro) {
			Messages.addGlobalError("Ocorreu um erro ao tentar salvar o Fabricante");
			erro.printStackTrace();
		}

		/*-- SEM O OMNIFACES --*/
		/*
		 * String texto = "Programação Web com Java"; FacesMessage mensagem = new
		 * FacesMessage(FacesMessage.SEVERITY_INFO, texto, texto);
		 * 
		 * FacesContext contexto = FacesContext.getCurrentInstance();
		 * contexto.addMessage(null, mensagem);
		 */
	}
	
	public void excluir(ActionEvent evento) {
		try {
		fabricante = (Fabricante) evento.getComponent().getAttributes().get("fabricanteSelecionado");
		
		FabricanteDAO fabricanteDAO = new FabricanteDAO();
		fabricanteDAO.excluir(fabricante);
		
		fabricantes = fabricanteDAO.listar();
		
		Messages.addFlashGlobalInfo("Fabricante removido com sucesso!");
		} catch (RuntimeException erro) {
			Messages.addFlashGlobalError("Ocorreu um erro ao tentar remover o Fabricante");
			erro.printStackTrace();
		}
	}
	
	public void editar(ActionEvent evento) {
		fabricante = (Fabricante) evento.getComponent().getAttributes().get("fabricanteSelecionado");
	}
}
