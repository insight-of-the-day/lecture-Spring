package com.cough.web.board.service;

import java.util.Date;

import lombok.Data;


@Data
public class BoardVO {
	private Integer bno;	//�Խù���ȣ(pk)
	private String title;	//�Խñ�����(NN)
	private String contents;//�Խñ۳���
	private String writer;	//�Խñ��ۼ���(NN)
	private Date regdate;	//�Խñ۵����(NN)
	private Date updatedate;//�Խñۼ�����
	private String image;	//÷������
}
