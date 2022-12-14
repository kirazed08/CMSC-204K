package application;

public class Road extends Object
implements Comparable<Road> {
	private String name;
	private Town source;
	private Town destination;
	private int degrees;

	public Road(Town source, Town destination, int degrees, String name) {
		this.name = name;
		this.source = source;
		this.destination = destination;
		this.degrees = degrees;
	}
	public Road(Town source, Town destination, String name) {
		this.name = name;
		this.source = source;
		this.destination = destination;
		
	}

	public Road() {
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		
		return name;
	}

	@Override
	public int compareTo(Road o) {
		  String s1 = new String(name);
		  String s2 = new String(o.name);
		 if(s1.compareTo(s2) == 0){
			 return 0;
		 }else if( s1.compareTo(s2) > 0) {
			 return 1;
		 }
		return -1;
	}
	 public boolean	contains(Town town) {
		 if(source.equals(town) || destination.equals(town)) {
			 return true;
		 }else
		 return false;
	 }
	 public int getDegrees() {
		return degrees;
	}
	public void setDegrees(int degrees) {
		this.degrees = degrees;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSource(Town source) {
		this.source = source;
	}
	public void setDestination(Town destination) {
		this.destination = destination;
	}
	public Town getDestination() {
		return destination;
		 
	 }
	 public Town  getSource() {
		return source;
		 
	 }
	 public int	getWeight() {
		return degrees;
		 
	 }
	 public boolean equals(Object o) {
		 Road r;
		 if(o instanceof Road) {
			 r = (Road)o;
			 if(this.getName().equals(r.getName()))
			 return true;
		 }
		 return false;
		 
	 }
	 public String	toString() {
		 return "town name: "+ name+", source: "+ source.getName()+", destination: "+destination.getName()+", degrees: "+degrees;
		 }
	
}
