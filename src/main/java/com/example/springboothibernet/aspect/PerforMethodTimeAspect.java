package com.example.springboothibernet.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PerforMethodTimeAspect {
	private long starttime;
	private final static Logger LOGGER=LoggerFactory.getLogger(PerforMethodTimeAspect.class);
	/*@Before("execution (* com.example.springboot.Controller.*.*(..))")
	public void beforemethod()
	{
		starttime=System.currentTimeMillis();
		
	}
	@After("execution (* com.example.springboot.Controller.*.*(..))")
	public void aftermethod()
	{
		long endtime=System.currentTimeMillis();
		long time=endtime-starttime;
		LOGGER.info("Time taken to execute the method is "+time);
	}*/
	@Around("execution (* com.example.springboot.Controller.*.*(..))")
	public Object arroundmethod(ProceedingJoinPoint jp) {
		
		String methodname=jp.getSignature().getName();
		String classname=jp.getTarget().getClass().toString();
		long satrttime=System.currentTimeMillis();
		Object obj=null;
	
		try {
			obj=jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long endtime=System.currentTimeMillis();
		
		long time=endtime-starttime;
		LOGGER.info("Time taken to execute the method "+methodname+"of the "+classname+"  is "+time);
		return obj;
	}


}
