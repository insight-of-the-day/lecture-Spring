package com.cough.web.common;

import lombok.Data;

@Data
public class PagingVO {
	private int totalData;//�����ѵ����ͼ�
	
	private int nowPage;//����������
	private int cntPage=5;//view�ȿ�����������������
	private int startPage;//����������
	private int endPage;//��������
	
	private int cntPerPage;//���������ȿ������ٵ����ͼ�
	private int lastPage;//������������
	private int start;//�����������ȿ�������1��°������
	private int end;//�����������ȿ������ٸ�����������
	
	//������
	public PagingVO(int totalData, int nowPage,int cntPerPage) {
		this.totalData=totalData;
		this.cntPerPage=cntPerPage;
		this.nowPage=nowPage;
		calcLastPage();
		calcStartAndEndPage();
		calcStartAndEnd();
	}
	public PagingVO(int totalData,int nowPage) {
		this(totalData,nowPage,10);
	}
	
	
	
	
	
	private void calcLastPage() {
		this.lastPage=(int)Math.ceil((double)this.totalData/(double)this.cntPerPage);
	}
	
	private void calcStartAndEndPage() {
		//endpage
		this.endPage=(int)Math.ceil((double)this.nowPage/(double)this.cntPage)*this.cntPage;
		if(this.endPage>this.lastPage) {
			this.endPage=this.lastPage;
		}
		//startpage
		this.startPage=(this.endPage-this.cntPage)+1;
		if(this.startPage<1) {
			this.startPage=1;
		}
	}
	//query��
	private void calcStartAndEnd() {
		this.start=((this.nowPage-1)*this.cntPerPage)+1;
		this.end=this.nowPage*this.cntPerPage;
		if(this.end>this.totalData) {
			this.end=this.totalData;
		}
	}
}
