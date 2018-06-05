package com.ying.background.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yingsy on 2018/5/20.
 */
@Data
public class BookDTO {

    private Integer id;
    private String bookNo;
    private String bookName;
    private BigDecimal price;
    private Integer status;
    private String createTime;
    private Integer createId;
    private String modifyTime;
    private Integer modifyId;

}
