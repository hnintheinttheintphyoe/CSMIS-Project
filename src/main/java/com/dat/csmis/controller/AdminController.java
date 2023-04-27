package com.dat.csmis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dat.csmis.entity.PdfFileEntity;
import com.dat.csmis.entity.RestaurantEntity;
import com.dat.csmis.model.RestaurantModel;
import com.dat.csmis.service.ImportService;
import com.dat.csmis.service.RestaurantService;

@Controller
public class AdminController {
	
	@Autowired 
	ImportService service;
	@Autowired
	RestaurantService serviceR;
	
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
			m.addAttribute("messageEmp", "Successfully Imported..!");
			return "import";
		}else {
			m.addAttribute("color", "alert alert-danger alert-dismissible fade show");
			m.addAttribute("messageEmp", "Import Failed..!");
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
			m.addAttribute("messageHoli", "Successfully Imported..!");
			return "import";
		}else {
			m.addAttribute("color", "alert alert-danger alert-dismissible fade show");
			m.addAttribute("messageHoli", "Import Failed..!");
			return "import";

		}
	}
	@PostMapping("/admin/doorlog")
	public String doorFile(@RequestParam("doorLog")MultipartFile file, Model m) {
		boolean condition=service.importDoorlog(file);
		
		if(condition) {
			m.addAttribute("color", "alert alert-success alert-dismissible fade show");
			m.addAttribute("messageDoor", "Successfully Imported..!");
			return "import";
		}else {
			m.addAttribute("color", "alert alert-danger alert-dismissible fade show");
			m.addAttribute("messageDoor", "Import Failed..!");
			return "import";

		}
	}
	@GetMapping("/admin/res")
	public ModelAndView resturant() {
		return new ModelAndView("adminRestaurant","res", new RestaurantModel());
	}
	@PostMapping("/admin/doRes")
	public String doRestaurant(@ModelAttribute("res")RestaurantModel rm, RedirectAttributes ra) {
		if(rm!=null) {
			RestaurantEntity entity= new RestaurantEntity();
			entity.setName(rm.getName());
			entity.setEmail(rm.getEmail());
			entity.setPhone(rm.getPhone());
			entity.setReceiveBy(rm.getReceiveBy());
			entity.setCost(rm.getCost());
			entity.setAddress(rm.getAddress());
			entity.setStatus("InActive");
			serviceR.save(entity);
			int a=serviceR.count();
			serviceR.updateA("Active", a);
			ra.addAttribute("errorS", "Successfully added..!!");
			return "redirect:/admin/res";	
		}else {
			ra.addAttribute("errorF", "Adding Restaurant Failed!");
			return "redirect:/admin/res";	
		}
			
	}

}


























