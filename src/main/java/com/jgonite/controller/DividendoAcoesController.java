package com.jgonite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jgonite.dto.DividendoAcoesGanharRequestDTO;
import com.jgonite.dto.ResponseGenericoDTO;
import com.jgonite.service.DividendoAcoesService;

@Controller
@RequestMapping("/api/v1/dividendo-acoes")
public class DividendoAcoesController {
	
	@Autowired private DividendoAcoesService dividendoAcoesService;

	
	@PostMapping("/ganhar")
	public ResponseEntity<ResponseGenericoDTO> comprarAcao(
			@RequestBody DividendoAcoesGanharRequestDTO requestDTO) {
				try {
					return ResponseEntity.ok(dividendoAcoesService.ganharDividendo(requestDTO));
				} catch (Exception e) {
					ResponseGenericoDTO errorResponse = new ResponseGenericoDTO();
					errorResponse.setMensagem(e.getMessage());
					return ResponseEntity.badRequest().body(errorResponse);
				}
	}
	
}
