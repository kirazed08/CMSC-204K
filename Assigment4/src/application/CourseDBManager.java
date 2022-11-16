package application;

import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class CourseDBManager implements CourseDBManagerInterface {
			CourseDBStructure list = new CourseDBStructure(25);
	@Override
	public void add(String id, int crn, int credits, String roomNum, String instructor) {
		
		  list.add(new CourseDBElement(id,crn,credits,roomNum, instructor));
	}

	@Override
	public CourseDBElement get(int crn) {
	
		try {
			return list.get(crn);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void readFile(File input) throws FileNotFoundException {
		try {
		Scanner scan = new Scanner(input);
		
		while(scan.hasNext()) {
			add(scan.next(),scan.nextInt(),scan.nextInt(),scan.next(),scan.nextLine());
		}
		scan.close();
		}catch(FileNotFoundException e) {
			System.out.println("File not Found");
			e.getMessage();
		}
			
		}

	@Override
	public ArrayList<String> showAll() {
ArrayList<String> L1 = new ArrayList<String>();
  
  for(LinkedList<CourseDBElement> dbelem: list.HashT) {
	  if(dbelem!= null) {
		  for(CourseDBElement elem: dbelem) {
			  String s1 =  elem.toString();
		L1.add(s1);
		  }
		 
	  }
  }
		
		return L1;
	}
}
