package org.kro.dao;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.kro.cmmn.MemberVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOImpl implements MemberDAO{

	@Autowired
	private SqlSession sqlsession;
	
	@Override
	public String getTime() {
		return sqlsession.selectOne("member.getTime");
	}

	@Override
	public void insertMember(MemberVO vo) {
		sqlsession.insert("member.insertMember", vo);
		
	}

	@Override
	public MemberVO readMember(String userid) throws Exception {
		return sqlsession.selectOne("member.readMember", userid);
		
	}

	@Override
	public MemberVO readWithPw(String userid, String userpw) throws Exception {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("userid", userid);
		paramMap.put("userpw", userpw);
		return sqlsession.selectOne("member.readWithPw", paramMap);
	}

}
