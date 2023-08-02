package com.cough.web.emp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cough.web.common.PagingVO;
import com.cough.web.emp.mapper.EmpMapper;
import com.cough.web.emp.service.EmpService;
import com.cough.web.emp.service.EmpVO;
@Service
public class EmpServiceImpl implements EmpService{
	@Autowired
	EmpMapper empmapper;
	
	@Override
	public int empCount() {
		// TODO Auto-generated method stub
		return empmapper.getTotalCount();
	}

	@Override
	public List<EmpVO> getEmpList(PagingVO vo) {
		// TODO Auto-generated method stub
		return empmapper.selectEmpAll(vo);
	}

}
