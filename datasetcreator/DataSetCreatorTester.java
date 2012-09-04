package com.cs7048.simulation.datasetcreator;

import java.io.IOException;

import com.cs7048.simulation.datastructures.AuthenticationDataClass;
import com.cs7048.simulation.utils.DatasetStore;
import com.cs7048.simulation.utils.Printer;

public class DataSetCreatorTester {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		DataSetCreator dsCreator = new DataSetCreator();
		// AuthenticationDataClass[] dataSet = dsCreator.firstDataset();
		AuthenticationDataClass[] dataSet = dsCreator.AttackDatasetDataset20AttackNodes();
		Printer printer = new Printer();
		printer.printDataset(dataSet);
		DatasetStore dsStore = new DatasetStore();
		dsStore.saveDataSet("AttackDatasetDataset20AttackNodes", dataSet);

	}

}
