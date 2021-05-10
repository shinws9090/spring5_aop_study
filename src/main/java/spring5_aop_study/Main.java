package spring5_aop_study;

import spring5_aop_study.aop.Calculator;
import spring5_aop_study.aop.ExeTimeCalaulator;
import spring5_aop_study.aop.ImpeCalculator;
import spring5_aop_study.aop.RecCalculator;

public class Main {
	public static void main(String[] args) {
		int num = 5;
//		tes01(num);
		
		long res = 0;
		ExeTimeCalaulator calaulator = new ExeTimeCalaulator(new ImpeCalculator());
		res= calaulator.factorial(num);
		System.out.printf("%d! = %d %n",num,res);
		
		ExeTimeCalaulator calaulator2 = new ExeTimeCalaulator(new RecCalculator());
		res= calaulator2.factorial(num);
		System.out.printf("%d! = %d %n",num,res);
	}

	private static void tes01(int num) {
		long res = -1;
		long start = 0;
		long end = 0;
		
		Calculator impeCal = new ImpeCalculator();
//		start = System.currentTimeMillis();
		res = impeCal.factorial(num);
//		end = System.currentTimeMillis();
		
//		System.out.printf("실행시간 (%d) 실행시간 = %d %n",num,(end - start));
		System.out.printf("%d! = %d %n",num,res);
		
		Calculator impeCal2 = new RecCalculator();
//		start = System.currentTimeMillis();
		res = impeCal2.factorial(num);
//		end = System.currentTimeMillis();
		
//		System.out.printf("실행시간 (%d) 실행시간 = %d %n",num,(end - start));
		System.out.printf("%d! = %d %n",num,res);
	}
}
