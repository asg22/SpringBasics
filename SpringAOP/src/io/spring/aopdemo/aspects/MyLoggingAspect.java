package io.spring.aopdemo.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

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
}
