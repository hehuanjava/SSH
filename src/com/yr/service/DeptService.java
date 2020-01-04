package com.yr.service;

import java.util.List;

import org.aspectj.lang.annotation.Around;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yr.dao.Deptdao;
import com.yr.entry.Dept;
import com.yr.entry.Emp;

@Service
public class DeptService {
	
	@Autowired
	private Deptdao deptdao;
	
	/**
	 * 	//查询全部部门
	 * @return
	 */
	@Transactional
	public List<Dept>querylist(){
		
	return	deptdao.querylist();
		
	}
	
	@Transactional
	public void insert(Dept dept) {
		
		 deptdao.insert(dept);
	}
	
	@Transactional
	public  Dept queryid(int id) {
		return deptdao.queryid(id) ;
		
		
	}
	@Transactional
	public void Update(Dept dept) {
		
		deptdao.update(dept);
	}
	@Transactional
	public List<Emp> queryemp(Integer id) {

		return deptdao.queryEmp(id);

	}
	@Transactional
	public void delete(int id) {
	
	deptdao.delete(id);
	}
	
	

}
