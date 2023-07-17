package com.cough.web.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Data
public class BoardVO {
	private Integer bno;	//�Խù���ȣ(pk)
	private String title;	//�Խñ�����(NN)
	private String contents;//�Խñ۳���
	private String writer;	//�Խñ��ۼ���(NN)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date regdate;	//�Խñ۵����(NN)
	//@�� �̿��ؼ� �Է��ϴ� �κп� ���� control�� �� �ִ�
	//java��default:yyyy/MM/dd
	//input��default:yyyy-MM-dd
	//���� ������̼��� ��ǲ�� �Ͱ� ��ġ��Ű�� ��
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date updatedate;//�Խñۼ�����
	private String image;	//÷������
}
