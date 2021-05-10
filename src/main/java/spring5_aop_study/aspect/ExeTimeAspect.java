package spring5_aop_study.aspect;


import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect // 여러객체에 공통으로 적용되는 기능
@Order(1)
public class ExeTimeAspect {
	
	@Pointcut("execution(public * spring5_aop_study.aop..*(..))")
	private void publicTarget() {}
	
	@Around("publicTarget()")
	public Object measure(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.nanoTime();
		try {
			Object res = joinPoint.proceed();
			return res;
		}finally {
			long end = System.nanoTime();
			Signature sig = joinPoint.getSignature();// 호출되는 메서드의 종류
			System.out.printf("%s.%s(%s) 실행시간 = %d %n",joinPoint.getTarget().getClass().getSimpleName(),
					sig.getName(),Arrays.deepToString(joinPoint.getArgs()),(end - start));
		}
		
	}
}
