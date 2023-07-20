package com.jgonite.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity	
@Table(name = "TB_MOVI_ACOE")
public class MovimentoAcoesModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NR_SEQU_MOVI_ACOE")
	private Long movimentoAcoesId;
	
	@Column(name = "DT_MOVI")
	private LocalDateTime dataMovimento;
	
	@Column(name = "NM_ACAO")
	private String nomeAcao;
	
	@Column(name = "NR_ACOE")
	private Integer numeroAcoes;
	
	@Column(name = "VL_ACAO")
	private String valorAcao;

	public Long getMovimentoAcoesId() {
		return movimentoAcoesId;
	}
	
	public LocalDateTime getDataMovimento() {
		return dataMovimento;
	}

	public void setDataMovimento(LocalDateTime dataMovimento) {
		this.dataMovimento = dataMovimento;
	}

	public String getNomeAcao() {
		return nomeAcao;
	}

	public void setNomeAcao(String nomeAcao) {
		this.nomeAcao = nomeAcao;
	}

	public Integer getNumeroAcoes() {
		return numeroAcoes;
	}

	public void setNumeroAcoes(Integer numeroAcoes) {
		this.numeroAcoes = numeroAcoes;
	}

	public String getValorAcao() {
		return valorAcao;
	}

	public void setValorAcao(String valorAcao) {
		this.valorAcao = valorAcao;
	}
	
	

}
