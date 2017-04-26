package com.example.dao;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.example.vo.PersonVO;

@Repository
public class PersonDAO {
	@Autowired  
    RedisTemplate<Object,Object> redisTemplate;  
      
    @Resource(name="redisTemplate")  
    ValueOperations<Object,Object> valOps;  
      
    public void save(PersonVO person){  
    	valOps.set(person.getId(), person);  
    }  
      
    public PersonVO getPerson(String id){  
        return (PersonVO) valOps.get(id);  
    }     
}
