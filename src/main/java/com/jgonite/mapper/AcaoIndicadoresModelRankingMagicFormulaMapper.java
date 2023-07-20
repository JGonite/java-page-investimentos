package com.jgonite.mapper;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

import com.jgonite.dto.RankingMagicFormulaDTO;
import com.jgonite.model.AcaoIndicadoresModel;
import com.jgonite.util.StringUtils;

@Component
public class AcaoIndicadoresModelRankingMagicFormulaMapper {
	
	public RankingMagicFormulaDTO toRankingMagicFormulaDTO(AcaoIndicadoresModel acoesModel) {
		RankingMagicFormulaDTO dto = new RankingMagicFormulaDTO();
		dto.setDataExtracao(StringUtils.localDateTimeParaDDMMYYYYhhmm(LocalDateTime.now()));
		dto.setEvEbit( String.valueOf(acoesModel.getEvEbit().setScale(2)) );
		dto.setPapel(acoesModel.getPapel());
		dto.setPosicao( String.valueOf(acoesModel.getPosicaoFinal()));
		dto.setRoic(StringUtils.bigDecimalParaPorcentagem(acoesModel.getRoic()));
		return dto;
	}

}
