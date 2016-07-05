package com.example.android.newsapp.model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Muhammad Muzammil on 7/5/2016.
 */

public class Response {
    private String total;

    private String startIndex;

    private Results[] results;

    private String orderBy;

    private String status;

    private String pages;

    private String pageSize;

    private String currentPage;

    private String userTier;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(String startIndex) {
        this.startIndex = startIndex;
    }

    public ArrayList<Results> getResults() {
        if (results == null)
            return null;
        return new ArrayList<Results>(Arrays.asList(results));
    }

    public void setResults(Results[] results) {
        this.results = results;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPages() {
        return pages;
    }

    public void setPages(String pages) {
        this.pages = pages;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getUserTier() {
        return userTier;
    }

    public void setUserTier(String userTier) {
        this.userTier = userTier;
    }

    @Override
    public String toString() {
        return "ClassPojo [total = " + total + ", startIndex = " + startIndex + ", results = " + results + ", orderBy = " + orderBy + ", status = " + status + ", pages = " + pages + ", pageSize = " + pageSize + ", currentPage = " + currentPage + ", userTier = " + userTier + "]";
    }
}