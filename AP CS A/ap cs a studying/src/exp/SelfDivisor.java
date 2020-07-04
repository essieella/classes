package exp;

public class SelfDivisor {
	public static boolean isSelfDivisor(int number) {
		int n = number;
		while(n > 0) {
			n = n % 10;
			if (!(number % 8 == 0)) {
				return false;
			} else if (n == 0) {
				return false;
			}
			n = n/10;
		} return true;
	}
	
	public static int[] firstNumSelfDivisors(int start, int num) {
		int[] arr = new int[num];
		int n = start;
		for (int i = 0; i < num; i++) {
			if (isSelfDivisor(n)) {
				arr[i] = n;
				n++;
			} else {
				n++;
				i--;
			}
		} return arr;
	}
	
	public static void main(String[] args) {
//		System.out.println(isSelfDivisor(10));
//		System.out.println(isSelfDivisor(128));
//		System.out.println(isSelfDivisor(26));
//		System.out.println(isSelfDivisor(24));
		int[] a = firstNumSelfDivisors(10, 3);
		for (int i = 0; i < 3; i++) {
			System.out.println(a[i]);
		}
	}
}
