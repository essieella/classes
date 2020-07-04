package acsl;

public class sameness {
	public static void main(String[] args) {
		align("ABCDEFT ABXCGBTZFP");
		align("ABCLLLL BDCMLL");
	}
	public static void align(String s) {
		int space = s.indexOf(" ");
		String left = s.substring(0, space);
		String right = s.substring(space + 1, s.length());
		int length; 
		String remainder = "";
		if (left.length() > right.length()) {
			length = right.length();
			remainder = left.substring(right.length(), left.length());
		} else {
			length = left.length();
			remainder = right.substring(left.length(), right.length());
		}
		String newleft = "";
		String newright = "";
		boolean allow = true;
		while (allow) {
			for (int i = 0; i < length; i++) {
				String left_c = left.substring(i, i+1);
				String right_c = right.substring(i, i+1);
				System.out.println("comparing " + left_c + " to " + right_c);
				if (!(left_c.equals(right_c))) {
					System.out.println("doesn't equal");
					newleft = newleft + left_c;
					newright = newright + right_c;
				} else {
					System.out.println("equals");
				}
			}	
			int nequal = 0;
			for (int i = 0; i < newleft.length(); i++) {
				System.out.println("testing");
				if (!(newleft.substring(i, i+1).equals(newright.substring(i, i+1)))) {
					nequal = nequal+1;
					System.out.println(nequal);
				}
				length = newleft.length();
			}
			if (nequal == newleft.length()) {
				System.out.println("end");
				allow = false;
			}
		}
		if (left.length() > right.length()) {
			newleft = newleft + remainder;
		} else {
			newright = newright + remainder;
		}
		System.out.println(newleft + " - " + newright);
	}
	
	public static int sameValue(String first, String second) {
		int length = 0;
		if (first.length() > second.length()) {
			length = second.length();
		} else {
			length = first.length();
		}
		for (int i = 0; i < length; i++) {
			
		}
		return 5;
	}

}

