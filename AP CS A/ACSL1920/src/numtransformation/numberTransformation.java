// package numtransformation;

public class numberTransformation {
	public static void main(String args[]) {
		// assert numberchange(102439, 3) == 546415;
		// assert numberchange(4329, 1) == 3219;
		// assert numberchange(296351, 5) == 193648;
		// assert numberchange(762184, 3) == 873173;
		// assert numberchange(45873216, 7) == 95322341;
		// assert numberchange(19750418, 6) == 86727361;
		// assert numberchange(386257914, 5) == 831752441;
	}
	public static int numberchange(int N, int P) {
		String s = "" + N + "";
		int arr[] = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			arr[i] = N % 10;
			N = N/10;
		}
		for (int i = 0; i < P - 1; i++) {
			arr[i] = Math.abs(arr[i] - arr[P - 1]);
		}
		for (int i = P; i < s.length(); i++) {
			arr[i] = (arr[i] + arr[P - 1]) % 10;
		}
		int end = 0;
		for(int i = 0; i < s.length(); i++) {
			double result = Math.pow(10, i);
			end = end + arr[i] * (int)result;
		}
		return end;
	}
}
