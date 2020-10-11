package io.spring.aopdemo.aspects;

import java.sql.Time;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import io.spring.aopdemo.entity.Account;

@Aspect
@Component
@Order(2)
public class MyLoggingAspect {

	@Pointcut("execution(public * io.spring.aopdemo.DAO.*.add*(..))")
	public void forDAOPackage(){}
	
	@Pointcut("execution(public * io.spring.aopdemo.DAO.*.set*(..))")
	public void setter(){}
	
	@Pointcut("execution(public * io.spring.aopdemo.DAO.*.get*(..))")
	public void getter(){}
	
	@Pointcut("forDAOPackage() && !(setter() || getter())")
	public void finalPtCutExpression(){}
	
	@Before("finalPtCutExpression()")
	public void beforeAddAccountMethodAdvice(JoinPoint theJointPoint)
	{
		MethodSignature signature = (MethodSignature)theJointPoint.getSignature();
		
		
		System.out.println("Running @Before method:"+signature);
		
		Object[] args = theJointPoint.getArgs();
		
		for(Object arg :args)
		{
			System.out.println("Running @Before method:"+arg);
		}
	}
	
	
	@AfterReturning(pointcut="execution(public * io.spring.aopdemo.DAO.*.find*(..))",returning="result")
	public void afterReturningfindAccountsMethodAdvice(JoinPoint theJointPoint,List<Account> result)
	{
		MethodSignature signature = (MethodSignature)theJointPoint.getSignature();
		
		
		System.out.println("Running @AfterReturning method:"+signature);
		
		List<Account> result1 = result;
		
		for(Account arg :result1)
		{
			System.out.println("Running @AfterReturning method:"+arg.getName());
			System.out.println("Running @AfterReturning method:"+arg.getLevel());
		}
		
		result1.add(new Account("New Akshay", 6));
	}
	@After("execution(public * io.spring.aopdemo.DAO.*.find*(..))")
	public void afterfindAccountsMethodAdvice(JoinPoint theJointPoint)
	{
		MethodSignature signature = (MethodSignature)theJointPoint.getSignature();
		
		
		System.out.println("Running @After method:"+signature);
	}
	
	@AfterThrowing(pointcut="execution(public * io.spring.aopdemo.DAO.*.find*(..))",throwing="result")
	public void afterThrowingfindAccountsMethodAdvice(JoinPoint theJointPoint,Throwable result)
	{
		MethodSignature signature = (MethodSignature)theJointPoint.getSignature();
		
		
		System.out.println("Running @AfterThrowing method:"+signature);
		System.out.println("Running @AfterThrowing method:"+result);
	}
	
	@Around("execution(public * io.spring.aopdemo.DAO.*.find*(..))")
	public Object afterfindAccountsMethodAdvice(ProceedingJoinPoint theJointPoint) throws Throwable
	{
		MethodSignature signature = (MethodSignature)theJointPoint.getSignature();
		
		
		System.out.println("Running @After method:"+signature);
		Long start =System.currentTimeMillis();
		Object p=null;
		try
		{
			 p = theJointPoint.proceed();
		}
		catch(Exception e)
		{
			System.out.println("exception occurred");
			p="returning result";
		}
		Long end =System.currentTimeMillis();
		Long t=end-start;
		System.out.println("time:" +t/1000.0 +" seconds" );
		return p;
	}
	
}
