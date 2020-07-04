package factorialCalculator;
public class FactorialCalculator {
	public static void main(String str[]) {
		for (int i = 0; i < 21; i++) {
		  System.out.println(FactorialCalculator.factorial(i));
		}
	}
	
	public static int factorial(int num) {
		int final_num = 1;
		for (int i = 1; i < num+2; i++) {
			final_num *= i;
		}
		return final_num;
	}
}
