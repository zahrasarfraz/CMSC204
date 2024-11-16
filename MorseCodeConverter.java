package assignment2222;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * converts morse code into englsih
 * @author ZahraSarfraz
 */
public class MorseCodeConverter {

	private static MorseCodeTree Tree = new MorseCodeTree();
	
	//Converts a file of Morse code into English Each letter 
	/**
	 * Converts a file of morsecode into english
	 * @param codeFile name of the file that contains the morse code
	 * @return englsih translation of the file
	 * @throws FileNotFoundException if the file is not found
	 */
	public static String convertToEnglish(File codeFile) throws FileNotFoundException {
		
	    Scanner scanner = new Scanner(codeFile);
	    String fResult = ""; 
	    while (scanner.hasNextLine()) {
	        String line = scanner.nextLine();
	        fResult += convertToEnglish(line); // Convert each line and add to result
	    }
	    scanner.close();//ffor the scanner leak
	    return fResult; 
	}

	//Converts Morse code into English. Each letter is delimited by a space (‘ ‘). 
	//Each word is delimited by a ‘/’.?????
	/**
	 * Converts morse code into englsih
	 * @param code the morse code
	 * @return the englsih translation
	 */
	public static String convertToEnglish(String code) {
	    String result = ""; 
	    String letter = ""; 

	    for (int i = 0; i < code.length(); i++) {
	        char z = code.charAt(i);

	        if (z == ' ') { 
	            if (!letter.isEmpty()) {
	                result += Tree.fetch(letter); // Convert Morse to English
	                letter = ""; 
	            }
	        } else if (z == '/') { 
	            if (!letter.isEmpty()) {
	                result += Tree.fetch(letter);
	                letter = ""; 
	            }
	            result += " "; 
	        } else {
	            letter += z; 
	        }
	    }
	    
	    if (!letter.isEmpty()) {
	        result += Tree.fetch(letter); 
	    }
	    return result; 
	}

	//returns a string with all the data in the tree in LNR order with an space in between them. 
	//Uses the toArrayList method in MorseCodeTree It should return the data in this order:
	//"h s v i f u e l r a p w j b d x n c k y t z g q m o"
	//Note the extra space between j and b - that is because there is an empty string that is the root, and in the LNR traversal,
	//the root would come between the right most child of the left tree (j) and the left most child of the right tree (b).
	//This is used for testing purposes to make sure the MorseCodeTree has been built properly
	/**
	 * Returns a string with all the data in the tree
	 * @return data data in the tree
	 */
	public static String printTree() {

	    String data = "";
	    ArrayList<String> tree = Tree.toArrayList();
	    
	    for (int i = 0; i < tree.size(); i++){
	        data += tree.get(i); // Add the data
	        if (i < tree.size() - 1) {
	            data += " "; // Add space only between elements
	        }
	    }
	    return data; 
	}
		

}
