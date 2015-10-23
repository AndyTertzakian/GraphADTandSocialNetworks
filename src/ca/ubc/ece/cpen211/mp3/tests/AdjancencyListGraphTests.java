package ca.ubc.ece.cpen211.mp3.tests;

import static org.junit.Assert.*;
import java.util.*;
import org.junit.Test;
import ca.ubc.ece.cpen221.mp3.staff.*;
import ca.ubc.ece.cpen221.mp3.graph.*;

public class AdjancencyListGraphTests {

	@Test
	public void testAddSingleVertex() {

		Vertex v1 = new Vertex("v1");

		AdjacencyListGraph adjListGraph = new AdjacencyListGraph();

		adjListGraph.addVertex(v1);

		assertTrue(adjListGraph.getVertices().contains(v1));

	}

	@Test
	public void testAddMultipleVertex() {

		Vertex v1 = new Vertex("v1");
		Vertex v2 = new Vertex("v2");
		Vertex v3 = new Vertex("v3");

		ArrayList<Vertex> vertices = new ArrayList<Vertex>();

		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);

		AdjacencyListGraph adjListGraph = new AdjacencyListGraph();

		adjListGraph.addVertex(v1);
		adjListGraph.addVertex(v2);
		adjListGraph.addVertex(v3);

		assertTrue(adjListGraph.getVertices().containsAll(vertices));

	}

	@Test
	public void testAddNoEdge() {

		Vertex v1 = new Vertex("v1");
		Vertex v2 = new Vertex("v2");

		ArrayList<Vertex> vertices = new ArrayList<Vertex>();

		vertices.add(v1);
		vertices.add(v2);

		AdjacencyListGraph adjListGraph = new AdjacencyListGraph();

		adjListGraph.addVertex(v1);
		adjListGraph.addVertex(v2);

		assertFalse(adjListGraph.edgeExists(v1, v2));

	}

	@Test
	public void testAddSingleEdge() {

		Vertex v1 = new Vertex("v1");
		Vertex v2 = new Vertex("v2");

		ArrayList<Vertex> vertices = new ArrayList<Vertex>();

		vertices.add(v1);
		vertices.add(v2);

		AdjacencyListGraph adjListGraph = new AdjacencyListGraph();

		adjListGraph.addVertex(v1);
		adjListGraph.addVertex(v2);

		adjListGraph.addEdge(v1, v2);

		assertTrue(adjListGraph.edgeExists(v1, v2));

	}

	@Test
	public void testAddTwoWayEdge() {

		Vertex v1 = new Vertex("v1");
		Vertex v2 = new Vertex("v2");

		ArrayList<Vertex> vertices = new ArrayList<Vertex>();

		vertices.add(v1);
		vertices.add(v2);

		AdjacencyListGraph adjListGraph = new AdjacencyListGraph();

		adjListGraph.addVertex(v1);
		adjListGraph.addVertex(v2);

		adjListGraph.addEdge(v1, v2);
		adjListGraph.addEdge(v2, v1);

		assertTrue(adjListGraph.edgeExists(v1, v2));
		assertTrue(adjListGraph.edgeExists(v2, v1));

	}

	@Test
	public void testDownstreamMembers() {

		AdjacencyListGraph adjListGraph = new AdjacencyListGraph();

		Vertex v1 = new Vertex("v1");
		Vertex v2 = new Vertex("v2");
		Vertex v3 = new Vertex("v3");
		Vertex v4 = new Vertex("v4");
		Vertex v5 = new Vertex("v5");

		ArrayList<Vertex> downstreamMembers = new ArrayList<Vertex>();
		downstreamMembers.add(v2);
		downstreamMembers.add(v3);
		downstreamMembers.add(v4);
		downstreamMembers.add(v5);

		adjListGraph.addVertex(v1);
		adjListGraph.addVertex(v2);
		adjListGraph.addVertex(v3);
		adjListGraph.addVertex(v4);
		adjListGraph.addVertex(v5);

		adjListGraph.addEdge(v1, v2);
		adjListGraph.addEdge(v1, v3);
		adjListGraph.addEdge(v1, v4);
		adjListGraph.addEdge(v1, v5);

		assertTrue(adjListGraph.getDownstreamNeighbors(v1).equals(downstreamMembers));

	}

	@Test
	public void testDownstreamMemberFalse() {

		AdjacencyListGraph adjListGraph = new AdjacencyListGraph();

		Vertex v1 = new Vertex("v1");
		Vertex v2 = new Vertex("v2");
		Vertex v3 = new Vertex("v3");
		Vertex v4 = new Vertex("v4");
		Vertex v5 = new Vertex("v5");

		ArrayList<Vertex> downstreamMembers = new ArrayList<Vertex>();
		downstreamMembers.add(v2);
		downstreamMembers.add(v3);
		downstreamMembers.add(v4);
		downstreamMembers.add(v5);

		adjListGraph.addVertex(v1);
		adjListGraph.addVertex(v2);
		adjListGraph.addVertex(v3);
		adjListGraph.addVertex(v4);
		adjListGraph.addVertex(v5);

		adjListGraph.addEdge(v1, v2);
		adjListGraph.addEdge(v1, v3);

		adjListGraph.addEdge(v1, v5);

		assertFalse(adjListGraph.getDownstreamNeighbors(v1).equals(downstreamMembers));

	}

	@Test
	public void testGetUpstreamMembers() {

		AdjacencyListGraph adjListGraph = new AdjacencyListGraph();

		Vertex v1 = new Vertex("v1");
		Vertex v2 = new Vertex("v2");
		Vertex v3 = new Vertex("v3");
		Vertex v4 = new Vertex("v4");
		Vertex v5 = new Vertex("v5");

		ArrayList<Vertex> downstreamMembers = new ArrayList<Vertex>();
		downstreamMembers.add(v2);
		downstreamMembers.add(v3);
		downstreamMembers.add(v4);
		downstreamMembers.add(v5);

		adjListGraph.addVertex(v1);
		adjListGraph.addVertex(v2);
		adjListGraph.addVertex(v3);
		adjListGraph.addVertex(v4);
		adjListGraph.addVertex(v5);

		adjListGraph.addEdge(v2, v1);
		adjListGraph.addEdge(v3, v1);
		adjListGraph.addEdge(v4, v1);
		adjListGraph.addEdge(v5, v1);

		assertTrue(adjListGraph.getUpstreamNeighbors(v1).equals(downstreamMembers));

	}

	@Test
	public void testGetUpstreamMembersFALSE() {

		AdjacencyListGraph adjListGraph = new AdjacencyListGraph();

		Vertex v1 = new Vertex("v1");
		Vertex v2 = new Vertex("v2");
		Vertex v3 = new Vertex("v3");
		Vertex v4 = new Vertex("v4");
		Vertex v5 = new Vertex("v5");

		ArrayList<Vertex> downstreamMembers = new ArrayList<Vertex>();
		downstreamMembers.add(v2);
		downstreamMembers.add(v3);
		downstreamMembers.add(v4);
		downstreamMembers.add(v5);

		adjListGraph.addVertex(v1);
		adjListGraph.addVertex(v2);
		adjListGraph.addVertex(v3);
		adjListGraph.addVertex(v4);
		adjListGraph.addVertex(v5);

		adjListGraph.addEdge(v2, v1);
		adjListGraph.addEdge(v3, v1);

		adjListGraph.addEdge(v5, v1);

		assertFalse(adjListGraph.getUpstreamNeighbors(v1).equals(downstreamMembers));

	}

	@Test
	public void testGetSingleVertex() {

		AdjacencyListGraph adjListGraph = new AdjacencyListGraph();

		Vertex v1 = new Vertex("v1");

		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		vertices.add(v1);

		adjListGraph.addVertex(v1);

		assertTrue(adjListGraph.getVertices().equals(vertices));

	}

	@Test
	public void testGetMultipleVertex() {

		AdjacencyListGraph adjListGraph = new AdjacencyListGraph();

		Vertex v1 = new Vertex("v1");
		Vertex v2 = new Vertex("v2");
		Vertex v3 = new Vertex("v3");

		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		vertices.add(v1);
		vertices.add(v2);
		vertices.add(v3);

		adjListGraph.addVertex(v1);
		adjListGraph.addVertex(v2);
		adjListGraph.addVertex(v3);

		assertTrue(adjListGraph.getVertices().equals(vertices));

	}

}
