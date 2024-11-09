package com.EpsonDoms.PropertyFile.library;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import com.EpsonDoms.Genericlibrary.Frameworkconstant;
/**
 * This Class Provides the Reusable Method To Perform Read The Data To PropertyFile
 * By calling Inbuild Methods
 * 
 *@author sande
 */
public class ReadPropertyFile implements Frameworkconstant {
	public  FileInputStream fis;
	public  Properties property;
	public  FileOutputStream fos;
	
public  String read_Data(String key) {
	//1.Convert the physical file into java readable file
	
	try {
		fis= new FileInputStream(propertypath);
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
	//2.Create an object for properties class
 property=new Properties();
		//3.Load all the keys/data
try {
	property.load(fis);
} catch (IOException e) {
	e.printStackTrace();
}
		//4 fetch the data
String data= property.getProperty(key);
return data;
}
	//5.Convert java Readable into Physical File
	
	
public  void write_Data(String key,String value){
	try {
		fis= new FileInputStream(propertypath);
	} catch (FileNotFoundException e) {
		
		e.printStackTrace();
	}
	//2.Create an object for properties class
	 property=new Properties();
			//3.Load all the keys/data
	try {
		property.load(fis);
	} catch (IOException e) {
		e.printStackTrace();
	}
	// 4.Write The Data
			property.put(key, value);

			// 5.Convert Java Readable into physical file
			try
			{
				fos = new FileOutputStream(propertypath);
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
			// 6.Store the data
			try 
			{
				property.store(fos, "Latest Key Updated Succesful");
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
	
}

}
