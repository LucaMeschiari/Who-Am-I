package com.cs7048.simulation.utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import com.cs7048.simulation.datastructures.AuthenticationDataClass;

public class DatasetStore {
	public void saveDataSet(String filename, AuthenticationDataClass[] output_dataset) {
	    String path = new String("Datasets/"+filename); 
		try {
	        FileOutputStream fos = new FileOutputStream(path);
	        GZIPOutputStream gzos = new GZIPOutputStream(fos);
	        ObjectOutputStream out = new ObjectOutputStream(gzos);
	        out.writeObject(output_dataset);
	        out.flush();
	        out.close();
	     }
	     catch (IOException e) {
	         System.out.println(e); 
	     }
	  }

	  public AuthenticationDataClass[] loadDataSet(String filename) {
		  String path = new String("Datasets/"+filename); 
		  try {
	        FileInputStream fis = new FileInputStream(path);
	        GZIPInputStream gzis = new GZIPInputStream(fis);
	        ObjectInputStream in = new ObjectInputStream(gzis);
	        AuthenticationDataClass[] return_dataset = (AuthenticationDataClass[])in.readObject();
	        in.close();
	        return return_dataset;
	      }
	      catch (Exception e) {
	          System.out.println(e);
	      }
	      return null;
	  }
}
