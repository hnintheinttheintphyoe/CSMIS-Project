package com.dat.csmis.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dat.csmis.entity.PdfFileEntity;
import com.dat.csmis.repository.PdfFileRepository;

@Service
public class PdfFileService {
	@Autowired
	PdfFileRepository pdfRepo;

	public void save(PdfFileEntity pdfFile) {
		pdfRepo.save(pdfFile);
	}

	public long count() {
		return pdfRepo.count();
	}

	public List<PdfFileEntity> getAllUser() {
		List<PdfFileEntity> list = (List<PdfFileEntity>) pdfRepo.findAll();
		return list;
	}

	public void update(PdfFileEntity pdfFile, Integer id) {
		pdfRepo.updateName(pdfFile, id);
	}

	public void delete(Integer i) {
		pdfRepo.deleteById(i);
	}
	
	public Optional<PdfFileEntity> findOne(Integer id) {
		return pdfRepo.findById(id);
	}
}
