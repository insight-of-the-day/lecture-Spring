package com.cough.web.emp.mapper;

import java.util.List;

import com.cough.web.common.PagingVO;
import com.cough.web.emp.service.EmpVO;

public interface EmpMapper {
//총데이터조회
	public int getTotalCount();
	//전체조회
	public List<EmpVO> selectEmpAll(PagingVO vo);
}
