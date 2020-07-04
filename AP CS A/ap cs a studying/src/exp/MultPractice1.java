package exp;

public class MultPractice1 {
	private int first;
	private int second;
	MultPractice1(int one, int two) {
		first = one;
		second = two;
	}
	
	public String getProblem() {
		return first + " TIMES "  + second;
	}
	
	public void nextProblem() {
		second++;
	}
	
	public static void main(String[] args) {
		MultPractice1 a = new MultPractice1(7, 3);
		System.out.println(a.getProblem());
		a.nextProblem();
		System.out.println(a.getProblem());
		MultPractice1 b = new MultPractice1(6,3);
		System.out.println(b.getProblem());
		b.nextProblem();
		System.out.println(b.getProblem());
		a.nextProblem();
		System.out.println(a.getProblem());

	}
}
