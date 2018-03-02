package com.recruit.persistence;

import java.util.List;

import com.recruit.domain.ResumeVO;

public interface ResumeDAO {

	public ResumeVO read(String id) throws Exception;
	
	public void update(ResumeVO vo) throws Exception;
	
	public void delete(String id) throws Exception;
	
	public List<ResumeVO> listAll(String id) throws Exception;
}
