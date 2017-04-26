package com.example.controll;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.PersonDAO;
import com.example.mapper.AccountMapper;
import com.example.vo.AccountVO;
import com.example.vo.PersonVO;

@RestController
@RequestMapping("/account")
public class AccountMybatisController  {
	
	 protected static Logger logger=LoggerFactory.getLogger(AccountMybatisController.class);  
     
	    @Resource  
	    AccountMapper accountMapper;  
	      
	    @RequestMapping("/setPerson")  
	    public void set(String id,String loginName,String password){  
	        logger.info("访问setPerson:id={},name={},age={}",loginName,password);  
	        AccountVO account=new AccountVO(loginName,password);  
	        accountMapper.insert(account);  
	    }  
	    
	    @RequestMapping("/getPerson")  
	    public List<AccountVO> getPerson(){  
	        return accountMapper.query();  
	    }  
	      
}

