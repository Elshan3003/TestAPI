package com.TestAPI.stepDefinitions;

import com.TestAPI.utils.ResponseHolder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.response.Response;
import static com.jayway.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import gherkin.formatter.model.DataTableRow;

public class BananaAppCenter {
	String url;
	Response response;
	ResponseHolder holder;
	Map<String, String>query;
	Map responseMap;
	
	@Given("^the app is up and running for \"([^\"]*)\"$")
	public void the_app_is_up_and_running_for(String url) throws Throwable {
	    this.url=url;
	    response=given().when().get(url);
	    assertEquals(response.getStatusCode(), 200);
	}

	@When("^a user performs a get request to \"([^\"]*)\"$")
	public void a_user_performs_a_get_request_to(String api_url) throws Throwable {
		this.url=this.url+api_url;
		response=given().when().get(this.url);
		holder.setResponse(response);
	}
	

	@Then("^the resonse code should be (\\d+)$")
	public void the_resonse_code_should_be(int responseCode) throws Throwable {
	    assertEquals(holder.getResponseCode(),responseCode);
	}

	@Then("^should see the json response with pairs on the filtered \"([^\"]*)\" node$")
	public void should_see_the_json_response_with_pairs_on_the_filtered_node(String filter, DataTable dataTable) throws Throwable {
		Map<String, String>query=new LinkedHashMap<String, String>();
		
		for(DataTableRow row:dataTable.getGherkinRows()){
			query.put(row.getCells().get(0),row.getCells().get(1));
//			System.out.println(query.values());
//			System.out.println(query.keySet());
		}
		
		
		ObjectReader reader=new ObjectMapper().reader(Map.class);
		
		 responseMap = reader.readValue(ResponseHolder.getResponseBody());
		 System.out.println(responseMap);
		 responseMap=(Map<String,Object>) responseMap.get(filter);
		
		 
		 for(String key:query.keySet()){
			 assertTrue(responseMap.containsKey(key));
			 assertEquals(query.get(key), responseMap.get(key).toString()); 
			 
		 }
	}
		 
	@When("^a user performs a post request to \"([^\"]*)\" with the following details$")
	public void a_user_performs_a_post_request_to_with_the_following_details(String url, DataTable dataTable) throws Throwable {
			this.url=this.url+url;
		
			Map<String, String>body=new LinkedHashMap<String, String>();
		
			for(DataTableRow row:dataTable.getGherkinRows()){
				body.put(row.getCells().get(0),row.getCells().get(1));
			}
		
			response=given().contentType(ContentType.JSON).when().body(body).post(this.url);
			ResponseHolder.setResponse(response);
		
		
	}	 
		
	@Then("^if filtered \"([^\"]*)\" node, result of first object will be like below$")
	public void if_filtered_node_result_of_first_object_will_be_like_below(String filter, DataTable dataTable) throws Throwable {
			Map<String, String>query=new LinkedHashMap<String, String>();
			for(DataTableRow row:dataTable.getGherkinRows()){
				query.put(row.getCells().get(0), row.getCells().get(1));
			}
			
			System.out.println("***"+ResponseHolder.getResponseBody());
			
//			ObjectReader reader=new ObjectMapper().reader(Map.class);
//			 responseMap = reader.readValue(ResponseHolder.getResponseBody());
//			 System.out.println("Verify*** "+ responseMap);
//			 responseMap=(Map<String,Object>) responseMap.get(filter);
			
//			for(String key:query.keySet()){
//				assertEquals(query.keySet(),responseMap.get(key).toString() );
//			}
	}

}
