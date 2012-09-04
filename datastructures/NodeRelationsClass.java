package com.cs7048.simulation.datastructures;

public class NodeRelationsClass implements NodeRelations {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8339399415449006483L;
	int firstNode;
	int secondNode;
	Float interval;

	public NodeRelationsClass(int rFirstNode, int rSecondNode, Float rInterval) {
		firstNode = rFirstNode;
		secondNode = rSecondNode;
		interval = rInterval;
	}

	@Override
	public String getFirstNode() {
		return String.valueOf(firstNode);
	}

	@Override
	public String getSecondNode() {
		return String.valueOf(secondNode);
	}

	@Override
	public Float getTimeIntervalInMinutes() {
		return interval;
	}

	public String toString() {
		String ret = String.format("%3s-%3.00f-%3s || ", getFirstNode(),
				interval, getSecondNode());
		return ret;
	}

}
