package com.cs7048.simulation.graphmanager;

import java.io.File;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.kernel.EmbeddedGraphDatabase;

public class GraphUtils {
	private static final String USER_DB = "SimData/DB/user-db";
	private GraphDatabaseService graphDb;

	public GraphDatabaseService setUp() {
		//deleteFileOrDirectory(new File(USER_DB));
		graphDb = new EmbeddedGraphDatabase(USER_DB);
		registerShutdownHook();
		// createNodespace();
		return graphDb;
	}

	public void shutdown() {
		graphDb.shutdown();
	}

	private void registerShutdownHook() {
		// Registers a shutdown hook for the Neo4j instance so that it
		// shuts down nicely when the VM exits (even if you "Ctrl-C" the
		// running example before it's completed)
		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				graphDb.shutdown();
			}
		});
	}

	@SuppressWarnings("unused")
	private static void deleteFileOrDirectory(final File file) {
		if (!file.exists()) {
			return;
		}

		if (file.isDirectory()) {
			for (File child : file.listFiles()) {
				deleteFileOrDirectory(child);
			}
		} else {
			file.delete();
		}
	}

}
