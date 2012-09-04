package com.cs7048.simulation.graphmanager;

import org.neo4j.graphdb.Direction;
import org.neo4j.graphdb.DynamicRelationshipType;
import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.graphdb.Node;
import org.neo4j.graphdb.Relationship;
import org.neo4j.graphdb.Transaction;
import org.neo4j.graphdb.index.Index;

import com.cs7048.simulation.datastructures.AuthenticationData;
import com.cs7048.simulation.datastructures.NodeRelationsClass;

public class GraphManagerClass implements GraphManager {
	public static String NodeName_Key = "Name";
	public static String Time_Key = "Time";
	public static String Weight_Key = "Weight";
	public static String NAttempts_Key = "NAttempts";
	public static String NSuccess_Key = "NSuccess";

	private static GraphDatabaseService graphDb;
	GraphUtils grUtils = new GraphUtils();
	static Index<Node> nodeIndex;
	TimeValidatorWithTolerance timeVal;

	public GraphManagerClass(TimeValidatorWithTolerance rTimeVal) {
		graphDb = grUtils.setUp();
		nodeIndex = graphDb.index().forNodes("nodes");
		timeVal = rTimeVal;
	}

	@Override
	public float[] getRelationshipWeightsForPath(AuthenticationData authData) {
		NodeRelationsClass[] nodeRelations = authData.getNodeRelationsArray();
		float relWeights[] = new float[nodeRelations.length];
		for (int i = 0; i < nodeRelations.length; i++) {
			// relWeights[i]=0;
			NodeRelationsClass n = nodeRelations[i];
			Node startNode = searchNode(n.getFirstNode());
			Node endNode = searchNode(n.getSecondNode());
			if ((startNode == null) || (endNode == null)) {
				relWeights[i] = 0;
			} else {
				Relationship rel = getMatchingRelationship(startNode, endNode,
						n.getTimeIntervalInMinutes());
				if (rel == null) {
					relWeights[i] = 0;
				} else {
					relWeights[i] = (Float) rel.getProperty(Weight_Key);
				}
			}
		}
		return relWeights;
	}

	public Relationship getMatchingRelationship(Node startNode, Node endNode,
			float currentInterval) {
		Iterable<Relationship> relationships = startNode
				.getRelationships(Direction.OUTGOING);
		for (Relationship r : relationships) {
			if (r.getEndNode().equals(endNode)) {
				if (timeVal.isIntervalAcceptable(
						(Float) r.getProperty(Time_Key),
						currentInterval)) {
					return r;
				}
			}
		}
		return null;
	}

	@Override
	public void updateGraphWeightsAuthenticated(AuthenticationData authData) {
		NodeRelationsClass[] nodeRelations = authData.getNodeRelationsArray();
		boolean newRel;
		for (int i = 0; i < nodeRelations.length; i++) {
			newRel = false;
			NodeRelationsClass n = nodeRelations[i];
			Node startNode = searchNode(n.getFirstNode());
			Node endNode = searchNode(n.getSecondNode());
			if (startNode == null) {
				Transaction tx1 = graphDb.beginTx();
				try {
					startNode = createAndIndexNode(n.getFirstNode());
					newRel = true;
					tx1.success();
				} finally {
					tx1.finish();
				}
			}
			if (endNode == null) {
				Transaction tx2 = graphDb.beginTx();
				try {
					endNode = createAndIndexNode(n.getSecondNode());
					newRel = true;
					tx2.success();
				} finally {
					tx2.finish();
				}
			}
			Relationship rel;
			if (newRel) {
				rel = createRelationship(startNode, endNode,
						n.getTimeIntervalInMinutes());
			} else {
				rel = getMatchingRelationship(startNode, endNode,
						n.getTimeIntervalInMinutes());
				if (rel == null) {
					rel = createRelationship(startNode, endNode,
							n.getTimeIntervalInMinutes());
				} else {
					updateRelationship(rel, n.getTimeIntervalInMinutes(), true);
				}
			}
		}
	}
	
	public void updateGraphWeightsNONAuthenticated(AuthenticationData authData) {
		NodeRelationsClass[] nodeRelations = authData.getNodeRelationsArray();
		for (int i = 0; i < nodeRelations.length; i++) {
			NodeRelationsClass n = nodeRelations[i];
			Node startNode = searchNode(n.getFirstNode());
			Node endNode = searchNode(n.getSecondNode());
			if ((startNode != null) && (endNode == null)) {
				Relationship rel = getMatchingRelationship(startNode, endNode,
						n.getTimeIntervalInMinutes());
				if (rel != null) {
					updateRelationship(rel, n.getTimeIntervalInMinutes(), false);
				}
			}

		}

	}

	private static Node createAndIndexNode(String nodeName) {
		Node node = graphDb.createNode();
		node.setProperty(NodeName_Key, nodeName);
		nodeIndex.add(node, NodeName_Key, nodeName);
		return node;

	}

	public Node searchNode(String nodeName) {
		Node foundNode = nodeIndex.get(NodeName_Key, nodeName).getSingle();
		return foundNode;
	}

	public Relationship createRelationship(Node startNode, Node endNode,
			Float interval) {
		String relName = new String("rel" + interval);
		Relationship rel = null;
		Transaction tx = graphDb.beginTx();
		try {
			DynamicRelationshipType type = DynamicRelationshipType
					.withName(relName);
			rel = startNode.createRelationshipTo(endNode, type);

			rel.setProperty(NAttempts_Key, Integer.valueOf(1));
			rel.setProperty(NSuccess_Key, Integer.valueOf(1));
			rel.setProperty(Weight_Key, calculateWeight(1, 1));
			rel.setProperty(Time_Key, interval);
			tx.success();
		} finally {
			tx.finish();
		}
		return rel;
	}

	public void updateRelationship(Relationship rel, Float interval,
			boolean isAuthenticated) {
		Integer attempts = (Integer) rel.getProperty(NAttempts_Key);
		Integer success = (Integer) rel.getProperty(NSuccess_Key);
		Float weight = (Float) rel.getProperty(Weight_Key);
		Float intervalSt = (Float) rel.getProperty(Time_Key);

		attempts++;
		if (isAuthenticated) {
			success++;
		}
		weight = calculateWeight(attempts, success);
		intervalSt = updateInterval(intervalSt, interval);
		Transaction tx = graphDb.beginTx();
		try {
			rel.setProperty(NAttempts_Key, attempts);
			rel.setProperty(NSuccess_Key, success);
			rel.setProperty(Weight_Key,weight);
			rel.setProperty(Time_Key, intervalSt);
			tx.success();
		} finally {
			tx.finish();
		}
	}

	public Float calculateWeight(int attempts, int success) {
		float weight = 0;
		float learningRate = 0;
		if (success <= 0) {
			weight = 0;
		} else {
			weight = (float) success / (float) attempts;
			learningRate = calcLearningRate(success, 5);
			weight = weight * learningRate;
		}

		//System.out.println(learningRate + "    " + weight);
		Float retValue = Float.valueOf(weight);
		return retValue;
	}

	public float calcLearningRate(int success, int learningFactor) {
		float lr = 0;
		lr = (float) success / (float) learningFactor;
		if (lr > 1) {
			lr = 1;
		}

		return lr;

	}

	public Float updateInterval(Float storedTime, Float newTime) {
		Float updTime = new Float(0);
		updTime = (float) ((storedTime * 0.9) + (newTime * 0.1));
		return updTime;
	}

	

}
