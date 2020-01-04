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
	 * ��ȡ�͵�ǰ�̰߳󶨵�Session
	 * 
	 * @return
	 */
	private Session getSession() {
		// return sessionFactory.openSession();// �˷����õ�Session�������ӳر�������
		return sessionFactory.getCurrentSession();// �Ƽ�ʹ�ô˷���
	}
	
	//��ѯȫ��Ա��
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
	 * ���
	 * @return
	 */
	public  void insert(Emp emp) {
		session = getSession();
		session.save(emp);
	}
	/**
	 * 
	 * �޸�
	 * @param emp
	 */
	public void update(Emp emp) {
		session = getSession();
		session.merge(emp);

	}
	
	/**
	 * 
	 * �޸Ĳ�ѯid
	 * 
	 */
	
	public Emp queryid(int id) {
		session = getSession();
		Emp emp = session.load(Emp.class, id);
		System.out.println(emp.toString());
		
		return emp;
	}
	
	/**
	 * ����id ��ѯ��������
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
	 * 	//��ѯȫ������
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
	
	
	// ����Ա��id��ѯ����
		public int queryiddd(int id) {
			session = getSession();
			Emp emp = session.load(Emp.class, id);
			return emp.getDept().getId();
		}
		
		/**
		 * 
		 * ɾ��
		 * @param id
		 */
		public void delete(int id) {
			session = getSession();
			Emp emp = session.load(Emp.class, id);
			session.delete(emp);
			
			
		}
	
	

}
