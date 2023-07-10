package com.gay.lesbian;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.gay.lesbian.emp.service.EmpVO;
import com.gay.lesbian.mapper.EmpMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class EmpService {
	@Autowired
	EmpMapper emp;
	
	@Test
	public void getEmp() {
		EmpVO vo=new EmpVO();
		vo.setEmployee_id("100");
		EmpVO findVO=emp.getEmp(vo);
		assertEquals(findVO.getFirst_name(),"Steven");
	}
}
