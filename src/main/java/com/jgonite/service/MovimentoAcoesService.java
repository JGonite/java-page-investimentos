package com.jgonite.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jgonite.dto.MovimentoAcoesRequestDTO;
import com.jgonite.dto.ResponseGenericoDTO;
import com.jgonite.model.MovimentoAcoesModel;
import com.jgonite.repository.MovimentosRepository;
import com.jgonite.util.StringUtils;

import static com.jgonite.util.StringUtils.*;

@Service
public class MovimentoAcoesService {
	
	@Autowired
	private MovimentosRepository movimentoRepository;
	
	
	public ResponseGenericoDTO executarCompraVenda(MovimentoAcoesRequestDTO requestDTO) {
		
		String msg1 = "VENDER".equalsIgnoreCase(requestDTO.getCompraVenda()) ? "venda" : "compra";
		String msg2 = "VENDER".equalsIgnoreCase(requestDTO.getCompraVenda()) ? "recuperado" : "investido";
		Integer sinalNumeroAcoes = "VENDER".equalsIgnoreCase(requestDTO.getCompraVenda()) ? -1 : 1;
		
		BigDecimal precoAcao = new BigDecimal( trocarVirgulaPorPonto( requestDTO.getPrecoAcao() )).setScale(2);
		MovimentoAcoesModel movimentoModel = new MovimentoAcoesModel();
		movimentoModel.setDataMovimento(requestDTO.getDataMovimento() == null ?  LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS) : StringUtils.YYYYMMDDparaLocalDateTime(requestDTO.getDataMovimento()));
		movimentoModel.setNomeAcao(requestDTO.getAcao());
		movimentoModel.setNumeroAcoes(sinalNumeroAcoes*requestDTO.getQtdAcoes()); 
		movimentoModel.setValorAcao(requestDTO.getPrecoAcao());
		movimentoRepository.save(movimentoModel);
		
		String valor = precoAcao.multiply(BigDecimal.valueOf(requestDTO.getQtdAcoes())).toPlainString();
		
		ResponseGenericoDTO response = new ResponseGenericoDTO();
		response.setMensagem("A " + msg1 + " foi efetuada com sucesso e lançada no banco de dados."
				+ " O valor total " + msg2 + " foi de R$ ".concat(valor));
		return response;
	}

}
