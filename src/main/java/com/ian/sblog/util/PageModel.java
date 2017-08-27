package com.ian.sblog.util;

public class PageModel{

    private Integer pageSize;
    private Integer firstLimitParam;
    private Integer currentPage;
    private Integer totalPage;
    private Integer totalRecords;

    public PageModel(){

    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getFirstLimitParam() {
        return firstLimitParam;
    }

    public void setFirstLimitParam(Integer firstLimitParam) {
        this.firstLimitParam = firstLimitParam;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }
}
