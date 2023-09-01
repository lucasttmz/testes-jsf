package com.lucasttmz.beans;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

@ManagedBean
@ViewScoped
public class DataBean {
	private LocalDate date;
	private LocalDate minDate;
    private LocalDate maxDate;
    private List<LocalDate> invalidDates;
    
    public DataBean() {
    	invalidDates = new ArrayList<>();
    	invalidDates.add(LocalDate.now().plusDays(1));
    	invalidDates.add(LocalDate.now().minusDays(1));
    	invalidDates.add(LocalDate.now().plusDays(3));
    	invalidDates.add(LocalDate.now().minusDays(3));
    	minDate = LocalDate.now().minusDays(7);
    	maxDate = LocalDate.now().plusDays(7);
    }

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalDate getMinDate() {
		return minDate;
	}

	public void setMinDate(LocalDate minDate) {
		this.minDate = minDate;
	}

	public LocalDate getMaxDate() {
		return maxDate;
	}

	public void setMaxDate(LocalDate maxDate) {
		this.maxDate = maxDate;
	}

	public List<LocalDate> getInvalidDates() {
		return invalidDates;
	}

	public void setInvalidDates(List<LocalDate> invalidDates) {
		this.invalidDates = invalidDates;
	}
    
}
