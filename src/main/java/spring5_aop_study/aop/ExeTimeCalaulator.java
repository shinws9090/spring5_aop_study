package spring5_aop_study.aop;

public class ExeTimeCalaulator implements Calculator{ //프록시 객체 (대행자)핵심 기능클래스는 따로있고 부가적인 기느만 넣은 클래스
	private Calculator delegete;
	
	public  ExeTimeCalaulator(Calculator delegete) {
		this.delegete = delegete;
	}

	@Override
	public long factorial(long num) {
		long start = System.nanoTime();
//		long start = System.currentTimeMillis();
		long res = delegete.factorial(num);
		long end = System.nanoTime();
//		long end = System.currentTimeMillis();
		
		System.out.printf("%s factorial(%d) 실행시간 = %d %n",delegete.getClass().getSimpleName(),num,(end - start));
		return res;
	}

}
