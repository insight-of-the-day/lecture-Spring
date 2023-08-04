package com.cough.web.emp.service;

import java.util.List;

import com.cough.web.common.PagingVO;

public interface EmpService {
	
	public int empCount();
	
	public List<EmpVO>getEmpList(PagingVO vo);
}
