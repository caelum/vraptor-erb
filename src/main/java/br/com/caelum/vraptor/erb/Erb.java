package br.com.caelum.vraptor.erb;

import java.io.File;
import java.net.URL;
import java.util.Map;

import javax.script.ScriptException;

import org.jruby.embed.ScriptingContainer;

public class Erb {
	
	static ScriptingContainer container = new ScriptingContainer();
	static {
		
		container.runScriptlet("class Object\n" +
				"	alias_method :require_original, :require\n" +
				"end\n");
		container.runScriptlet("require 'erb'");
		String gemPath = new File("gems/").getAbsolutePath();
		container.runScriptlet(
				"def require(name)\n" +
				"	begin\n"+
				"		x = require_original name\n" +
				"		return x\n" + 
				"	rescue LoadError\n" +
				"		$LOAD_PATH << \"" + gemPath + "/#{name}/lib\"\n" +
				"		require_original name\n" +
				"	end\n" +
				"end\n");
		container.runScriptlet(
				"class MyClass\n" +
				"end\n");

	}
	
	public String render(String name, Map<String, Object> map) throws ScriptException {
		StringBuilder argsNames = new StringBuilder();
		for(String key : map.keySet()) {
			container.put(key, map.get(key));
			argsNames.append(key + ",");
		}
		String args = argsNames.length()==0? "" : argsNames.substring(0, argsNames.length()-1);
		
		URL resource = Erb.class.getResource("/" +name);
		String filename =  resource.toExternalForm();
		container.put("filename", filename);
		Object result = container.runScriptlet(
				"template = File.read(filename)\n" +
				"erb = ERB.new(template)\n" +
				"erb.filename = filename\n"+
				"erb.def_method(MyClass, 'render(" + args + ")', filename)\n" + 
				"result = MyClass.new.render(" + args + ")");
		return result.toString();
	}

}
