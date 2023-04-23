package com.dat.csmis.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
public class EmployeeEntity implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true , nullable = false)
	private String staffId;
	@Column(unique = true , nullable = false)
	private String doorLog;
	@Column(nullable = false)
	private String name;
	@Column(unique = true , nullable = false)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(nullable = false)
	private String team;
	@Column(nullable = false)
	private String role;
	@Column(nullable = false)
	private String dept;
	@Column(nullable = false)
	private String division;
	@Column(nullable = false)
	private String status;
	
	
	
	
	
	public EmployeeEntity(long id, String staffId, String doorLog, String name, String email, String password,
			String team, String role, String dept, String division, String status) {
		this.id = id;
		this.staffId = staffId;
		this.doorLog = doorLog;
		this.name = name;
		this.email = email;
		this.password = password;
		this.team = team;
		this.role = role;
		this.dept = dept;
		this.division = division;
		this.status = status;
	}
	
	public EmployeeEntity() {
		
	}
	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}
	/**
	 * @return the staffId
	 */
	public String getStaffId() {
		return staffId;
	}
	/**
	 * @param staffId the staffId to set
	 */
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	/**
	 * @return the doorLog
	 */
	public String getDoorLog() {
		return doorLog;
	}
	/**
	 * @param doorLog the doorLog to set
	 */
	public void setDoorLog(String doorLog) {
		this.doorLog = doorLog;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	
	/**
	 * @return the team
	 */
	public String getTeam() {
		return team;
	}
	/**
	 * @param team the team to set
	 */
	public void setTeam(String team) {
		this.team = team;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the dept
	 */
	public String getDept() {
		return dept;
	}
	/**
	 * @param dept the dept to set
	 */
	public void setDept(String dept) {
		this.dept = dept;
	}
	/**
	 * @return the division
	 */
	public String getDivision() {
		return division;
	}
	/**
	 * @param division the division to set
	 */
	public void setDivision(String division) {
		this.division = division;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> auth=new ArrayList<GrantedAuthority>();
		if(this.getRole()!=null && !this.getRole().isEmpty()) {
			auth.add(new SimpleGrantedAuthority("ROLE_"+this.getRole()));
		}
		return auth;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.name;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	
	
//	@OneToMany(mappedBy = "employee")
//	private List<RegisterEntity> registered;
	
	
	
	
	
//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		List<GrantedAuthority> auth=new ArrayList<GrantedAuthority>();
//		if(this.getRole()!=null && !this.getRole().isEmpty()) {
//			auth.add(new SimpleGrantedAuthority("ROLE_"+this.getRole()));
//		}
//		return auth;
//	}
//	
//
//	@Override
//	public boolean isAccountNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	@Override
//	public boolean isAccountNonLocked() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	@Override
//	public boolean isCredentialsNonExpired() {
//		// TODO Auto-generated method stub
//		return true;
//	}
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return true;
//	}
////	public List<RegisterEntity> getRegistered() {
////		return registered;
////	}
////	public void setRegistered(List<RegisterEntity> registered) {
////		this.registered = registered;
////	}
//	public long getId() {
//		return id;
//	}
//	public void setId(long id) {
//		this.id = id;
//	}
//	public String getStaffId() {
//		return staffId;
//	}
//	public void setStaffId(String staffId) {
//		this.staffId = staffId;
//	}
//	public String getDoorLog() {
//		return doorLog;
//	}
//	public void setDoorLog(String doorLog) {
//		this.doorLog = doorLog;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	@Override
//	public String getPassword() {
//		// TODO Auto-generated method stub
//		return this.password;
//	}
//
//
//	@Override
//	public String getUsername() {
//		// TODO Auto-generated method stub
//		return this.getName();
//	}
//	/**
//	 * @param pass the pass to set
//	 */
//	public void setPass(String password) {
//		this.password = password;
//	}
//
//
//	public String getTeam() {
//		return team;
//	}
//	public void setTeam(String team) {
//		this.team = team;
//	}
//	public String getRole() {
//		return role;
//	}
//	public void setRole(String role) {
//		this.role = role;
//	}
//	public String getDept() {
//		return dept;
//	}
//	public void setDept(String dept) {
//		this.dept = dept;
//	}
//	public String getDivision() {
//		return division;
//	}
//	public void setDivision(String division) {
//		this.division = division;
//	}
//	public String getStatus() {
//		return status;
//	}
//	public void setStatus(String status) {
//		this.status = status;
//	}
	
}
