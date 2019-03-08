package com.hk.nai.daos;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hk.nai.dtos.BoardDto;
import com.hk.nai.dtos.CommentDto1;

@Repository
public class BoardDao implements IBoardDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	private String namespace="com.hk.nai.";
	//-------------------게시판------------------------
	@Override
	public List<BoardDto> getAllList() {
		return sqlSession.selectList(namespace+"getAllContent");
	}

	@Override
	public boolean insertBoard(BoardDto dto) {
		int count = 0;
		count = sqlSession.insert(namespace+"insertBoard",dto);
		return count>0?true:false;
	}

	@Override
	public BoardDto getBoard(BoardDto dto) {
		return sqlSession.selectOne(namespace+"getBoard",dto);
	}

	@Override
	public boolean updateBoard(BoardDto dto) {
		int count=0;
		count = sqlSession.update(namespace+"updateBoard",dto);
		return count>0?true:false;
	}

	@Override
	public boolean b_readCount(int b_seq) {
		int count=0;
		count = sqlSession.update(namespace+"b_readCount",b_seq);
		return count>0?true:false;
	}

	
	@Override
	public boolean b_like_up(int b_seq) {
		int count=0;
		count = sqlSession.update(namespace+"b_like_up", b_seq);
		return count>0?true:false;
	}

	@Override
	public boolean b_like_down(int b_seq) {
		int count=0;
		count = sqlSession.update(namespace+"b_like_down", b_seq);
		return count>0?true:false;
	}

	@Override
	public boolean delBoard(int b_seq) {
		int count=0;
		count = sqlSession.delete(namespace+"delBoard", b_seq);
		return count>0?true:false;
	}
	@Override
	public int getB_like(int b_seq) {
		int count = sqlSession.selectOne(namespace+"getB_like", b_seq);
		return count;
	}
	@Override
	public int getPointCheck(int b_seq) {
		int count = sqlSession.selectOne(namespace+"getPointCheck", b_seq);
		return count;
	}
	
	@Override
	public void bUpdateNick(Map<String, String> map) {
		sqlSession.update(namespace+"bUpdateNick", map);		
	}

	@Override
	public void cUpdateNick(Map<String, String> map) {
		sqlSession.update(namespace+"cUpdateNick", map);		
	}

	@Override
	public void lUpdateNick(Map<String, String> map) {
		sqlSession.update(namespace+"lUpdateNick", map);		
	}

//------------------------페이징----------------------
	@Override
	public List<BoardDto> listCriteria(String page) throws Exception {
		return sqlSession.selectList(namespace+"listCriteria", page);
	}

	@Override
	public List<BoardDto> listCriteria1(String page) throws Exception {
		return sqlSession.selectList(namespace+"listCriteria1", page);
	}
	@Override
	public List<BoardDto> listCriteria2(String page) throws Exception {
		return sqlSession.selectList(namespace+"listCriteria2", page);
	}
	
	@Override
	public List<BoardDto> listCriteria3(String page) throws Exception {
		return sqlSession.selectList(namespace+"listCriteria3", page);
	}

	
//-----------------게시글 전체 수 구하기----------------------------
	@Override
	public Integer TotalCount() throws Exception {
		return sqlSession.selectOne(namespace+"getTotalCount");
	}
//----------------------댓글-------------------------------
	@Override
	public List<CommentDto1> commentList(int b_seq) {
		return sqlSession.selectList(namespace+"commentList",b_seq);
	}

	@Override
	public boolean insertComment(CommentDto1 comment) {
		int count=0;
		count = sqlSession.insert(namespace+"insertComment", comment);
		return count>0?true:false;
	}

	@Override
	public boolean replyBoardUpdate(CommentDto1 comment) {
		int count=0;
		count = sqlSession.update(namespace+"updateComment",comment);
		return count>0?true:false;
	}

	@Override
	public boolean delComment(int r_seq) {
		int count=0;
		count = sqlSession.delete(namespace+"delComment",r_seq);
		return count>0?true:false;
	}

	@Override
	public CommentDto1 readComment(int r_seq) {
		return sqlSession.selectOne(namespace+"readComment",r_seq);
	}


	@Override
	public boolean upComment(int b_seq) {
		int count = 0;
		count = sqlSession.update(namespace+"upComment", b_seq);
		return count>0?true:false;
	}

	@Override
	public boolean downComment(int b_seq) {
		int count=0;
		count = sqlSession.update(namespace+"downComment", b_seq);
		return count>0?true:false;
	}

	
	
	

	

	

	
	

}
