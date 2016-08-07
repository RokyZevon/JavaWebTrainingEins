package com.cnstrong.entity;

import java.util.List;

public class Page<T> {
	private int pagenumber=3;//每页多少行
	private int countpage;//当前页码
	private int totalrows;//总共多少行
	private int totalpages;//总共多少页
	private List<T> pagelist;
	public int getPagenumber() {
		return pagenumber;
	}
	public void setPagenumber(int pagenumber) {
		this.pagenumber = pagenumber;
	}
	public int getCountpage() {
		return countpage;
	}
	public void setCountpage(int countpage) {
		this.countpage = countpage;
	}
	public int getTotalrows() {
		return totalrows;
	}
	public void setTotalrows(int totalrow) {
		this.totalrows = totalrow;
	}
	public int getTotalpages() {
		return totalpages;
	}
	public void setTotalpages(int totalpages) {
		this.totalpages = totalpages;
	}
	public List<T> getPagelist() {
		return pagelist;
	}
	public void setPagelist(List<T> list) {
		this.pagelist = list;
	}
	

}
