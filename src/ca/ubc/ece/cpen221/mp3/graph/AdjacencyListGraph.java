package ca.ubc.ece.cpen221.mp3.graph;

import java.util.ArrayList;
import java.util.*;

import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class AdjacencyListGraph implements Graph {

	private Map<Vertex, ArrayList<Vertex>> membersMap;
	private ArrayList<Vertex> connections;

	public AdjacencyListGraph() {

		membersMap = new HashMap<Vertex, ArrayList<Vertex>>();

	}

	@Override
	public void addVertex(Vertex v) {

		connections = new ArrayList<Vertex>();
		membersMap.put(v, connections);

	}

	@Override
	public void addEdge(Vertex v1, Vertex v2) {

		membersMap.get(v1).add(v2);
		// membersMap.get(v2).add(v1);

	}

	@Override
	public boolean edgeExists(Vertex v1, Vertex v2) {

		return membersMap.get(v1).contains(v2);

	}

	@Override
	public List<Vertex> getDownstreamNeighbors(Vertex v) {

		ArrayList<Vertex> downStreamNeighbours = new ArrayList<Vertex>();
		downStreamNeighbours.addAll(membersMap.get(v));

		return downStreamNeighbours;

	}

	@Override
	public List<Vertex> getUpstreamNeighbors(Vertex v) {

		ArrayList<Vertex> upStreamNeighbours = new ArrayList<Vertex>();

		for (Vertex member : membersMap.keySet()) {

			if (!member.equals(v)) {

				if (membersMap.get(member).contains(v)) {
					upStreamNeighbours.add(member);
				}

			}

		}

		return upStreamNeighbours;
	}

	@Override
	public List<Vertex> getVertices() {

		ArrayList<Vertex> members = new ArrayList<Vertex>();
		members.addAll(membersMap.keySet());

		return members;
	}

}
