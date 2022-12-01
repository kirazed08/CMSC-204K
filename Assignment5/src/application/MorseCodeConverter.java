package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class MorseCodeConverter {
	private static MorseCodeTree  tree = new MorseCodeTree();
	public MorseCodeConverter() {
		
	}
public static String convertToEnglish(File inputFile)throws FileNotFoundException{
	String s = "";
	String []letter;
	String[] word;
	ArrayList<String> list = new ArrayList<String>();
	Scanner scan = new Scanner(inputFile);
	while(scan.hasNext()) {
		list.add(scan.nextLine());
	}
	//scan.close();
	for(int x = 0; x < list.size(); x++) {
	
	word = list.get(x).split(" / ");
	for( int y = 0; y < word.length; y++) {
	
		letter = word[y].split(" ");
		for(int a = 0; a < letter.length; a++) {

			s+= tree.fetch(letter[a]);
		}
		s+=" ";
	}
	}
	s = s.trim();
	return s;
}

public static String printTree() {
	String s = "";
	ArrayList<String> list = new ArrayList<String>();
	list = tree.toArrayList();
	for( int x = 0; x < list.size(); x++) {
		s += list.get(x)+" ";
	}
	return s.trim();
}

public static String convertToEnglish(String code) {

	String s = "";
	String []letter;
	String[]word;
	word = code.split(" / ");
	for( int x = 0; x < word.length; x++) {
			letter = word[x].split(" ");
			for( int y = 0; y < letter.length; y++) {
				
				s+= tree.fetch(letter[y]);
				}
			s += " ";
			
	}
	s = s.trim();
	
	return s;
}
}
