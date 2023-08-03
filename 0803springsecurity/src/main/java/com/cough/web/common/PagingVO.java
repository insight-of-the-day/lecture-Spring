package com.cough.web.common;

import lombok.Data;

@Data
public class PagingVO {
	private int totalData;//현재총데이터수
	
	private int nowPage;//현재페이지
	private int cntPage=5;//view안에서보여줄페이지수
	private int startPage;//시작페이지
	private int endPage;//끝페이지
	
	private int cntPerPage;//한페이지안에보여줄데이터수
	private int lastPage;//마지막페이지
	private int start;//현재페이지안에보여줄1번째데이터
	private int end;//현재페이지안에보여줄마지막데이터
	
	//생성자
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
	//query문
	private void calcStartAndEnd() {
		this.start=((this.nowPage-1)*this.cntPerPage)+1;
		this.end=this.nowPage*this.cntPerPage;
		if(this.end>this.totalData) {
			this.end=this.totalData;
		}
	}
}
