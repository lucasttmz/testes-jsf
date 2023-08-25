package com.lucasttmz.beans;

import java.io.Serializable;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

@ManagedBean
@ViewScoped
public class EstacaoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Date data;
	private Double temperatura;
	private Double humidade;
	private Boolean chuva;

	
	public void mostrar() {
		System.out.println(data);
		System.out.println(temperatura);
		System.out.println(humidade);
		System.out.println(chuva);
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
