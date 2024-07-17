package com.example.service;

import java.util.List;

import com.example.entity.CitizenPlan;
import com.example.search.SearchRequest;

import jakarta.servlet.http.HttpServletResponse;

public interface ReportService {

	public List<String> getPlanNames();
	
	public List<String> getPlanStatus();
	
	public List<CitizenPlan> search( SearchRequest request);
	
	public boolean exportPdf (HttpServletResponse reponse) throws Exception;
	
	public boolean exportExcel(HttpServletResponse reponse) throws Exception;
	
	
}
