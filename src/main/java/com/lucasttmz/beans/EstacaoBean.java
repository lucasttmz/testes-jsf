package com.lucasttmz.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import com.lucasttmz.controller.EstacaoController;

@ManagedBean
@ViewScoped
public class EstacaoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private EstacaoController controller = new EstacaoController();
	
	private Date data;
	private Double temperatura;
	private Double humidade;
	private Boolean chuva;
	private List<String> datasComRegistros;

	
	public void mostrar() {
		System.out.println(data);
		System.out.println(temperatura);
		System.out.println(humidade);
		System.out.println(chuva);
	}
	
	public void atualizarMedidas() {
		List<Double> medidas = controller.atualizarMedidas();
		this.temperatura = medidas.get(0);
		this.humidade = medidas.get(1);
		this.chuva = medidas.get(2) >= 50.0;
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

	public Double getTemperatura() {
		return temperatura;
	}

	public void setTemperatura(Double temperatura) {
		this.temperatura = temperatura;
	}

	public Double getHumidade() {
		return humidade;
	}

	public void setHumidade(Double humidade) {
		this.humidade = humidade;
	}

	public Boolean getChuva() {
		return chuva;
	}

	public void setChuva(Boolean chuva) {
		this.chuva = chuva;
	}
	
	
	
}
