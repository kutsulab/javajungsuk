public class RoundTest {
	
	/* 자바의 정석 3판 p.483
	 * java.lang.Math의 메서드 중 반올림에 관한 메서드
	 * 
	 * 1. static long round(double a)
	 *    static long round(float a) 
	 *    소숫점 첫째자리에서 반올림하여 long 타입으로 반환한다.
	 *    수학에서의 일반적인 반올림 방식으로 반올림함.
	 *    예를 들어 0.5는 1로 반올림한다.
	 *    
	 * 2. static double rint(double a)
	 * 
	 *     소숫점 첫째자리에서 짝수 반올림하여 double 타입으로 반환한다.
	 *     짝수 반올림이 생소할 수 있는데, 예를 들어 1.5의 경우 2로 반올림하고, 0.5의 경우는 0으로 반올림한다는 것이다.
	 *     
	 *     왜 이런 반올림 방식이 나왔는지 궁금해서 알아봤는데, 여러가지 실수값을 다루는 상황에서 발생한 문제 때문으로 추정된다.
	 *     일반적인 반올림 방식으로 반올림을 하면 모든 0.5마다 올림을 하게 되는데 이렇게 되면 여러값을 함께 다루는 상황에서 오차가 커지는 경우가 생긴다.
	 *     짝수 반올림을 하게 되면 특정 상황에서는 버리고 특정 상황에서는 올려서, 값들의 총합을 구하는 상황 등에서 일반적인 반올림 방식보다 오차를 줄일 수 있게 된다. 
	 */
	
	public static void main(String[] args) {
		
		double sum = 0, sum1 = 0, sum2 = 0;
		
		for (double d=1.5; d<=10.5; d ++) {
			double d1 = Math.round(d);
			double d2 = Math.rint(d);
			System.out.printf("%4.1f %4.1f %4.1f%n",d,d1,d2);
			sum += d;
			sum1 += d1;
			sum2 += d2;
			
		}
		
		System.out.println("-----------------------------");
		System.out.printf("%4.1f %4.1f %4.1f%n",sum,sum1,sum2);
		// sum : 60.0, sum1 65.0, sum2 60.0
		// rint방식으로 반올림했을 때 round방식으로 했을 때보다 오차가 적어진다.
	}
}