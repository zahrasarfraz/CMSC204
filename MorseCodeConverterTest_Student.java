package assignment2222;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class MorseCodeConverterTest_Student {
	
	/**
	 * testing for correct conversion of morse code string
	 */
	@Test
	public void testConvertToEnglishString() {	
	    String converter2 = MorseCodeConverter.convertToEnglish(".-- .... .- - / .. ... / -.-- --- ..- .-. / -. .- -- . ");
	    assertEquals("what is your name", converter2);
	}
	
	/**
	 * Testing for correct implementation of tree and traversal
	 */	
	@Test
	public void testPrintTree() {	
		
		assertEquals("h s v i f u e l r a p w j  b d x n c k y t z g q m o", MorseCodeConverter.printTree());
	}
	
	/**
	 * Testing for correct conversion of all characters using key phrase to hit all letters
	 */
	@Test
	public void testConvertMorseStringToEnglishString() {	
	    String converter3 = MorseCodeConverter.convertToEnglish(" - .... .. ... / .. ... / .- / - . ... - / -.-. .- ... . ");
	    assertEquals("this is a test case", converter3);
	}
	
	/**
	 * Testing for correct conversion of morsde code
	 */
	@Test
	public void testConvertMorseFileToEnglishString() {	

		File file = new File("src/howDoILoveThee.txt"); 
		try {
			assertEquals("this is just a testing method", MorseCodeConverter.convertToEnglish(file));
		} catch (FileNotFoundException e) {
		}
	}
	

}


