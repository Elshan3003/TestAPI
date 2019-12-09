package com.TestAPI.utils;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.*;

public class ResponseHolder {
	public static int responseCode;
	public static String responseBody;
	public static Response response;
	public static Headers responseHeaders;
	
	

	
	public static void setResponse(Response response){
		ResponseHolder.response=response;
	}
	public static Response getResponse(){
		return response;	
	}
	
	public static int getResponseCode(){
		responseCode=response.getStatusCode();
		return responseCode;
		
		
	}
	public static String getResponseBody(){
		responseBody=response.asString();
		return responseBody;
		
	}
	
	public static Headers getHeaders(){
		responseHeaders=response.getHeaders();
		return responseHeaders;
		
	}
}
