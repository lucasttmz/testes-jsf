package com.lucasttmz.beans;

import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class TarefaBean implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String descricao;
	private int prioridade;
	private Boolean finalizada = false;

	public int[] getListaPrioridades() {
		return new int[]{1, 2, 3};
	}
	
	public void salvar() {
		System.out.println(nome);
		System.out.println(descricao);
		System.out.println(prioridade);
		System.out.println(finalizada);
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
