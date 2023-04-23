package com.dat.csmis.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dat.csmis.entity.PdfFileEntity;
import com.dat.csmis.service.PdfFileService;


@Controller
public class PdfFileUploadController {
	@Autowired
	private PdfFileService pfs;
//	@GetMapping("/file")
//	public String display(Model model) {
//		model.addAttribute("image",new PdfFileEntity());
//		return "import";
//	}
	@PostMapping("/doFile")
	public String done(@RequestParam("pdf") MultipartFile pdfFile,Model model,RedirectAttributes redirectAttributes) throws IOException{
		//System.out.print(pdfFile);
	 PdfFileEntity pdf=new PdfFileEntity();
		if (!pdfFile.isEmpty()) {
			String fileName = StringUtils.cleanPath(pdfFile.getOriginalFilename());
			Path path = Paths.get("src/main/resources/static/file/" + fileName);
			System.out.print(path);
			if (!Files.exists(path.getParent())) {
				Files.createDirectories(path.getParent());
			}

//			Files.copy(pdfFile.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
			pdf.setPdfName("file/"+fileName);
			System.out.print(fileName);

		}
		
			if(pfs.count()==0) {
				pfs.save(pdf);
				 redirectAttributes.addFlashAttribute("message", "Success");
				    redirectAttributes.addFlashAttribute("alertClass", "alert-success");
			}
			else {
				List<PdfFileEntity> list=pfs.getAllUser();
				for(PdfFileEntity li:list) {
					//System.out.print(li.getId());
					pfs.delete(li.getId());
					pfs.save(pdf);
					 redirectAttributes.addFlashAttribute("message", "Successful!Your menu import ");
					    redirectAttributes.addFlashAttribute("alertClass", "alert-success");
				}
			
			}
		System.out.print(pfs.count());
		
		
		
		return "redirect:/import";
		
	}
   
}
