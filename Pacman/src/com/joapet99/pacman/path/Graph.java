package com.joapet99.pacman.path;

import java.util.ArrayList;

import org.newdawn.slick.geom.Vector2f;

public class Graph {
	ArrayList<Node> nodes;
	
	public Graph(){
		nodes = new ArrayList<Node>();
	}
	
	public ArrayList<Node> getNodes(){
		return nodes;
	}
	
	public void addNode(int id, Vector2f position){
		Node n = new Node(id, position);
		this.nodes.add(n);
	}
	
	public void addEdge(Node firstNode, Node secondNode){
		Edge edge = new Edge(firstNode, secondNode);
		firstNode.addEdge(edge);
		secondNode.addEdge(edge);
	}
}
