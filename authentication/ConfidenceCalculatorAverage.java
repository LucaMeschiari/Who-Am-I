package com.cs7048.simulation.authentication;

public class ConfidenceCalculatorAverage implements ConfidenceCalculator {
	// Average confidence calculator
	public float calcIdConfidence(float[] pairWeights) {
		float average = 0;
		for (float d : pairWeights) {
			average += d;
		}
		average = average / pairWeights.length;
		return average;
	}

}
