package com.lucasttmz.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import com.lucasttmz.controller.TarefaController;
import com.lucasttmz.model.TarefaModel;
import com.lucasttmz.repository.TarefaListRepository;

@ManagedBean
@ApplicationScoped
public class TarefaBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private TarefaController controle;
	private List<TarefaModel> listaTarefas;
	
	private String nome;
	private String descricao;
	private int prioridade;
	private Boolean finalizada = false;
	

	public TarefaBean() {
		controle= new TarefaController(new TarefaListRepository());
	}
	
	public void todasTarefas() {
		listaTarefas = controle.pesquisarTarefas();
	}
	
	public void salvar() {
		controle.adicionarTarefa(List.of(nome, descricao, String.valueOf(prioridade), String.valueOf(finalizada)));
		this.nome = null;
		this.descricao = null;
		this.prioridade = 0;
		this.finalizada = false;
	}
	
	public void excluir(String id) {
		controle.apagarTarefa(id);
	}

	public String index() {
		return "index?faces-redirect=true";
	}

	public List<TarefaModel> getListaTarefas() {
		return listaTarefas;
	}

	public Boolean getFinalizada() {
		return finalizada;
	}

	public void setFinalizada(Boolean finalizada) {
		this.finalizada = finalizada;
	}

	public int[] getListaPrioridades() {
		return new int[] { 1, 2, 3 };
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
	}

	public boolean isFinalizada() {
		return finalizada;
	}

	public void setFinalizada(boolean finalizada) {
		this.finalizada = finalizada;
	}

}
