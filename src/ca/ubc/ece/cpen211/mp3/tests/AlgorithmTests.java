package ca.ubc.ece.cpen211.mp3.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import ca.ubc.ece.cpen221.mp3.graph.*;
import ca.ubc.ece.cpen221.mp3.staff.*;

public class AlgorithmTests {

	@Test
	public void BFStest() {

		AdjacencyListGraph alg = new AdjacencyListGraph();

		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		Vertex d = new Vertex("d");
		Vertex e = new Vertex("e");

		alg.addVertex(a);
		alg.addVertex(b);
		alg.addVertex(c);
		alg.addVertex(d);
		alg.addVertex(e);

		alg.addEdge(a, b);
		alg.addEdge(a, d);
		alg.addEdge(d, a);
		alg.addEdge(b, c);
		alg.addEdge(c, e);

		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		vertices.addAll(Algorithms.breadthFirstSearch(alg, a));
		
		ArrayList<Vertex> expectedResult = new ArrayList<Vertex>();
		expectedResult.add(a);
		expectedResult.add(b);
		expectedResult.add(c);
		expectedResult.add(d);
		expectedResult.add(e);
		
		
		
		for(Vertex v : vertices){
			System.out.println(v.toString());
		}
		
		System.out.println("\n");
		
		for(Vertex v : expectedResult){
			System.out.println(v.toString());
		}
		
		assertTrue(vertices.equals(expectedResult));
	}
	
	@Test
	public void BFStest2() {

		AdjacencyListGraph alg = new AdjacencyListGraph();

		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		Vertex d = new Vertex("d");
		Vertex e = new Vertex("e");

		alg.addVertex(a);
		alg.addVertex(b);
		alg.addVertex(c);
		alg.addVertex(d);
		alg.addVertex(e);

		alg.addEdge(a, b);
		alg.addEdge(a, d);
		alg.addEdge(d, a);
		alg.addEdge(b, c);
		alg.addEdge(c, a);

		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		vertices.addAll(Algorithms.breadthFirstSearch(alg, a));
		
		ArrayList<Vertex> expectedResult = new ArrayList<Vertex>();
		expectedResult.add(a);
		expectedResult.add(b);
		expectedResult.add(c);
		expectedResult.add(d);
		//expectedResult.add(e);
		
		
		
		for(Vertex v : vertices){
			System.out.println(v.toString());
		}
		
		System.out.println("\n");
		
		for(Vertex v : expectedResult){
			System.out.println(v.toString());
		}
		
		assertTrue(vertices.equals(expectedResult));
	}
	
	@Test
	public void DFStest() {

		AdjacencyListGraph alg = new AdjacencyListGraph();

		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		Vertex d = new Vertex("d");
		Vertex e = new Vertex("e");

		alg.addVertex(a);
		alg.addVertex(b);
		alg.addVertex(c);
		alg.addVertex(d);
		alg.addVertex(e);

		alg.addEdge(a, b);
		alg.addEdge(a, d);
		alg.addEdge(d, a);
		alg.addEdge(b, c);
		alg.addEdge(c, e);

		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		vertices.addAll(Algorithms.depthFirstSearch(alg, a));
		
		ArrayList<Vertex> expectedResult = new ArrayList<Vertex>();
		expectedResult.add(a);
		expectedResult.add(b);
		expectedResult.add(c);
		expectedResult.add(d);
		expectedResult.add(e);
		
		
		
		for(Vertex v : vertices){
			System.out.println(v.toString());
		}
		
		System.out.println("\n");
		
		for(Vertex v : expectedResult){
			System.out.println(v.toString());
		}
		
		assertTrue(vertices.equals(expectedResult));
	}
	
	@Test
	public void DFStest2() {

		AdjacencyListGraph alg = new AdjacencyListGraph();

		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		Vertex d = new Vertex("d");
		Vertex e = new Vertex("e");

		alg.addVertex(a);
		alg.addVertex(b);
		alg.addVertex(c);
		alg.addVertex(d);
		alg.addVertex(e);

		alg.addEdge(a, b);
		alg.addEdge(a, d);
		alg.addEdge(d, a);
		alg.addEdge(b, c);
		alg.addEdge(c, a);

		ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		vertices.addAll(Algorithms.depthFirstSearch(alg, a));
		
		ArrayList<Vertex> expectedResult = new ArrayList<Vertex>();
		expectedResult.add(a);
		expectedResult.add(b);
		expectedResult.add(c);
		expectedResult.add(d);
		//expectedResult.add(e);
		
		
		
		for(Vertex v : vertices){
			System.out.println(v.toString());
		}
		
		System.out.println("\n");
		
		for(Vertex v : expectedResult){
			System.out.println(v.toString());
		}
		
		assertTrue(vertices.equals(expectedResult));
	}
	
	@Test
	public void testDistance() {

		AdjacencyListGraph alg = new AdjacencyListGraph();

		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		Vertex d = new Vertex("d");
		Vertex e = new Vertex("e");
		Vertex f = new Vertex("f");

		alg.addVertex(a);
		alg.addVertex(b);
		alg.addVertex(c);
		alg.addVertex(d);
		alg.addVertex(e);
		alg.addVertex(f);

		alg.addEdge(a, b);
		alg.addEdge(a, d);
		alg.addEdge(b, c);
		alg.addEdge(d, a);
		alg.addEdge(d, c);
		alg.addEdge(d, e);
		alg.addEdge(c, a);
		alg.addEdge(c, e);
		alg.addEdge(e, f);
		
		int distance = -1;
		
		try {
			distance = Algorithms.shortestDistance(alg, a, d);
		} catch (Exception e1) {

			e1.printStackTrace();
		}
		
		
		assertEquals(1, distance);
	}
	
	@Test 
	public void testCommonDownStream() {

		AdjacencyListGraph alg = new AdjacencyListGraph();

		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		Vertex d = new Vertex("d");
		Vertex e = new Vertex("e");
		Vertex f = new Vertex("f");

		alg.addVertex(a);
		alg.addVertex(b);
		alg.addVertex(c);
		alg.addVertex(d);
		alg.addVertex(e);
		alg.addVertex(f);

		alg.addEdge(a, b);
		alg.addEdge(a, d);
		alg.addEdge(b, c);
		alg.addEdge(d, a);
		alg.addEdge(d, c);
		alg.addEdge(d, e);
		alg.addEdge(c, a);
		alg.addEdge(c, e);
		alg.addEdge(e, f);
		
		ArrayList<Vertex> result = (ArrayList<Vertex>) Algorithms.commonDownstream(alg,b,d);
		ArrayList<Vertex> expected = new ArrayList<Vertex>();
		
		expected.add(c);
		
		assertEquals(expected, result);
	}
	
	@Test 
	public void testCommonUpStream() {

		AdjacencyListGraph alg = new AdjacencyListGraph();

		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		Vertex d = new Vertex("d");
		Vertex e = new Vertex("e");
		Vertex f = new Vertex("f");

		alg.addVertex(a);
		alg.addVertex(b);
		alg.addVertex(c);
		alg.addVertex(d);
		alg.addVertex(e);
		alg.addVertex(f);

		alg.addEdge(a, b);
		alg.addEdge(a, d);
		alg.addEdge(b, c);
		alg.addEdge(d, a);
		alg.addEdge(d, c);
		alg.addEdge(d, e);
		alg.addEdge(c, a);
		alg.addEdge(c, e);
		alg.addEdge(e, f);
		
		ArrayList<Vertex> result = (ArrayList<Vertex>) Algorithms.commonUpstream(alg,b,d);
		ArrayList<Vertex> expected = new ArrayList<Vertex>();
		
		expected.add(a);
		
		assertEquals(expected, result);
	}
	
}
