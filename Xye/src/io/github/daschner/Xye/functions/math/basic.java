package io.github.daschner.Xye.functions.math;

import javax.script.ScriptException;

import io.github.daschner.Xye.devs.Daschner;

public class basic 
{
	
	public double evaluateString(String problem) throws ScriptException
	{
		return (Double)Daschner.scriptEngine.eval(problem);
	}
	
	

}
