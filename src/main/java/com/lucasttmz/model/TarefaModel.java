package com.lucasttmz.model;

import java.util.List;

public class TarefaModel {
	private int id;
	private String nome;
	private String descricao;
	private int prioridade;
	private boolean finalizada;
	
	public TarefaModel(String nome, String descricao, int prioridade, boolean finalizada) {
		this.nome = nome;
		this.descricao = descricao;
		this.prioridade = prioridade;
		this.finalizada = finalizada;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public static TarefaModel pelosDados(List<String> dados) {
		String nome = dados.get(0);
		String descricao = dados.get(1);
		int prioridade = Integer.parseInt(dados.get(2));
		boolean finalizada = Boolean.valueOf(dados.get(3));
		return new TarefaModel(nome, descricao, prioridade, finalizada);
	}

	@Override
	public String toString() {
		return "TarefaModel [id=" + id + ", nome=" + nome + ", descricao=" + descricao + ", prioridade=" + prioridade
				+ ", finalizada=" + finalizada + "]";
	}

	
}
