package com.recruit.persistence;

import java.util.List;

import com.recruit.domain.AmainVO;

public interface AmainDAO {
	
	public AmainVO read(String id) throws Exception;
	
	public void update(AmainVO vo) throws Exception;
	
	public void delete(String id) throws Exception;
	
	public List<AmainVO> listAll() throws Exception;
}
