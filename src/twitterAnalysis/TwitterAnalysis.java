package twitterAnalysis;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;

import ca.ubc.ece.cpen221.mp3.graph.AdjacencyListGraph;
import ca.ubc.ece.cpen221.mp3.graph.AdjacencyMatrixGraph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class TwitterAnalysis {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		FileInputStream fis1, fis2;

		System.out.println("Please input a filename with correct extension: ");
		String inFile = sc.nextLine();

		while (!inFile.substring(inFile.length() - 4).equals(".txt")) {
			System.out.println("Please input a filename with correct extension: ");
			inFile = sc.nextLine();
		}

		inFile = "datasets/" + inFile;
		System.out.println("Please output a filename with correct extension: ");
		String outFile = sc.nextLine();

		while (!outFile.substring(outFile.length() - 4).equals(".txt")) {
			System.out.println("Please output a filename with correct extension: ");
			outFile = sc.nextLine();
		}

		try {
			fis1 = new FileInputStream(inFile);
			fis2 = new FileInputStream(inFile);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}

		// graph implementation to be used
		AdjacencyListGraph graph = new AdjacencyListGraph();
		// AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph();

		// ArrayList<Vertex> vertices = new ArrayList<Vertex>();
		Vertex from, to;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(fis1));
			BufferedReader br2 = new BufferedReader(new InputStreamReader(fis2));

			String line;
			int counter = 1;
			int total = 0;

			while ((line = br2.readLine()) != null) {
				total++;
			}
			br2.close();
			fis2.close();
			System.out.println("Total number of edges: " + total);

			//long start = 0;
			//long diff = 0;
			//long remainingTime = -1;

			while ((line = br.readLine()) != null) {

				//start = System.nanoTime();
				String[] columns = line.split(" ");

				String fromVertexStr = columns[0];
				String toVertexStr = columns[2];

				from = new Vertex(fromVertexStr);
				to = new Vertex(toVertexStr);

				if (!graph.getVertices().contains(to))
					graph.addVertex(to);
				if (!graph.getVertices().contains(from))
					graph.addVertex(from);

				if (graph.getVertices().contains(to) && graph.getVertices().contains(from)
						&& !graph.edgeExists(to, from)) {
					graph.addEdge(to, from);
				}

				//diff = System.currentTimeMillis() - start;
				//remainingTime = (diff * (total-counter));
				
				double percent = ((double) counter++ / (double) total) * 100.0;
				System.out.format("\r%01.4f%% done reading-in graph", percent);
				
			}
			br.close();
			fis1.close();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
