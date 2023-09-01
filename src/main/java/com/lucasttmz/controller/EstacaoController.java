package com.lucasttmz.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class EstacaoController {

	private final int TAMANHO_MAXIMO = 3;
	private Map<String, List<Double>> medidas = new HashMap<>();

	public EstacaoController() {
		medidas.put("temperatura", new ArrayList<>());
		medidas.put("humidade", new ArrayList<>());
		medidas.put("chuva", new ArrayList<>());
	}

	public Map<String, List<Double>> atualizarMedidas() {
		List<Double> novasMedidas = obterMedidas();
		int tamanhoAtual = medidas.get("temperatura").size();

		medidas.get("temperatura").add(novasMedidas.get(0));
		medidas.get("humidade").add(novasMedidas.get(1));
		medidas.get("chuva").add(novasMedidas.get(2));

		if (tamanhoAtual >= TAMANHO_MAXIMO) {
			medidas.get("temperatura").remove(0);
			medidas.get("humidade").remove(0);
			medidas.get("chuva").remove(0);
		}
		return medidas;
	}

	private List<Double> obterMedidas() {
		return new Random().doubles()
				.map(d -> d * 100)
				.limit(3)
				.boxed()
				.collect(Collectors.toList());
	}
}
