package com.cs7048.simulation.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class StatsManager {
	// StatsData
	int totPaths = 0;
	int authCount = 0;
	int notAuthCount = 0;
	float sumConfidence = 0;
	int conf50 = 0;
	int conf60 = 0;
	int conf70 = 0;
	int conf80 = 0;
	int conf90 = 0;
	int conf100 = 0;
	
	int falsePos = 0;
	int falseNeg = 0;
	int correctAuth = 0;
	int correctNeg = 0;
	
	
	PrintWriter outXLS = null;
	
	int count = 0;
	
	

	public StatsManager() {
		//Create xls File for graph
		String fileName = "SimData/ConfHist.xls";

		 try {
			outXLS = new PrintWriter(new FileWriter(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setTotalPaths(int length) {
		totPaths = length;

	}

	public void updateStats(float confLevel, boolean isAuth,boolean hasAuthKey) {
		if (isAuth) {
			authCount++;
			if(hasAuthKey){
				correctAuth++;
			}else{
				falsePos++;
			}
		} else {
			notAuthCount++;
			if(hasAuthKey){
				falseNeg++;
			}else{
				correctNeg ++;
			}
		}

		sumConfidence += confLevel;

		if (confLevel <= 0.5) {
			conf50++;
		} else if (confLevel <= 0.6) {
			conf60++;
		} else if (confLevel <= 0.7) {
			conf70++;
		} else if (confLevel <= 0.8) {
			conf80++;
		} else if (confLevel <= 0.9) {
			conf90++;
		} else if (confLevel <= 1) {
			conf100++;
		}
		
		//Write xls file
		outXLS.println(confLevel);
		outXLS.flush();
		count++;
	}

	public void printStats() {
		PrintWriter out = null;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(
					"SimData/Statistics.txt")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		out.println("Number of tests:  " + totPaths);
		out.println("Number of authorizations:  " + authCount + "  --  "
				+ calculatePercentage(authCount) + "%");
		out.println("Number of NON authorizations:  " + notAuthCount + "  --  "
				+ calculatePercentage(notAuthCount) + "%");
		out.println("Average confidence level:  " + (sumConfidence / totPaths));
		out.println("Number tests with confidence < 50:  " + conf50 + "  --  "
				+ calculatePercentage(conf50) + "%");
		out.println("Number tests with confidence < 60:  " + conf60 + "  --  "
				+ calculatePercentage(conf60) + "%");
		out.println("Number tests with confidence < 70:  " + conf70 + "  --  "
				+ calculatePercentage(conf70) + "%");
		out.println("Number tests with confidence < 80:  " + conf80 + "  --  "
				+ calculatePercentage(conf80) + "%");
		out.println("Number tests with confidence < 90:  " + conf90 + "  --  "
				+ calculatePercentage(conf90) + "%");
		out.println("Number tests with confidence <100:  " + conf100 + "  --  "
				+ calculatePercentage(conf100) + "%");
		
		out.println("Correct Authentications:  " + correctAuth + "  --  "
				+ calculatePercentage(correctAuth) + "%");
		out.println("Correct NONAuthentications:  " + correctNeg + "  --  "
				+ calculatePercentage(correctNeg) + "%");
		out.println("False positives:  " + falsePos + "  --  "
				+ calculatePercentage(falsePos) + "%");
		out.println("Flase negatives:  " + falseNeg + "  --  "
				+ calculatePercentage(falseNeg) + "%");
		
		out.flush();
		out.close();

	}

	float calculatePercentage(int value) {
		return (((float) value / totPaths) * 100);
	}
}
