package com.cs7048.simulation.graphmanager;

public class TimeValidatorWithTolerance implements TimeIntervalValidator {
	double tolerance = 10;

	public boolean isIntervalAcceptable(float storedInterval,
			float currentInterval) {
		if ((Math.abs(storedInterval - currentInterval)) <= tolerance) {
			return true;
		} else {
			return false;
		}
	}

	public void setToleranceLevel(float toleranceLevel) {
		tolerance = toleranceLevel;

	}

}
