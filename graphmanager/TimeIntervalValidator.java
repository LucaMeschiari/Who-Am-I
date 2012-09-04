package com.cs7048.simulation.graphmanager;

public interface TimeIntervalValidator {
	public boolean isIntervalAcceptable(float storedInterval,
			float currentInterval);
	public void setToleranceLevel(float toleranceLevel);
}
