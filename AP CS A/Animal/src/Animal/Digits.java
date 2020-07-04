package Animal;
import java.util.ArrayList;

public class Digits {
	private ArrayList<Integer> digitList;
	public Digits(int num) {
		digitList = new ArrayList<Integer>();
		int digit = num % 10;
		num = num/10;
		digitList.add(num);
		while(num > 0) {
			digit = num % 10;
			digitList.add(digit);
			num = num/10;
		}
		for (int i = 0; i < digitList.size(); i++) {
			System.out.println(digitList.get(i));
		}
	}
	public static void main(String[] args) {
		Digits a = new Digits(10537);
		
	}
}
