package application;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;





public class Graph implements GraphInterface<Town, Road> {
	private Set<Town> vertex;
	private Set<Road> edge;
			
	private Map<String, Town> prevTown;
	
	public Graph() {
		vertex = new HashSet<Town>();
		edge = new HashSet<Road>();
		prevTown = new HashMap<>();
	}
	@Override
	public Road getEdge(Town sourceVertex, Town destinationVertex) {
		
		for(Road road: edge) {
			if(((road.getSource().equals(sourceVertex)) &&
				(road.getDestination().equals(destinationVertex))) ||
				((road.getDestination().equals(sourceVertex)) &&
				(road.getSource().equals(destinationVertex)))) {
				return road;
			}
		}
	
		return null;
	}

	@Override
	public Road addEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
	     Road road =  new Road(sourceVertex,destinationVertex,weight,description);
	     edge.add(road);
	     sourceVertex.addTowns(sourceVertex, weight);
	     destinationVertex.addTowns(destinationVertex, weight);
		
		 return road;
	}

	@Override
	public boolean addVertex(Town v) {
	
		return 	vertex.add(v);
		
	}

	@Override
	public boolean containsEdge(Town sourceVertex, Town destinationVertex) {
		 if(sourceVertex == null && destinationVertex == null) {
			 return false;
		 }
		for(Road rd : edge) {
			if(rd.contains(sourceVertex) && rd.contains(destinationVertex)) {
				return true;
		}
		}
		return false;
	}

	@Override
	public boolean containsVertex(Town v) {
				for(Town t: vertex) {
					
			if(t.getName().compareToIgnoreCase(v.getName()) == 0) 
				return true;
		
				}
		return false;
	}

	@Override
	public Set<Road> edgeSet() {
	
		return edge;
	}

	@Override
	public Set<Road> edgesOf(Town vertex) {
		Set<Road> road = new HashSet<>();
		for(Road r : edge) {
			if(r.contains(vertex)) {
				road.add(r);
			}
			
		}
		return road;
	}

	@Override
	public Road removeEdge(Town sourceVertex, Town destinationVertex, int weight, String description) {
		Road road = new Road(sourceVertex,destinationVertex,weight,description);
		Road ro = null;
		for (Road r : edge) {
		if (r.equals(road)) {
		ro = r;
		break;
		}
		}
		if (ro != null) {
		edge.remove(ro);
		}
		return ro;
		}
	

	@Override
	public boolean removeVertex(Town v) {
			
		return vertex.remove(v);
	}

	@Override
	public Set<Town> vertexSet() {
		
		return vertex;
	}

	@Override
	public ArrayList<String> shortestPath(Town sourceVertex, Town destinationVertex) {

		ArrayList<String> output = new ArrayList<String>();
		dijkstraShortestPath(sourceVertex);
		Town next = destinationVertex;
		while (!next.equals(sourceVertex)) {
			if (!prevTown.containsKey(next.getName())) {
				output.clear();
				break;
			}
			Town parentTown = prevTown.get(next.getName());
			Road edge = getEdge(parentTown, next);
			output.add(0, parentTown.getName() + " via " + edge.getName() + " to " + next.getName() + " " + edge.getWeight());
			next = parentTown;
		}
		return output;
		}
//		ArrayList<String> path = new ArrayList<>();
//		dijkstraShortestPath(sourceVertex);
//		Town newTown = destinationVertex;
//		while (!newTown.equals(sourceVertex)) {
//		
//		if (!prevTown.containsKey(newTown.getName())) {
//		path.clear();
//		break;
//		}
//		Town parentTown = prevTown.get(newTown.getName());
//		Road r = getEdge(parentTown, newTown);
//		path.add(0,parentTown.getName() + " via " + r.getName() + " to " + newTown.getName() + " " + r.getDegrees() + " mi");
//		newTown = parentTown;
//		}
//		return path;
	
//protected void buildPaths(java.util.ArrayList<String> paths, Town s, Town d) {
//	// Checks
//	try {
//		// Variables
//		StringBuilder path = new StringBuilder();
//		Road r = this.getEdge(d.previous, d); // Throws NPTR
//		
//		// Build Path String
//		path.append(d.previous.getName());
//		path.append(" via ");
//		path.append(r.getName());
//		path.append(" to ");
//		path.append(d.getName());
//		path.append(" ");
//		path.append(r.getWeight());
//		path.append(" mi");
//		paths.add(path.toString());
//		
//		// Checks
//		if (d.previous.equals(s) == false) {
//			this.buildPaths(paths, s, d.previous);
//		}
//	} catch(Exception e) {
//		paths.clear();
//	}
//}
	@Override
	public void dijkstraShortestPath(Town sourceVertex) {
		HashSet<Town> hash = new HashSet<>();

		ArrayList<Town> unTown = new ArrayList<>();

		HashMap<String, Integer> map = new HashMap<>();

		prevTown.clear();

		for (Town t : vertex) {

		unTown.add(t);

		map.put(t.getName(), Integer.MAX_VALUE);

		prevTown.put(t.getName(), null);

		}

		map.put(sourceVertex.getName(), 0);

		System.out.println(unTown);

		System.out.println(map + "\n");

		while (!unTown.isEmpty()) {

		int lowestIndex = 0;

		for (int i = 1; i < unTown.size(); i++) {

		Town Vertex = unTown.get(i);

		if (map.get(Vertex.getName()) < map.get(unTown.get(lowestIndex).getName())) {

		lowestIndex = i;

		}

		}

		Town lowestCostVertex = unTown.remove(lowestIndex);

		hash.add(lowestCostVertex);

		if (map.get(lowestCostVertex.getName()) == Integer.MAX_VALUE) {

		return;

		}

		for (Road r : edgesOf(lowestCostVertex)) {

		Town neighbor = r.getDestination();

		if (neighbor.equals(lowestCostVertex)) {

		neighbor = r.getSource();

		}

		if (hash.contains(neighbor)) {

		continue;

		}

		int adjacentCost = map.get(lowestCostVertex.getName()) + r.getDegrees();
		
		if (adjacentCost < map.get(neighbor.getName())) {

		map.put(neighbor.getName(), adjacentCost);

		prevTown.put(neighbor.getName(), lowestCostVertex);

		}

		}

		}
	}

}
