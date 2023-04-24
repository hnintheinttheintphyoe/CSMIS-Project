package com.dat.csmis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.dat.csmis.entity.PdfFileEntity;

import com.dat.csmis.service.ImportService;

@Controller
public class AdminController {
	
	@Autowired ImportService service;
	
	@GetMapping("/import")
	public String fileImport(Model model) {
		model.addAttribute("image",new PdfFileEntity());
		return "import";
	}
	@PostMapping("/admin/uploadUser")
	public String userFile(@RequestParam("userFile")MultipartFile file, Model m) {
		boolean condition=service.importEmployee(file);
		if(condition) {
			m.addAttribute("color", "alert alert-success alert-dismissible fade show");
			m.addAttribute("messageEmp", "Success..!");
			return "import";
		}else {
			m.addAttribute("color", "alert alert-danger alert-dismissible fade show");
			m.addAttribute("messageEmp", "Failed..!");
			return "import";

		}
	}
	@GetMapping("/adminRegister")
	public String displayAdminRegister() {
		return "adminRegister";
	}
	@PostMapping("/admin/holiday")
	public String dayFile(@RequestParam("dayFile")MultipartFile file, Model m) {
		boolean condition=service.importHoliday(file);
		if(condition) {
			m.addAttribute("color", "alert alert-success alert-dismissible fade show");
			m.addAttribute("messageHoli", "Success..!");
			return "import";
		}else {
			m.addAttribute("color", "alert alert-danger alert-dismissible fade show");
			m.addAttribute("messageHoli", "Failed..!");
			return "import";

		}
	}
	@PostMapping("/admin/doorlog")
	public String doorFile(@RequestParam("doorLog")MultipartFile file, Model m) {
		boolean condition=service.importDoorlog(file);
		
		if(condition) {
			m.addAttribute("color", "alert alert-success alert-dismissible fade show");
			m.addAttribute("messageDoor", "Success..!");
			return "import";
		}else {
			m.addAttribute("color", "alert alert-danger alert-dismissible fade show");
			m.addAttribute("messageDoor", "Failed..!");
			return "import";

		}
	}

}
