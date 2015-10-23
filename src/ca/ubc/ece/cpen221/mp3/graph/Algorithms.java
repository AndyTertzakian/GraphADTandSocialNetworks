package ca.ubc.ece.cpen221.mp3.graph;

import java.util.*;

import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class Algorithms {

	/**
	 * *********************** Algorithms ****************************
	 * 
	 * 
	 * @param graph
	 * @param a
	 * @param b
	 * @return
	 */

	public static Set<List<Vertex>> bfs(Graph g) {
		Set<List<Vertex>> result = new HashSet<List<Vertex>>();
		ArrayList<Vertex> vertices;

		for (Vertex v : g.getVertices()) {

			vertices = new ArrayList<Vertex>();
			vertices.addAll(breadthFirstSearch(g, v));
			result.add(vertices);
		}

		return result;

	}

	public static List<Vertex> breadthFirstSearch(Graph graph, Vertex a) {

		ArrayList<Vertex> result = new ArrayList<Vertex>();

		Queue<Vertex> q = new LinkedList<Vertex>();
		Map<Vertex, Boolean> visited = new HashMap<Vertex, Boolean>();

		for (Vertex v : graph.getVertices()) {

			visited.put(v, false);

		}

		q.add(a);

		while (!q.isEmpty()) {

			Vertex u = q.remove();

			for (Vertex v : graph.getDownstreamNeighbors(u)) {

				if (visited.get(v) == false) {

					if (!visited.get(v) && !v.equals(a)) {
						q.add(v);
						visited.replace(v, true);
					}

				}

			}

		}

		visited.replace(a, true);

		for (Vertex v : visited.keySet()) {

			if (visited.get(v)) {
				result.add(v);
			}
		}

		return result;
	}

	public static Set<List<Vertex>> dfs(Graph g) {
		Set<List<Vertex>> result = new HashSet<List<Vertex>>();
		ArrayList<Vertex> vertices;

		for (Vertex v : g.getVertices()) {

			vertices = new ArrayList<Vertex>();
			vertices.addAll(depthFirstSearch(g, v));
			result.add(vertices);
		}

		return result;

	}

	public static List<Vertex> depthFirstSearch(Graph graph, Vertex v) {

		ArrayList<Vertex> result = new ArrayList<Vertex>();
		Map<Vertex, Boolean> visited = new HashMap<Vertex, Boolean>();

		Stack<Vertex> s = new Stack<Vertex>();

		for (Vertex vertex : graph.getVertices()) {

			visited.put(vertex, false);

		}

		s.push(v);

		Vertex a = v;
		visited.replace(a, true);
		int counter = 0;

		while (!s.isEmpty()) {

			a = s.peek();
			counter = 0;

			if (!graph.getDownstreamNeighbors(a).isEmpty()) {
				for (Vertex vertex : graph.getDownstreamNeighbors(a)) {
					counter++;

					if (counter == graph.getDownstreamNeighbors(a).size() && visited.get(vertex)) {
						s.pop();
					} else if (!visited.get(vertex)) {

						visited.replace(vertex, true);
						s.push(vertex);

					}

				}
			} else {

				s.pop();

			}

		}

		for (Vertex vertex : visited.keySet())

		{

			if (visited.get(vertex)) {
				result.add(vertex);
			}
		}

		return result;
	}

	public static int shortestDistance(Graph g, Vertex v1, Vertex v2) throws Exception {

		int distance = 0;

		if (v1.equals(v2)) {
			return 0;
		} else if (breadthFirstSearch(g, v1).contains(v2)) {

			Queue<Vertex> q = new LinkedList<Vertex>();
			Map<Vertex, Boolean> visited = new HashMap<Vertex, Boolean>();
			Map<Vertex, Integer> dist = new HashMap<Vertex, Integer>();

			for (Vertex v : g.getVertices()) {

				visited.put(v, false);
				dist.put(v, Integer.MAX_VALUE);

			}

			q.add(v1);
			dist.replace(v1, 0);
			visited.replace(v1, true);

			while (!q.isEmpty()) {

				Vertex u = q.remove();

				for (Vertex v : g.getDownstreamNeighbors(u)) {

					if (!visited.get(v)) {
						visited.replace(v, true);
						dist.replace(v, dist.get(u) + 1);
						q.add(v);

						if (visited.get(v2)) {
							return dist.get(v2);
						}

					}

				}
			}

		} else {
			throw new Exception();
		}

		return distance;
	}

	public static List<Vertex> commonDownstream(Graph g, Vertex a, Vertex b) {

		List<Vertex> result = new ArrayList<Vertex>();
		List<Vertex> downA = g.getDownstreamNeighbors(a);
		List<Vertex> downB = g.getDownstreamNeighbors(b);

		for (Vertex v : downA) {

			if (downB.contains(v)) {
				result.add(v);
			}

		}

		return result;
	}

	public static List<Vertex> commonUpstream(Graph g, Vertex a, Vertex b) {

		List<Vertex> result = new ArrayList<Vertex>();
		List<Vertex> downA = g.getUpstreamNeighbors(a);
		List<Vertex> downB = g.getUpstreamNeighbors(b);

		for (Vertex v : downA) {

			if (downB.contains(v)) {
				result.add(v);
			}

		}

		return result;
	}

}
