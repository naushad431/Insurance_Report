package com.example.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.entity.CitizenPlan;
import com.example.repository.CitizenPlanRepository;

@Component
public class DataLoader  implements ApplicationRunner{
	
	
	@Autowired
	private CitizenPlanRepository repository;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		repository.deleteAll();
		
		CitizenPlan c1= new CitizenPlan();
		 c1.setCitizenName("Naushad");
		 c1.setGender("Male");
		 c1.setPlanName("Cash");
		 c1.setPlanStatus("Approved");
		 c1.setPlanStartDate(LocalDate.now());
		 c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		 c1.setBenifitAmount(50000.00);
		 
		 CitizenPlan c2= new CitizenPlan();
		 c2.setCitizenName("Saleema");
		 c2.setGender("FeMale");
		 c2.setPlanName("Cash");
		 c2.setPlanStatus("Approved");
		 c2.setPlanStartDate(LocalDate.now());
		 c2.setPlanEndDate(LocalDate.now().plusMonths(6));
		 c2.setBenifitAmount(70000.00);
		 
		 CitizenPlan c3= new CitizenPlan();
		 c3.setCitizenName("Doe");
		 c3.setGender("Male");
		 c3.setPlanName("Cash");
		 c3.setPlanStatus("Denail");
		 c3.setDenialReason("RentalIncome");
		 
		 CitizenPlan c4= new CitizenPlan();
		 c4.setCitizenName("Cathy");
		 c4.setGender("FeMale");
		 c4.setPlanName("Cash");
		 c4.setPlanStatus("Denail");
		 c4.setDenialReason("RentalIncome");
		 
		 CitizenPlan c5= new CitizenPlan();
		 c5.setCitizenName("Smith");
		 c5.setGender("Male");
		 c5.setPlanName("Cash");
		 c5.setPlanStatus("Terminated");
		 c5.setPlanStartDate(LocalDate.now().minusMonths(4));
		 c5.setPlanEndDate(LocalDate.now().plusMonths(6));
		 c5.setBenifitAmount(5000.00);
		 c5.setTerminatedDate(LocalDate.now());
		 c5.setTerminationReason("Employeed");
		 
		 CitizenPlan c6= new CitizenPlan();
		 c6.setCitizenName("Sona");
		 c6.setGender("Female");
		 c6.setPlanName("Cash");
		 c6.setPlanStatus("Terminated");
		 c6.setPlanStartDate(LocalDate.now().minusMonths(4));
		 c6.setPlanEndDate(LocalDate.now().plusMonths(6));
		 c6.setBenifitAmount(1000.00);
		 c6.setTerminatedDate(LocalDate.now());
		 c6.setTerminationReason("Employeed");
		 
		 CitizenPlan c7= new CitizenPlan();
		 c7.setCitizenName("Ahmad");
		 c7.setGender("Male");
		 c7.setPlanName("Food");
		 c7.setPlanStatus("Approved");
		 c7.setPlanStartDate(LocalDate.now());
		 c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		 c7.setBenifitAmount(450000.00);
		 
		 CitizenPlan c8= new CitizenPlan();
		 c8.setCitizenName("Aliya");
		 c8.setGender("FeMale");
		 c8.setPlanName("Food");
		 c8.setPlanStatus("Approved");
		 c8.setPlanStartDate(LocalDate.now());
		 c8.setPlanEndDate(LocalDate.now().plusMonths(6));
		 c8.setBenifitAmount(70000.00);
		 
		 CitizenPlan c9= new CitizenPlan();
		 c9.setCitizenName("Janu");
		 c9.setGender("Male");
		 c9.setPlanName("Food");
		 c9.setPlanStatus("Denail");
		 c9.setDenialReason("Property");
		 
		 CitizenPlan c10= new CitizenPlan();
		 c10.setCitizenName("Neha");
		 c10.setGender("FeMale");
		 c10.setPlanName("Food");
		 c10.setPlanStatus("Denail");
		 c10.setDenialReason("RentalIncome");
		 
		 CitizenPlan c11= new CitizenPlan();
		 c11.setCitizenName("Smith");
		 c11.setGender("Male");
		 c11.setPlanName("Food");
		 c11.setPlanStatus("Terminated");
		 c11.setPlanStartDate(LocalDate.now().minusMonths(4));
		 c11.setPlanEndDate(LocalDate.now().plusMonths(6));
		 c11.setBenifitAmount(9000.00);
		 c11.setTerminatedDate(LocalDate.now());
		 c11.setTerminationReason("Retaired");
		 
		 CitizenPlan c12= new CitizenPlan();
		 c12.setCitizenName("Sona");
		 c12.setGender("Female");
		 c12.setPlanName("Food");
		 c12.setPlanStatus("Terminated");
		 c12.setPlanStartDate(LocalDate.now().minusMonths(4));
		 c12.setPlanEndDate(LocalDate.now().plusMonths(6));
		 c12.setBenifitAmount(1000.00);
		 c12.setTerminatedDate(LocalDate.now());
		 c12.setTerminationReason("Reataired");
		 
		 
		 CitizenPlan c13= new CitizenPlan();
		 c13.setCitizenName("Ahmad");
		 c13.setGender("Male");
		 c13.setPlanName(" Medical");
		 c13.setPlanStatus("Approved");
		 c13.setPlanStartDate(LocalDate.now());
		 c13.setPlanEndDate(LocalDate.now().plusMonths(6));
		 c13.setBenifitAmount(450000.00);
		 
		 CitizenPlan c14= new CitizenPlan();
		 c14.setCitizenName("Aliya");
		 c14.setGender("FeMale");
		 c14.setPlanName(" Medical");
		 c14.setPlanStatus("Approved");
		 c14.setPlanStartDate(LocalDate.now());
		 c14.setPlanEndDate(LocalDate.now().plusMonths(6));
		 c14.setBenifitAmount(70000.00);
		 
		 CitizenPlan c15= new CitizenPlan();
		 c15.setCitizenName("Janu");
		 c15.setGender("Male");
		 c15.setPlanName("Food");
		 c15.setPlanStatus("Denail");
		 c15.setDenialReason("Property");
		 
		 CitizenPlan c16= new CitizenPlan();
		 c16.setCitizenName("Neha");
		 c16.setGender("FeMale");
		 c16.setPlanName(" Medical");
		 c16.setPlanStatus("Denail");
		 c16.setDenialReason("RentalIncome");
		 
		 CitizenPlan c17= new CitizenPlan();
		 c17.setCitizenName("Smith");
		 c17.setGender("Male");
		 c17.setPlanName(" Medical");
		 c17.setPlanStatus("Terminated");
		 c17.setPlanStartDate(LocalDate.now().minusMonths(4));
		 c17.setPlanEndDate(LocalDate.now().plusMonths(6));
		 c17.setBenifitAmount(9000.00);
		 c17.setTerminatedDate(LocalDate.now());
		 c17.setTerminationReason("Retaired");
		 
		 CitizenPlan c18= new CitizenPlan();
		 c18.setCitizenName("Sona");
		 c18.setGender("Female");
		 c18.setPlanName(" Medical");
		 c18.setPlanStatus("Terminated");
		 c18.setPlanStartDate(LocalDate.now().minusMonths(4));
		 c18.setPlanEndDate(LocalDate.now().plusMonths(6));
		 c18.setBenifitAmount(1000.00);
		 c18.setTerminatedDate(LocalDate.now());
		 c18.setTerminationReason("Reataired");
		 
		 
		 CitizenPlan c19= new CitizenPlan();
		 c19.setCitizenName("Ahmad");
		 c19.setGender("Male");
		 c19.setPlanName("Employment");
		 c19.setPlanStatus("Approved");
		 c19.setPlanStartDate(LocalDate.now());
		 c19.setPlanEndDate(LocalDate.now().plusMonths(6));
		 c19.setBenifitAmount(450000.00);
		 
		 CitizenPlan c20= new CitizenPlan();
		 c20.setCitizenName("Aliya");
		 c20.setGender("FeMale");
		 c20.setPlanName("Employment");
		 c20.setPlanStatus("Approved");
		 c20.setPlanStartDate(LocalDate.now());
		 c20.setPlanEndDate(LocalDate.now().plusMonths(6));
		 c20.setBenifitAmount(70000.00);
		 
		 CitizenPlan c21= new CitizenPlan();
		 c21.setCitizenName("Janu");
		 c21.setGender("Male");
		 c21.setPlanName("Employment");
		 c21.setPlanStatus("Denail");
		 c21.setDenialReason("Govt Employee");
		 
		 CitizenPlan c22= new CitizenPlan();
		 c22.setCitizenName("Neha");
		 c22.setGender("FeMale");
		 c22.setPlanName("Employment");
		 c22.setPlanStatus("Denail");
		 c22.setDenialReason("Govet Employee");
		 
		 CitizenPlan c23= new CitizenPlan();
		 c23.setCitizenName("Smith");
		 c23.setGender("Male");
		 c23.setPlanName("Employment");
		 c23.setPlanStatus("Terminated");
		 c23.setPlanStartDate(LocalDate.now().minusMonths(4));
		 c23.setPlanEndDate(LocalDate.now().plusMonths(6));
		 c23.setBenifitAmount(9000.00);
		 c23.setTerminatedDate(LocalDate.now());
		 c23.setTerminationReason("Retaired");
		 
		 CitizenPlan c24= new CitizenPlan();
		 c24.setCitizenName("Sona");
		 c24.setGender("Female");
		 c24.setPlanName(" Medical");
		 c24.setPlanStatus("Terminated");
		 c24.setPlanStartDate(LocalDate.now().minusMonths(4));
		 c24.setPlanEndDate(LocalDate.now().plusMonths(6));
		 c24.setBenifitAmount(1000.00);
		 c24.setTerminatedDate(LocalDate.now());
		 c24.setTerminationReason("Reataired");
		 
		 List<CitizenPlan> list=Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24);
		 repository.saveAll(list);
		 
	}

}
