package com.cough.web.emp.mapper;

import java.util.List;

import com.cough.web.common.PagingVO;
import com.cough.web.emp.service.EmpVO;

public interface EmpMapper {
//�ѵ�������ȸ
	public int getTotalCount();
	//��ü��ȸ
	public List<EmpVO> selectEmpAll(PagingVO vo);
}
