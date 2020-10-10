package io.spring.aopdemo.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class MyLoggingSecondAspect {

	@Pointcut("execution(public * io.spring.aopdemo.DAO.*.apply*(..))")
	public void forDAOPackage(){}
	
	@Pointcut("execution(public * io.spring.aopdemo.DAO.*.set*(..))")
	public void setter(){}
	
	@Pointcut("execution(public * io.spring.aopdemo.DAO.*.get*(..))")
	public void getter(){}
	
	@Pointcut("forDAOPackage() && !(setter() || getter())")
	public void finalPtCutExpression(){}
	
	@Before("finalPtCutExpression()")
	public void beforeApplytMethodAdvice()
	{
		System.out.println("Running @Before method for apply:"+getClass().getCanonicalName());
	}
}
