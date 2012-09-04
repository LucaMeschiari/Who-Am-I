package com.cs7048.simulation.datasetcreator;

import com.cs7048.simulation.datastructures.AuthenticationDataClass;
import java.util.Random;

public class DataSetCreator {
	public AuthenticationDataClass[] firstDataset() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 20;
		int totNodes = 1000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 60;
		int nPaths = 1000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i++] = initialPath;
			dataSet[i++] = initialPath;
			dataSet[i++] = dataSet[i++] = devGen.returnDeviatedSet(initialPath,
					i / 11, totNodes, maxInterval);
			dataSet[i++] = initialPath;
			dataSet[i++] = initialPath;
			dataSet[i++] = devGen.returnDeviatedSet(initialPath, 30, totNodes,
					maxInterval);
			dataSet[i++] = initialPath;
			dataSet[i++] = initialPath;
			dataSet[i] = initialPath;
		}

		return dataSet;
	}

	public AuthenticationDataClass[] secondDataset() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 20;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 60;
		int nPaths = 1000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = initialPath;
			dataSet[i++] = initialPath;
			dataSet[i++] = devGen.returnDeviatedSet(initialPath, 30, totNodes,
					maxInterval);
			dataSet[i++] = initialPath;
			dataSet[i++] = initialPath;
			dataSet[i++] = devGen.returnDeviatedSet(initialPath, 30, totNodes,
					maxInterval);
			dataSet[i++] = initialPath;
			dataSet[i++] = devGen.returnDeviatedSet(initialPath, 20, totNodes,
					maxInterval);
			dataSet[i] = initialPath;
		}

		return dataSet;
	}

	public AuthenticationDataClass[] noDevDataset10() {
		basicSetCreator sCreator = new basicSetCreator();
		// DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 10;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = initialPath;
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] noDevDataset20() {
		basicSetCreator sCreator = new basicSetCreator();
		// DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 20;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = initialPath;
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] noDevDataset20AttackNodes() {
		basicSetCreator sCreator = new basicSetCreator();
		// DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 20;
		int totNodes = 20;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 30;
		int nPaths = 200;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = initialPath;
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] AttackDatasetDataset20AttackNodes() {
		basicSetCreator sCreator = new basicSetCreator();
		// DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 20;
		int totNodes = 20;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 500000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = sCreator.returnSet(nRecord,
					totNodes, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] AttackDatasetDataset20AttackPath(AuthenticationDataClass initDataset) {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 20;
		int totNodes = 20;

		int maxInterval = 30;
		int nPaths = 500000;
		
		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];
		
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnfullIntervalDeviatedSet(initDataset, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] noDevDataset30() {
		basicSetCreator sCreator = new basicSetCreator();
		// DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 30;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = initialPath;
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset10Int10() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 10;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnIntervalDeviatedSet(initialPath, 10, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset20Int10() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 20;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnIntervalDeviatedSet(initialPath, 10, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset30Int10() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 30;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnIntervalDeviatedSet(initialPath, 10, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset10Int20() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 10;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnIntervalDeviatedSet(initialPath, 20, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset20Int20() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 20;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnIntervalDeviatedSet(initialPath, 20, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset30Int20() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 30;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnIntervalDeviatedSet(initialPath, 20, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset10Int30() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 10;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnIntervalDeviatedSet(initialPath, 30, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset20Int30() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 20;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnIntervalDeviatedSet(initialPath, 30, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset30Int30() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 30;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnIntervalDeviatedSet(initialPath, 30, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset10Int40() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 10;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnIntervalDeviatedSet(initialPath, 40, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset20Int40() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 20;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnIntervalDeviatedSet(initialPath, 40, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset30Int40() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 30;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnIntervalDeviatedSet(initialPath, 40, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset10Int50() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 10;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnIntervalDeviatedSet(initialPath, 50, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset20Int50() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 20;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnIntervalDeviatedSet(initialPath, 50, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset30Int50() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 30;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnIntervalDeviatedSet(initialPath, 50, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset10Dev10() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 10;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnDeviatedSet(initialPath, 10, totNodes, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset20Dev10() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 20;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnDeviatedSet(initialPath, 10, totNodes, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset30Dev10() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 20;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnDeviatedSet(initialPath, 10, totNodes, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset10Dev20() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 10;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnDeviatedSet(initialPath, 20, totNodes, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset20Dev20() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 20;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnDeviatedSet(initialPath, 20, totNodes, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset30Dev20() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 20;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnDeviatedSet(initialPath, 20, totNodes, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset10Dev30() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 10;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnDeviatedSet(initialPath, 30, totNodes, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset20Dev30() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 20;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnDeviatedSet(initialPath, 30, totNodes, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset30Dev30() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 20;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnDeviatedSet(initialPath, 30, totNodes, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset10Dev40() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 10;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnDeviatedSet(initialPath, 40, totNodes, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset20Dev40() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 20;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnDeviatedSet(initialPath, 40, totNodes, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset30Dev40() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 20;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnDeviatedSet(initialPath, 40, totNodes, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset10Dev50() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 10;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnDeviatedSet(initialPath, 50, totNodes, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset20Dev50() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 20;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnDeviatedSet(initialPath, 50, totNodes, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] devDataset30Dev50() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 20;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 2000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnDeviatedSet(initialPath, 50, totNodes, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] RandomDataSet10() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 10;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 100000000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		//AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				//totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = sCreator.returnSet(nRecord,
					totNodes, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] RandomDataSet20() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 10;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 100000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnDeviatedSet(initialPath, 100, totNodes, maxInterval);
		}

		return dataSet;
	}
	
	public AuthenticationDataClass[] RandomDataSet30() {
		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 10;
		int totNodes = 2000;
		// int maxSetDeviation = 50;
		// int maxDeviatedSetDeviation = 50;
		// int maxShift = nRecord-1;
		int maxInterval = 120;
		int nPaths = 100000;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];

		AuthenticationDataClass initialPath = sCreator.returnSet(nRecord,
				totNodes, maxInterval);
		//dataSet[0] = initialPath;
		for (int i = 0; i < nPaths; i++) {
			dataSet[i] = devGen.returnDeviatedSet(initialPath, 100, totNodes, maxInterval);
		}

		return dataSet;
	}
	

	public AuthenticationDataClass[] threePathsWithShiftsDataset() {

		/*
		 * 3 paths (id: 0, 1, 2). One with no shifts; one with 2 shifts (id: 3,
		 * 4 ); one with 4 shifts (id: 5, 6, 7, 8).
		 */

		basicSetCreator sCreator = new basicSetCreator();
		DeviationGenerator devGen = new DeviationGenerator();

		int nRecord = 20;
		int totNodes = 2000;
		int maxInterval = 60;
		int nPaths = 1000;
		int pathTypes = 9;

		AuthenticationDataClass dataSet[] = new AuthenticationDataClass[nPaths];
		AuthenticationDataClass paths[] = new AuthenticationDataClass[pathTypes];

		paths[0] = sCreator.returnSet(nRecord, totNodes, maxInterval);
		paths[1] = sCreator.returnSet(nRecord, totNodes, maxInterval);
		paths[2] = sCreator.returnSet(nRecord, totNodes, maxInterval);
		paths[3] = sCreator
				.returnShiftedSet(paths[1], totNodes, 5, maxInterval);
		paths[4] = sCreator.returnShiftedSet(paths[1], totNodes, 15,
				maxInterval);
		paths[5] = sCreator
				.returnShiftedSet(paths[2], totNodes, 4, maxInterval);
		paths[6] = sCreator
				.returnShiftedSet(paths[2], totNodes, 8, maxInterval);
		paths[7] = sCreator.returnShiftedSet(paths[2], totNodes, 12,
				maxInterval);
		paths[8] = sCreator.returnShiftedSet(paths[2], totNodes, 16,
				maxInterval);

		for (int i = 0; i < nPaths; i++) {
			int ran = new Random().nextInt(pathTypes);
			// dataSet[i] = paths[ran];
			dataSet[i] = devGen.returnDeviatedSet(paths[ran], 10, totNodes,
					maxInterval);

			dataSet[i].setType(ran);
		}

		return dataSet;
	}
}
