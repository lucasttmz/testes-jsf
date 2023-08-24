package com.lucasttmz.repository;

import java.util.List;
import java.util.Optional;

import com.lucasttmz.model.TarefaModel;

public interface TarefaRepository {
	public List<TarefaModel> pesquisarTarefas();
	public Optional<TarefaModel> pesquisarTarefasPorId(int id);
	public List<TarefaModel> pesquisarTarefasPorPrioridade(int prioridade);
	public List<TarefaModel> pesquisarTarefasPorFinalizada(boolean finalizada);
	public void adicionarTarefa(TarefaModel tarefa);
	public void alterarTarefa(int id, TarefaModel nova);
	public void apagarTarefa(int id);
}
