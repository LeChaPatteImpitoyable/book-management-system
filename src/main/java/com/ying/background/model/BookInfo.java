package com.ying.background.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BookInfo {
    private Long bookId;

    private String name;

    private String author;

    private String publish;

    private String isbn;

    private String language;

    private BigDecimal price;

    private Date pubdate;

    private String classId;

    private Integer pressmark;

    private Short state;

    private Date createTime;

    private Integer createId;

    private Date modifyTime;

    private Integer modifyId;

    private Integer isDeleted;

    private String introduction;
}