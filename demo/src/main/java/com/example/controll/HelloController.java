package com.example.controll;
import javax.annotation.Resource;  
  
import org.slf4j.Logger;  
import org.slf4j.LoggerFactory;  
import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.data.redis.core.StringRedisTemplate;  
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RestController;  
  
@RestController  
public class HelloController {  
      
	protected static Logger logger=LoggerFactory.getLogger(HelloController.class);  
     
    @RequestMapping("/")  
    public String helloworld(){  
        logger.debug("访问hello");  
        return "Hello world!";  
    }  
      
    @RequestMapping("/hello/{name}")  
    public String helloName(@PathVariable String name){  
        logger.debug("访问helloName,Name={}",name);  
        return "Hello "+name;  
    }  
}