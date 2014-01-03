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
	
	public Node getNode(int id){
		for(Node n : nodes){
			if(n.id == id){
				return n;
			}
		}
		return null;
	}
	
	public ArrayList<Edge> getEdges(){
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for(Node n : nodes){
			for(Edge e : n.edges){
				edges.add(e);
			}
		}
		return edges;
	}
}
