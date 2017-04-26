package com.example.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dao.PersonDAO;
import com.example.vo.PersonVO;

@RestController
public class ObjectRedisController  {
	 protected static Logger logger=LoggerFactory.getLogger(ObjectRedisController.class);  
     
	    @Autowired  
	    PersonDAO personDao;
	      
	    @RequestMapping("/setPerson")  
	    public void set(String id,String name,Integer age){  
	        logger.debug("访问setPerson:id={},name={},age={}",id,name,age);  
	        PersonVO person=new PersonVO(id,name,age);  
	        personDao.save(person);  
	    }  
	    
	    @RequestMapping("/getPerson")  
	    public PersonVO getPerson(String id){  
	        return personDao.getPerson(id);  
	    }  
	      
}

