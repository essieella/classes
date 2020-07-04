package BCD;
public class BCD {
	private int[] digits;
	BCD (int[] bcdDigits) {
		digits = new int[bcdDigits.length];
		for (int i = 0; i < bcdDigits.length; i++) {
			digits[i] = bcdDigits[i];
		}	
	}

	private int digit;
	BCD (int num) {
		digit = num % 10;
		num = num / 10;
		digits = new int[1]; 
		digits[0] = digit; 
		while (num > 0) { 
			digit = num % 10; 
			addADigit(digit);
			num = num/10; 
		}	
	}

	public static void main(String args[]) {
		// BCD2test();
		// BCD3test();
		// BCD4test();
        // BCD5test();
		
       /*
		// 120
		System.out.println(factorial(5));
		
		// 720
		System.out.println(factorial(6));
		
		// 5,040
		System.out.println(factorial(7));
		
		// 4,0320
		System.out.println(factorial(8));
		
		// 362,880
		System.out.println(factorial(9));
		
		// 3,628,800
		System.out.println(factorial(10));
		
		// 0
		System.out.println(factorial(0));
		*/
		
		
		// actual test for factorial
		
		// System.out.println(factorial(52));
		// System.out.println(factorial(104));
		
		/*
		// 8
		BCD a = new BCD(2);
		System.out.println(a.pow(3));
		
		// 2401
		BCD b = new BCD(7);
		System.out.println(b.pow(4));
		
		// 0
		BCD c = new BCD(0);
		System.out.println(c.pow(3));
		
		// 248,832
		BCD d = new BCD(12);
		System.out.println(d.pow(5));
		
		*/
		
		// actual test for pow
		
		// 2 raised to the 127th power
		// BCD e = new BCD(2);
		// System.out.println(e.pow(127));
		
		// 19 raised to the 19th power
		// BCD f = new BCD(19);
		// System.out.println(f.pow(19));
	}
	
	public static BCD factorial(int num) {
		BCD fact = new BCD(num);
		BCD other;
		for (int i = num - 1; i >= 1; i--) {
			other = new BCD(i);
			fact = fact.multiplyBCDs(other);
		}
		return fact;
		
	}
	
	public BCD pow(int num) {
		BCD temp = this;
		for (int i = 0; i < num - 1; i++) {
			temp = temp.multiplyBCDs(this);
		}
		return temp;
	}
	
	public BCD addBCDs(BCD other) {
		int num;
		int carryover = 0;
		int length;
		int place = 0;
		if (this.numberOfDigits() > other.numberOfDigits()) {
			length = this.numberOfDigits(); //0
		} else if (this.numberOfDigits() < other.numberOfDigits()){
			length = other.numberOfDigits();
		} else {
			length = other.numberOfDigits();
		}
		num = this.nthDigit(0) + other.nthDigit(0); //0
		if (num/10 > 0) {
			carryover = num/10;
			num = num - 10;
			place = num;
		} else {
			carryover = 0;
			place = num;
		}
		BCD ans = new BCD(place);
		for (int i = 1; i < length; i++) {
			num = this.nthDigit(i) + other.nthDigit(i) + carryover;
			if (num/10 > 0) { 
				carryover = num/10;
				num = num - 10; 
				ans.addADigit(num); 
			} else { 
				carryover = 0;
				ans.addADigit(num);
			}
		}
		if (carryover > 0 ) {
			ans.addADigit(carryover);
		}
		return ans;
	}

	public int numberOfDigits() {
		return digits.length;
	}

	public int nthDigit(int n) {
		if ( n >= digits.length) {
			return 0;
		} else {
			return digits[n];
		}
	}

	private int diagonalSum(int[][] lattice, int column, int row) {
		int sum = lattice[row][column];
		int width = lattice[0].length;
		while (column < width - 1 && row > 0) {
			sum = sum + lattice[row - 1][column + 1];
			column = column + 1;
			row = row - 1;
		}
		return sum;

	}

	private int[] addDiagonals(int[][] lattice){          
		int height = lattice.length; //4    
		int width = lattice[0].length; //3 
		int diagonals = width+height-1;          
		int[] result = new int[diagonals];
		int diag = diagonals-1;
		//Add the diagonals that end at the bottom          
		for (int col=width-1;col>=0;col--){         
			result[diag] = diagonalSum(lattice,col,height-1);               
			diag--;          
		}
		//Add the diagonals that end at the left side          
		for (int row = height-2; row>=0; row--){              
			result[diag] = diagonalSum(lattice,0,row);               
			diag--;          
		}      
		// for (int i = 0; i < result.length; i++) {
		// System.out.println(result[i]);
		// }
		return result;     
	}

	public BCD multiplyBCDs (BCD other) {
		int width = this.numberOfDigits();
		int length = other.numberOfDigits();
		int place = 0;
		int[][] A = new int[width][length];
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < length; y++) {
				A[x][y] = this.nthDigit(x) * other.nthDigit(y);
			}
		}
		BCD answerBCD = new BCD(place);
		int remaining = 0;
		int sum = 0;
		int counter = 0;
		int[] obj = answerBCD.addDiagonals(A);
		// for (int i = 0; i < 1; i++) {
		// 	System.out.println(obj[i]);
		//}
		for (int i = 0; i < width + length - 1; i++) { // runs once
			sum = obj[i]; // 20
			if (i > 0 ) { // yes
				sum = sum + remaining; // 20
			}
			int ones = sum % 10; // 0
			remaining = sum/10; // 2
			if (i == 0) {
				answerBCD = new BCD(ones); // = 0
				// System.out.println(answerBCD);
			} else {
				answerBCD.addADigit(ones);
			}
			if (remaining > 0 && i == width + length - 2) { // 
				answerBCD.addADigit(remaining);
				// System.out.println(answerBCD);
			}
			if(ones == 0 && width + length - 1 != 1) {
				counter = counter + 1;
			}
		}
		if (counter == width + length - 1) {
			answerBCD = new BCD(0);
		}
		return answerBCD;
	}

	public void addADigit(int newdigit) {
		// makes a new array with one element larger than the digits array
		int[] newArr = new int[digits.length + 1];
		// for loop to load elements of the digit array into the newArr
		for (int i = 0; i < digits.length; i++) {
			newArr[i] = digits[i];
			// System.out.print(newArr[i]);
		}
		newArr[digits.length] = newdigit;
		digits = newArr;
	}

	public String toString() {
		// 44321 --> 12,344
		//7654321 --> 11234567
		String place = "";
		for (int i = digits.length - 1; i >= 0; i--) {
			place = place + digits[i];
			if ((i % 3 == 0) && (i > 0)) {
				place = place + ",";
			}
		}
		return place;
	}
	
	public static void BCD5test() {
		/*
		// 20 
		BCD a2 = new BCD(5);
		BCD b2 = new BCD(4);
		System.out.println(a2.multiplyBCDs(b2));
		
		// two BCDs with at least three digits --> 1,597,953
		BCD a = new BCD(4857);
		BCD b = new BCD(329);
		System.out.println(a.multiplyBCDs(b));
		System.out.println(b.multiplyBCDs(a));

		// two BCDs with at least three digits --> 347,582,160
		BCD a1 = new BCD(2896518);
		BCD b1 = new BCD(120);
		System.out.println(a1.multiplyBCDs(b1));
		System.out.println(b1.multiplyBCDs(a1));

		// one BCD with one digit one longer --> 16,728
		BCD c1 = new BCD(17);
		BCD d1 = new BCD(984);
		System.out.println(c1.multiplyBCDs(d1));
		System.out.println(d1.multiplyBCDs(c1));
		
		//861
		BCD c = new BCD(7);
		BCD d = new BCD(123);
		System.out.println(c.multiplyBCDs(d));
		System.out.println(d.multiplyBCDs(c));

		// two BCDs with one digit --> 21
		BCD e = new BCD(3);
		BCD f = new BCD(7);
		System.out.println(e.multiplyBCDs(f));
		System.out.println(f.multiplyBCDs(e));

		// two BCDs are zero
		BCD g1 = new BCD(0);
		BCD h1 = new BCD(0);
		System.out.println(g1.multiplyBCDs(h1));
		System.out.println(h1.multiplyBCDs(g1));

		// two long BCDs, each containing at least one digit as zero --> 1,080
		BCD i = new BCD(10);
		BCD j = new BCD(108);
		System.out.println(i.multiplyBCDs(j));
		System.out.println(j.multiplyBCDs(i));

		// two long BCDs, one divisible by 10, the other not --> 127,300
		BCD k = new BCD(100);
		BCD l = new BCD(1273);
		System.out.println(k.multiplyBCDs(l));
		System.out.println(l.multiplyBCDs(k));
	
		//error
		// one BCD is zero --> 0
		BCD g = new BCD(0);
		BCD h = new BCD(144);
		System.out.println(g.multiplyBCDs(h));
		System.out.println(h.multiplyBCDs(g));
		
		// 117,511,252,239
		BCD m = new BCD(1347);
		BCD n = new BCD(87239237);
		System.out.println(m.multiplyBCDs(n));
		System.out.println(n.multiplyBCDs(m));
		*/
	}
	
	public static void BCD4test() {
		/*
		// both BCDs are zero → 0
		BCD b1 = new BCD(0);
		BCD b2 = new BCD(0);
		System.out.println(b1.addBCDs(b2));
		System.out.println(b2.addBCDs(b1));

		// the parameter is zero and the one the method is called on is not → 100
		BCD b3 = new BCD(100);
		BCD b4 = new BCD(0);
		System.out.println(b3.addBCDs(b4));

		// the one the method is called on is zero and the parameter is not → 100
		BCD b5 = new BCD(0);
		BCD b6 = new BCD(100);
		System.out.println(b5.addBCDs(b6));

		// the parameter is longer than the one the method is called on  
		// and there is no carry in the last digit → 14
		BCD b7 = new BCD(2);
		BCD b8 = new BCD(12);
		System.out.println(b7.addBCDs(b8));

		// the one the method is called on is longer than the parameter 
		// and there is no carry in the last digit → 14
		BCD c1 = new BCD(12);
		BCD c2 = new BCD(2);
		System.out.println(c1.addBCDs(c2));

		// the one the method is called in is longer than the parameter 
		// and there is a carry from the last digit that makes the 
		// result longer than the parameter → 16
		BCD a1 = new BCD(12);
		BCD a2 = new BCD(4);
		System.out.println(a1.addBCDs(a2));

		// the parameter is longer than the one the method is called on 
		// and there is a carry from the last digit that makes the result longer
		// than the BCD that addBCDs was called on → 16
		BCD a3 = new BCD(4);
		BCD a4 = new BCD(12);
		System.out.println(a3.addBCDs(a4));

		// there is more than one carry → 11,110 
		BCD a5 = new BCD(1234);
		BCD a6 = new BCD(9876);
		System.out.println(a5.addBCDs(a6));
		System.out.println(a6.addBCDs(a5));

		// supposed to equal 12,467
		BCD t1 = new BCD(5678);
		BCD t2 = new BCD(6789);
		System.out.println(t1.addBCDs(t2));
		System.out.println(t2.addBCDs(t1));

		// supposed to equal 10,000
		BCD t3 = new BCD(5);
		BCD t4 = new BCD(9995);
		System.out.println(t3.addBCDs(t4));
		System.out.println(t4.addBCDs(t3));

		// supposed to equal 20,000
		BCD longer = new BCD(10001);
		BCD shorter = new BCD(9999);
		System.out.println(longer.addBCDs(shorter));
		System.out.println(shorter.addBCDs(longer));
		 */
	}

	public static void BCD3test() {
		// BCD m = new BCD(1234);
		// System.out.println(m.toString());
		// BCD n = new BCD(7654321);
		// System.out.println(n.toString());
		// BCD o = new BCD(123);
		// System.out.println(o.toString());
	}

	public static void BCD2test() {
		// int[] a = {3, 2, 1};
		// BCD b = new BCD(a);
		// should print 3 --> prints 3
		// System.out.println(b.numberOfDigits());

		// an n value less than the length
		// should print 2 --> prints 2
		// System.out.println(b.nthDigit(1));
		// an n value equal to the length
		// should print 0 --> prints 0
		// System.out.println(b.nthDigit(3));
		// an n value greater than the length
		// should print 0 --> prints 0
		// System.out.println(b.nthDigit(5));

		// adding 4 to the end
		// should print 1234 --> prints 1234
		// b.addADigit(4);
		// should print 1235 --> prints 1235
		// adding 5 to the end
		// b.addADigit(5);

		//zero test
		// int[] l = {0};
		// BCD k = new BCD(l);
		// System.out.println(k.numberOfDigits());
		// System.out.println(k.nthDigit(0));
		// System.out.println(k.nthDigit(1));
		// k.addADigit(1);

		//one digit number
		// int[] g = {3};
		// BCD h = new BCD(g);
		// System.out.println(h.numberOfDigits());
		// System.out.println(h.nthDigit(0));
		// System.out.println(h.nthDigit(1));
		// h.addADigit(1);

		//two digit number
		//int[] n = {1, 5};
		//BCD m = new BCD(n);
		//System.out.println(m.numberOfDigits());
		//System.out.println(m.nthDigit(0));
		//System.out.println(m.nthDigit(1));
		//System.out.println(m.nthDigit(2));
		//m.addADigit(6);

		//more than two digit number
		// int[] d = {1, 2, 3};
		// BCD c = new BCD(d);
		//System.out.println(c.numberOfDigits());
		//System.out.println(c.nthDigit(0));
		//System.out.println(c.nthDigit(1));
		// System.out.println(c.nthDigit(2));
		// System.out.println(c.nthDigit(3));
		// c.addADigit(4);
	}
}



