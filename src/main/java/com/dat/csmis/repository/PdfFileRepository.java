package com.dat.csmis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dat.csmis.entity.EmployeeEntity;
import com.dat.csmis.entity.PdfFileEntity;


public interface PdfFileRepository extends JpaRepository<PdfFileEntity, Integer> {
	@Query("update PdfFileEntity p set p.pdfName =?1  where p.id=?2")
	void updateName(PdfFileEntity pdfFile,Integer id);
//	@Query(value="select p from PdfFileEntity p limit 1", nativeQuery=true)
//    public PdfFileEntity findOne();
}
