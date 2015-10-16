package hcl_package;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.apache.log4j.Logger;

import com.beust.jcommander.JCommander;

public class Config {
	final static Logger logger = Logger.getLogger(Config.class.getName());
	Path in_folder;
	JCommanderExample jct = new JCommanderExample();
	
	
	public Config(String[] args) {
		JCommander cmd = new JCommander(jct);
		cmd.parse(args);
		new JCommander(jct, args);
		if (jct.help){
			cmd.usage();
			System.exit(0);
		}
		if(jct.parameters.size() != 2){	logger.fatal(String.format("Bad parameter count!! (%d)", jct.parameters.size())); System.exit(1);}
		this.in_folder = getInputFolder(jct.parameters.get(0));
	}
	
	private Path getInputFolder(String in_folder){
		Path out = Paths.get(in_folder);
		if(!Files.exists(out)){
			logger.fatal("Input folder does not exist"); System.exit(2);
		}
		if(!out.toFile().canRead()){
			logger.fatal("Input folder is not readable"); System.exit(3);
		}
		logger.info("Pass input");
		return out;
	}
	

	
}
