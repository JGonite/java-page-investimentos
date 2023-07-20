package com.jgonite.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity	
@Table(name = "TB_DIVI_ACOE")
public class DividendoAcoesModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NR_SEQU_DIVI_ACOE")
	private Long movimentoAcoesId;
	
	@Column(name = "DT_DIVI")
	private LocalDateTime dataDividendo;
	
	@Column(name = "NM_ACAO")
	private String nomeAcao;
	
	@Column(name = "VL_RECE")
	private BigDecimal valorRecebido;

	public Long getMovimentoAcoesId() {
		return movimentoAcoesId;
	}

	public void setMovimentoAcoesId(Long movimentoAcoesId) {
		this.movimentoAcoesId = movimentoAcoesId;
	}

	public LocalDateTime getDataDividendo() {
		return dataDividendo;
	}

	public void setDataDividendo(LocalDateTime dataDividendo) {
		this.dataDividendo = dataDividendo;
	}

	public String getNomeAcao() {
		return nomeAcao;
	}

	public void setNomeAcao(String nomeAcao) {
		this.nomeAcao = nomeAcao;
	}

	public BigDecimal getValorRecebido() {
		return valorRecebido;
	}

	public void setValorRecebido(BigDecimal valorRecebido) {
		this.valorRecebido = valorRecebido;
	}
	
	
}
