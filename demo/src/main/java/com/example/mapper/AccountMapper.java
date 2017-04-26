package com.example.mapper;

import java.util.List;

import com.example.vo.AccountVO;

public interface AccountMapper {  
	
	public List<AccountVO> query(); 
	
	public void insert(AccountVO accountVO);
}