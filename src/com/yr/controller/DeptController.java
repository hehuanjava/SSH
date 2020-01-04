package com.yr.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yr.entry.Dept;
import com.yr.entry.Emp;
import com.yr.service.DeptService;

@Controller
public class DeptController {
		
@Autowired
private  DeptService deptService;

private  List<Dept>deptList;

/**
 * ����,��ת������ҳ��ʹ��
 * @param dept
 * @param map
 * @return
 */
@RequestMapping(value="/isnertdept", method = RequestMethod.GET)
public String insertdept( Map<String, Object> map) {	
	map.put("dept", new Dept());
	/**
	 * map�е�ֵ��תҳ���ǲ�����ת������ת :ֻ����ת����.forward �� ��ǰ��jspҳ��*/
	return "insertdept";	
}

@RequestMapping(value="isnertdept",method=RequestMethod.POST)
public  String insert(Dept dept,Map<String, Object> map) {
	deptService.insert(dept);
	return "redirect:/fuck";
}


//��ѯ����
	@ResponseBody // ��ʾ����json��ʽ������
	@RequestMapping("/querydept")
	public List<Dept> Querylist() {
		deptList =deptService.querylist();
		return deptList;	
	}
	@RequestMapping("/fuck")
	public String fuck() {
		
	return "deptlist";
	}
	
	
	//�����޸�
	@RequestMapping(value="/isnertdept{id}",method = RequestMethod.GET)
	public String input(@PathVariable("id") Integer id, Map<String,Object>map) {
		map.put("dept", deptService.queryid(id));
		return "insertdept";
	}
	
	@RequestMapping(value="/isnertdept{id}",method =RequestMethod.PUT)
	public String update(Dept dept) {
		deptService.Update(dept);
		return "redirect:/fuck";
	}
	
	/**
	 * ɾ��
	 * 
	 */
	
	@RequestMapping(value = "/empp/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Emp> delete(@PathVariable("id") Integer id, Emp emp, Map<String, Object> map) {
		return deptService.queryemp(id);// ��ѯ���ݰ༶id��ѯ ȥѧ�����Ƿ���ѧ�� Ȼ�󷵻ص�ҳ���ж�
	}

	@RequestMapping(value = "/empp/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
		deptService.delete(id);
		System.out.println("ɾ���ɹ�");
		return "redirect:/fuck";
	}
	
}
