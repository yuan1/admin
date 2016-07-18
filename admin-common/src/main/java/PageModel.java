/**
 * 分页封装类
 * @author Administrator
 *
 */
public class PageModel {
	private int pageNo = 1;
	private int pageSize = 20;
	private int totalRecords;
	
	public int getTotalPages() {
		return (this.totalRecords + this.pageSize - 1) / this.pageSize;
	}
	
	public int getFirstPageNo() {
		return 1;
	}
	
	public int getLastPageNo() {
		return this.getTotalPages();
	}
	
	public int getPreviousPageNo() {
		if (this.pageNo <= 1) {
			return 1;
		}
		return this.pageNo - 1;
	}

	public int getNextPageNo() {
		if (this.pageNo >= this.getLastPageNo()) {
			return this.getLastPageNo();
		}
		return this.pageNo + 1;
	}

	public int getTotalRecords() {
		return totalRecords;
	}

	public void setTotalRecords(int totalRecords) {
		this.totalRecords = totalRecords;
	}

	public int getPageSize() {
		return this.pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNo() {
		if (this.pageNo <= 0) {
			return 1;
		}
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getStartIndex() {
		return (getPageNo() - 1) * pageSize;
	}
	
	public int getEndIndex() {
		return getStartIndex() + pageSize;
	}
	
}
