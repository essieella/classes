package collegelist;
import java.util.*; 

public class college {
	college (String a) {
		split(a);
	}

	public static void main(String[] args) {
		// String enter = "Aggarwal, Gesna UMCP Ahearn, Ryleigh UMCP Ahmed, Sanya UMBC Ahn, Jennifer Towson University Akintayo, Tolani Hofstra University Ali, Muhammad HCC Allen, Camryn Towson University Anderson, Ariel Drexel University Andrew, Samuel Philadelphia University Archuleta, Kai HCC Ashraf, Mehnaz UMBC Ayoub, Robert HCC Babkir, Shukran UMBC Babu, Adharsh UMCP Baker, Christopher UMBC Balderas, Paulina HCC Baldy, Mary Ursinus College Bambach, Christina East Carolina University Baroncinni, Jonah HCC Baruch, Jenna New York University Berry, Ashley Virginia Tech Betzer, Amelia Coastal Carolina University Bhamra, Attar HCC Bicknell, Stanley UMCP Billah, Mohammed UMCP Bon, Ann UMBC Boncore, Nancy UMBC Boone, Brian UMBC Boswell, Dylan HCC Bracey, Lauren UMCP Brady, Michael University of Kentucky Breedlove, Justin HCC Breland, Dion HCC Brillante, Isabella La Salle University Burk, Vernon UMCP Byun, Suzie MIT Cabonilas, Kyle UMBC Cagas, Stephen UMBC Caldis, Madeline University of Minnesota, Twin Cities Calloway, Grace UMCP Carandang, Maria Yvonne UMBC Carmichael, Emmanuel North Carolina A&T State University Cary, Logan UMBC Chae, Christy UMBC Chan, Anna UMCP Chang, Mike UMBC Chen, Andrew UMCP Chen, Ken University of Cincinnati College Conservatory of Music Chen, Madeleine UMCP Choe, Sean HCC Choi, Yeeun Johns Hopkins University Cleary, Joseph UMBC Cleary, Michael Towson University "; 
		String enter = "Aaaa, Gggg University of Colorado AAAA, rrrr UMCP";
		college a = new college(enter);
		// a.getStats();
		// split into array
		// delete string, string
		// possibly delete -
		// take out duplicates
	}

	// only works if there is a space at the end
	public static ArrayList<String> split(String enter) {
		int last = 0;
		ArrayList<String> arr = new ArrayList<String>(300);
		for (int i = 0; i < enter.length(); i++) {
			if (enter.substring(i, i+1).equals(" ")) {
				arr.add(enter.substring(last, i));
				last = i + 1;
			}
		}

		for (int i = 2; i < arr.size(); i++) {
			// check pattern 1 name, name
			// check for pattern 2 name, name
			// if pattern1 and pattern 2 return true
			// add strings between them
			// remove null arrayList elements
			Boolean pattern1 = false;
			Boolean pattern2 = false;
			if (arr.get(i - 2).indexOf(",") != -1) {
				pattern1 = true;
			}
			int index = 0;
			for (int j = i; j < arr.size(); j++) {
				if (arr.get(j).indexOf(",") != -1) {
					index = j;
					pattern2 = true;
				} 
			if (pattern1 && pattern2) {
				String b = "";
				for (int n = i; n < index; n++) {
					b = b + arr.get(n);
				}
				arr.add(b);
			}

			}
		}
		
		for (int i = 0; i < arr.size() - 1; i++) {
			String item = arr.get(i);
			String next = arr.get(i+1);
			int end = item.length();
			if (item.substring(end - 1, end).equals(",")) {
				arr.remove(item);
				arr.remove(next);
			}
		}



		// checking
		for (int i = 0; i < arr.size(); i++) {
			System.out.println(arr.get(i));
		}
		return arr;
	}

	public static void getStats() {

	}
}
