package com.recruit.service;

import java.util.List;

import com.recruit.domain.AdminResumeVO;

public interface ResumeService {

	public AdminResumeVO read(String id)throws Exception;
	
	public void modify(AdminResumeVO vo)throws Exception;
	
	public void remove(String id)throws Exception;
	
	public List<AdminResumeVO> listAll(String id) throws Exception;
}
