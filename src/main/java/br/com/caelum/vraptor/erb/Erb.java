package br.com.caelum.vraptor.erb;

import java.net.URL;
import java.util.Map;

import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class Erb {
	
	public String render(String name, Map<String, Object> map) throws ScriptException {
		ScriptEngineManager m = new ScriptEngineManager();
		ScriptEngine rubyEngine = m.getEngineByName("jruby");
		if(rubyEngine==null) {
			throw new RuntimeException("Unable to load jruby");
		}

		ScriptContext context = rubyEngine.getContext();

		StringBuilder argsNames = new StringBuilder();
		StringBuilder argsVariables = new StringBuilder();
		for(String key : map.keySet()) {
			context.setAttribute(key, map.get(key), ScriptContext.ENGINE_SCOPE);
			argsNames.append(key + ",");
			argsVariables.append("$"+key + ",");
		}
		String args = argsNames.length()==0? "" : argsNames.substring(0, argsNames.length()-1);
		String args2 = argsVariables.length()==0? "" : argsVariables.substring(0, argsVariables.length()-1);
		
		URL resource = Erb.class.getResource("/" +name);
		String filename =  resource.toExternalForm();
		context.setAttribute("filename", filename, ScriptContext.ENGINE_SCOPE);

		return rubyEngine.eval(
				"require 'erb'\n" + 
				"class MyClass;end\n" +
				"template = File.read($filename)\n" +
				"erb = ERB.new(template)\n" +
				"erb.filename = $filename\n"+
				"erb.def_method(MyClass, 'render(" + args + ")', $filename)\n" + 
				"result = MyClass.new.render(" + args2 + ")", context).toString();
	}

}
