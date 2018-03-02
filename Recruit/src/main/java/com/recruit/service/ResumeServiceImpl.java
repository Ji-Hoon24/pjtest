package com.recruit.service;

import java.util.List;

import javax.inject.Inject;

import com.recruit.domain.ResumeVO;
import com.recruit.persistence.ResumeDAO;

public class ResumeServiceImpl implements ResumeService {

	@Inject
	private ResumeDAO dao;
	
	@Override
	public ResumeVO read(String id) throws Exception{
		return dao.read(id);
	}
	
	@Override
	public void modify(ResumeVO vo) throws Exception{
		dao.update(vo);
	}
	
	@Override
	public void remove(String id) throws Exception{
		dao.delete(id);
	}
	
	@Override
	public List<ResumeVO> listAll(String id) throws Exception{
		System.out.println("service : "+id);
		return dao.listAll(id);
	}
}
