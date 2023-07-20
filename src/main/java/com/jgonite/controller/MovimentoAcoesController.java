package com.jgonite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jgonite.dto.MovimentoAcoesRequestDTO;
import com.jgonite.dto.ResponseGenericoDTO;
import com.jgonite.service.MovimentoAcoesService;

@Controller
@RequestMapping("/api/v1/movimento-acoes")
public class MovimentoAcoesController {
	
	@Autowired private MovimentoAcoesService movimentoAcoesService;

	
	@PostMapping("/comprar")
	public ResponseEntity<ResponseGenericoDTO> comprarAcao(
			@RequestBody MovimentoAcoesRequestDTO requestDTO) {
				try {
					return ResponseEntity.ok(movimentoAcoesService.executarCompraVenda(requestDTO));
				} catch (Exception e) {
					ResponseGenericoDTO errorResponse = new ResponseGenericoDTO();
					errorResponse.setMensagem(e.getMessage());
					return ResponseEntity.badRequest().body(errorResponse);
				}
	}
	
}
