package hcl_package;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

import org.apache.log4j.Logger;



public class DataMatrix {
	final static Logger logger = Logger.getRootLogger();
	
	Integer[][] rawData;
	Double[][] distances;
	long total;
	String[] labels;
	
	public void readV1(Path in_file) throws IOException{
		logger.info(String.format("Operating on file : %s", in_file));
		FileReader fr = new FileReader(in_file.toString());
		BufferedReader br = new BufferedReader(fr);
		total = Integer.parseInt((br.readLine()));
		labels = br.readLine().split("\\s");
		logger.info(String.format("Label count : %d", labels.length));
		String str; int i = 0; rawData = new Integer[labels.length][labels.length];
		while ((str = br.readLine()) != null){
			String[] ciagi = str.split("\\s");
			for(int j = 0; ciagi.length > j; j++){
				try{
					rawData[i][j] = Integer.parseInt(ciagi[j]);
				}catch (Exception e){
					logger.fatal(String.format("Cell %d:%d containing \"%s\" was not coverted", i, j, ciagi[j]));
				}
			}
			i++;
		}
		br.close();
		
	}
	
}
