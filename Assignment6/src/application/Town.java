package application;

import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;

public class Town extends Object
implements Comparable<Town>{
	
	protected String name;
	   protected Map<Town, Integer> adjacentTowns;
	   protected LinkedList<Town> way;
	   protected int distance;
	   Town previous = null;
	
	   public Town()
	   {
	       super();
	       this.adjacentTowns = new HashMap<Town, Integer>();
	       this.way = new LinkedList<Town>();
	       this.distance = Integer.MAX_VALUE;
	      
	   }

	  
	   public Town(String name)
	   {
	       this.name = name;
	       this.adjacentTowns = new HashMap<Town, Integer>();
	       this.way = new LinkedList<Town>();
	       this.distance = Integer.MAX_VALUE;
	   }
	   public void reset() {
			this.distance = Integer.MAX_VALUE;
			this.previous = null;
		}
	  public Town(Town TemplateTown) {
		  this.name = TemplateTown.name;
		  this.way = TemplateTown.way;
		  this.distance = TemplateTown.distance;
		  this.adjacentTowns = TemplateTown.adjacentTowns;
		  this.previous = TemplateTown.previous;
	  }
	   public Town(String name, Map<Town, Integer> adjacentTowns)
	   {
	       this.name = name;
	       this.adjacentTowns = adjacentTowns;
	       this.way = new LinkedList<Town>();
	       this.distance = Integer.MAX_VALUE;
	   }


	   public String getName()
	   {
	       return name;
	   }

	 
	   public Map<Town, Integer> getTowns()
	   {
	       return adjacentTowns;
	   }
	  
	  
	   public void setName(String nameOfTown)
	   {
	       this.name = nameOfTown;
	   }

	 
	   public void setTowns(Map<Town, Integer> AdjTowns)
	   {
	       this.adjacentTowns = AdjTowns;
	   }

	   public void addTowns(Town destinationTown, int distance)
	   {
	       this.adjacentTowns.put(destinationTown, distance);
	   }

	
	   public LinkedList<Town> getPath()
	   {
	       return way;
	   }

	 
	   public void setDistance(int distance)
	   {
	       this.distance = distance;
	   }

	  
	   public int getDistance()
	   {
	       return distance;
	   }

	   public void setPath(LinkedList<Town> shortestPath)
	   {
	       this.way = shortestPath;
	   }
	   @Override
	   public int compareTo(Town other)
	   {
	       if (name.compareToIgnoreCase(other.name) < 0)
	           return -1;
	       else if (name.compareToIgnoreCase(other.name) > 0)
	           return 1;
	       else
	           return 0;
	   }
	   
	   @Override
	   public String toString()
	   {
	       return "Name = " + name ;
	   }

	  
	  

	
}