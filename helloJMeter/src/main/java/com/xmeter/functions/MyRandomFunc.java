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
	
	//�Զ���functions����
	private static final List<String> desc = new LinkedList<String>();
	static{
		//��Ӻ������ֲ�������
		desc.add("first value");
		desc.add("second value");
	}
	
	//function���ƣ�������������
	private static final String KEY = "__MyRandomFunc";
	//����������������3�����������2��
	private static final int MAX_PARA_COUNT = 3;
	private static final int MIN_PARA_COUNT = 2;
	
	//���������ֵ
	private Object[] values;
	
	private Random r = new Random();
	
			
			
    //���ں�����������չʾ
	@Override
	public List<String> getArgumentDesc() {
		// TODO Auto-generated method stub
		return desc;
	}
    //�������ʵ�ֵ�ҵ��
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
    //չʾ����������������
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
