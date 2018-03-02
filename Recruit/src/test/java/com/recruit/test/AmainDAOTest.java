package com.recruit.test;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.recruit.domain.AmainVO;
import com.recruit.persistence.AmainDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations ={"file:src/main/webapp/WEB-INF/spring/**/root-context.xml"})
public class AmainDAOTest {

	@Inject
	private AmainDAO dao;
	
	private static Logger logger = LoggerFactory.getLogger(AmainDAOTest.class);
	
	@Test
	public void testRead() throws Exception{
		logger.info(dao.read("asdf").toString());
	}
		
//	@Test
//	public void testupdate() throws Exception {
//		AmainVO ama = new AmainVO();
//		ama.setId("asdf");
//		ama.setPw("4321");
//		ama.setPname("이무기");
//		ama.setEmail("test@test.com");
//		ama.setBirth("19970324");
//		dao.update(ama);
//	}
	
//	@Test
//	public void testdelete() throws Exception {
//		dao.delete("asdf");
//	}

}
