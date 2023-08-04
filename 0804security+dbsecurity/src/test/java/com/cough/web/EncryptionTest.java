package com.cough.web;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/*-context.xml")
public class EncryptionTest {
	@Autowired
	StandardPBEStringEncryptor encryptor;
	
	@Test
	public void encryptionTest() {
		String[] dataList= {
				"net.sf.log4jdbc.sql.jdbcapi.DriverSpy",
				"jdbc:log4jdbc:oracle:thin:@localhost:1521:xe",
				"hr",
				"1234"
		};
//		깃허브에올릴때는 이거 빈 값으로 해서 올리기~ 테스트할때만 이렇게 써라
		for(String data:dataList) {
			String encData=encryptor.encrypt(data);
			System.out.println(encData);
		}
	}
}
