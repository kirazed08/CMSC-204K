import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class HashingClass {
public static void main(String[]args) {
	int ip,q,N, offset;
	int size = 10;
	N = size;
	
	ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(27, 53, 13, 10, 138, 109, 49, 174, 26, 24));
	Integer[]hash = new Integer[N];
	 System.out.println("---------LQ Hashing-------");
	for(int i = 0; i < list.size(); i++) {
		
	int pk = list.get(i);
	
	ip = pk % N;
	
	if(hash[ip] != null) {
		q = pk/N;
		if(q % N != 0) {
			offset = q;
		}else {
			offset = 19;
		}
		do {
			System.out.println("Collison can't replace "+pk+" : "+ip+" is already occupied by "+hash[ip]);
				ip = (ip + offset)% N;
			}while(hash[ip] != null);
			
		}
		 hash[ip] = pk;
		
 
		 System.out.println( pk+": "+ip);
		 
		 		
	}
	System.out.print( "Elements:");
	for(int x =0; x < hash.length; x++) {
	System.out.print(+hash[x]+",");
	}

	System.out.println();
System.out.println("--------Bucket List Hashing-------");
System.out.println();
LinkedList<Integer>[] hash1 = new LinkedList[N];
	for(Integer d:list) {
      int pk = d.hashCode();
     int index = (pk) % N;
     if(hash1[index] == null) {
    	 hash1[index] = new LinkedList<Integer>();
     }
       hash1[index].add(d);
   
	}
	for(LinkedList<Integer> current : hash1) {
		if (current == null) {
			System.out.print("null,");
			System.out.println();
			continue;
		}else {
			 
		for (Integer item : current) {
			String s = item+",";
			
			System.out.print(s);
			 
		
		}
		}
		
		System.out.println();
	}
	
	
}

	
}


