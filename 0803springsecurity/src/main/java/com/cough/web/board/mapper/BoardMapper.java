package com.cough.web.board.mapper;

import java.util.List;

import com.cough.web.board.service.BoardVO;

public interface BoardMapper {
	//��ü��ȸ �ܰ���ȸ ���(��ȣ�ڵ�����,���̺������Ͽ��ʼ���/�ɼǰ������ϱ�) ����(����||����||�̹��� ��¥�� �����Ǽ���(�����ؼ���������)) ����
	public List<BoardVO> searchAll();
	
	public BoardVO search(BoardVO board);
	
	public int insert(BoardVO board);
	
	public int update(BoardVO board);
	
	public int delete(int bno);
	
	
}
