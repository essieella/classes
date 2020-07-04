package smorse;

public class smorse {
	String[] morse = {"._", "_...", "_._.", "_..", ".", ".._.", "__.", "....", "..", ".___", "_._", "._..", "__", "_.", "___", ".__.","__._", "._.", "...", "_", ".._", ".._", "..._", ".__", "_.._", "_.__", "__.."};
	String[] alphabet = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "y", "x", "z"};
	public static void main(String str[]) {
		// instance variables
		smorse a = new smorse();
		System.out.println(a.combo("ab"));
		assert (a.combo("ab") == ".__...");
	}
	public String combo(String word) {
		String place = "";
		for (int j = 0; j < word.length(); j++) {
			for (int i = 0; i < 26; i++) {
				if (alphabet[i].equals(word.substring(j, j + 1))) {
					place = place + morse[i];
				}
			}
		}
		return place;
	}
}
