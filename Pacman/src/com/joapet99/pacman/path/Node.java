package com.joapet99.pacman.path;

import java.util.ArrayList;

import org.newdawn.slick.geom.Vector2f;

/*Implementation details are up to you, but I'm going to impose some limitations on the design.
1. You must have the ability to add and remove Nodes and Edges from the graph.
2. You must be able to retrieve the full set of all Nodes, and the full set of all Edges, as arrays of their respective classes, from the Graph class.
3. You must be able to fetch all connected Edges from the Node class.
4. You must be able to fetch both connected Nodes (there will only be 2) from the Edge class.
5. The constructor for Edge must accept two Nodes as arguments.
6. There should be no stored pointer to the Graph within the Node class.
7. You must be able to clear all Edges and Nodes from the graph from a single method.
8. The Node class must have a Name property, as either a unique integer or a string.
9. You must be able to look up a Node instance, given its Name, from the Graph class.
10. You must have a GraphTest class containing test methods which verify all of the above design rules.
11. I want to see the code when you are done, including the test code.*/

public class Node{
	ArrayList<Edge> edges;
	Vector2f position;
	int id;
	
	public Node(int id,Vector2f position){
		this.position = position;
		this.id = id;
		this.edges = new ArrayList<Edge>();
	}
	
	public int getID(){
		return id;
	}
	
	public Vector2f getPosition(){
		return position;
	}
	
	public void setPosition(Vector2f position){
		this.position = position;
	}
	
	public void addEdge(Edge edge){
		edges.add(edge);
	}
}
