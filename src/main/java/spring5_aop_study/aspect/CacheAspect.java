package spring5_aop_study.aspect;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;

@Aspect
@Order(2)
public class CacheAspect {
	private Map<Long, Object> cache = new HashMap<Long, Object>();
	
	@Pointcut("execution(public * spring5_aop_study.aop..*(long))")
	private void publicTarget() {}
	
	@Around("publicTarget()")
	public Object execute(ProceedingJoinPoint joinPoint) throws Throwable {
		
		Long num = (Long) joinPoint.getArgs()[0];
		
		if(cache.containsKey(num)) {
			System.out.printf("CacheAspect: Cache에서 구함[%d]\n",num);
			return cache.get(num);
		}
		
		Object res = joinPoint.proceed();
		cache.put(num,res);
		System.out.printf("CacheAspect: Cache에 추가[%d]\n",num);
		return res;
		
	}
}
