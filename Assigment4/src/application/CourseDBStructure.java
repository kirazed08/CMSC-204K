package application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class CourseDBStructure implements CourseDBStructureInterface{
	
	 int size,numofEntry;
	   static final double factor = 1.5;
	 LinkedList<CourseDBElement> HashT [];
	public CourseDBStructure( int a) {
		this.size = getNextPrimeNumber((int)(a/factor));
		HashT =  new  LinkedList [size];
		numofEntry = 0;
	}
public CourseDBStructure( String s, int a) {
		this.size = a;
		HashT =  new LinkedList [size];
		numofEntry = 0;
	}

	@Override
	public void add(CourseDBElement element) {
		int count = 0;
		String s = element.getCRN()+"";
		int val = s.hashCode()% size;
		if( HashT[val] == null) {
			HashT[val] = new LinkedList<CourseDBElement>();
		HashT[val].add(element);
		numofEntry++;
		}else {
	Iterator<CourseDBElement> itr = HashT[val].iterator(); 
		CourseDBElement dbelem = null; 
		boolean Match = false;
		while(itr.hasNext() && !Match) { //iterator through all CourseDBElement objects in the bucket
			dbelem = itr.next(); 
			if(dbelem.getCRN() == element.getCRN()) //if CourseDBElement with matching CRN is found
				Match = true;
		}
		if(!Match) {//if a matching search key was NOT found, then add the object to the bucket
			HashT[val].add(element);
			numofEntry++;
		}
		if(Match) { //if matching search key was found, then update all of its values (updating CRN is not necessary as they are equal) 
			dbelem.setName(element.getName()); 
		dbelem.setId(element.getID());
			dbelem.setCredit(element.getCredit()); 
			dbelem.setRoomNum(element.getRoomNum()); 
		}
	}
		
		
	}

	@Override
	public CourseDBElement get(int crn) throws IOException {
		 CourseDBElement dbelem;
		 String s = crn+"";
		 int val = s.hashCode()%size;
		 
		 if( HashT[val] == null) {
			 throw new IOException();
		 }
		 for( int x = 0; x < size; x++) {
			
			dbelem = HashT[val].get(x);
			if(dbelem.getCRN() == crn) {
				 return dbelem;
				
			}
			 
			
		 }
		 
		return null;
	}
	public int getNextPrimeNumber(int num) {
		int k = num/4;
		int prime = (4 * k) + 3;
		while(k < 4) {
			k++;
			prime = (4 * k) + 3;
		}
		return prime;
	}

	@Override
	public ArrayList<String> showAll() {
		
		ArrayList<String> list = new ArrayList<String>();
		for(int x = 0; x < size; x++) {
		   if(HashT[x] != null) {
			   Iterator<CourseDBElement> itr = HashT[x].iterator();
		   
		   while(itr.hasNext()) {
			   list.add(itr.next().toString());
		   }
		   }
		}
		
				
		return list;
	}

	@Override
	public int getTableSize() {
	
		return size;
	}

}
