package br.pro.bruno.drogaria.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.omnifaces.util.Messages;

import br.pro.bruno.drogaria.dao.FabricanteDAO;
import br.pro.bruno.drogaria.domain.Fabricante;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class FabricanteBean implements Serializable {
	private Fabricante fabricante;

	public Fabricante getFabricante() {
		return fabricante;
	}
	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}
	
	public void novo() {
		fabricante = new Fabricante();
	}

	public void salvar() {
		try {
			FabricanteDAO fabricanteDAO = new FabricanteDAO();
			fabricanteDAO.salvar(fabricante);
			
			novo();

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
}
