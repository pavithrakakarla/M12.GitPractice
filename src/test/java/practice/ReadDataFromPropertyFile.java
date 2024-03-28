package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {

	public static void main(String[] args) throws IOException {
		
		//step1: Open the Document in java readable format
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		
		//step2: Create an object of properties class from java.util package
		Properties p=new Properties();
		
		//step3: Load the file input stream to the properties
		p.load(fis);
		//step4: Provide the key and read the value
		String value = p.getProperty("url");

		System.out.println(value);
	}

}
