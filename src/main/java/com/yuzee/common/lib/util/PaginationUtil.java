package com.yuzee.common.lib.util;

import org.springframework.data.domain.Page;

import com.yuzee.common.lib.dto.PaginationResponseDto;
import com.yuzee.common.lib.dto.PaginationUtilDto;
import com.yuzee.common.lib.exception.ValidationException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PaginationUtil {

	private PaginationUtil() {

	}
	public static Integer MAX_RESULT_SIZE = 50;
	public static PaginationUtilDto calculatePagination(final long startIndex, final long pageSize,
			final long totalCount) {
		PaginationUtilDto paginationUtilDto = new PaginationUtilDto();
		boolean hasPreviousPage = false;
		boolean hasNextPage = false;
		long totalPages = totalCount / pageSize;
		if (totalCount % pageSize > 0) {
			totalPages += 1;
		}
		long pageNumber = startIndex / pageSize + 1;

		if (pageNumber != 1 && pageNumber <= totalPages) {
			hasPreviousPage = true;
		}
		if (pageNumber < totalPages) {
			hasNextPage = true;
		}
		paginationUtilDto.setTotalPages(totalPages);
		paginationUtilDto.setPageNumber(pageNumber);
		paginationUtilDto.setHasPreviousPage(hasPreviousPage);
		paginationUtilDto.setHasNextPage(hasNextPage);
		return paginationUtilDto;

	}

	public static PaginationResponseDto calculatePaginationAndPrepareResponse(final long startIndex, final int pageSize,
			final long totalCount, Object response) {
		PaginationResponseDto paginationResponseDto = new PaginationResponseDto();
		boolean hasPreviousPage = false;
		boolean hasNextPage = false;
		Long totalPages = totalCount / pageSize;
		if (totalCount % pageSize > 0) {
			totalPages += 1;
		}
		Long pageNumber = Long.valueOf(startIndex / pageSize + 1);

		if (pageNumber != 1 && pageNumber <= totalPages) {
			hasPreviousPage = true;
		}
		if (pageNumber < totalPages) {
			hasNextPage = true;
		}
		paginationResponseDto.setTotalCount(totalCount);
		paginationResponseDto.setTotalPages(totalPages);
		paginationResponseDto.setPageNumber(pageNumber);
		paginationResponseDto.setHasPreviousPage(hasPreviousPage);
		paginationResponseDto.setHasNextPage(hasNextPage);
		paginationResponseDto.setResponse(response);
		return paginationResponseDto;
	}
	
	public static <T> PaginationResponseDto<T> calculatePaginationAndPrepareResponse(Page<?> page, T response) {
		PaginationResponseDto<T> paginationResponseDto = new PaginationResponseDto<>();
		paginationResponseDto.setTotalCount(page.getTotalElements());
		paginationResponseDto.setTotalPages(Long.valueOf(page.getTotalPages()));
		paginationResponseDto.setPageNumber(Long.valueOf(page.getNumber())+1);
		paginationResponseDto.setHasPreviousPage(page.hasPrevious());
		paginationResponseDto.setHasNextPage(page.hasNext());
		paginationResponseDto.setResponse(response);
		return paginationResponseDto;
	}

	public static long getStartIndex(final long pageNumber, final long pageSize) {
		return (pageNumber - 1) * pageSize;
	}
	
	public static void validatePageNoAndPageSize(int pageNumber, int pageSize) throws ValidationException {
		if (pageNumber < 1) {
			log.error("Page number can not be less than 1");
			throw new ValidationException("Page number can not be less than 1");
		}
		if (pageSize < 1) {
			log.error("Page size can not be less than 1");
			throw new ValidationException("Page size can not be less than 1");
		}
	}
	
	public static void validateMaxResultSize(int pageNumber) {
		if (pageNumber > PaginationUtil.MAX_RESULT_SIZE) {
			log.error("Maximum course limit per is " + PaginationUtil.MAX_RESULT_SIZE);
			throw new ValidationException("Maximum course limit per is " + PaginationUtil.MAX_RESULT_SIZE);
		}
	}
	
	public static int getJPAPageNumber(final int pageNumber) {
		return (pageNumber - 1);
	}
	
	public static void calculatePagination(final int startIndex, final int pageSize, final int totalCount, PaginationResponseDto<?> paginationUtilDto) {
		boolean hasPreviousPage = false;
		boolean hasNextPage = false;
		int totalPages = totalCount / pageSize;
		if (totalCount % pageSize > 0) {
			totalPages += 1;
		}
		int pageNumber = startIndex / pageSize + 1;

		if (pageNumber != 1 && pageNumber <= totalPages) {
			hasPreviousPage = true;
		}
		if (pageNumber < totalPages) {
			hasNextPage = true;
		}
		paginationUtilDto.setTotalCount(Long.valueOf(totalCount));
		paginationUtilDto.setTotalPages(Long.valueOf(totalPages));
		paginationUtilDto.setPageNumber(Long.valueOf(pageNumber));
		paginationUtilDto.setHasPreviousPage(hasPreviousPage);
		paginationUtilDto.setHasNextPage(hasNextPage);
	}
}
