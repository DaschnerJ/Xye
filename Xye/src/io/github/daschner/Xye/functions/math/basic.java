package io.github.daschner.Xye.functions.math;

import javax.script.ScriptException;

import io.github.daschner.Xye.devs.Daschner;

public class basic 
{
	
	/**
	 * Uses the script engine to iterate through and solve problems.
	 * 
	 * @param problem - The problem for the script engine to complete.
	 * @return The numerical answer to the problem in a double.
	 * @throws ScriptException If the script cannot be completed.
	 */
	
	public double evaluateString(String problem) throws ScriptException
	{
		
		return (Double)Daschner.scriptEngine.eval(problem);
		
	}

}
