import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.Scanner;

public class cipher2 {

	public static void main(String[] args) {


			@SuppressWarnings("resource")
			Scanner reader = new Scanner(System.in);
			//Scanner reader2 = new Scanner(System.in);

			String stringDeCyphered = null;
			String alphabetString = "abcdefghijklmnopqrstuvwxyz"; // include other characters here
			ArrayList<Character> alphabet = new ArrayList<Character>();
			ArrayList<Integer> index = new ArrayList<Integer>();
			ArrayList<Character> deCyphered = new ArrayList<Character>();

			int alphbetStringLeng = alphabetString.length();

			while (true) {

				index.clear();
				deCyphered.clear();
				
				System.out.println("Write what you want to encrypt/decrypt (no numbers) ");
				String cypher = reader.nextLine();
				
				if (cypher.equals("")) {
					cypher = "";
					System.out.println("no empty strings, try again");
					System.out.println();
					break;
					
				}
				

				for (int i = 0; i < alphbetStringLeng; i++) {
					alphabet.add(alphabetString.charAt(i));
				}

				for (int i = 0; i < cypher.length(); i++) {// takes care of spaces by setting them to -1
					if (Character.isWhitespace(cypher.charAt(i))) {
						index.add(-1);
					} else {// turns the string into an ArrayList of numbers corresponding to the letters
							// position in the alphabet
						index.add(findIndex(alphabet, cypher.charAt(i)));
					}
				}

				for (int i = 0; i < alphbetStringLeng; i++) {
					for (int z = 0; z < cypher.length(); z++) {
						if (index.get(z) != -1) {
							int plusOne = index.get(z);
							plusOne++;
							if (plusOne > (alphbetStringLeng - 1)) {
								plusOne = 0;
							}
							index.set(z, plusOne);
						}
					}
					for (int z = 0; z < cypher.length(); z++) {
						if (index.get(z) == -1) {
							deCyphered.add(' ');
							continue;
						}
						char temp = alphabet.get(index.get(z));
						deCyphered.add(temp);
						stringDeCyphered = deCyphered.stream().map(e -> e.toString()).collect(Collectors.joining());
						// turns the ArrayList into a string
					}
					System.out.println(stringDeCyphered + " " + i);
					deCyphered.clear();
					stringDeCyphered = "";

				}
				stringDeCyphered = "";
				System.out.print("exit, restart ");
				System.out.println();
				String next = reader.nextLine();
				if (next.equals("exit")) {
					break;
				}
			}
		}


	public static int findIndex(ArrayList<Character> arr, char t) {

		// if array is Null
		if (arr == null) {
			return -1;
		}

		// find length of array
		int len = arr.size();

		// traverse in the array
		for (int i = 0; i < len; i++) {

			// if the i-th element is t
			// then return the index
			if (arr.get(i) == t) {
				return i;
			}
		}
		return -1;
	}
}