package com.lucasttmz.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import com.lucasttmz.controller.EstacaoController;

@ManagedBean
@ApplicationScoped
public class EstacaoBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private EstacaoController controller = new EstacaoController();

	private Date data;
	private List<Double> temperatura;
	private List<Double> humidade;
	private List<Boolean> chuva;
	private List<String> datasComRegistros;

	public void mostrar() {
		System.out.println(data);
		System.out.println(temperatura);
		System.out.println(humidade);
		System.out.println(chuva);
	}

	public void atualizarMedidas() {
		Map<String, List<Double>> medidas = controller.atualizarMedidas();
		this.temperatura = medidas.get("temperatura");
		this.humidade = medidas.get("humidade");
		this.chuva = medidas.get("chuva").stream().map(m -> m >= 50.0).toList();
	}

	public List<Double> getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(List<Double> temperatura) {
		this.temperatura = temperatura;
	}

	public List<Double> getHumidade() {
		return humidade;
	}

	public void setHumidade(List<Double> humidade) {
		this.humidade = humidade;
	}

	public List<Boolean> getChuva() {
		return chuva;
	}

	public void setChuva(List<Boolean> chuva) {
		this.chuva = chuva;
	}

	public void carregarDatas() {
		this.datasComRegistros = List.of("2023-08-24", "2023-08-25");
	}

	public List<String> getDatasComRegistros() {
		return datasComRegistros;
	}

	public void setDatasComRegistros(List<String> datasComRegistros) {
		this.datasComRegistros = datasComRegistros;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

}
