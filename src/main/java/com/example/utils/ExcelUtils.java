package com.example.utils;

import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.example.entity.CitizenPlan;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelUtils {

	public void genrate(HttpServletResponse response,List<CitizenPlan> records) throws Exception {
		Workbook workBook= new XSSFWorkbook();
	      Sheet sheet= workBook.createSheet("plan-data");
	      Row headerRow=sheet.createRow(0);
	      headerRow.createCell(0).setCellValue("CITIZEN_ID");
	      headerRow.createCell(1).setCellValue("CITIZEN_NAME");
	      headerRow.createCell(2).setCellValue("GENDER");
	      headerRow.createCell(3).setCellValue("PLAN_NAME");
	      headerRow.createCell(4).setCellValue("PLAN_STATUS");
	      headerRow.createCell(5).setCellValue("PLAN_START_DATE");
	      headerRow.createCell(6).setCellValue("PLAN_END_DATE");
	      headerRow.createCell(7).setCellValue("BENIFIT_AMT");
	      int dataRowIndex=1;
	      for(CitizenPlan plan:records) {
	    	  Row dataRow =sheet.createRow(dataRowIndex);
	    	  dataRow.createCell(0).setCellValue(plan.getCitizenId());
	    	  dataRow.createCell(1).setCellValue(plan.getCitizenName());
	    	  dataRow.createCell(2).setCellValue(plan.getGender());
	    	  dataRow.createCell(3).setCellValue(plan.getPlanName());
	    	  dataRow.createCell(4).setCellValue(plan.getPlanStatus());
	    	  
	    	  if(plan.getPlanStartDate()!=null) {
	    		  dataRow.createCell(5).setCellValue(plan.getPlanStartDate());
	    	  }else {
	    		  dataRow.createCell(5).setCellValue("N/A");
	    	  }
	   
	    	  if(plan.getPlanEndDate()!=null) {
	    		  dataRow.createCell(6).setCellValue(plan.getPlanEndDate());
	    	  }else {
	    		  dataRow.createCell(6).setCellValue("N/A");
	    	  }
	  
	    	  if(plan.getBenifitAmount()!=null) {
	    		  dataRow.createCell(7).setCellValue(plan.getBenifitAmount());
	    	  }else {
	    		  dataRow.createCell(7).setCellValue("N/A");
	    	  }
	    	  dataRowIndex++;
	    	  
	      }
	     ServletOutputStream outPutStream = response.getOutputStream();
	     workBook.write(outPutStream);
	     workBook.close();
	}
}
