package com.lucasttmz.controller;

import java.util.List;

import com.lucasttmz.model.TarefaModel;
import com.lucasttmz.repository.TarefaListRepository;
import com.lucasttmz.repository.TarefaRepository;

public class TarefaController {
	public TarefaRepository repository;
	
	public TarefaController(TarefaRepository repo) {
		this.repository = repo;
	}

	public void adicionarTarefa(List<String> dados) {
		repository.adicionarTarefa(TarefaModel.pelosDados(dados));
	}
	
	public List<TarefaModel> pesquisarTarefas() {
		return repository.pesquisarTarefas();
	}
	
	public TarefaModel pesquisarTarefasPorId(String idTarefa) {
		int id = Integer.parseInt(idTarefa);
		return repository.pesquisarTarefasPorId(id)
				.orElse(null);
	}
	
	public List<TarefaModel> pesquisarTarefasPorFinalizada(String finalizada) {
		boolean f = Boolean.parseBoolean(finalizada);
		return repository.pesquisarTarefasPorFinalizada(f);
	}
	
	public List<TarefaModel> pesquisarTarefasPorPrioridade(String prioridade) {
		int p = Integer.parseInt(prioridade);
		return repository.pesquisarTarefasPorPrioridade(p);
	}
	
	public void alterarTarefa(String idTarefa, List<String> dados) {
		int id = Integer.parseInt(idTarefa);
		repository.alterarTarefa(id, TarefaModel.pelosDados(dados));
	}
	
	public void apagarTarefa(String idTarefa) {
		int id = Integer.parseInt(idTarefa);
		repository.apagarTarefa(id);
	}
	
	public static void main(String[] args) {
		TarefaController controller = new TarefaController(new TarefaListRepository());
		controller.adicionarTarefa(List.of("Estudar", "Bastante", "3", "false"));
		System.out.println(controller.pesquisarTarefas());
		controller.adicionarTarefa(List.of("Dormir", "Pouco", "1", "false"));
		System.out.println(controller.pesquisarTarefas());
		controller.apagarTarefa("2");
		System.out.println(controller.pesquisarTarefasPorId("1"));
		System.out.println(controller.pesquisarTarefas());
		controller.adicionarTarefa(List.of("Jogar", "", "2", "false"));
		System.out.println(controller.pesquisarTarefas());
		controller.alterarTarefa("2", List.of("Dormir", "Pouco", "2", "true"));
		System.out.println(controller.pesquisarTarefasPorId("2"));
		System.out.println(controller.pesquisarTarefasPorPrioridade("2"));
		System.out.println(controller.pesquisarTarefasPorPrioridade("2"));
		
	}
	
}
