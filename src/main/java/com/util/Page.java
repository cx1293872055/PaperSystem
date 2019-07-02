package com.util;

public class Page {

	int page=1;
	int count = 7;
	int last = 0;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getLast() {
		return last;
	}
	public void setLast(int last) {
		this.last = last;
	}
	
	public void caculateLast(int total) {
	    // 假设总数是50，是能够被5整除的，那么最后一页的开始就是45
	    if (0 == total % count)
			last = total / count - 1;
	    // 假设总数是51，不能够被5整除的，那么最后一页的开始就是50
	    else
	        last = total / count + 1;
	}

	public void caculatePage() {
		this.page = (this.page - 1)* this.count;
	}

}
