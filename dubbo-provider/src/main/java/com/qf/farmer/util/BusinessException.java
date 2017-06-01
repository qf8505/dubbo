package com.qf.farmer.util;

/** 
 * @ClassName: BusinessException 
 * @Description: TODO
 * @author: qinfei
 * @date: 2017年5月11日 下午4:45:50 
 */
public class BusinessException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public BusinessException(String message){
		super(message);
	}
	
	public BusinessException(Throwable cause)
	{
		super(cause);
	}
	
	public BusinessException(String message,Throwable cause)
	{
		super(message,cause);
	}
}
