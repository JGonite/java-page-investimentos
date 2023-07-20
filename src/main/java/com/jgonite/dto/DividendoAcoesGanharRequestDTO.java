package com.jgonite.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

public class DividendoAcoesGanharRequestDTO {

	@NotNull
	private String acaoDividendo;
	@NotNull
	@Positive
	private String valorRecebido;
	@PastOrPresent
	private String dataDividendo;
	
	public String getAcaoDividendo() {
		return acaoDividendo;
	}
	public void setAcaoDividendo(String acaoDividendo) {
		this.acaoDividendo = acaoDividendo;
	}
	public String getValorRecebido() {
		return valorRecebido;
	}
	public void setValorRecebido(String valorRecebido) {
		this.valorRecebido = valorRecebido;
	}
	public String getDataDividendo() {
		return dataDividendo;
	}
	public void setDataDividendo(String dataDividendo) {
		this.dataDividendo = dataDividendo;
	}
	
	
	
}
