package com.recruit.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.recruit.domain.ResumeVO;

@Repository
public class ResumeDAOImpl implements ResumeDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.recruit.mapper.resumeMapper";
	
	@Override
	public ResumeVO read(String id) throws Exception{
		return session.selectOne(namespace+".read", id);
	}
	
	@Override
	public void update(ResumeVO vo) throws Exception{
		session.update(namespace+".update", vo);
	}
	
	@Override
	public void delete(String id) throws Exception{
		session.delete(namespace+".delete", id);
	}
	
	@Override
	public List<ResumeVO> listAll(String id) throws Exception{
		System.out.println("dao : " + id);
		return session.selectList(namespace+".listAll", id);
	}
}
