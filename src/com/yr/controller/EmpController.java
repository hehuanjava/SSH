package com.yr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yr.entry.Dept;
import com.yr.entry.Emp;
import com.yr.service.DeptService;
import com.yr.service.EmpService;

@Controller
public class EmpController {
	
	@Autowired
	private EmpService empService;
	
	private List<Emp>emplist;
	
	@RequestMapping("start")
	public String test() {
		
		System.out.println("����ϵͳ");	
		return "emplist";	
	}
	/**
	 * 
	 * emp��ѯ
	 * @return
	 */
	@ResponseBody
	@RequestMapping("/emp")
	public List <Emp> query(){
		emplist = empService.queryList();
		return emplist;
	}
	
	/**
	 * 
	 * ȥ���ҳ�����
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/empadd",method=RequestMethod.GET)
	public String inserthx(Map<String,Object>map) {
		Map<String,String> genders = new HashMap<String,String>();
		genders.put("1", "��");
		genders.put("0", "Ů");
		map.put("genders", genders);// ���뵽request����
		map.put("emp", new Emp());
		map.put("Dept", empService.listquery1());
		return "empput";
	}
	/**
	 * 
	 * ���
	 * @param emp
	 * @param dept1
	 * @return
	 */
	@RequestMapping(value="empadd",method=RequestMethod.POST)
	public String insert(Emp emp ,String dept1) {
		Dept dept = new Dept();
		dept.setName(empService.queryname(Integer.valueOf(dept1)));
		dept.setId(Integer.valueOf(dept1));
		emp.setDept(dept);
		empService.insert(emp);
		return "redirect:/start";
	}

	/**
	 * 
	 * �޸Ļ���
	 * @param id
	 * @param map
	 * @return
	 */
	@RequestMapping(value="/empadd{id}", method=RequestMethod.GET)
	public  String update(@PathVariable("id") Integer id,Map<String,Object>map) {
		Map<String,String> genders = new HashMap<String,String>();
		genders.put("1", "��");
		genders.put("0", "Ů");
		map.put("genders", genders);// ���뵽request����
		map.put("Deptt", empService.listquery1());//��ѯȫ������
		map.put("emp", empService.enpname(id));//����id��ѯԱ��
		map.put("Dept1", empService.queryiddd(id));//����Ա��id��ѯ����
		return "empput";
	}
	//�޸�
	@RequestMapping(value="/empadd", method=RequestMethod.PUT)
	public String update1(Emp emp ,String Deptt) {
		
		Dept dept = new Dept();
		dept.setName(empService.queryname(Integer.valueOf(Deptt)));
		dept.setId(Integer.valueOf(Deptt));
		
		emp.setDept(dept);
		empService.update(emp);		
		
		return "redirect:/start";	
	}
	//ɾ��
	@ResponseBody
	@RequestMapping(value="empadd{id}",method=RequestMethod.POST)
	public String delete(@PathVariable("id") Integer id) {
		empService.delete(id);
		String mark = "kt";
		return mark;
	}

	
	
	
}
	
