package hcl_package;

import java.io.IOException;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class main {
	final static Logger logger = Logger.getRootLogger();
	public static void main(String[] args) throws IOException {
		BasicConfigurator.configure();
		Config conf = new Config(args);
		DataMatrix data = new DataMatrix();
		data.readV1(conf.in_folder);
		System.out.println(data.total);
		System.out.println(data.rawData[0][0]);
	}



}
