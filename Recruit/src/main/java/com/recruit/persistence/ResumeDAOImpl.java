package com.recruit.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.recruit.domain.AdminResumeVO;

@Repository
public class ResumeDAOImpl implements ResumeDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.recruit.mapper.resumeMapper";
	
	@Override
	public AdminResumeVO read(String id) throws Exception{
		return session.selectOne(namespace+".read", id);
	}
	
	@Override
	public void update(AdminResumeVO vo) throws Exception{
		session.update(namespace+".update", vo);
	}
	
	@Override
	public void delete(String id) throws Exception{
		session.delete(namespace+".delete", id);
	}
	
	@Override
	public List<AdminResumeVO> listAll(String id) throws Exception{
		return session.selectList(namespace+".listAll", id);
	}
}
