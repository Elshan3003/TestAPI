$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("com/TestAPI/features/BananaAppCenter.feature");
formatter.feature({
  "line": 1,
  "name": "Citi movies advanced",
  "description": "",
  "id": "citi-movies-advanced",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Get location",
  "description": "",
  "id": "citi-movies-advanced;get-location",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "the app is up and running for \"http://cmapi.bananaappscenter.com/\"",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "a user performs a get request to \"api/Location/LocationDetails\"",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "the resonse code should be 200",
  "keyword": "Then "
});
formatter.step({
  "line": 7,
  "name": "should see the json response with pairs on the filtered \"Msg\" node",
  "rows": [
    {
      "cells": [
        "Message",
        "Success Location Details"
      ],
      "line": 9
    },
    {
      "cells": [
        "StatusCode",
        "200"
      ],
      "line": 10
    },
    {
      "cells": [
        "isError",
        "false"
      ],
      "line": 11
    },
    {
      "cells": [
        "isSuccess",
        "true"
      ],
      "line": 12
    }
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "http://cmapi.bananaappscenter.com/",
      "offset": 31
    }
  ],
  "location": "BananaAppCenter.the_app_is_up_and_running_for(String)"
});
