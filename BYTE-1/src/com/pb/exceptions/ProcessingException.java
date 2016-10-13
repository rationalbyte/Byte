package com.pb.exceptions;

public class ProcessingException extends Exception
{

	private static final long serialVersionUID = 5676013825748215628L;
    
	private int errorCode;
	private String errorMsg;
	public ProcessingException()
    {
    	super();
    }
	
	public ProcessingException(int errorCode, String errorMsg)
	{
		super(errorMsg);
		this.errorCode=errorCode;
		this.errorMsg = errorMsg;
	}

	public int getErrorCode()
	{
		return errorCode;
	}


	public String getErrorMsg()
	{
		return errorMsg;
	}

}
