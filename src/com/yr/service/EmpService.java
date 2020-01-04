package com.yr.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yr.dao.Empdao;
import com.yr.entry.Dept;
import com.yr.entry.Emp;;

@Service
public class EmpService {
	
	@Autowired
	private Empdao empdao;
	
	
	@Transactional
	public List<Emp>queryList(){
		return empdao.queyrlist();
		
	}
	/**
	 * Ìí¼Ó
	 * @param emp
	 */
	@Transactional
	public void insert(Emp emp) {
		
		empdao.insert(emp);
	}
	
	/**
	 * ÐÞ¸Ä
	 * @param emp
	 */
	@Transactional
	public void update(Emp emp) {
		
		empdao.update(emp);
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	@Transactional
	public Emp queryid(int id) {
		
		return empdao.queryid(id) ;	
	}
	
	@Transactional
	public String queryname(int id) {
		
		
		return  empdao.queryname(id);
		
	}
	@Transactional
	public List<Dept>listquery1(){
		return empdao.querylist1();
		
		
	}
	
	@Transactional
	public Emp enpname(int id) {
		
		return empdao.empname(id);
		
	}
	
	@Transactional
	public int queryiddd(int id) {
		return empdao.queryiddd(id);
	}
	
	@Transactional
	public void delete(int id) {
		empdao.delete(id);
		
	}
	

}
