package com.yr.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yr.entry.Dept;
import com.yr.entry.Emp;
@SuppressWarnings("unchecked")
@Repository
public class Empdao {
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
	
	//查询全部员工
	public List<Emp> queyrlist(){
		session = getSession();
		String hql = "from Emp";
		Query query = session.createQuery(hql);
		
		List<Emp> emp = query.list();
		for (Emp emp2 : emp) {
			System.out.println(emp2.toString());
		}	
		return emp;
		
	}
	
	/**
	 * 
	 * 添加
	 * @return
	 */
	public  void insert(Emp emp) {
		session = getSession();
		session.save(emp);
	}
	/**
	 * 
	 * 修改
	 * @param emp
	 */
	public void update(Emp emp) {
		session = getSession();
		session.merge(emp);

	}
	
	/**
	 * 
	 * 修改查询id
	 * 
	 */
	
	public Emp queryid(int id) {
		session = getSession();
		Emp emp = session.load(Emp.class, id);
		System.out.println(emp.toString());
		
		return emp;
	}
	
	/**
	 * 根据id 查询部门名称
	 * 
	 */
	
	public String queryname(int id) {
		session = getSession();

		Dept dept = session.load(Dept.class, id);
		System.out.println(dept.getName());
		
		return dept.getName();
		
	}
	
	public Emp empname(int id) {
		session = getSession();
		Emp emp =session.load(Emp.class, id);
		System.out.println(emp.toString());
		return emp;
		

		
	}
	
	
	/**
	 * 	//查询全部部门
	 * @return
	 */
	public List<Dept> querylist1(){
		session = getSession();
		String hql ="from Dept";
		Query query = session.createQuery(hql);
		List<Dept> dept = query.list();
		for (Dept dept2 : dept) {
			System.out.println(dept.toString());
		}
		return dept;
		}
	
	
	// 根据员工id查询部门
		public int queryiddd(int id) {
			session = getSession();
			Emp emp = session.load(Emp.class, id);
			return emp.getDept().getId();
		}
		
		/**
		 * 
		 * 删除
		 * @param id
		 */
		public void delete(int id) {
			session = getSession();
			Emp emp = session.load(Emp.class, id);
			session.delete(emp);
			
			
		}
		/**
		 * 
		 * 测试
		 * @param id
		 */
	
		public void deletett(int id) {
			session = getSession();
			Emp emp = session.load(Emp.class, id);
			session.delete(emp);	
		}
	

}
