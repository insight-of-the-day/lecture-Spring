package com.cough.web.board.service;

import java.util.Date;

import lombok.Data;


@Data
public class BoardVO {
	private Integer bno;	//게시물번호(pk)
	private String title;	//게시글제목(NN)
	private String contents;//게시글내용
	private String writer;	//게시글작성자(NN)
	private Date regdate;	//게시글등록일(NN)
	private Date updatedate;//게시글수정일
	private String image;	//첨부파일
}
