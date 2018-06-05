package com.ying.background.vo;

import lombok.Data;

/**
 * Created by yingsy on 2018/5/28.
 */
@Data
public class PageVO {
    private int curPage = 1; //当前是第几页
    private int maxPage; //一共有多少页
    private int maxRowCount; //一共有多少行
    public int rowsPerPage = 10; //每页多少行
}
