package ca.ubc.ece.cpen221.mp3.graph;

import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class Node{
	
	private Vertex vertex;
	private boolean checked;	

	public Node(Vertex v) {
		
		vertex = v;
		checked = false;
		
	}
	
	public void check(){	
		checked = true;	
	}

}
