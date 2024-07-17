package com.example.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.example.entity.CitizenPlan;
import com.example.repository.CitizenPlanRepository;
import com.example.search.SearchRequest;
import com.example.utils.ExcelUtils;
import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImplemention  implements ReportService{
	
	@Autowired
	private CitizenPlanRepository repository;
	
	@Autowired
	private ExcelUtils excel;

	@Override
	public List<String> getPlanNames() {
	
	return repository.getPlanNames();
	}

	@Override
	public List<String> getPlanStatus() {
		// TODO Auto-generated method stub
		return repository.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {
		// TODO Auto-generated method stub
		CitizenPlan entity= new CitizenPlan();
		if(null!=request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}
		
		if(null!=request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}
		
		if(null!=request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}
		
		if(null!=request.getStartDate() && !"".equals(request.getStartDate())) {
			String startDate=request.getStartDate();
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate= LocalDate.parse(startDate,formatter);
			entity.setPlanStartDate(localDate);
		}
		
		if(null!=request.getEndDate() && !"".equals(request.getEndDate())) {
			String endDate=request.getEndDate();
			DateTimeFormatter formatter=DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate localDate= LocalDate.parse(endDate,formatter);
			entity.setPlanStartDate(localDate);
		}
		return repository.findAll(Example.of(entity));
	}

	@Override
	public boolean exportExcel(HttpServletResponse reponse) throws Exception {
		  List<CitizenPlan> plans=repository.findAll();
		  excel.genrate(reponse, plans);
		 
		 return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse reponse) throws Exception{
		// TODO Auto-generated method stub
		Document document = new Document(PageSize.A4);
		PdfWriter.getInstance(document, reponse.getOutputStream());
		document.open();
		Paragraph p = new Paragraph("CitizenPlan");
		document.add(p);
		
		 PdfPTable table = new PdfPTable(8);
		 table.addCell("CITIZEN_ID");
		 table.addCell("CITIZEN_NAME");
		 table.addCell("CITIZEN_GENDER");
		 table.addCell("CITIZEN_PLAN");
		 table.addCell("PLAN_STATUS");
		 table.addCell("PLAN_START_DATE");
		 table.addCell("PLAN_END_DATE");
		 table.addCell("PLAN_BENIFIT_AMT");
		 List<CitizenPlan> records= repository.findAll();
		 for(CitizenPlan plan:records) {
			 table.addCell(String.valueOf(plan.getCitizenId()));
			 table.addCell(String.valueOf(plan.getCitizenName()));
			 table.addCell(String.valueOf(plan.getGender()));
			 table.addCell(String.valueOf(plan.getPlanName()));
			 table.addCell(String.valueOf(plan.getPlanStatus()));
			 table.addCell(String.valueOf(plan.getPlanStartDate()));
			 table.addCell(String.valueOf(plan.getPlanEndDate()));
			 table.addCell(String.valueOf(plan.getBenifitAmount()));
			 
		 }
		 
		 document.add(table);
		 
		document.close();
	       
		return true;
	}

}
