package spring5_aop_study;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import spring5_aop_study.aop.Calculator;
import spring5_aop_study.aop.RecCalculator;
import spring5_aop_study.config.AppCtx;

public class MainAspect {
	
	public static void main(String[] args) {
		try(AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppCtx.class)){
			RecCalculator cal = ctx.getBean("calculator",RecCalculator.class);
			long fiveFact = cal.factorial(5);
			System.out.printf("cal.factorial()=%d%n",fiveFact);
			System.out.printf(cal.getClass().getName());
		}
	}
}
