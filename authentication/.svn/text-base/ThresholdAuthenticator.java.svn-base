package com.cs7048.simulation.authentication;

public class ThresholdAuthenticator implements Authenticator {
	float threshold =  (float)0.7;

	@Override
	public boolean isAuthenticated(float confidenceLevel) {
		if (threshold <= confidenceLevel) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void setThresholdConfidenceLevel(float thresholdConfidenceLevel) {
		threshold = thresholdConfidenceLevel;
	}

}
