package com.cough.web.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Data
public class BoardVO {
	private Integer bno;	//게시물번호(pk)
	private String title;	//게시글제목(NN)
	private String contents;//게시글내용
	private String writer;	//게시글작성자(NN)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;	//게시글등록일(NN)
	//@를 이용해서 입력하는 부분에 대해 control할 수 있다
	//java의default:yyyy/MM/dd
	//input의default:yyyy-MM-dd
	//위의 어노테이션은 인풋의 것과 일치시키는 것
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedate;//게시글수정일
	private String image;	//첨부파일
}
