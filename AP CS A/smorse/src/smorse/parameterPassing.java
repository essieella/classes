package smorse;

public class parameterPassing {
	private int data;
	public int getData() {return data;}
	public void setData(int n) {data = n;}
	
	public static void changeA (int a, int b) {
		a = b;
	}
	
	public static void changeB (int a, parameterPassing b) {
		b.setData(a);
	}
	
	public static void change (parameterPassing a, parameterPassing b) {
		a = b;
	}
	
	public static void changeX (int[] a) {
		int [] b = {10, 11, 12};
		a = b;
	}
	
	public static void changeC (int a, int b, int[] c) {
		c[a] = b;
	}
	
	public static void main(String[] args) {
		int a = 1;
		changeA(a, 2);
		// System.out.println(a); // prints 1
		
		parameterPassing a1 = new parameterPassing();
		a1.setData(4);
		changeB(1, a1);
		System.out.println(a1.getData());
		
		parameterPassing a2 = new parameterPassing();
		a2.setData(5);
		change(a1,a2);
		// System.out.println(a1.getData());
		// System.out.println(a2.getData());
		
		int[] b = {6, 7, 8};
//		changeX(b);
//		for (int i = 0; i < b.length; i++) {
//			System.out.print(b[i] + " ");
//		}
//		changeC(0, 3, b);
//		for (int i = 0; i < b.length; i++) {
//			System.out.print(b[i] + " ");
//		}
	}
	
	
}
