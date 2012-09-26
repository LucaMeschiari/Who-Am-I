package com.cs7048.simulation.datasetcreator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.cs7048.simulation.datastructures.AuthenticationDataClass;

public class Simulator {

	static PrintWriter out;
	static PrintWriter out2;

	public static void main(String[] args) throws IOException {w
		int nRecord = 10;
		int totNodes = 1000;
		int maxSetDeviation = 50;
		int maxDeviatedSetDeviation = 50;
		int maxShift = nRecord - 1;
		int maxInterval = 60;

		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(
				"somFile.txt")));

		basicSetCreator setCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		AuthenticationDataClass basicSet = setCreator.returnSet(nRecord,
				totNodes, maxInterval);
		out.println("BasicSet");
		out.println(basicSet.toString());

		for (int i = 5; i < maxSetDeviation; i += 5) {
			out.println("Set Deviated " + i + "%");
			AuthenticationDataClass devSet = devGen.returnDeviatedSet(basicSet,
					i, totNodes, maxInterval);
			out.println(devSet.toString());
			// Deviate the deviated Set
			for (int c = 5; c < maxDeviatedSetDeviation; c += 5) {
				out.println("Set Deviated " + i + "% deviated again " + c + "%");
				AuthenticationDataClass devdevSet = devGen.returnDeviatedSet(
						devSet, c, totNodes, maxInterval);
				out.println(devdevSet.toString());
			}
		}

		out.println("BasicSet");
		out.println(basicSet.toString());
		// Shift the set
		for (int i = 0; i <= maxShift; i++) {
			out.println("Set Shifted by " + i);
			AuthenticationDataClass shiftSet = setCreator.returnShiftedSet(
					basicSet, totNodes, i, maxInterval);
			out.println(shiftSet.toString());
		}

		out.flush();
		out.close();
	}

	public static void printSet(int set[]) {
		for (int i = 0; i < set.length; i++) {
			// out.printf("%4d ",set[i]);
			out.println(set[i] + "  ");
		}
		out.println("");
	}

}
