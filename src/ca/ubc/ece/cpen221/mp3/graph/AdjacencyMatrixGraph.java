package ca.ubc.ece.cpen221.mp3.graph;

import java.util.*;

import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class AdjacencyMatrixGraph implements Graph {

	private ArrayList<ArrayList<Boolean>> connectionsMatrix;
	private ArrayList<Boolean> connections;
	private ArrayList<Vertex> membersList;

	public AdjacencyMatrixGraph() {

		connectionsMatrix = new ArrayList<ArrayList<Boolean>>();
		membersList = new ArrayList<Vertex>();
	}

	@Override
	public void addVertex(Vertex v) {
		
		connections = new ArrayList<Boolean>();

		for (int i = 0; i < membersList.size(); i++) {

			connections.add(false);

		}
		
		membersList.add(v);
		connectionsMatrix.add(connections);

		for (ArrayList<Boolean> currentList : connectionsMatrix) {

			currentList.add(false);

		}

	}

	@Override
	public void addEdge(Vertex v1, Vertex v2) {

		int fromIndex = membersList.indexOf(v1);
		int toIndex = membersList.indexOf(v2);

		connectionsMatrix.get(fromIndex).set(toIndex, true);

	}

	@Override
	public boolean edgeExists(Vertex v1, Vertex v2) {

		int fromIndex = membersList.indexOf(v1);
		int toIndex = membersList.indexOf(v2);

		return connectionsMatrix.get(fromIndex).get(toIndex);
	}

	@Override
	public List<Vertex> getDownstreamNeighbors(Vertex v) {

		int fromIndex = membersList.indexOf(v);
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();

		for (int i = 0; i < membersList.size(); i++) {

			if (connectionsMatrix.get(fromIndex).get(i)) {

				vertices.add(membersList.get(i));

			}

		}

		return vertices;
	}

	@Override
	public List<Vertex> getUpstreamNeighbors(Vertex v) {

		int toIndex = membersList.indexOf(v);
		ArrayList<Vertex> vertices = new ArrayList<Vertex>();

		for (int i = 0; i < membersList.size(); i++) {
			
			if(connectionsMatrix.get(i).get(toIndex)){
				
				vertices.add(membersList.get(i));
				
			}
			
		}

		return vertices;
	}

	@Override
	public List<Vertex> getVertices() {

		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		vertices.addAll(membersList);

		return vertices;
	}
}
