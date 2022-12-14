package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TownGraphManager implements TownGraphManagerInterface {
	
	Graph TownGraph;
	Set<Town> vertex;
	Set<Road> edge;
	public TownGraphManager() {
		TownGraph = new Graph();
		vertex = new HashSet<>();
		edge = new HashSet<>();
	}

	@Override
	public boolean addRoad(String source, String destination, int weight, String Name) {
		Town to1 = new Town(source);
		Town to2 = new Town(destination);

		 TownGraph.addEdge(to1, to2, weight, Name);
		 return true;
	}

	@Override
	public String getRoad(String town1, String town2) {
		 Road ro = null;
		 Town to1 = new Town(town1);
		 Town to2 = new Town(town2);
		 while (to1!= null&& to2 != null) {
		 
		  for (Road m : TownGraph.edgeSet()) {
		  if ((m.getSource().getName().equals(town1) && m.getDestination().getName().equals(town2)) ||
				  (m.getSource().getName().equals(town2) && m.getDestination().getName().equals(town1))) {
		  ro = m;
		  }
		  }
		//  
		return ro.getName();
		 }
		 return null;
	}

	@Override
	public boolean addTown(String v) {
	
 return TownGraph.addVertex(new Town(v));
	}

	@Override
	public Town getTown(String name) {
		  Town to = null;
		  for (Town m : TownGraph.vertexSet()) {
		  if (m.getName().equals(name)) {
		  to = m;
		  }
		  }
		  return to;
		 
	}

	@Override
	public boolean containsTown(String v) {
		Town to = new Town(v);
		return TownGraph.containsVertex(to);
	}

	@Override
	public boolean containsRoadConnection(String town1, String town2) {
		 
		 for(Road r: TownGraph.edgeSet()) {
		  if((r.getSource().getName().equals(town1) && r.getDestination().getName().equals(town2)) ||
				  (r.getSource().getName().equals(town2) && r.getDestination().getName().equals(town1)))
					return true;
		 }
		  
			  return false;
	}



	@Override
	public boolean deleteRoadConnection(String town1, String town2, String road) {
		
		  			return TownGraph.removeEdge(new Town(town1),new Town(town2), 1, road) != null;
	}

	@Override
	public boolean deleteTown(String v) {
		 Town to = null;
		  for (Town m : TownGraph.vertexSet()) {
		  if (m.getName().equals(v)) {
		  to = m;
		  }
		  }
		
		return TownGraph.removeVertex(to);
		
	}
	@Override
	public ArrayList<String> allRoads() {
		ArrayList<String> list = new ArrayList<String>();
		Set<Road> road = TownGraph.edgeSet();
		for(Road ro : road) {
			list.add(ro.getName());
		}
		Collections.sort(list);
		return list;
	}

	@Override
	public ArrayList<String> allTowns() {
		
		ArrayList<String> list = new ArrayList<String>();
		Set<Town>town = TownGraph.vertexSet();
		for(Town t: town) {
			list.add(t.getName());
		}
		Collections.sort(list);
		return list;
	}

	@Override
	public ArrayList<String> getPath(String town1, String town2) {
		ArrayList<String> list = new ArrayList<String>();
		String s  ="";
		Road ro = null;
		  for (Road m : TownGraph.edgeSet()) {
			  if ((m.getSource().getName().equals(town1) && m.getDestination().getName().equals(town2)) ||
					  (m.getSource().getName().equals(town2) && m.getDestination().getName().equals(town1))) {
			  ro = m;
			  if(this.containsRoadConnection(town1, town2)) {
					s += town1+ " via "+ this.getRoad(town1, town2)+" to "+town2+" "+ ro.getDegrees()+ " mi";
						list.add(s);
				
				
				  }
				 
			  }
		  }
		 
		 return list;
	}


	
	 public void populateTownGraph(File selectedFile) throws FileNotFoundException
	  { 
		 try {
            Scanner scan = new Scanner(selectedFile);
           String currentLine = "";
           String name = "";
          int weight = 0;
           String source = "";
           String destination = "";
          
           while(scan.hasNext()) {
              currentLine = scan.nextLine();    
             
             name = currentLine.substring(0, currentLine.indexOf(','));
              
               weight = Integer.parseInt(currentLine.substring(currentLine.indexOf(',') + 1,
                       currentLine.indexOf(';')));
              
               source = currentLine.substring(currentLine.indexOf(';') + 1);
               source = source.substring(0, source.indexOf(';'));
              
               destination = currentLine.substring(currentLine.indexOf(';') + 1);
               destination = destination.substring(destination.indexOf(';') + 1, destination.length());
              
        
               Town sourceTown = new Town(source);
               Town destinationTown = new Town(destination);
               if(!TownGraph.containsVertex(sourceTown)) TownGraph.addVertex(sourceTown);
               if(!TownGraph.containsVertex(destinationTown)) TownGraph.addVertex(destinationTown);
               if(!TownGraph.containsEdge(sourceTown, destinationTown))
            	   TownGraph.addEdge(sourceTown, destinationTown, weight, name);
           }
       }catch(Exception e) {
           System.out.println("error in readFile");
           e.printStackTrace(); 
           }
	  }
}
	

