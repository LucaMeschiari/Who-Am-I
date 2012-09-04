package com.cs7048.simulation.datasetcreator;

import com.cs7048.simulation.datastructures.AuthenticationDataClass;
import com.cs7048.simulation.utils.DatasetStore;
import com.cs7048.simulation.utils.Printer;

public class DatasetCreatorAttackPath {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DataSetCreator dsCreator = new DataSetCreator();
		// AuthenticationDataClass[] dataSet = dsCreator.firstDataset();
		AuthenticationDataClass[] dataSet = dsCreator.noDevDataset20AttackNodes();
		Printer printer = new Printer();
		printer.printDataset(dataSet);
		DatasetStore dsStore = new DatasetStore();
		dsStore.saveDataSet("noDevDataset20AttackNodes30MaxInterval", dataSet);
		
		AuthenticationDataClass[] dataSet2 = dsCreator.AttackDatasetDataset20AttackPath(dataSet[1]);
		printer = new Printer();
		printer.printDataset(dataSet2);
		dsStore = new DatasetStore();
		dsStore.saveDataSet("AttackDatasetDataset20AttackPath30MaxInterval", dataSet2);

	}

}
