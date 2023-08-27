package com.lucasttmz.controller;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class EstacaoController {
	
	public List<Double> atualizarMedidas() {
		return new Random().doubles()
				.map(d -> d*100)
				.limit(3)
				.boxed()
				.collect(Collectors.toList());
	}
}
