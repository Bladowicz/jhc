package hcl_package;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class main {
	final static Logger logger = Logger.getRootLogger();
	public static void main(String[] args) throws IOException {
		BasicConfigurator.configure();
		Config conf = new Config(args);
		Integer[][] data = readMatrixFile(conf.in_folder);

	}

	
	private static Integer[][] readMatrixFile(Path in_file) throws NumberFormatException, IOException{
		logger.info(String.format("Operating on file : %s", in_file));
		FileReader fr = new FileReader(in_file.toString());
		BufferedReader br = new BufferedReader(fr);
		int total = Integer.parseInt((br.readLine()));
		String[] labels = br.readLine().split("\\s");
		logger.info(String.format("Label count : %d", labels.length));
		String str; int i = 0; Integer[][] data = new Integer[labels.length][labels.length];
		while ((str = br.readLine()) != null){
			String[] ciagi = str.split("\\s");
			for(int j = 0; ciagi.length > j; j++){
				try{
					data[i][j] = Integer.parseInt(ciagi[j]);
				}catch (Exception e){
					logger.fatal(String.format("Cell %d:%d containing \"%s\" was not coverted", i, j, ciagi[j]));
				}
			}
			i++;
		}
		br.close();
		return data;
	}


}
