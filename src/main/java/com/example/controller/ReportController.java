package com.example.controller;

import java.util.List;

import org.apache.catalina.filters.ExpiresFilter.XHttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.entity.CitizenPlan;
import com.example.search.SearchRequest;
import com.example.service.ReportService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class ReportController {

	@Autowired
	private ReportService service;
	
	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("search", new SearchRequest());
		init(model);
		return "index";
		}

	private void init(Model model) {
		model.addAttribute("plans", service.getPlanNames());
		model.addAttribute("status", service.getPlanStatus());
	}
	
	@PostMapping("/search")
	public String handleFormRequest( @ModelAttribute("search") SearchRequest search , Model model ) {
		System.out.println(search);
		List<CitizenPlan> plan=service.search(search);
		model.addAttribute("plan", plan);
		init(model);
		return "index";
		
	}
	
	@GetMapping("/excel")
	public void dwonloadExcel(HttpServletResponse response) throws Exception {
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition", "attachment; filename=plans.xlsx");
		service.exportExcel(response);
	}
	
	@GetMapping("/pdf")
	public void dwonloadPdf(HttpServletResponse response) throws Exception {
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", "attachment; filename=plans.pdf");
		service.exportExcel(response);
	}
	}
