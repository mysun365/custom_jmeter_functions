package com.xmeter.functions;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import org.apache.jmeter.engine.util.CompoundVariable;
import org.apache.jmeter.functions.AbstractFunction;
import org.apache.jmeter.functions.InvalidVariableException;
import org.apache.jmeter.samplers.SampleResult;
import org.apache.jmeter.samplers.Sampler;

public class MyRandomFunc extends AbstractFunction{
	
	//自定义functions描述
	private static final List<String> desc = new LinkedList<String>();
	static{
		//添加函数助手参数名称
		desc.add("first value");
		desc.add("second value");
	}
	
	//function名称，函数助手下拉
	private static final String KEY = "__MyRandomFunc";
	//参数个数，最多添加3个，最少添加2个
	private static final int MAX_PARA_COUNT = 3;
	private static final int MIN_PARA_COUNT = 2;
	
	//传入参数的值
	private Object[] values;
	
	private Random r = new Random();
	
			
			
    //用于函数助手名称展示
	@Override
	public List<String> getArgumentDesc() {
		// TODO Auto-generated method stub
		return desc;
	}
    //具体参数实现的业务
	@Override
	public String execute(SampleResult previousResult, Sampler currentSampler) throws InvalidVariableException {
		try{
			int max = new Integer(((CompoundVariable) values[0]).execute().trim())+new Integer(((CompoundVariable) values[1]).execute().trim());
			int val = r.nextInt(max);
			return String.valueOf(val);
		}catch(Exception ex){
			throw new InvalidVariableException(ex);
		}
		
	}
    //展示函数助手下拉名称
	@Override
	public String getReferenceKey() {
		// TODO Auto-generated method stub
		return KEY;
	}

	@Override
	public void setParameters(Collection<CompoundVariable> parameters) throws InvalidVariableException {
		// TODO Auto-generated method stub
		checkParameterCount(parameters, MIN_PARA_COUNT,MAX_PARA_COUNT);
		values = parameters.toArray();
		
	}

}
