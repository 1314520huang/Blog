package com.netstudy.common.bean;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


/**
 * 分页对象
 *
 * @author Chen Huang @ forstudy
 * @since 2019-05-05
 */
@Data
public class PagedList<T> {

    // 第一页
    private Integer firstPage = 1;
    // 当前页
    private Integer currentPage;
    // 每页多少条数据
    private Integer pageSize;
    // 上一页
    private Integer prvePage;
    // 下一页
    private Integer nextPage;
    // 一共多少条数据
    private Integer totalCount;
    // 总共多少页
    private Integer totalPage;
    // 尾页
    private Integer endPage;
    // 这一页所包含的数据
    List<T> data = new ArrayList<>();

    /**
     * 传入我们不能计算的数据(pageSize,currentPage,totalCount) pageSize:是我们在Query里面自己决定的
     * currentPage：用户访问的时候生成的 totalCount：从数据库中查询出来的
     *
     */
    public PagedList(Integer pageSize, Integer currentPage, Integer totalCount) {

        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        // 计算一共多少页
        this.totalPage = this.totalCount % this.pageSize > 0 ? this.totalCount
                / this.pageSize + 1 : this.totalCount / this.pageSize;


        //计算最后一页
        this.endPage = this.totalPage;
        //上一页(保证上一页不能小于1)
        this.prvePage = this.currentPage-1<1?1:this.currentPage-1;
        //下一页(保证下一页不大于最后一页)
        this.nextPage = this.currentPage+1>this.endPage?this.endPage:this.currentPage+1;
    }
}
