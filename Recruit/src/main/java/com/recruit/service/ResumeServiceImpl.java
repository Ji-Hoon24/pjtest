package com.recruit.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.recruit.domain.AdminResumeVO;
import com.recruit.persistence.ResumeDAO;

@Service
public class ResumeServiceImpl implements ResumeService {

	@Inject
	private ResumeDAO dao;
	
	@Override
	public AdminResumeVO read(String id) throws Exception{
		return dao.read(id);
	}
	
	@Override
	public void modify(AdminResumeVO vo) throws Exception{
		dao.update(vo);
	}
	
	@Override
	public void remove(String id) throws Exception{
		dao.delete(id);
	}
	
	@Override
	public List<AdminResumeVO> listAll(String id) throws Exception{
		return dao.listAll(id);
	}


}
