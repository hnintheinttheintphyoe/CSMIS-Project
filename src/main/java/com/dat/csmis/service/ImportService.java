package com.dat.csmis.service;


import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dat.csmis.entity.DoorLogEntity;
import com.dat.csmis.entity.EmployeeEntity;
import com.dat.csmis.entity.HolidaysEntity;
import com.dat.csmis.repository.DoorLogRepository;
import com.dat.csmis.repository.EmployeeRepository;
import com.dat.csmis.repository.HolidaysRepository;
import com.dat.csmis.security.SecurityConfig;

@Service
public class ImportService {
	
	@Autowired
	EmployeeRepository repoE;
	@Autowired
	HolidaysRepository repoH;
	@Autowired
	DoorLogRepository repoD;
	@Autowired
	SecurityConfig sec;
	
	
	public boolean importEmployee(MultipartFile file){
		boolean isFirstRow= true;
		List<EmployeeEntity> newExcel = new ArrayList<EmployeeEntity>();
		BCryptPasswordEncoder encode= sec.encoder();
		Workbook wb;
		try {
			wb = WorkbookFactory.create(file.getInputStream());
		
		System.out.println("Workbook has " + wb.getNumberOfSheets() + " Sheets : ");
        for(Sheet sheet: wb) {
            System.out.println("=> " + sheet.getSheetName());
            for (Row row: sheet) {
            	
            	if(isFirstRow) {
                    isFirstRow = false;
                    continue;
                }
            	
            	int StaffId = (int) row.getCell(0).getNumericCellValue();
            	int doorLog= (int) row.getCell(1).getNumericCellValue();
            	String name = row.getCell(2).getStringCellValue();
            	String email= row.getCell(3).getStringCellValue();
            	int password= (int) row.getCell(4).getNumericCellValue();
            	String team= row.getCell(5).getStringCellValue();
            	String role= row.getCell(6).getStringCellValue();
            	String dept= row.getCell(7).getStringCellValue();
            	String division= row.getCell(8).getStringCellValue();
            	String status= row.getCell(9).getStringCellValue();
            	
        		EmployeeEntity entity = new EmployeeEntity();
        		entity.setStaffId(String.valueOf(StaffId));
            	entity.setDoorLog(String.valueOf(doorLog));
            	entity.setName(name);
            	entity.setEmail(email);
            	entity.setPassword(encode.encode(String.valueOf(password)));
            	entity.setTeam(team);
            	entity.setRole(role);
            	entity.setDept(dept);
            	entity.setDivision(division);
            	entity.setStatus(status);
            	entity.setPhoto("avatar.png");
            	newExcel.add(entity);
            	Optional<EmployeeEntity> emp=repoE.findByStaffId(String.valueOf(StaffId));
            	
            	if(emp.isPresent()) {         		            		
            		EmployeeEntity ee=emp.get();
            		 try {
                		repoE.update(entity.getStaffId(),entity.getDoorLog(),entity.getEmail(),entity.getName(),
                					entity.getPassword(),entity.getTeam(),entity.getRole(),entity.getDept(),
                					entity.getDivision(),entity.getStatus(), entity.getPhoto(),ee.getId());
                	 }catch(Exception e) {
                		System.out.println("error on 1 is "+e.getMessage());
                		
                		return false;
                	}
            		
            	}
            	else{      	
                	try {
                		repoE.save(entity);
                	}catch(Exception e) {
                		System.out.println("error on 2 is "+e.getMessage());
                		return false;
                	}
            	}	
            }
        }
        } catch (EncryptedDocumentException | IOException e) {
        	System.out.println("error on 3 is "+e.getMessage());
			return false;
		} catch (InvalidFormatException e) {
			System.out.println("error on 4 is "+e.getMessage());
			return false;
		}
		
		
		List<EmployeeEntity> oldEmployeeList = repoE.findAll();

		for (EmployeeEntity oldEmployee : oldEmployeeList) {
		    boolean found = false;
		    for (EmployeeEntity newEmployee : newExcel) {
		        if (oldEmployee.getStaffId().equals(newEmployee.getStaffId())) {
		            found = true;
		            break;
		        }
		    }
		    
		    if (!found) {
		        oldEmployee.setStatus("Inactive");
		        repoE.save(oldEmployee);
		    }
		}		
        return true;
	}
	
	public boolean importHoliday(MultipartFile file){
		boolean isFirstRow= true;
		Workbook wb;
		try {
			wb = WorkbookFactory.create(file.getInputStream());
		
        for(Sheet sheet: wb) {
            for (Row row: sheet) {
            	
            	if(isFirstRow) {
                    isFirstRow = false;
                    continue;
                }
            	
            	Date date= row.getCell(0).getDateCellValue();
            	String days=row.getCell(1).getStringCellValue();
            	
            	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            	String dateString = df.format(date);

            	HolidaysEntity entity = new HolidaysEntity();
        		entity.setDate(dateString);
        		entity.setHolidays(days);
        		            	
            	
            	repoH.save(entity);	
            }
        }
        } catch (Exception e) {
        	System.out.println("error is "+e.getMessage());
			return false;
        }
		
			
        return true;
	}
	public boolean importDoorlog(MultipartFile file){
		boolean isFirstRow= true;
		Workbook wb;
		try {
			wb = WorkbookFactory.create(file.getInputStream());
		
        for(Sheet sheet: wb) {
            for (Row row: sheet) {
            	
            	if(isFirstRow) {
                    isFirstRow = false;
                    continue;
                }
            	
            	Date date= row.getCell(0).getDateCellValue();
            	int doorLog= (int) row.getCell(1).getNumericCellValue();
            	
            	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            	String dateString = df.format(date);

            	DoorLogEntity entity = new DoorLogEntity();
            	entity.setDate(dateString);
        		entity.setDoorLog(String.valueOf(doorLog));
        		            	
            	
            	repoD.save(entity);	
            }
        }
        } catch (Exception e) {
        	System.out.println("error is "+e.getMessage());
			return false;
        }
		
			
        return true;
	}

}

