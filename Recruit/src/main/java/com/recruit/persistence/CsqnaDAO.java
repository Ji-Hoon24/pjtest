package com.recruit.persistence;

import java.util.List;

import com.recruit.domain.CsqnaVO;

public interface CsqnaDAO {

	public void create(CsqnaVO vo) throws Exception;

	public CsqnaVO read(Integer bno) throws Exception;
	
	public void update(CsqnaVO vo) throws Exception;
	
	public void delete(Integer bno) throws Exception;
	
	public List<CsqnaVO> listAll() throws Exception;
	
	public void updateViewCnt(Integer bno)throws Exception;
}
