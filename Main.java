package com.cs7048.simulation;

import com.cs7048.simulation.authentication.Authenticator;
import com.cs7048.simulation.authentication.ConfidenceCalculator;
import com.cs7048.simulation.authentication.ConfidenceCalculatorAverage;
import com.cs7048.simulation.authentication.ThresholdAuthenticator;
import com.cs7048.simulation.datastructures.AuthenticationDataClass;
import com.cs7048.simulation.datastructures.AuthenticationData;
import com.cs7048.simulation.datastructures.NodeRelationsClass;
import com.cs7048.simulation.graphmanager.GraphManager;
import com.cs7048.simulation.graphmanager.GraphManagerClass;

//public class Main {

	//static AuthenticationData path;

	/**
	 * @param args
	 */
/*	public static void main(String[] args) {

		// TODO Establish Looping Policy.
		int SIMULATION_MAX = 20;

		path = simulatePaths();
		printPath();
		// TODO statsGatherer for after initial simulation;

		// The graph manager looks after things like Relationships between
		// Nodes, Weights etc.
		GraphManager graphManager = new GraphManagerClass();

		// Set up functionality to calculate confidence in user Id.
		ConfidenceCalculator confCalculator = new ConfidenceCalculatorAverage();

		// The authenticator delivers the authentication policy used within the
		// system.
		Authenticator auth = new ThresholdAuthenticator();

		for (int i = 0; i < SIMULATION_MAX; i++) {

			// Get "track record" (haha) for specific path.
			double pairWeights[] = graphManager
					.getRelationshipWeightsForPath(path);
			printWeights(pairWeights);

			// Use "track record" to calculate confidence
			double confLevel = confCalculator.calcIdConfidence(pairWeights);
			printConf(confLevel);

			// Test if confidence level is sufficient for authentication policy.
			boolean isAuth = auth.isAuthenticated(confLevel);
			printIsAuth(isAuth);

			/*
			 * Adaptive bit: ** Store record of good path **** "Good path" =
			 * Path analysis is successful or alternative authentication **
			 * Store record of bad path
			 
			if (isAuth || isAlternativeAuth()) {
				graphManager.updateGraphWeightsAuthenticated(path);
			} else {
				graphManager.updateGraphWeightsNONAuthenticated(path);
			}
		}

		
	}

	private static AuthenticationData simulatePaths() {

		int ARRAY_SIZE = 20;

		NodeRelationsClass[] nodeRelationsArray = new NodeRelationsClass[ARRAY_SIZE];

		for (int i = 0; i < ARRAY_SIZE; i++) {
			nodeRelationsArray[i] = new NodeRelationsClass("Node_" + i, "Node_"
					+ (i + 1), Math.random());
		}

		return new AutenticationDataClass("User1", nodeRelationsArray);
	}

	private static void printPath() {
		System.out.println("Claimed UserId: " + path.getClaimedUserId());
		NodeRelationsClass[] nodes = path.getNodeRelationsArray();
		for (int i = 0; i < nodes.length; i++) {
			NodeRelationsClass currNode = nodes[i];
			System.out.println("Hop " + i + ": " + currNode.getFirstNode()
					+ " to " + currNode.getSecondNode() + " in "
					+ currNode.getTimeIntervalInMinutes());
		}
	}

	private static void printWeights(double[] pairWeights) {
		for (int i = 0; i < pairWeights.length - 1; i++) {
			System.out.print("<Hop_" + i + ", " + pairWeights[i] + ">, ");
		}
		System.out.println("<Hop_" + (pairWeights.length - 1) + ", "
				+ pairWeights[pairWeights.length - 1] + ">");

	}

	private static void printConf(double confLevel) {
		System.out.println("Confidence Level: " + confLevel);
	}

	private static void printIsAuth(boolean isAuth) {
		System.out.println("Is Auth? " + isAuth);
	}

	private static boolean isAlternativeAuth() {
		return true;
	}
} */
