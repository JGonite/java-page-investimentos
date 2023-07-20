package com.jgonite.service;

import static com.jgonite.util.StringUtils.trocarVirgulaPorPonto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgonite.dto.DividendoAcoesGanharRequestDTO;
import com.jgonite.dto.ResponseGenericoDTO;
import com.jgonite.model.DividendoAcoesModel;
import com.jgonite.repository.DividendoRepository;
import com.jgonite.util.StringUtils;

@Service
public class DividendoAcoesService {
	
	@Autowired
	private DividendoRepository dividendoRepository;
	
	public ResponseGenericoDTO ganharDividendo(DividendoAcoesGanharRequestDTO requestDTO) {
		
		BigDecimal valorRecebido = new BigDecimal( trocarVirgulaPorPonto( requestDTO.getValorRecebido() )).setScale(2);
		DividendoAcoesModel dividendoModel = new DividendoAcoesModel();
		dividendoModel.setDataDividendo(requestDTO.getDataDividendo() == null ?  LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS) : StringUtils.YYYYMMDDparaLocalDateTime( requestDTO.getDataDividendo()));
		dividendoModel.setNomeAcao(requestDTO.getAcaoDividendo());
		dividendoModel.setValorRecebido(valorRecebido);
		dividendoRepository.save(dividendoModel);
		ResponseGenericoDTO response = new ResponseGenericoDTO();
		response.setMensagem("O dividendo foi lançado com sucesso no banco de dados.");
		return response;
	}

}
