/**
 * 
 */
package com.cough.web.board.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cough.web.board.mapper.BoardMapper;
import com.cough.web.board.service.BoardService;
import com.cough.web.board.service.BoardVO;

/**
 * @author admin
 *
 */
@Service
public class BoardServiceImpl implements BoardService {
	@Autowired
	BoardMapper boardmapper;

	@Override
	public List<BoardVO> searchAll() {		
		return boardmapper.searchAll();
	}

	@Override
	public BoardVO search(BoardVO board) {
		return boardmapper.search(board);
	}

	@Override
	public int insert(BoardVO board) {
		int result=boardmapper.insert(board);
		if(result>0) {
			return board.getBno();//selectkey에있는거
		}else {
			return -1;
		}
		
	}

	@Override
	public int update(BoardVO board) {
		BoardVO vo=new BoardVO();
		board.setBno(board.getBno());
		int result=boardmapper.update(board);
		if(result>0) {
			return board.getBno();
		}else {
			return -1;
		}
	}

	@Override
	public int delete(int bno) {
		int result=boardmapper.delete(bno);
		if(result>0) {
			return bno;
		}else {
			return -1;
		}
	}

}
