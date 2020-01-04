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
 * 新增,跳转到新增页面使用
 * @param dept
 * @param map
 * @return
 */
@RequestMapping(value="/isnertdept", method = RequestMethod.GET)
public String insertdept( Map<String, Object> map) {	
	map.put("dept", new Dept());
	/**
	 * map中的值跳转页面是不能用转向来跳转 :只能用转发的.forward 和 当前的jsp页面*/
	return "insertdept";	
}

@RequestMapping(value="isnertdept",method=RequestMethod.POST)
public  String insert(Dept dept,Map<String, Object> map) {
	deptService.insert(dept);
	return "redirect:/fuck";
}


//查询数据
	@ResponseBody // 表示返回json格式的数据
	@RequestMapping("/querydept")
	public List<Dept> Querylist() {
		deptList =deptService.querylist();
		return deptList;	
	}
	@RequestMapping("/fuck")
	public String fuck() {
		
	return "deptlist";
	}
	
	
	//回显修改
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
	 * 删除
	 * 
	 */
	
	@RequestMapping(value = "/empp/{id}", method = RequestMethod.GET)
	@ResponseBody
	public List<Emp> delete(@PathVariable("id") Integer id, Emp emp, Map<String, Object> map) {
		return deptService.queryemp(id);// 查询根据班级id查询 去学生表是否有学生 然后返回到页面判断
	}

	@RequestMapping(value = "/empp/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Integer id) {
		deptService.delete(id);
		System.out.println("删除成功");
		return "redirect:/fuck";
	}
	
}
