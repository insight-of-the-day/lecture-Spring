package com.cough.web.board.mapper;

import java.util.List;

import com.cough.web.board.service.BoardVO;

public interface BoardMapper {
	//전체조회 단건조회 등록(번호자동생성,테이블참조하여필수값/옵션값구분하기) 수정(제목||내용||이미지 날짜는 무족건수정(선택해서수정가능)) 삭제
	public List<BoardVO> searchAll();
	
	public BoardVO search(BoardVO board);
	
	public int insert(BoardVO board);
	
	public int update(BoardVO board);
	
	public int delete(int bno);
	
	
}
