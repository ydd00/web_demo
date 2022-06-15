package com.ydd.pojo;

import java.util.List;

public class PageBean<T> {
    List<T> rows;
    int totalCount;

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalcount) {
        this.totalCount = totalcount;
    }
}
