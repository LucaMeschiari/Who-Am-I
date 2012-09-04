package com.cs7048.simulation.datasetcreator;

import java.util.Random;

import com.cs7048.simulation.datastructures.AuthenticationDataClass;
import com.cs7048.simulation.datastructures.NodeRelationsClass;

public class basicSetCreator {
	public AuthenticationDataClass returnSet(int nRecords, int nTotNodes,
			int maxInterval) {
		AuthenticationDataClass authData = new AuthenticationDataClass("test");

		Random ran = new Random();
		int first = 0;
		int second = 0;
		for (int i = 0; i < nRecords - 1; i++) {
			if (i == 0) {
				first = ran.nextInt(nTotNodes);
			} else {
				first = second;
			}
			second = ran.nextInt(nTotNodes);
			int interval = ran.nextInt(maxInterval);
			NodeRelationsClass nodeRel = new NodeRelationsClass(first, second,
					Float.valueOf((float) interval));
			authData.addNodeRelation(nodeRel);
		}

		return authData;
	}

	public AuthenticationDataClass returnShiftedSet(
			AuthenticationDataClass authData, int nTotNodes, int shift,
			int maxInterval) {
		Random ran = new Random();
		AuthenticationDataClass shiftAuthData = new AuthenticationDataClass(
				authData.getClaimedUserId(), authData.getNodeRelationsArray());
		int nNodesRel = shiftAuthData.returnNumberRelationships();
		shiftAuthData.shiftListLeft(shift);
		for (int i = (nNodesRel - shift); i < nNodesRel; i++) {
			int first = ran.nextInt(nTotNodes);
			int second = ran.nextInt(nTotNodes);
			int interval = ran.nextInt(maxInterval);
			NodeRelationsClass nodeRel = new NodeRelationsClass(first, second,
					Float.valueOf((float) interval));
			shiftAuthData.addNodeRelation(nodeRel);
		}
		return shiftAuthData;
	}
}
