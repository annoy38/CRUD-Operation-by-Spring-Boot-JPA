package com.CRUDoperationInSpring.CRUDoperation.controllerPack;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CRUDoperationInSpring.CRUDoperation.repositoryPACK.IstudentRepository;
import com.CRUDoperationInSpring.CRUDoperation.studentPACK.studentClass;

@Controller
public class controllerClass {
	
	@Autowired
	IstudentRepository studentRepo;
	
	@ModelAttribute
	public void header(Model title) {
		title.addAttribute("title", "Student Info");
	}

	@GetMapping("/home")
	public String homePage() {
		return "mainPage.html";
	}
	
	@PostMapping("/savedata")
	public String saveData(@ModelAttribute studentClass students) { 
		studentRepo.save(students);
		return "redirect:/home";
	}
	
	@SuppressWarnings("deprecation")
	@PostMapping("/findById")
	public String findById(@RequestParam String sId, Model m) {
		studentClass s = studentRepo.getOne(sId);
		m.addAttribute("student", s);
		return "studentPage.html";
	}
	
	@GetMapping("/deletedata")
	public String deleteById(@RequestParam String sId, Model m) {
		studentRepo.deleteById(sId);
		return "redirect:/home";
		
	}
	
	@SuppressWarnings("deprecation")
	@PostMapping("/updatedata")
	public String updateData(@ModelAttribute studentClass student) {
		studentClass stu = studentRepo.getOne(student.getsId());
		//stu.setsId(student.getsId());
		stu.setsName(student.getsName());
		stu.setsSection(student.getsSection());
		stu.setsBatch(student.getsBatch());
		
		studentRepo.save(stu);
		return "mainPage.html";
	}
	
	@PostMapping("/findbybatch")
	public String findByBatch(@RequestParam String sSection, Model m) {
		
		List<studentClass> section = studentRepo.findBysSection(sSection);
		
		m.addAttribute("students", section);
		
		return "sections.html";
	}
}
