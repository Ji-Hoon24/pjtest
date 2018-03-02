package com.recruit.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.recruit.domain.AmainVO;

@Repository
public class AmainDAOimpl implements AmainDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.recruit.mapper.amainMapper";
	
	@Override
	public AmainVO read(String id) throws Exception{
		return session.selectOne(namespace+".read", id);
	}
	
	@Override
	public void update(AmainVO vo) throws Exception{
		session.update(namespace+".update", vo);
	}
	
	@Override
	public void delete(String id) throws Exception{
		session.delete(namespace+".delete", id);
	}
	
	@Override
	public List<AmainVO> listAll() throws Exception{
		return session.selectList(namespace+".listAll");
	}
}
