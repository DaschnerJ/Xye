package io.github.daschner.Xye.functions.math;

import io.github.daschner.Xye.data.types.Date;
import io.github.daschner.Xye.data.types.Stock;
import io.github.daschner.Xye.devs.Daschner;

import java.util.ArrayList;
import java.util.Collections;

import javax.script.ScriptException;
/**
 * @author Mr. Daschner
 */
public class Basic 
{
	
	/**
	 * Uses the script engine to iterate through and solve problems.
	 * 
	 * @param problem - The problem for the script engine to complete.
	 * @return The numerical answer to the problem in a double.
	 * @throws ScriptException If the script cannot be completed.
	 * @throws ClassNotFoundException 
	 */
	public double evaluateString(String problem) throws ScriptException
	{
		
		return (Double) Daschner.scriptEngine.eval(problem);
		
	}
	
}
