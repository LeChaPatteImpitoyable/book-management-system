package com.ying.background.model;

import lombok.Data;

@Data
public class VerifyCodeSession
{
	private int id;
	private String token;
	private String ip;
	private String mobile;
	private String password;
	private String uid;
	private long time;

}
