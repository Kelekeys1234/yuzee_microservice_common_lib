/**
 * 
 */
package com.yuzee.common.lib.dto;

import java.io.Serializable;

/**
 * @author SeekADegree
 *
 */
public class PaginationUtilDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8268627697200155436L;
	private long pageNumber;
	private long totalPages;
	private boolean hasPreviousPage;
	private boolean hasNextPage;


	public long getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(long pageNumber) {
		this.pageNumber = pageNumber;
	}

	public long getTotalPages() {
		return totalPages;
	}

	public void setTotalPages(long totalPages) {
		this.totalPages = totalPages;
	}

	public boolean isHasPreviousPage() {
		return hasPreviousPage;
	}

	public void setHasPreviousPage(boolean hasPreviousPage) {
		this.hasPreviousPage = hasPreviousPage;
	}

	public boolean isHasNextPage() {
		return hasNextPage;
	}

	public void setHasNextPage(boolean hasNextPage) {
		this.hasNextPage = hasNextPage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (hasNextPage ? 1231 : 1237);
		result = prime * result + (hasPreviousPage ? 1231 : 1237);
		result = prime * result + (int) (pageNumber ^ (pageNumber >>> 32));
		result = prime * result + (int) (totalPages ^ (totalPages >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaginationUtilDto other = (PaginationUtilDto) obj;
		if (hasNextPage != other.hasNextPage)
			return false;
		if (hasPreviousPage != other.hasPreviousPage)
			return false;
		if (pageNumber != other.pageNumber)
			return false;
		if (totalPages != other.totalPages)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PaginationUtilDto [pageNumber=").append(pageNumber).append(", totalPages=").append(totalPages)
				.append(", hasPreviousPage=").append(hasPreviousPage).append(", hasNextPage=").append(hasNextPage)
				.append("]");
		return builder.toString();
	}

}
