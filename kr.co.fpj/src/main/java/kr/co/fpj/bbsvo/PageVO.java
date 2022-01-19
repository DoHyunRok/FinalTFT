package kr.co.fpj.bbsvo;

public class PageVO {
	int cpage;
	String sorttype;

	public PageVO() {
	}

	public PageVO(int cpage, String sorttype) {
		this.cpage = cpage;
		this.sorttype = sorttype;
	}

	public int getCpage() {
		return cpage;
	}

	public void setCpage(int cpage) {
		this.cpage = cpage;
	}

	public String getSorttype() {
		return sorttype;
	}

	public void setSorttype(String sorttype) {
		this.sorttype = sorttype;
	}

	@Override
	public String toString() {
		return "PageVO [cpage=" + cpage + ", sorttype=" + sorttype + "]";
	}


	
}
