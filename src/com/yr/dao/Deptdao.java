package com.yr.dao;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.lang.annotation.Around;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yr.entry.Dept;
import com.yr.entry.Emp;


@SuppressWarnings("unchecked")
@Repository
public class Deptdao {
	private Session session;
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * 获取和当前线程绑定的Session
	 * 
	 * @return
	 */
	private Session getSession() {
		// return sessionFactory.openSession();// 此方法得到Session会有连接池饱和问题
		return sessionFactory.getCurrentSession();// 推荐使用此方法
	}
	/**
	 * 	//查询全部部门
	 * @return
	 */
	public List<Dept> querylist(){
		session = getSession();
		String hql ="from Dept";
		Query query = session.createQuery(hql);
		List<Dept> dept = query.list();
		for (Dept dept2 : dept) {
			System.out.println(dept.toString());
		}
		return dept;
		}
	
	/**
	 * 添加
	 * @param dept
	 */
		public void insert(Dept dept) {
			
			session = getSession();
			session.save(dept);
		
	}
		
	public  Dept queryid(int id) {
		session = getSession();
		Dept dept =session.load(Dept.class, id);
		System.out.println(dept.toString());
		return dept; 
		
		
	}
	
	public  void update(Dept dept) {
		session = getSession();
		session.merge(dept);
		
	}

	public List<Emp> queryEmp(Integer id) {
		session = getSession();

		List<Emp> emp = new ArrayList<Emp>();
		String  hql ="select new count(o.name)from Emp o where o.dept =:dept";
		Query query = session.createQuery(hql);
		
		Dept dept = new Dept();
		dept.setId(id);
		emp = query.setEntity("dept", dept).list();
		System.out.println(emp);
		return emp;
	}
	
	public void delete(int id) {
		session = getSession();
		Dept dept = session.load(Dept.class, id);
		session.delete(dept);
	}
	
	

	
}
