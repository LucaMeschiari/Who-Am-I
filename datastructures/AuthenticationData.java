package com.cs7048.simulation.datastructures;

import java.io.Serializable;

public interface AuthenticationData extends Serializable {
	public String getClaimedUserId();

	public NodeRelationsClass[] getNodeRelationsArray();
}
