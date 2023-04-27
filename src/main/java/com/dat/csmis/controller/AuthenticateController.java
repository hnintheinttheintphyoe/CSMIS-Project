package com.dat.csmis.controller;

import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.dat.csmis.entity.EmployeeEntity;
import com.dat.csmis.entity.PdfFileEntity;
import com.dat.csmis.repository.AuthenticateRepository;
import com.dat.csmis.service.PdfFileService;

@Controller
public class AuthenticateController {

	@Autowired
	private PdfFileService pfs;
	@Autowired
	private AuthenticateRepository repo;
	
	@GetMapping("/user/dashboard")
	public String user(Model model) {
		
		List<PdfFileEntity> pdfList=pfs.getAllUser();
		for(PdfFileEntity li:pdfList) {
			
			Optional<PdfFileEntity> pdf = pfs.findOne(li.getId());
			if(pdf.isPresent()) {
				model.addAttribute("pdf",pdf.get());
			}
			else {
				System.out.println("file is null");
			}
		}
		
		return "userMenu";
	}
	@GetMapping("/admin/dashboard")
	public String admin() {
		return "adminDashboard";
	}
	@GetMapping("/login")
	public String showLogin() {
		return "login";
	}
	@GetMapping("/roleValidation")
	public String validateRole(Authentication auth, HttpServletRequest req) {
		String role=null;
		
		GrantedAuthority authority = auth.getAuthorities().stream()
										 .findFirst().orElse(null);
		if (authority != null) {
            role = authority.getAuthority().substring("ROLE_".length());
        }
		EmployeeEntity entity=repo.findByName(auth.getName());
		if ("ADMIN".equals(role)) {
			req.getSession().setAttribute("name", entity.getName());
			req.getSession().setAttribute("photo", entity.getPhoto());
			req.getSession().setAttribute("id", entity.getId());
            return "redirect:/admin/dashboard";
        } else if ("USER".equals(role)) {
        	return "redirect:/user/dashboard";
        } 
			else {
        	return "login";
        }
	}

	
}
