package com.jgonite.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jgonite.service.CarteiraAcoesService;
import com.jgonite.service.FundamentusService;

@Controller
@RequestMapping
public class RecursosFrontController {
	
	@Autowired private CarteiraAcoesService carteiraAcoesService;	
	@Autowired private FundamentusService fundamentusService;	
	
	@GetMapping
	public String elementosIndex(Model model) throws IOException {
		model.addAttribute("acoesDisponiveis", fundamentusService.listarAcoesDeUmSetor(""));
		model.addAttribute("acoesDaCarteira", carteiraAcoesService.calcularCarteira());
		return "index";
	}
	
	@GetMapping("/magic-formula")
	public String elementosMagicFormula(Model model) throws IOException {
		model.addAttribute("ranking", fundamentusService.getRanking());
		return "magic-formula";
	}

}
