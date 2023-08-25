package com.lucasttmz.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.lucasttmz.model.TarefaModel;

public class TarefaListRepository implements TarefaRepository {
	private static int LAST_ID = 0;
	private List<TarefaModel> tarefas;

	public TarefaListRepository() {
		tarefas = new ArrayList<TarefaModel>();
		adicionarTarefa(new TarefaModel("Tarefa Inicial", "Descrição qualquer", 1, false));
		adicionarTarefa(new TarefaModel("Tarefa Inicial", "Descrição qualquer", 1, false));
	}

	public void adicionarTarefa(TarefaModel tarefa) {
		tarefa.setId(++LAST_ID);
		tarefas.add(tarefa);
	}

	public List<TarefaModel> pesquisarTarefas() {
		return tarefas;
	}

	public Optional<TarefaModel> pesquisarTarefasPorId(int id) {
		return pesquisarTarefas()
				.stream()
				.filter(t -> t.getId() == id)
				.findFirst();
	}

	public List<TarefaModel> pesquisarTarefasPorPrioridade(int prioridade) {
		return pesquisarTarefas()
				.stream()
				.filter(t -> t.getPrioridade() == prioridade)
				.collect(Collectors.toList());
	}
	
	public List<TarefaModel> pesquisarTarefasPorFinalizada(boolean finalizada) {
		return pesquisarTarefas()
				.stream()
				.filter(t -> t.isFinalizada() == finalizada)
				.collect(Collectors.toList());
	}
	
	public void alterarTarefa(int id, TarefaModel nova) {
		Optional<TarefaModel> tarefa = pesquisarTarefasPorId(id);
		if (tarefa.isPresent()) {
			TarefaModel antiga = tarefa.get();
			antiga.setNome(nova.getNome());
			antiga.setDescricao(nova.getDescricao());
			antiga.setPrioridade(nova.getPrioridade());
			antiga.setFinalizada(nova.isFinalizada());
		}
	}
	
	public void apagarTarefa(int id) {
		Optional<TarefaModel> tarefa = pesquisarTarefasPorId(id);
		if (tarefa.isPresent()) {
			tarefas.remove(tarefa.get());
		}
	}
}
