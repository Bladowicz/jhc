package test_jcommander;

import com.beust.jcommander.JCommander;

public class config {
	public void read(String[] args){

	JCommanderExample jct = new JCommanderExample();
	JCommander cmd = new JCommander(jct);
	cmd.parse(args);
	new JCommander(jct, args);
	if (jct.help) {
		cmd.usage();
		return;
	}
	}
	
	
}
