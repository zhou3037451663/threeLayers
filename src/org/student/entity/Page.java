package org.student.entity;

import java.util.List;

/**
 * @Author: Mr.Zhou
 * @Date 2020/1/3
 * @Explain:
 */
public class Page {
    private int currentPage;//当前页
    private int pageSize;//页面大小
    private int totalCount;//总数据
    private int totalPage;//总页数
    private List<Student> students;//当前页的数据集合

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }
    /*
     *总页数=数据总数%页面大小==0?总数居/页面大小:数据总数/页面大小+1；
     *当我们调用了数据总数set()和页面大小的set()后，自动计算出总页数
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
        this.totalPage=this.totalCount%this.pageSize==0?this.totalCount/this.pageSize:this.totalCount/this.pageSize+1;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

//    public void setTotalPage(int totalPage) {
//        this.totalPage = totalPage;
//    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
