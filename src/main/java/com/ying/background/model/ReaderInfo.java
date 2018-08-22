package com.ying.background.model;

import lombok.Data;

import java.util.Date;

@Data
public class ReaderInfo {
    private Integer readerId;

    private String name;

    private String sex;

    private Date birth;

    private String address;

    private String telcode;

    private Date createTime;

    private Integer createId;

    private Date modifyTime;

    private Integer modifyId;

    private Integer isDeleted;


}