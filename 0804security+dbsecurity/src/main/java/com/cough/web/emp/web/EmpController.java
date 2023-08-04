package com.cough.web.emp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cough.web.common.PagingVO;
import com.cough.web.emp.service.EmpService;
import com.cough.web.emp.service.EmpVO;

@Controller
public class EmpController {
	@Autowired
	EmpService empservice;
	
	@GetMapping("empList")
	public String empList(Model m
			,@RequestParam(value="nowPage",defaultValue="1")Integer nowPage
			,@RequestParam(value="cntPerPage",defaultValue="10")Integer cntPerPage) {
		int total=empservice.empCount();
		PagingVO vo=new PagingVO(total,nowPage,cntPerPage);
		List<EmpVO>empList=empservice.getEmpList(vo);
		             
		m.addAttribute("empList",empList);
		m.addAttribute("paging",vo);
		return "emp/empList";
	}
}
