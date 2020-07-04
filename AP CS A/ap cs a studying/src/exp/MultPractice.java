package exp;

public class MultPractice {
	private static int first;
	private static int second;
	MultPractice(int one, int two) {
		first = one;
		second = two;
	}
	
	public static String getProblem() {
		return first + " TIMES "  + second;
	}
	
	public static void nextProblem() {
		second++;
	}
	
	public static void main(String[] args) {
		MultPractice a = new MultPractice(7, 3);
		System.out.println(a.getProblem());
		a.nextProblem();
		System.out.println(a.getProblem());
		MultPractice b = new MultPractice(6,3);
		System.out.println(b.getProblem());
		b.nextProblem();
		System.out.println(b.getProblem());
		a.nextProblem();
		System.out.println(a.getProblem());

	}

}
