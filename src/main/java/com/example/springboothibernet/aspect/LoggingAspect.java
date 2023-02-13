package com.example.springboothibernet.aspect;

import java.util.Optional;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private final static Logger LOGGER=LoggerFactory.getLogger(LoggingAspect.class);
	   @Before("execution (* com.example.springboot.Controller.*.*(..))")
		public void beforemethod(JoinPoint jp)
		{
		   String  methodname=jp.getSignature().getName();
		   String classname=jp.getTarget().getClass().toString();
		   LOGGER.info("enter into the method"+methodname+"of the"+classname);
			
		}
	   @After("execution (* com.example.springboot.Controller.*.*(..))")
		public void aftermethod(JoinPoint jp)
		{
		   String  methodname=jp.getSignature().getName();
		   String classname=jp.getTarget().getClass().toString();
		   LOGGER.info("After into the method"+methodname+"of the"+classname);
			
		}
	   @AfterReturning(pointcut = "execution (* com.example.springboot.Controller.*.*(..))",
				returning = "obj")

	   public void Afterteturning(Object obj)
	   {
			if(obj instanceof Optional ) {
				LOGGER.info("obj is book type");
				Optional optional = (Optional)obj;
				LOGGER.info("After processing : "+optional);
			}
			LOGGER.info("After retruning");

	   }
	   
	   
}
