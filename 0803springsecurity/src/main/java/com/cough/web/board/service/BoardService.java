package com.cough.web.board.service;

import java.util.List;

public interface BoardService {
	public List<BoardVO> searchAll();

	public BoardVO search(BoardVO board);

	public int insert(BoardVO board);

	public int update(BoardVO board);

	public int delete(int bno);
}
