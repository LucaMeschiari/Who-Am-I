// Luca Meschiari & Matthew Byrne
// Class used to test the system and gather statistical results
//

package com.cs7048.simulation;

import com.cs7048.simulation.authentication.Authenticator;
import com.cs7048.simulation.authentication.ConfidenceCalculator;
import com.cs7048.simulation.authentication.ConfidenceCalculatorAverage;
import com.cs7048.simulation.authentication.ThresholdAuthenticator;
import com.cs7048.simulation.datasetcreator.DataSetCreator;
import com.cs7048.simulation.datastructures.AuthenticationDataClass;
import com.cs7048.simulation.graphmanager.GraphManager;
import com.cs7048.simulation.graphmanager.GraphManagerClass;
import com.cs7048.simulation.graphmanager.TimeValidatorWithTolerance;
import com.cs7048.simulation.utils.DatasetStore;
import com.cs7048.simulation.utils.Printer;
import com.cs7048.simulation.utils.StatsManager;

public class SystemSimulator {
	
	public static void main(String[] args) {
		// Set up functionality to calculate confidence in user Id.
		ConfidenceCalculator confCalculator = new ConfidenceCalculatorAverage();

		// The authenticator delivers the authentication policy used within the
		// system.   + setup
		Authenticator auth = new ThresholdAuthenticator();
		auth.setThresholdConfidenceLevel((float)0.7);

		//Time Validator with setup
		TimeValidatorWithTolerance timeVal = new TimeValidatorWithTolerance();
		timeVal.setToleranceLevel(3);
		// The graph manager looks after things like Relationships between
		// Nodes, Weights etc.
		GraphManager graphManager = new GraphManagerClass(timeVal);

		// Printer
		Printer printer = new Printer();

		// StatsCreator
		StatsManager statsMan = new StatsManager();

		// Create Dataset
		//DataSetCreator dsCreator = new DataSetCreator();
		//AuthenticationDataClass[] dataSetCreated = dsCreator.secondDataset();
		
		
		//Load Dataset using DatasetStore
		DatasetStore dsStore = new DatasetStore();
		//dsStore.saveDataSet("test", dataSetCreated);
		AuthenticationDataClass[] dataSet = dsStore.loadDataSet("AttackDatasetDataset20AttackPath30MaxInterval");
		printer.printDataset(dataSet);
		// setTotal path in statManager
		statsMan.setTotalPaths(dataSet.length);

		for (int i = 0; i < dataSet.length; i++) {

			// Get "track record" for specific path.
			float pairWeights[] = graphManager
					.getRelationshipWeightsForPath(dataSet[i]);

			// Use "track record" to calculate confidence
			float confLevel = confCalculator.calcIdConfidence(pairWeights);

			// Test if confidence level is sufficient for authentication policy.
			boolean isAuth = auth.isAuthenticated(confLevel);

			printer.printAttemptDataExtended(i, pairWeights, confLevel, isAuth, dataSet[i].retAltAuth());
			statsMan.updateStats(confLevel, isAuth, isAlternativeAuth());

			/*
			 * Adaptive bit: ** Store record of good path **** "Good path" =
			 * Path analysis is successful or alternative authentication **
			 * Store record of bad path
			 */
			if (isAuth || isAlternativeAuth()) {
				graphManager.updateGraphWeightsAuthenticated(dataSet[i]);
			} else {
				graphManager.updateGraphWeightsNONAuthenticated(dataSet[i]);
			}

			if ((i % 1000) == 0) {
				System.out.print("|");
			}
		}

		statsMan.printStats();
		System.out.print("\n\nSIMULATION ENDED");
	}

	private static boolean isAlternativeAuth() {
		return false;
	}
}