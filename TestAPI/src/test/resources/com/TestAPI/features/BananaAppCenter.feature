Feature:  Citi movies advanced
	
	Scenario: Get location
	Given the app is up and running for "http://cmapi.bananaappscenter.com/"
	When a user performs a get request to "api/Location/LocationDetails"
	Then the resonse code should be 200
	And should see the json response with pairs on the filtered "Msg" node
		
		|Message	|Success Location Details|
		|StatusCode	|200					 |
		|isError	|false					 |
		|isSuccess	|true					 |
	
	
	Scenario: Check the movie datails
	Given the app is up and running for "http://cmapi.bananaappscenter.com/"
	When a user performs a post request to "api/MovieBooking/MovieBooking" with the following details
		|Mov_ID			|3	|
		|Location_ID	|5	|
	Then the resonse code should be 200
	And should see the json response with pairs on the filtered "Msg" node
		|Message	|Success Moviebooking Details|
		|StatusCode	|200					 	 |
		|isError	|false					 	 |
		|isSuccess	|true					 	 |
	
	Scenario: Get and verify first result
		Given the app is up and running for "http://cmapi.bananaappscenter.com/"
		When a user performs a get request to "api/Location/LocationDetails/"
		Then the resonse code should be 200
		And if filtered "Mloc" node, result of first object will be like below
		|Country		|1				|
		|Country Name	|India			|
		|Latitude		|17.6868		|
		|Location_ID	|Visakhapatnam	|
		|Longitude		|83.2185		|
		|State			|1				|
		|StateName		|Andhra Pradesh	|
		|Status			|true			|
		
		
		
		
		
		
		
		