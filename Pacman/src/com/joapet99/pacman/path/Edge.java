package com.joapet99.pacman.path;

public class Edge {
	Node firstNode;
	Node secondNode;
	
	public Edge(Node firstNode, Node secondNode){
		this.firstNode = firstNode;
		this.secondNode = secondNode;
	}
	
	public double findDistance(){
		double xDelta = secondNode.getPosition().getX() - firstNode.getPosition().getX();
		double yDelta = secondNode.getPosition().getY() - firstNode.getPosition().getY();
		return Math.sqrt((xDelta * xDelta) + (yDelta * yDelta));
	}
}
