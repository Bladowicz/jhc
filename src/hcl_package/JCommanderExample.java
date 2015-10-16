package hcl_package;

import java.util.ArrayList;
import java.util.List;

import com.beust.jcommander.Parameter;

public class JCommanderExample {
	  @Parameter
	  public List<String> parameters = new ArrayList<>();
	 
	  @Parameter(names = { "-log", "-verbose" }, description = "Level of verbosity")
	  private Integer verbose = 1;
//	 
//	  @Parameter(names = "-groups", description = "Comma-separated list of group names to be run")
//	  private String groups;
//	 
	  @Parameter(names = "-debug", description = "Debug mode")
	  public boolean debug = false;

	  @Parameter(names = {"--help", "-h"}, help = true)
	  public boolean help = false;
	  
	  
}
