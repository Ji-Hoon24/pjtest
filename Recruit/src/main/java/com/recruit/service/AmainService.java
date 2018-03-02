package com.recruit.service;

import java.util.List;

import com.recruit.domain.AmainVO;

public interface AmainService {

	public AmainVO read(String id)throws Exception;
	
	public void modify(AmainVO vo)throws Exception;
	
	public void remove(String id)throws Exception;
	
	public List<AmainVO> listAll() throws Exception;
}
