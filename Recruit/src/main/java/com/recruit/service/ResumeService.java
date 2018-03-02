package com.recruit.service;

import java.util.List;

import com.recruit.domain.ResumeVO;

public interface ResumeService {

	public ResumeVO read(String id)throws Exception;
	
	public void modify(ResumeVO vo)throws Exception;
	
	public void remove(String id)throws Exception;
	
	public List<ResumeVO> listAll(String id) throws Exception;
}
