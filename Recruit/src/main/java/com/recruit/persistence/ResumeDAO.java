package com.recruit.persistence;

import java.util.List;

import com.recruit.domain.AdminResumeVO;

public interface ResumeDAO {

	public AdminResumeVO read(String id) throws Exception;
	
	public void update(AdminResumeVO vo) throws Exception;
	
	public void delete(String id) throws Exception;
	
	public List<AdminResumeVO> listAll(String id) throws Exception;
}
