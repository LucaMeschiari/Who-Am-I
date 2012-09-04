package com.cs7048.simulation.graphmanager;

import com.cs7048.simulation.datastructures.AuthenticationData;

public interface GraphManager {
	public float[] getRelationshipWeightsForPath(AuthenticationData authData);

	public void updateGraphWeightsAuthenticated(AuthenticationData authData);

	public void updateGraphWeightsNONAuthenticated(AuthenticationData authData);
}
