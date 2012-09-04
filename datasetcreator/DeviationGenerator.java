package com.cs7048.simulation.datasetcreator;

import java.util.Random;

import com.cs7048.simulation.datastructures.AuthenticationDataClass;

public class DeviationGenerator {
	public AuthenticationDataClass returnDeviatedSet(
			AuthenticationDataClass origAuthData, int percDev, int nNodes,
			int maxInterval) {
		Random ran = new Random();
		int nRelations = origAuthData.returnNumberRelationships();
		AuthenticationDataClass deviatedAuthData = new AuthenticationDataClass(
				origAuthData.getClaimedUserId(),
				origAuthData.getNodeRelationsArray());
		int nDev = (int) (((float) (nRelations + 1) / 100) * percDev);

		for (int i = 0; i < nDev; i++) {
			int pos = ran.nextInt(nRelations);
			int newNode = ran.nextInt(nNodes);
			int newFirstInterval = ran.nextInt(maxInterval);
			int newSecondInterval = ran.nextInt(maxInterval);

			deviatedAuthData.DeviateNode(pos, newNode,
					Float.valueOf((float) newFirstInterval),
					Float.valueOf((float) newSecondInterval));

		}

		return deviatedAuthData;

	}

	public AuthenticationDataClass returnIntervalDeviatedSet(
			AuthenticationDataClass origAuthData, int percDev, int maxInterval) {
		Random ran = new Random();
		int nRelations = origAuthData.returnNumberRelationships();
		AuthenticationDataClass deviatedAuthData = new AuthenticationDataClass(
				origAuthData.getClaimedUserId(),
				origAuthData.getNodeRelationsArray());

		int nDev = (int) (((float) (nRelations + 1) / 100) * percDev);

		for (int i = 0; i < nDev; i++) {
			int pos = ran.nextInt(nRelations);
			int newInterval = ran.nextInt(maxInterval);

			deviatedAuthData.changeIntervalRelation(pos,
					Float.valueOf((float) newInterval));

		}

		return deviatedAuthData;

	}
	
	public AuthenticationDataClass returnfullIntervalDeviatedSet(
			AuthenticationDataClass origAuthData, int maxInterval) {
		Random ran = new Random();
		int nRelations = origAuthData.returnNumberRelationships();
		AuthenticationDataClass deviatedAuthData = new AuthenticationDataClass(
				origAuthData.getClaimedUserId(),
				origAuthData.getNodeRelationsArray());

		for (int i = 0; i < nRelations; i++) {
			int newInterval = ran.nextInt(maxInterval);

			deviatedAuthData.changeIntervalRelation(i,
					Float.valueOf((float) newInterval));

		}

		return deviatedAuthData;

	}
}
