package com.cs7048.simulation.utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.cs7048.simulation.datastructures.AuthenticationDataClass;

public class Printer {
	PrintWriter outResExt;
	PrintWriter outResSumm;

	public Printer() {
		try {
			outResExt = new PrintWriter(new BufferedWriter(new FileWriter(
					"SimData/ExtReport.txt")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printDataset(AuthenticationDataClass[] dataSet) {
		PrintWriter out;
		try {
			out = new PrintWriter(new BufferedWriter(new FileWriter(
					"SimData/DataSet.txt")));

			for (AuthenticationDataClass c : dataSet) {
				out.println(c.toString());
			}
			out.println(dataSet.toString());
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void printWeights(float[] pairWeights, PrintWriter out) {
		for (int i = 0; i < pairWeights.length - 1; i++) {
			out.print("<Hop_" + i + ", " + pairWeights[i] + ">, ");
		}
		out.println("<Hop_" + (pairWeights.length - 1) + ", "
				+ pairWeights[pairWeights.length - 1] + ">");

	}

	public void printConf(float confLevel, PrintWriter out) {
		out.println("Confidence Level: " + confLevel);
	}

	public void printIsAuth(boolean isAuth, boolean hasAuthKey, PrintWriter out) {
		out.println("Is Auth? " + isAuth);
		out.println("Has alternative authentication? " + hasAuthKey);
	}

	public void printAttemptDataExtended(int n, float[] pairWeights,
			float confLevel, boolean isAuth, boolean hasAuthKey) {
		outResExt.println("---- Attempt " + n);
		printWeights(pairWeights, outResExt);
		printConf(confLevel, outResExt);
		printIsAuth(isAuth, hasAuthKey, outResExt);
		outResExt.println();
		outResExt.flush();
	}

}
